$(function(){
	$("#addTypeForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageType_add.action',
			data:form.serialize(),
			success: function(data){bootbox.alert(data);},
			error: function(){alert("插入失败，请稍候重试！");}
			});
		return false;
		
		});
	$("#updateTypeForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageType_update.action',
			data:form.serialize(),
			success: function(data){bootbox.alert(data);},
			error: function(){alert("修改失败，请稍候重试！");}
		});
		return false;
		
	});
});