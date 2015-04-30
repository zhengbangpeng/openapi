<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="updateParameterForm"  method="post">
	<input type="hidden" name="id" value="${parameter.id}">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" id="name"
				value="${parameter.name }" placeholder="请输入名称" required>
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-2 control-label">类型</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="type" id="type"
				value="${parameter.type }" placeholder="请输入类型" required>
		</div>
	</div>
	<div class="form-group">
		<label for="required" class="col-sm-2 control-label">必填</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="required" id="required"
				value="${parameter.required }" placeholder="是否必填(1:必填    0:选填)" required pattern="[0-1]{1}">
		</div>
	</div>
	<div class="form-group">
		<label for="des" class="col-sm-2 control-label">说明</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" name="des" id="des">${parameter.des}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="updateParameterr">Update</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#updateParameterForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageParameter_update.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("修改失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

