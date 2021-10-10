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
<title>Insert title here</title>
</head>
<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg">
<table border='1' align="center">
<tr><th colspan='9' bgcolor='#C4E1FF'>商品資料表</th></tr>
<tr bgcolor='#C4E1FF'>
	<th>商品編號</th>
	<th>商品分類</th>
	<th>商品名稱</th>
	<th>產地</th>
	<th>國際條碼</th>
	<th>製造日期</th>
	<th>商品上架日期</th>
	<th>價格</th>
	<th>圖片預覽</th>
</tr>
<c:forEach var='member' items='${allMembers}'>
 <tr bgcolor='#C4E1FF'>
	<td>${member.memberId}</td>
	<td>${member.password}</td>
	<td>${member.name}</td>
	<td>${member.address}</td>
	<td>${member.phone}</td>
	<td>${member.birthday}</td>
	<td>${member.registerDate}</td>
	<td>${member.weight}</td>
	<td><img src=${ member.pictureFilePath } width="100" height="100"></td>
</tr>
</c:forEach>
</table>
</table>
<table border='1' align="center" bgcolor='#CECEFF'>
<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>
</table>
</body>
</html>