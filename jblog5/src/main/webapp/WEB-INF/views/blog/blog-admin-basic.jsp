<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script>
$(function(){
	$("#file-upload").on("click", function(){ 
		alert("11");
	});
	
	
});
</script>	
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/includes/blog-title.jsp" />
			<c:import url="/WEB-INF/views/includes/blog-menu.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected">기본설정</li>
					<li><a
						href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/category">카테고리</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/write">글작성</a></li>
				</ul>
				<form action="" method="post" enctype="multipart/form-data">
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="title"
								value="${blogInfo.title }"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<td>
								<c:choose>
									<c:when test="${empty blogInfo.logo }">
										<img
											src="${pageContext.servletContext.contextPath }/assets/images/spring-logo.jpg" />
									</c:when>
									<c:otherwise>
										<img
											src="${pageContext.servletContext.contextPath }/assets/logo/${blogInfo.logo }" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" id="file-upload" name="logoFile"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="upload" ></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
	</div>
</body>
</html>