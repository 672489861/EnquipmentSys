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
            $("#form").submit(function () {
                var name = $("#name").val();
				
                if (name == null || name == "") {
                    $("#error").text("设备名称不能为空");
                    return false;
                }
            });

            $("button").first().click(function () {
                $("#form").submit();
            }).end().last().click(function () {
                $("input").val("");
                $("select").val("");
                return false;
            });
            
            if("${equipment}"!=null){
            	$("select").last().val("${equipment.state}").end().first().val("${equipment.equipmentType.id}");
            }
        });
    </script>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">${actionName}</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" id="form" action="${pageContext.request.contextPath}/equipment/save.do" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">设备名称:</label>

                <div class="col-sm-10">
                    <input id="name" name="name" type="text" class="form-control" style="width: 300px"
                           value="${equipment.name}">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="no">编号:</label>

                <div class="col-sm-10">
                    <input id="no" name="no" type="text" class="form-control" style="width: 300px"
                           value="${equipment.no}">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="no">设备类型:</label>

                <div class="col-sm-10">
					<select class="form-control" name="equipmentType.id" style="width: 300px">
						<option value="">请选择</option>
						<c:forEach var="equipmentType" items="${equipmentTypes}">
								<option value="${equipmentType.id}">${equipmentType.typeName}</option>
						</c:forEach>
					</select>                    
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="no">状态:</label>

                <div class="col-sm-10">
                	<select class="form-control" name="state" style="width: 300px">
                		<option value="">请选择</option>
                		<option value="1">正常</option>
                		<option value="2">维修</option>
                		<option value="3">报废</option>
                	</select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="no">备注:</label>

                <div class="col-sm-10">
                    <input id="remark" name="remark" type="text" class="form-control" style="width: 300px"
                           value="${equipment.remark}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="id" type="text" value="${equipment.id}">
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
