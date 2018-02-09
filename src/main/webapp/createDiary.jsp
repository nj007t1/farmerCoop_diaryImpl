<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,diary.ZipCodeDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ZipCodeDAO dao = new ZipCodeDAO();
		List list = dao.zipCodeList();
		request.setAttribute("zipList", list);
	%>
	<h1>新增日誌</h1>
	<form action="createDiary.do" method="POST">
		<table border=1>
			<tr>
				<td>日誌標題：<input type="text" name="title"></td>
			</tr>
			<tr>
				<td>所屬農作物：<select name="productOid">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select>
				</td>
			</tr>
			<tr>
					
					<td>產地：<select name="zipCode">
							<c:forEach var="list" items="${zipList}">	
							<option value="${list.zipCode}">${list.zipCode} ${list.zipTownName}</option>
							</c:forEach>
					</select>
				
				</td>
			</tr>
		</table>
		<input type="submit" value="送出">
	</form>

</body>
</html>