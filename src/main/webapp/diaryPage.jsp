<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,diary.DiaryDAO,diary.DiaryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

var list = document.getElementsByClassName("myBtn");
for (var i = 0; i < list.length; i++) {
 list[i].setAttribute("id", "myBtnId" + i);
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
DiaryDAO dao = new DiaryDAO();
List<DiaryBean> bean = dao.showAllDiary(1);
request.setAttribute("diary", bean); 
%>
<body>
	<c:choose>
		<c:when test="${empty diary}">
                        目前尚未有任何日誌
        </c:when>
	<c:otherwise>
                      日誌列表：<br>
		<table border='1'>
			<tr>
				<th width='200'>標題</th>
				<th width='200'>建立時間</th>
				<th width='200'>上架時間</th>
				<th width='360'>下架時間</th>
			</tr>
			<c:forEach var="dBean" items="${diary}">
				<tr>
					<td>${dBean.diaryTitle}</td>
					<td>${dBean.diaryCreateTime}</td>
					<td>${dBean.diaryStrTime}</td>
					<td>${dBean.diaryEndTime}</td>
					<td>
					<!--<button onclick="location.href='UpdateDiaryServlet?diaryOid=${dBean.diaryOid}'">修改</button>
						-->
						<a href="UpdateDiaryServlet?diaryOid=${dBean.diaryOid}">修改</a>
					</td>
					
					<td>

					<a href="DeleteDiaryServlet?diaryOid=${dBean.diaryOid}" onclick="return(confirm('確定要刪除嗎'))">刪除</a></td>					
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<input type="button" onclick="location.href='createDiary.jsp';" value="新增日誌" />

</body>
</html>