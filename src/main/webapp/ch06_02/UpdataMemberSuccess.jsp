<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品查詢</title>
</head>
<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg">
<table border='1' align="center">
<tr><th colspan='9' bgcolor='#C4E1FF'><h1>更新成功!!</h1></th></tr>
<tr bgcolor='#C4E1FF'>
	<th>商品編號</th>
	<th>商品分類</th>
	<th>商品名稱</th>
	<th>產地</th>
	<th>國際條碼</th>
	<th>製造日期</th>
	<th>價格</th>
	<th>圖片預覽</th>
</tr>
 <tr bgcolor='#C4E1FF'>
	<td>${memberBean.memberId}</td>
	<td>${memberBean.password}</td>
	<td>${memberBean.name}</td>
	<td>${memberBean.address}</td>
	<td>${memberBean.phone}</td>
	<td>${memberBean.birthday}</td>
	<td>${memberBean.weight}</td>
	<td><img src=${ memberBean.pictureFilePath } width="100" height="100"></td>
</tr>
</table>
<table border='1' align="center" bgcolor='#CECEFF'>
<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>
<th><a href="javascript:history.back()">回上一頁</a></th>
</table>
</body>
</html>