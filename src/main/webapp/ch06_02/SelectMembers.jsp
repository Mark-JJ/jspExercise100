<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢商品資料</title>
<style>
form {
	margin: 0 auto;
	width: 1200px;
}
table {
	margin: 0 auto;
	width: 1200px;
}
</style>
</head>
<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg">

	<form name="deletMemberFormA" action="member4.do" onSubmit="" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='#FFBD9D'>
					<th height="60" colspan="2" align="center">查詢商品資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='#FFBD9D'>
					<td width="200" height="40">想查詢的商品編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="mId" value="${param.mId}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.id}</div>
					</td>	
				</tr>
				<tr bgcolor='#FFBD9D'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="查詢"></td>
				</tr>
				
			</tbody>
		</table>
		<div style="color:#FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
	</table>
	<table border='1' align="center" bgcolor='#CECEFF'>
	<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>
	</table>
	
</body>
</html>