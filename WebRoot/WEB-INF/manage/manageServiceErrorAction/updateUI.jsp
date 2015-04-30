<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="updateServiceErrorForm"  method="post">
	<input type="hidden" name="id" value="${serviceError.id}">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">错误码</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" id="name"
				value="${serviceError.name }" placeholder="请输入错误码" required>
		</div>
	</div>
	<div class="form-group">
		<label for="des" class="col-sm-2 control-label">描述</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" name="des" id="des">${serviceError.des}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="updateServiceError">Update</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#updateServiceErrorForm").submit(function(){
		
		
		/*bootbox.alert("update...");
		window.opener=null;
		window.open('','_self');window.close();*/
		/* form.parents(".modal").modal('hide'); */
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageServiceError_update.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("修改失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

