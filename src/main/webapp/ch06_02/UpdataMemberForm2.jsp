<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新商品資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg">



	<form name="updataMemberFormB" action="member3.do" method="POST"
		enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='#C4E1FF'>
					<th height="60" colspan="2" align="center">更新商品資料</th>
				</tr>
			</thead>
			<tbody>

				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品編號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="mId" value="${param.mId}"
						type="text" size="20" readonly>
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.password}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品分類:</td>
					<td width="600" height="40" align="left"><input id='num2'
						style="text-align: left" name="pswd"
						value="${ memberBean.password }${param.pswd}" type="text"
						size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.password}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品名稱:</td>
					<td width="600" height="40" align="left"><input id='num3'
						style="text-align: left" name="mName"
						value="${memberBean.name}${param.mName}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.name}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">產地:</td>
					<td width="600" height="40" align="left"><input
						name="mAddress" value="${ memberBean.address }${param.mAddress}"
						type="text" size="20">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.address}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">國際條碼:</td>
					<td width="600" height="40" align="left"><input name="mPhone"
						value="${ memberBean.phone }${param.mPhone}" type="text" size="20"></td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">製造日期:</td>
					<td width="600" height="40" align="left"><input
						name="mBirthday"
						value="${ memberBean.birthday }${param.mBirthday}" type="text"
						size="20"> <font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font>
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.bday}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">價格:</td>
					<td width="600" height="40" align="left"><input name="mWeight"
						value="${ memberBean.weight }${param.mWeight}" type="text"
						size="20">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.weight}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品圖上傳:</td>
					<td width="600" height="40" align="left"><input name="picture"
						type="File" size="20">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.picture}</div>
					</td>
				</tr>

				<tr bgcolor='#C4E1FF'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>

			</tbody>
		</table>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>

	</form>
	<table border='1' align="center" bgcolor='#CECEFF'>
		<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>
		<th><a href="javascript:history.back()">回上一頁</a></th>
	</table>
</body>

</html>