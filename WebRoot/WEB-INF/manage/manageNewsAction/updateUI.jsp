<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="updateNewsForm"  method="post">
	<input type="hidden" name="id" value="${news.id }">
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">标题</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="title" id="title"
				 placeholder="请输入标题" required value="${news.title }">
		</div>
	</div>
	
	<div class="form-group">
		<label for="des" class="col-sm-2 control-label">内容</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="8" name="content" id="content">${news.content }</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="updateNews">Save</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#updateNewsForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageNews_update.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("修改失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

