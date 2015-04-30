$(function(){
	$("#uploadApiForm").ajaxForm({
		url:'manageApi_upload.action',
		type:'POST',
		dataType : "text",
		async :true,
		success: function(data){bootbox.alert(data);},
		error: function(){bootbox.alert("上传失败，请检查文件内容是否正确！！");}
	});
	
	$("#uploadApi").click(function(){
		/*$("#updateApiForm").submit();*/
		var filename=$("#file").val();
		var str=filename.substr(filename.lastIndexOf("."));
		if(str==".rar"||str==".zip")
		{
			$("#uploadApiForm").submit();
		}else{
			bootbox.alert("请上传.rar,.zip文件");	
		}
		return false;
	});
	
	/*$("#file").change(function(){
		getFullPath($(this));
	});
	
	function getFullPath(obj) 
	{ 
		if(obj) 
		{ 
			
			var s=window.getSelection();
			if(s.rangeCount > 0) s.removeAllRanges();
			var range = document.createRange(obj);
			s.addRange(range);
			alert(s.rangeCount);
			var path=s.getRangeAt(0); 
			alert(path);
			document.getElementById("path").value=path;
		} 
	} */
	
});