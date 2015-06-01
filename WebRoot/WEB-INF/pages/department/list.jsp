<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	function departmentDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/department/delete.json",{id:id},
				function(result){
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/department/list.do";
					}else{
						if(result.errorInfo){
							alert(result.errorInfo);
						}else{
							alert("删除失败,请联系管理员!");
						}
					}
				}
			);
		}
	}
</script>
<div class="row search">
	<div class="col-md-6">
		<form action="${pageContext.request.contextPath}/department/list.do" method="post">
	   		<div class="input-group" style="width: 300px">
	   			<input type="text" class="form-control" name="deptName" placeholder="请输入要查询的部门..." value="${s_department.deptName}">
	   			<span class="input-group-btn">
		        	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      	</span>
	   		</div>
    	</form>
	</div>
	<div class="col-md-6">
		<button class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/department/preSave.do'">添加</button>
	</div>
</div>
<div>
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th>编号</th>
		  	<th>部门名称</th>
		  	<th>部门备注</th>
		  	<th>操作</th>
		</tr>
		<c:forEach var="department" items="${departmentList }" varStatus="status" >
			<tr>
		  		<td>${status.index+1 }</td>
		  		<td>${department.deptName }</td>
		  		<td>${department.remark }</td>
		  		<td>
		  			<button class="btn btn-xs btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/department/preSave.do?id=${department.id}'">修改</button>
		  			<button type="button" class="btn btn-danger btn-xs" onclick="departmentDelete(${department.id })">删除</button>
		  		</td>
	  		</tr>
		</c:forEach>
	</table>
	<nav>
		<ul class="pagination">
			${pageCode}
		</ul>
	</nav>
</div>