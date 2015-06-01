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
            $("form").submit(function () {
                var deptName = $("#deptName").val();
                if (deptName == null || "" == deptName.trim()) {
                    $("#error").text("部门名称不能为空");
                    return false;
                }
                return true;
            });

            $("#saveBtn").click(function () {
                $("form").submit();
            });

            $("#resetBtn").click(function () {
                $("#deptName,#remark").val("");
                return false;
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
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/department/save.do">
            <div class="form-group">
                <label class="col-sm-2 control-label">部门名称:</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="deptName" name="deptName" value="${department.deptName}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">部门备注:</label>

                <div class="col-sm-10">
                    <textarea rows="4" class="form-control" id="remark" name="remark" >${department.remark}</textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                	<input type="hidden" name="id" id="id" value="${department.id}">
                    <button class="btn btn-primary" id="saveBtn">保存</button>
                    <button class="btn btn-primary" id="resetBtn">重置</button>
                    &nbsp;&nbsp;
                    <span style="color: red;" id="error"></span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
