<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}

button {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>

<body background="https://drimg01.scbao.com/160906/330613-160Z609251769.jpg" onload="javascript:document.insertMemberFormA.mId.focus();">
	<p />
<form name="insertMemberFormA" action="member.do" method="POST" enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='#C4E1FF'>
					<th height="60" colspan="2" align="center">新增商品資料</th>
				</tr>
			</thead>
			<tbody>

				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品編號:</td>
					<td width="600" height="40" align="left"><input id="Q1"
						style="text-align: left" name="mId" value="${param.mId}"
						type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品分類:</td>
					<td width="600" height="40" align="left"><input id="Q2"
						style="text-align: left" name="pswd" value="${param.pswd}"
						type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.password}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品名稱:</td>
					<td width="600" height="40" align="left"><input name="mName"
						value="${param.mName}" type="text" size="20" id="Q3">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.name}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">產地:</td>
					<td width="600" height="40" align="left"><input
						name="mAddress" value="${param.mAddress}" type="text" size="20"
						id="Q4">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.address}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">國際條碼:</td>
					<td width="600" height="40" align="left"><input name="mPhone"
						value="${param.mPhone}" type="text" size="20" id="Q5"></td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">製造日期:</td>
					<td width="600" height="40" align="left"><input
						name="mBirthday" value="${param.mBirthday}" type="text" size="20"
						id="Q6"> <font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font>
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.bday}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">價格:</td>
					<td width="600" height="40" align="left"><input name="mWeight"
						value="${param.mWeight}" type="text" size="20" id="Q7">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.weight}</div>
					</td>
				</tr>
				<tr bgcolor='#C4E1FF'>
					<td width="120" height="40">商品圖上傳:</td>
					<td width="600" height="40" align="left"><input name="picture"
						type="File" size="20" id="Q8">
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
	<hr>

	<table border="1" align="center">
		<thead>
			<tr bgcolor='#D9FFFF'>
				<th height="60" colspan="2" align="center">自動填入商品資料</th>
			</tr>
		</thead>
		<tbody>
			<tr bgcolor='#D9FFFF'>
				<td width="600" height="40" align="center">
					<button class="C1" style="width: 100px; height: 30px;">資料1</button>
					<button class="C2" style="width: 100px; height: 30px;">資料2</button>
					<button class="C3" style="width: 100px; height: 30px;">資料3</button>
					<button class="C4" style="width: 100px; height: 30px;">資料4</button>
					<button class="C5" style="width: 100px; height: 30px;">資料5</button>
				</td>
			</tr>
		<tbody>
	</table>
	<table border='1' align="center" bgcolor='#CECEFF'>
		<th><a href="<c:url value='/index.jsp' />">回首頁</a></th>

	</table>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


	//自動填入資料
	$(document).ready(function() {
		$(".C1").click(function() {
			$("#Q1").val('QQ1');
			$("#Q2").val('玩具');
			$("#Q3").val('狗狗玩偶');
			$("#Q4").val('台灣');
			$("#Q5").val('4710114815556');
			$("#Q6").val('2020-11-29');
			$("#Q7").val('249');
		})
	});
	$(document).ready(function() {
		$(".C2").click(function() {
			$("#Q1").val('QQ2');
			$("#Q2").val('玩具');
			$("#Q3").val('貓咪玩偶');
			$("#Q4").val('中國');
			$("#Q5").val('4710114815557');
			$("#Q6").val('2020-10-29');
			$("#Q7").val('200');
		})
	});
	$(document).ready(function() {
		$(".C3").click(function() {
			$("#Q1").val('QQ3');
			$("#Q2").val('飼料');
			$("#Q3").val('狗狗飼料');
			$("#Q4").val('台灣');
			$("#Q5").val('4710114815558');
			$("#Q6").val('2020-9-29');
			$("#Q7").val('250');
		})
	});
	$(document).ready(function() {
		$(".C4").click(function() {
			$("#Q1").val('QQ4');
			$("#Q2").val('飼料');
			$("#Q3").val('貓咪罐罐');
			$("#Q4").val('台灣');
			$("#Q5").val('4710114815559');
			$("#Q6").val('2020-9-29');
			$("#Q7").val('209');
		})
	});
	$(document).ready(function() {
		$(".C5").click(function() {
			$("#Q1").val('QQ5');
			$("#Q2").val('其他');
			$("#Q3").val('神奇海螺');
			$("#Q4").val('深海');
			$("#Q5").val('4710114815567');
			$("#Q6").val('1990-10-29');
			$("#Q7").val('20000');
		})
	});
	
</script>

</html>