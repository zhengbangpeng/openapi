<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="updateQueryForm"  method="post">
	<input type="hidden" name="id" value="${query.id}">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" id="name"
				value="${query.name }" placeholder="请输入名称" required>
		</div>
	</div>
	<div class="form-group">
		<label for="keywords" class="col-sm-2 control-label">关键字</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="keywords" id="keywords"
				value="${query.keywords }" placeholder="请输入关键字，以','分隔" required>
		</div>
	</div>
	<div class="form-group">
		<label for="url" class="col-sm-2 control-label">接口地址</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="url" id="url"
				value="${query.url }" placeholder="请输入接口地址" required>
		</div>
	</div>
	<div class="form-group">
		<label for="supportType" class="col-sm-2 control-label">支持格式</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="supportType" id="supportType"
				value="${query.supportType }" placeholder="请输入支持格式" required>
		</div>
	</div>
	<div class="form-group">
		<label for="requestType" class="col-sm-2 control-label">请求方式</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="requestType" id="requestType"
				value="${query.requestType }" placeholder="请求方式" required>
		</div>
	</div>
	<div class="form-group">
		<label for="queryExample" class="col-sm-2 control-label">请求示例</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="queryExample" id="queryExample"
				value="${query.queryExample }" placeholder="请输入请求示例" required>
		</div>
	</div>
	<div class="form-group">
		<label for="jsonExample" class="col-sm-2 control-label">说明</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" name="jsonExample" id="jsonExample">${query.jsonExample}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="updateQuery">Update</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#updateQueryForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageQuery_update.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("修改失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

