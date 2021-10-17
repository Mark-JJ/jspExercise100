<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
div{
padding: 20px
}
th{
padding: 30px
}
</style>

<title>期中專題</title>
</head>

<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg">

<div align="center" >


<%-- <a href="<c:url value='/ch06_01/login.jsp' />">登入(Lab06_01)</a><p/> --%>
<%-- <a href="<c:url value='/ch06_01/logout.jsp' />">登出(Lab06_01)</a><p/> --%>

<table border='1' align="center">
<tr>
<th colspan='9' bgcolor='#CECEFF'>
<h1>期中專題</h1>
<h1>黃俊傑 座號11號</h1>
</th>
</tr>
<tr bgcolor='#CECEFF'>
	<th>
	<a href="<c:url value='/ch06_02/InsertMemberForm.jsp' />"><h2>新增商品資料</h2></a><br>
	<a href="<c:url value='/ch06_02/SelectMembers.jsp' />"><h2>查詢商品資料</h2></a><br>
	<a href="<c:url value='/ch06_02/ShowMember20.do' />"><h2>更新商品資料</h2></a><br>
	<a href="<c:url value='/ch06_02/ShowMember.do' />"><h2>刪除商品資料</h2></a><br>
	<a href="<c:url value='/ch06_03/ShowMember.do' />"><h2>顯示現有商品資料</h2></a>
		<a href="<c:url value='/ch06_02/UAndDServlet.do' />"><h2>修改與刪除測試中</h2></a>

	</th>

	
</tr>

</table>
</body>
</html>