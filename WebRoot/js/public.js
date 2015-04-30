/**
 * 功能函数
 * 
 * $.dataTarget
 * 通过标签的属性设置，自动执行的，比如data-dialog，$.dataTarget中存放了对应的触发对象
 *
 * $.openHTML(url,context,postData,fn)
 * 在指定的区域(context)打开url,完成后回调fn(context)，postData为提交的表单数据
 * 
 * $.openContent(a)
 * 在#content中打开a标签的链接内容
 * 
 * data-load
 * 标签属性单击加载href属性的内容，加载区域为data-load指定的selector的内容，默认为#content
 * 
 * data-dialog
 * 标签属性单击打开对话框，对话框的内容为href属性指定的内容,对话框标题为title属性，如未设置，为text()的内容
 * 
 * $.confirm(title,message,fn)
 * 确认对话框 title:标题 message:消息 fn(true|false):回调函数
 * 
 * $.alert = (title,message,fn)
 * 提示对话框 title:标题 message:消息 fn():回调函数
 */
(function($){
$(function(){
	
	/**
	在指定的区域(context)打开url,完成后回调fn
	url,context,postData,fn
	**/
	$.openHTML = function(url,context,postData,fn){
		if(postData==null)postData=[];
		if(fn==null)fn=function(){};
		context = $(context);
		if(context.size()==0)context=$("#content");
		context.html('<div class="text-center"><i class="fa-3x fa fa-spin fa-spinner"></i></div>');
		$.ajax({
			url:url,
			dataType:"html",
			type:"post",
			data:postData,
			success:function(data){
				context.html(data);
				fn(context);
			},
			error:function(data){
				context.html('<div style="margin-top:10px" class="text-center text-danger fa-2x"><i class="fa fa-exclamation-triangle"></i> 页面加载错误<br/><button class="btn btn-danger"><i class="fa fa-refresh fa-spin"></i> 重新加载</button></div>');
				context.find("button").click(function(){
					$.openHTML(url,context,postData,fn);
				});	
			}
		});
	}
	
	/**
	在主区域装载标签a的href的属性
	**/
	$.openContent = function(a){
		$.openHTML($(a).attr("href"),"#content");
	}
	
	/**
	给页面内所有加了data-load属性的标签，使用ajax加载内容,属性为指定地址
	**/
	$("body").on("click","[data-load]",function(){
		$.dataTarget = $(this);
		var selector = $(this).attr("data-load");
		if(selector=="")selector="#content";
		$.openHTML($(this).attr("href"),selector);
		return false;
	});
	
	
	$.confirm = function(title,message,fn){
		
		bootbox.dialog({
			title:title,
			message:message,
			closeButton:false,
			buttons:{
				success:{
					label:"是",
					className: "btn-success",
					callback: function() {
						fn(true);
					}
				},
				"fail": {
					label:"否",
					className: "btn-danger",
					callback: function() {
						fn(false);
					} 
				}
			}
		});
	}
	
	$.alert = function(title,message,fn){
		if(fn==null)fn=function(){}
		bootbox.dialog({
			title:title,
			message:message,
			closeButton:false,
			buttons:{
				success:{
					label:"关闭",
					className: "btn-success",
					callback: function() {
						fn();
					}
				}
			}
		});
	}
	
	
	$("body").on("click","[data-dialog]",function(){
		$.dataTarget = $(this);
		var title = $(this).attr("title")!=null?$(this).attr("title"):$(this).text();

		var loading = $('<div class="text-center"><i class="fa-3x fa fa-spin fa-spinner"></i></div>');
		
		bootbox.dialog({
			title:title,
			message:loading,
			closeButton:true,
			buttons:{}
		});
		$.post($(this).attr("href"),function(message){
			var message = $(message);
			loading.after(message).remove();

			
		},"html");
		
		return false;
	});
 
});	
})(jQuery);