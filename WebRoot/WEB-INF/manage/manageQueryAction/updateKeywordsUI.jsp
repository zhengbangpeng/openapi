<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="updateKeywordsForm"  method="post">
	<input type="hidden" name="id" value="${query.id}">
	<div class="form-group">
		<label for="keywords" class="col-sm-2 control-label">关键字</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="keywords" id="keywords"
				value="${query.keywords }" placeholder="请输入关键字(以','分隔)" required >
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="updateKeywords">Update</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form>
<script language="javascript">
$(function(){
	$("#updateKeywordsForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'manageQuery_updateKeywords.action',
			data:form.serialize(),
			success: function(data){$("#modal").click();bootbox.alert(data);},
			error: function(){$("#modal").click();bootbox.alert("修改失败，请稍候重试！");}
		});
		return false;
	});
});

</script>

