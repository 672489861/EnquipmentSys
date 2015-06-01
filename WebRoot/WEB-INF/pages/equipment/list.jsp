<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script>
	function deleteEquipment(id){
		if(confirm("你确定删除这条记录么?")){
			$.ajax({
				url:"${pageContext.request.contextPath}/equipment/delete.json",
				type:"post",
				data:{
					id:id
				},
				cache:false,
				success:function(result){
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/equipment/list.do";
					}else{
						alert("删除失败,请联系管理员!");
					}
				}
			});
		}
	}
 </script>
    
  	 <div class="row search">
        <div class="col-sm-10">
            <form action="${pageContext.request.contextPath}/equipment/list.do" method="post" class="form-inline">
                <div class="form-group">
                    <label for="name" class="control-label">设备名称:</label>
                    <input type="text" name="name" id="name" class="form-control" placeholder="请输入设备名称.." value="${s_equipment.name}">
                </div>
                <div class="form-group">
                    <label for="remark" class="control-label">备注:</label>
                    <input type="text" name="remark" id="remark" class="form-control" placeholder="请输入备注名称.." value="${s_equipment.remark}">
                </div>
                <div class="form-group">
                    <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
                </div>
            </form>
        </div>
        <div class="col-sm-2">
              <div style="float:right;">
                  <button class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/preSave.do'">添加</button>
              </div>
        </div>
    </div>
    <div>
        <table class="table table-hover table-bordered table-striped">
            <tr>
            	<th>编号</th>
                <th>设备名称</th>
                <th>编号</th>
                <th>设备类型名称</th>
                <th>状态</th>
                <th>备注</th>
            </tr>
            <c:forEach var="equipment" items="${equipmentList}" varStatus="status">
             	<tr>
             		<td>${status.index+1}</td>
	                <td>${equipment.name}</td>
	                <td>${equipment.no}</td>
	                <td>${equipment.equipmentType.typeName}</td>
	                <c:if test="${equipment.state==1}">
	  					<td>正常</td>
	  				</c:if>
	  				<c:if test="${equipment.state==2}">
	  					<td>维修</td>
	  				</c:if>
	  				<c:if test="${equipment.state==3}">
	  					<td>报废</td>
	  				</c:if>
	                <td>${equipment.remark}</td>
	                <td>
	                    <button class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/preSave.do?id=${equipment.id}'">修改</button>
	                    <button class="btn btn-danger" onclick="deleteEquipment(${equipment.id})">删除</button>
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
