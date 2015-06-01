<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script>
	function deleteEquipmentType(id){
		if(confirm("你确定删除这条记录么?")){
			$.ajax({
				url:"${pageContext.request.contextPath}/equipmentType/delete.json",
				type:"post",
				data:{
					id:id
				},
				cache:false,
				success:function(result){
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/equipmentType/list.do";
					}else{
						if(result.errorInfo){
							alert(result.errorInfo);
						}else{
							alert("删除失败,请联系管理员!");
						}
					}
				}
			});
		}
	}
 </script>
    
  	 <div class="row search">
        <div class="col-sm-10">
            <form action="${pageContext.request.contextPath}/equipmentType/list.do" method="post" class="form-inline">
                <div class="form-group">
                    <label for="typeName" class="control-label">类型名称:</label>
                    <input type="text" name="typeName" id="typeName" class="form-control" placeholder="请输入类型名称" value="${s_equipmentType.typeName}">
                </div>
                <div class="form-group">
                    <label for="remark" class="control-label">备注:</label>
                    <input type="text" name="remark" id="remark" class="form-control" placeholder="请输入备注名称" value="${s_equipmentType.remark}">
                </div>
                <div class="form-group">
                    <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
                </div>
            </form>
        </div>
        <div class="col-sm-2">
              <div style="float:right;">
                  <button class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipmentType/preSave.do'">添加</button>
              </div>
        </div>
    </div>
    <div>
        <table class="table table-hover table-bordered table-striped">
            <tr>
            	<th>编号</th>
                <th>类型名称</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach var="equipmentType" items="${equipmentTypeList}" varStatus="status">
             	<tr>
             		<td>${status.index+1}</td>
	                <td>${equipmentType.typeName}</td>
	                <td>${equipmentType.remark}</td>
	                <td>
	                    <button class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipmentType/preSave.do?id=${equipmentType.id}'">修改</button>
	                    <button class="btn btn-danger" onclick="deleteEquipmentType(${equipmentType.id})">删除</button>
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
