<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <script>
	function successRepair(equipmentId,id,state){
		$.ajax({
			url:"${pageContext.request.contextPath}/repair/successRepair.json",
			data:{
				equipmentId:equipmentId,
				id:id,
				state:state
			},
			cache:false,
			type:"post",
			success:function(result){
				if(result.success){
					alert("操作成功!");
					window.location.href="${pageContext.request.contextPath}/repair/repairList.do";
				}else{
					alert("操作失败!");
				}
			}
		});
	}
 </script>
    
  	 <div class="row search">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/repair/repairList.do" method="post" class="form-inline">
                <div class="form-group">
                    <label for="name" class="control-label">设备名称:</label>
                    <input type="text" name="equipment.name" id="name" class="form-control" placeholder="请输入设备名称.." value="${s_repair.equipment.name}">
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
            	<th>序号</th>
	  			<th>设备名称</th>
	  			<th>设备编号</th>
	  			<th>报修时间</th>
	  			<th>报修人</th>
	  			<th>操作</th>
            </tr>
            <c:forEach var="repair" items="${repairList}" varStatus="status">
             	<tr>
             		<td>${status.index+1}</td>
	                <td>${repair.equipment.name}</td>
	                <td>${repair.equipment.no}</td>
	                <td><fmt:formatDate value="${repair.repairTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date"/></td>
	                <td>${repair.userman}</td>
	                <td>
	                    <button class="btn btn-info btn-xs" onclick="successRepair(${repair.equipment.id},${repair.id},1)">修理完成</button>
	                    <button class="btn btn-danger btn-xs" onclick="successRepair(${repair.equipment.id},${repair.id},2)">报废</button>
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
