<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除商品資料</title>
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
<body>
	
	
	<table border='1' bgcolor='#C4E1FF'>
		<tr>
			<th colspan='11' bgcolor='#C4E1FF'>現有商品資料表</th>
		</tr>
		<tr>
			<th>商品編號</th>
			<th>商品分類</th>
			<th>商品名稱</th>
			<th>產地</th>
			<th>國際條碼</th>
			<th>製造日期</th>
			<th>商品上架日期</th>
			<th>價格</th>
			<th>圖片預覽</th>
			<th>編輯商品</th>
			<th>刪除商品</th>
		</tr>
		
		<c:forEach var='member' items='${allMembers}' varStatus="s">
		<form name="" action="UandD2.do"
		onSubmit="" method="POST">
			<tr bgcolor='#C4E1FF'>
				<td>${member.memberId}</td>
				<td>${member.password}</td>
				<td>${member.name}</td>
				<td>${member.address}</td>
				<td>${member.phone}</td>
				<td>${member.birthday}</td>
				<td>${member.registerDate}</td>
				<td>${member.weight}</td>
				<td><img src=${ member.pictureFilePath } width="100"
					height="100"></td>
				<td align="center">
				<input	name="mId" type="hidden" value="${member.memberId}">
				<input	type="submit" value="編輯" onclick='this.form.action="member40.do";'>
				</td>
				<td align="center">
				<input	name="mId" type="hidden" value="${member.memberId}">
				<input	type="submit" value="刪除" class="de">
				</td>
				
			</tr>
		</form>
		</c:forEach>
	</table>

	<table border='1' align="center" bgcolor='#CECEFF'>
		<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>
	</table>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


	//自動填入資料
	$(document).ready(function() {
		$(".de").click(function() {
			var yes = confirm('你確定嗎？');

			if (yes) {
			    alert('刪除成功');
			} else {
				this.form.action="";
			    alert('取消刪除');
			}
		})
	});
</script>
</html>