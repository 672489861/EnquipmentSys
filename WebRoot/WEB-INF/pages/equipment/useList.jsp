<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script>
	function repairEquipment(id){
		if(confirm("你确定保修该设备么?")){
			$.ajax({
				url:"${pageContext.request.contextPath}/repair/repairEquipment.json",
				type:"post",
				data:{
					id:id
				},
				cache:false,
				success:function(result){
					if(result.success){
						alert("报修成功!");
						window.location.href="${pageContext.request.contextPath}/equipment/useList.do";
					}else{
						alert("报修失败!");
					}
				}
			});
		}
	}
 </script>
    
  	 <div class="row search">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/equipment/useList.do" method="post" class="form-inline">
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
                <th>操作</th>
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
	                	<button class="btn btn-info btn-xs" onclick="repairEquipment(${equipment.id})">设备保修</button>
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
