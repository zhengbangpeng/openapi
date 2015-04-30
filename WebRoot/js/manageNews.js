$(function(){
	
	//删除api
	$(".deleteType").click(function(){
	var id=$(this).attr("value");
	var res=bootbox.confirm("您确定要删除该news吗？",function(result){
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
				url:'manageNews_delete.action',
				data:data,
				success: function(data){
					bootbox.alert(data);
					location.href="manageNews_list.action?pageNum="+pageNum;
					/*location=location;*/
					},
				error:function(){bootbox.alert("删除失败，请稍候重试！");}
			});
	}});
		return false;
	});
	
	
	
	
	//提交item搜索api
	/*$("#search").click(function(){
		alert("aaaaaaaa");
		return false;
	});*/
	
	
	
	
});