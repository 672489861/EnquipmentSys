<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
     <script>
        $(function () {
            $("#form").submit(function () {
                var typeName = $("#typeName").val();
                var remark = $("#remark").val();

                if (typeName == null || typeName == "") {
                    $("#error").text("类型名称不能为空");
                    return false;
                }
            });

            $("button").first().click(function () {
                $("#form").submit();
            }).end().last().click(function () {
                $("input").val("");
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
        <form class="form-horizontal" id="form" action="${pageContext.request.contextPath}/equipmentType/save.do" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="typeName">类型名称:</label>

                <div class="col-sm-10">
                    <input id="typeName" name="typeName" type="text" class="form-control" style="width: 300px"
                           value="${equipmentType.typeName}">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="typeName">备注:</label>

                <div class="col-sm-10">
                    <input id="remark" name="remark" type="text" class="form-control" style="width: 300px"
                           value="${equipmentType.remark}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="id" type="text" value="${equipmentType.id}">
                    <button class="btn btn-info">保存</button>
                    <button class="btn btn-info" style="margin-left: 20px;">重置</button>
                    &nbsp;&nbsp;
                    <span style="color: red;" id="error"></span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
