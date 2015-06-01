<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
 <script>
    $(function () {
    	if("${user}"!=null){
    		$("select").first().val("${user.roleName}").end().last().val("${user.department.id}");
    	}
    
        $("#resetBtn").click(function () {
            $("input").val("");
            $("select").val("");
            return false;
        });

        $("form").submit(function () {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var trueName = $("#trueName").val();
            var roleName = $("#roleName").val();
            var deptId = $("#deptId").val();
            if (userName == null || userName == "") {
                $("#error").text("用户名不能为空！");
                return false;
            }
            if (password == null || password == "") {
                $("#error").text("密码不能为空！");
                return false;
            }
            if (trueName == null || trueName == "") {
                $("#error").text("真实姓名不能为空！");
                return false;
            }
            if (roleName == null || roleName == "") {
                $("#error").text("请选择用户角色！");
                return false;
            }
            if (deptId == null || deptId == "") {
                $("#error").text("请选择所属部门！");
                return false;
            }
            return true;
        });

        $("#saveBtn").click(function () {
            $("form").submit();
        });
    });
</script>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">${actionName}</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/user/save.do">
            <div class="form-group">
                <label class="col-sm-2 control-label" for="userName">用户名:</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName" name="userName" style="width: 300px" value="${user.userName}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="password">密码:</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password" style="width: 300px" value="${user.password}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="trueName">真实姓名:</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="trueName" name="trueName" style="width: 300px" value="${user.trueName}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="roleName">用户角色:</label>

                <div class="col-sm-10">
                    <select class="form-control" style="width: 300px" id="roleName" name="roleName">
                        <option value="">请选择...</option>
                        <option value="管理员">管理员</option>
                        <option value="使用者">使用者</option>
                        <option value="维修者">维修者</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">所属部门:</label>

                <div class="col-sm-10">
                    <select class="form-control" style="width: 300px" id="deptId" name="department.id">
                        <option value="">请选择...</option>
                        <c:forEach var="department" items="${departmentList}">
                            <option value="${department.id}">${department.deptName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                	<input type="hidden" name="id" value="${user.id}">
                    <button class="btn btn-primary" id="saveBtn">保存</button>
                    &nbsp;&nbsp;
                    <button class="btn btn-primary" id="resetBtn">重置</button>
                    &nbsp;&nbsp;
                    <span style="color: red" id="error"></span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>