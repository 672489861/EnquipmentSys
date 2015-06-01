<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script>
        function deleteUser(id) {
            if (confirm("你确定删除这条记录么?")) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/user/delete.json",
                    data: {
                        id: id
                    },
                    cache: false,
                    success: function (result) {
                        if (result.success) {
                            alert("删除成功!");
                            window.location.href = "${pageContext.request.contextPath}/user/list.do";
                        } else {
                            alert("删除失败");
                            return false;
                        }
                    }
                });
            }
        }
    </script>
    
    
<div class="row search">
    <div class="col-md-10">
        <form action="${pageContext.request.contextPath}/user/list.do" class="form-inline" method="post">

            <div class="form-group">
                <label for="userName" class="control-label">用户名: </label>
                <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入要查询的用户名..."
                       value="${s_user.userName}">
            </div>
            <div class="form-group">
                <label for="trueName" class="control-label">真实姓名: </label>
                <input type="text" class="form-control" id="trueName" name="trueName" placeholder="请输入要查询的姓名名..."
                       value="${s_user.trueName}">
            </div>
            <div class="form-group">
                <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
            </div>
        </form>
    </div>
    <div class="col-md-2">
        <button class="btn btn-primary" style="float: right"
                onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/preSave.do'">添加
        </button>
    </div>
</div>
<div>
    <table class="table table-hover table-bordered table-striped">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>真实姓名</th>
            <th>角色</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>
        <c:forEach var="userz" items="${userList}" varStatus="status">
        	<tr>
	            <td>${status.index+1}</td>
	         	<td>${userz.userName}</td>
	            <td>${userz.password}</td>
	            <td>${userz.trueName}</td>
	            <td>${userz.roleName}</td>
	            <td>${userz.department.deptName}</td>
	            <td>
	                <button class="btn btn-xs btn-info"
	                        onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/preSave.do?id=${userz.id}'">
	                    	修改
	                </button>
	                <button class="btn btn-xs btn-danger" onclick="deleteUser(${userz.id})">删除</button>
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