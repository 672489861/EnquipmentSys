<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/BootStrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/BootStrap/dist/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/resource/BootStrap/dist/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/BootStrap/dist/js/bootstrap.min.js"></script>
<title>设备管理系统</title>
<%
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect(request.getContextPath()+"/");
		return;
	}
	
	String mainPage = (String)request.getAttribute("mainPage");
	if(mainPage==null || "".equals(mainPage)){
		mainPage = "/common/default.jsp";
	}
 %>
</head>
<body>
	<div class="container">
		<div class="row">
			 <div class="col-md-12">
			 	<jsp:include page="/common/head.jsp"></jsp:include>
			 </div>
		</div>
		<div class="row" style="margin-top: 60px;">
			 <div class="col-md-3">
			 	<jsp:include page="/common/menu.jsp"></jsp:include>
			 </div>
			 <div class="col-md-9">
			 	<div>
					<ol class="breadcrumb">
			 			 <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/user/toMain.html">主页</a></li>
			  			 <li class="active">${modeName}</li>
					</ol>
				</div>
				<jsp:include page="<%=mainPage %>"></jsp:include>
			 </div>
		</div>
		<div class="row">
			 <div class="col-md-12">
			 	<jsp:include page="/common/foot.jsp"></jsp:include>
			 </div>
		</div>
	</div>
</body>
</html>