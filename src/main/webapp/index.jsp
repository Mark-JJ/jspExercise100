<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
div{
padding: 20px;
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

<table border='1' align="left">
<tr>
<th colspan='8' bgcolor='#CECEFF'>
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
	<a href="<c:url value='/ch06_02/UAndDServlet.do' />"><h2>修改與刪除(成功)</h2></a>
	<a href="<c:url value='/ch06_02/CBS.do' />"><h2>多筆刪除功能</h2></a>
	<input	type="submit" value="區域變動" onclick='getBrowse();'>
	<input	type="submit" value="區域變動2" onclick='getBrowse2();'>
	<input	type="submit" value="區域變動3" onclick='loadContent();'>
	</th>	
</tr>
</table>

<!-- <div id="content" align="center" style="border: 3px solid red; width: 800px; height: 1000px; background: #D0D0D0;"> -->
<!-- <H1>我是DIV</H1> -->
<!-- </div> -->
<div id="content"></div>


</body >
<script type="text/javascript">
function getBrowse(){
   var rep = new XMLHttpRequest(); //XMLHttpRequest和伺服器做連線
   rep.open("post","/jspExercise100/ch06_02/UAndDServlet.do"); //設定連線的網址
   rep.onload = function(){ //load事件 偵測連線的狀態
    var content = document.getElementById("content");
    content.innerHTML = this.responseText;
   }
   rep.send(); //送出連線
  }
function getBrowse2(){
	   var rep = new XMLHttpRequest(); //XMLHttpRequest和伺服器做連線
	   rep.open("post","<c:url value='/ch06_02/InsertMemberForm.jsp' />"); //設定連線的網址
	   rep.onload = function(){ //load事件 偵測連線的狀態
	    var content = document.getElementById("content");
	    content.innerHTML = this.responseText;
	   }
	   rep.send("mId=qianyu"); //送出連線
	  }
// function loadContent() { 
// 	$("#content").load('/ch06_02/UAndDServlet.do'}//content即為你載入頁面的div 
</script>
</html>