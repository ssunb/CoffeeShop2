$(document).ready(function(){
	var $orders = $('#orders');
	var $name = $('#name');
	var $drink = $('#drink');
	
/*	var orderTemplate = ""+
	"<li>"+
	"<p><strong>Name:</strong> {{name}}</p>"+
	"<p><strong>Drink:</strong> {{drink}}</p>"+
	"<button data-id='{{id}}' class='remove'>X</button>" +
	"</li>";*/
	
	var orderTemplate = $('#order-template').html();
	
	
	function addOrder(order){
		//$orders.append('<li>name: '+order.name+', drink: '+order.drink+'</li>');	
		$orders.append(Mustache.render(orderTemplate, order));
	};
	
	$.ajax({
		type: 'GET',
		url: '/orders',
		//dataType: 'json',
		success: function(data) {
			console.log('success', data);
			$.each(data, function(i, order){
				addOrder(order);
			});
		},
		error: function(){
			alert('error getting orders');
		}
	});
	
	$('#add-order').on('click', function(){
		var order = {
			name: $name.val(),
			drink: $drink.val(),
		};
		
		var myJSON = JSON.stringify(order);
		
		$.ajax({
			type: 'POST',
			url: '/order',
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			data: myJSON,
			success: function(order){
				addOrder(order);
			},
			error: function(){
				alert('error saving order');
			}
		});
		
	});
	
	//$('remove').on('click', function(){
	$orders.delegate('.remove', 'click', function(){
		var $li = $(this).closest('li');
		$.ajax({
			type: 'DELETE',
			url: '/order/' + $(this).attr('data-id'),
			success: function(){
				//$li.remove();
				$li.fadeOut(300, function(){
					$(this).remove();
				});
			}
		});
	});
	
	$orders.delegate('.editOrder', 'click', function(){
		var $li = $(this).closest('li');
		$li.find('input.name').val($li.find('span.name').html());
		$li.find('input.drink').val($li.find('span.drink').html());
		$li.addClass('edit');
	});
	
	
	$orders.delegate('.cancelEdit', 'click', function(){
		$(this).closest('li').removeClass('edit');
	});
	
	$orders.delegate('.saveEdit', 'click', function(){
		var $li = $(this).closest('li');
		var order = {
			id: $li.attr('data-id'),	
			name: $li.find('input.name').val(),
			drink: $li.find('input.drink').val(),
		};
		
		var myJSON = JSON.stringify(order);
		
		$.ajax({
			type: 'PUT',
			url: '/order',
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			data: myJSON,
			success: function(order){
				//addOrder(order);
				$li.find('span.name').html(order.name);
				$li.find('span.drink').html(order.drink);
				$li.removeClass('edit');
			},
			error: function(){
				alert('error uptading order');
			}
		});
		
	});
	
});