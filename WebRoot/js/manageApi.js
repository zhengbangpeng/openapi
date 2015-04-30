$(function(){
	
	$("#file").change(function(){
		//alert($(this).val());
		//$("#img").attr("src",$(this).val());
		var f=document.getElementById("file").files[0];
		var src = window.URL.createObjectURL(f);
		document.getElementById("img").src = src;
		//$("#img").attr("src",$(this).
	});
	
	
	//点击Add按钮 转到addUI页面
	$("#addUI").click(function(){
		location.href="manageApi_addUI.action";
	});
	
	//删除api
	$(".deleteType").click(function(){
	var id=$(this).attr("value");
	var res=bootbox.confirm("您确定要删除该api吗？",function(result){
		if(result){
		var data={};
		//当前页面是否是最后一页  且只有一条记录
		var pageNum=$("#pageNum").val();
		var listSize=$("#listSize").val();
		var isLast=listSize==1?1:0;
		
		pageNum=pageNum-isLast;
		
		data["id"]=id;
		$.ajax({
				type:'POST',
				async:false,
				url:'manageApi_delete.action',
				data:data,
				success: function(data){
					bootbox.alert(data);
					location.href="manageApi_list.action?pageNum="+pageNum;
					/*location=location;*/
					},
				error:function(){bootbox.alert("删除失败，请稍候重试！");}
			});
	}});
		return false;
	});
	
	/*$("#addApiForm").submit(function(){
		$.ajax({
			type:'POST',
			url:'manageApi_add.action',
			success: function(data){bootbox.alert(data);},
			error: function(){alert("插入失败，请稍候重试！");}
			});
		return false;
		
		});*/
	
	$("#addApiForm").ajaxForm({
		url:'manageApi_add.action',
		type:'POST',
		dataType : "text",
		async :true,
		success: function(data){bootbox.alert(data);},
		error: function(){alert("插入失败，请稍候重试！");}
	});
	
	$("#addApi").click(function(){
		$("#addApiForm").submit();
		return false;
	});
	
	
	
	//提交item搜索api
	/*$("#search").click(function(){
		alert("aaaaaaaa");
		return false;
	});*/
	
	
	$("#updateApiForm").ajaxForm({
		url:'manageApi_update.action',
		type:'POST',
		dataType : "text",
		async :true,
		success: function(data){bootbox.alert(data);},
		error: function(){alert("修改失败，请稍候重试！");}
	});
	
	$("#updateApi").click(function(){
		$("#updateApiForm").submit();
		return false;
	});
	
});