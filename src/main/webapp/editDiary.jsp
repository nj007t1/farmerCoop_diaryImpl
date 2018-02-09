<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,diary.ZipCodeDAO,diary.ZipCodeBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ZipCodeDAO dao = new ZipCodeDAO();
		List<ZipCodeBean> list = dao.zipCodeList();
		request.setAttribute("zipList", list);
	%>
<h1>編輯日誌</h1>
	<form action="editDiary.do" method="POST">
		<table border='1'>
				   <tr>　　　　　　　　　　　　　
             <td colspan="2">日誌<input type="hidden" name="diaryOid" value="${edit.diaryOid}"/></td>           
         </tr>
				<tr>
					<td>標題:<input type="text" value="${edit.diaryTitle}" name="title"></td>
				</tr>
				<tr>
					<td>所屬農作物:<input type="text" value="${edit.productOid}" name="productOid"></td>
				</tr>
				<tr>
					<td>產地：<select name="zipCode">
							<c:forEach var="list" items="${zipList}">	
							<option value="${list.zipCode}">${list.zipCode} ${list.zipTownName}</option>
							</c:forEach>
					</select>
				
				</td>
				</tr>
				<tr>
					<td>上架時間:<input type="date" value="${edit.diaryStrTime}" name="strTime"></td>
				</tr>
				<tr>
					<td>下架時間:<input type="date" value="${edit.diaryEndTime}" name="endTime"></td>
				</tr>
		</table>
				<input type="submit" value="送出">
	</form>
</body>
</html>