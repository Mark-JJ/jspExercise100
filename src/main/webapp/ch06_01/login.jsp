<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登錄</title>
<style>
form {
	margin: 0 auto;
	width: 400px;
}
</style>

</head>
<body>

<form Action="login.do" method="POST">
    <table>
         <tr><th colspan='2'>
            <h1>登入</h1> 
         </th><th></th></tr>
         <tr>   
             <td width='180' align="RIGHT">帳號：</td>
             <td width='180' align="LEFT">
             	<input	type="text" name="userId" size="10" value="${param.userId}">
             </td>
             <td width='120'><small>
             	<font color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</font></small>
             </td>
         </tr>
         <tr>
             <td align="RIGHT">密碼：</td>
             <td align="LEFT" >
             	<input	type="password" name="pswd" size="10" value="${param.pswd}">
             </td>
             <td width='120'><small>
             	<font color='red'  size="-1">${ErrorMsgKey.PasswordEmptyError}</font></small>
             </td>
         </tr>            
         <tr>
             <td align="CENTER" colspan='3'>
             	<font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</font>
             </td>
         </tr>
        <tr>
            <td colspan="2" align="center">      
            	<input type="submit" value="提交"> </td>
            </tr>
         </Table>        
</form>
</body>

</html>
