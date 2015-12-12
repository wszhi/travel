$(function () {
	$('#loginbtn').bind('blur',function () {
		$.ajax({
			
			type:"get",
			url:"hello",
		    data:{'userName':$('#loginbtn').val()},
		    
		    success:function(u){
		     if(u=='noExist'){
		     	$('#hintloginbtn').html("<font color='green'>审批成功</font>")
		     }else{
		     	$('#hintloginbtn').html("<font color='red'>审批失败</font>")  	
		     }
		    }
		});
		
		
	})
})