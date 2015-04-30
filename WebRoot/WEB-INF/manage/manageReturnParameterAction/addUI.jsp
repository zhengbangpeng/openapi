<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="addReturnParameterForm"  method="post">
	<input type="hidden" name="queryId" value="${queryId }">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" id="name"
				 placeholder="请输入名称" required>
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-2 control-label">类型</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="type" id="type"
				 placeholder="请输入类型" required>
		</div>
	</div>
	<div class="form-group">
		<label for="des" class="col-sm-2 control-label">说明</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" name="des" id="des"></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="addReturnParameter">Save</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#addReturnParameterForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageReturnParameter_add.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("添加失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

