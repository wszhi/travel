$(function () {
	$.ajax({
		type:"get",
		url:"finance_reimburse_list",
		dataType:'json',
		success:function (result) {
			
			$('#finance_reimburse_list tr:not(#title)').remove();
			
			$.each(result, function(index,item) {
				
				$('#finance_reimburse_list').append(
					"<tr><td bgcolor='cornsilk'>"+item.real_reimburse_id+"</td>"
					+"   <td bgcolor='cornsilk'>"+item.reimburse_id+"</td>"
					+"   <td bgcolor='cornsilk'>"+item.travel_id+"</td>"
					+"   <td bgcolor='cornsilk'>"+item.budget_id+"</td>"
					+"   <td bgcolor='cornsilk'>"+item.real_total_money+"</td>"
					+"   <td bgcolor='cornsilk'>"+item.reimburse_detail+"</td>"
					+"</tr>"
		
				);
			});	
		}
	});
}
)