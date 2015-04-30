
$(function() {
	
	
	$("#typeId").change(function(){
		var typeId=$(this).val();
		//if(typeId==-1) return false;
		var data={};
		data['typeId']=typeId;
		$.ajax({
				type:'POST',
				async:true,
				url:'apiTest_changeType.action',
				data:data,
				success: function(data){
					//bootbox.alert(data);
					/*location=location;*/
					var apiList=eval("("+data+")");
					var options="";
					//bootbox.alert(apiList[0].name);
					$("#apiId").html();
					for(var index in apiList){
							/*$("#apiId").append("<option value='"+api.id+"'>"+api.name+"</option>");*/
						options+="<option value='"+apiList[index].id+"'>"+apiList[index].name+"</option>";
						//alert(api.id);
						//alert(api);
						//bootbox.alert(api.name);
						}
					$("#apiId").html(options);
					$("#apiId").change();
					},
				error:function(){bootbox.alert("选项加载失败，请稍候重试！");}
			});
	});
	$("#apiId").change(function(){
		var apiId=$(this).val();
		var data={};
		data['apiId']=apiId;
		$.ajax({
			type:'POST',
			async:true,
			url:'apiTest_changeApi.action',
			data:data,
			success: function(data){
				//bootbox.alert(data);
				/*location=location;*/
				var queryList=eval("("+data+")");
				var options="";
				//bootbox.alert(apiList[0].name);
				$("#queryId").html();
				for(var index in queryList){
					/*$("#apiId").append("<option value='"+api.id+"'>"+api.name+"</option>");*/
					options+="<option value='"+queryList[index].id+"'>"+queryList[index].name+"</option>";
					//alert(api.id);
					//alert(api);
					//bootbox.alert(api.name);
				}
				$("#queryId").html(options);
				$("#queryId").change();
			},
			error:function(){bootbox.alert("选项加载失败，请稍候重试！");}
		});
	});
	//改变后返回请求参数
	$("#queryId").change(function(){
		var queryId=$(this).val();
		var data={};
		data['queryId']=queryId;
		$.ajax({
			type:'POST',
			async:true,
			url:'apiTest_changeQuery.action',
			data:data,
			success: function(data){
				//bootbox.alert(data);
				/*location=location;*/
				var parameterList=eval("("+data+")");
				var parameters="";
				//bootbox.alert(data);
				//bootbox.alert(apiList[0].name);
				//$("#queryId").html();
				for(var index in parameterList){
					parameters+="<tr><td>"+parameterList[index].name+":</td><td><input type='text' name='"+parameterList[index].name+"' required='true'>";
					if(parameterList[index].required==1) parameters+="&nbsp;*";
					parameters+="</td></tr>";
				}
				if(parameterList!=""){
					parameters+="<input type='hidden' id='url' value='"+parameterList[0].query.url+"'>";
				}
				$("#parameters").html();
				$("#parameters").html(parameters);
			},
			error:function(){bootbox.alert("选项加载失败，请稍候重试！");}
		});
		
	});
	$("#typeId").change();
	$("#apiTestForm").submit(function(){
		var reqText="请求方式：";
		reqText+=$("input[name=requestType]:checked").val()+"\n";
		reqText+="请求URL："+$("#url").val()+"\n";
		reqText+="请求参数：";
		var paras=$("#parameters input").serialize();
		reqText+=paras+"\n";
		$("#reqText").html(reqText);
		
		var url=$("#url").val()+"?"+paras;
		var data={};
		data['url']=url;
		$.ajax({
			type:'POST',//$("input[name=requestType]:checked").val(),
			async:true,
			//url:$("#url").val(),
			url:'apiTest_getJson.action',
			data:data,
			success: function(data){
				$("#resText").html(data);
			},
			error:function(){bootbox.alert("请求失败，请稍候重试！");}
		});
		
		return false;
		
	});
});
