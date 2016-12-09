<%--
  Created by IntelliJ IDEA.
  User: admins
  Date: 2016/12/5
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form1" name="form1" method="get" action="/api/user/login">
    <table width="260" border="1" align="center">
        <tr>
            <td width="64">用户：</td>
            <td width="180"><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td> <input type="password" name="password" /></td>
        </tr>
        <tr>
            <td> </td>
            <td>
                <input type="submit" name="Submit2" value="登录" />
                <input type="reset" name="Submit" value="重置" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
