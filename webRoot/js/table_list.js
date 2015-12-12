$(function () {
	$.ajax({
		type:"get",
		url:"ListTriptab",
		/*data:{
			'Apply_Time':$('#Apply_Time').val(),
			'state':$('#state').val()
		},*/
		dataType:'json',
		success:function (result) {
			
			$('#triptablist th:not(#title)').remove();
			
			$.each(result, function(index,item) {
				
				$('#triptablist').append(
					"<tr><td bgcolor='aqua'>"+item.travel_id+"</td>"
					+"   <td bgcolor='aqua'>"+item.type+"</td>"
					+"   <td bgcolor='aqua'>"+item.apply_time+"</td>"
					+"   <td bgcolor='aqua'>"+item.state+"</td>"
					+"   <td bgcolor='aqua'>"更改"</td>"
					+"</tr>"
		
				);
			
				
			});
			
			
			
			
			
			
		}
	});
	
}
)

