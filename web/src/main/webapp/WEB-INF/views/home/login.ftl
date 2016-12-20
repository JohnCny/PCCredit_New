<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>乾康微贷管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <link href="/static/css/login.css" rel="stylesheet">
</head>
<body>
<div class="login-box">
    <img src="../static/img/login-logo1.png"/>
    <form id="loginForm">
        <!--错误信息提示-->
			<div class="errorMessage">
				<img src="/static/img/icon-warning.png"/>&nbsp;<span></span>
			</div>
        <input  id="user" name="userName" type="text" class="login-input" placeholder="用户名">
        <input id="password" name="password" type="password" class="login-input" placeholder="密码">

        <input type="button" class="login-button" value="登&nbsp;&nbsp;录">
        <div class="codeImg">

        </div>
        <div class="forgetPwd">
            <a href="/user/anon/resetPasswordPage">忘记密码？</a>
        </div>
    </form>
</div>
<script type="text/javascript" src="/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/static/js/QK.js"></script>

<script type="text/javascript">
    $(function () {
        $(".login-button").click(function(){
            var userName = $("#user").val();
            var password = $("#password").val();
            var data = {"userName" : userName,"password" : password};
            if(userName.length >= 3){
                $.ajax({
                    type : "POST",
                    url : "/logon/login",
                    data : data,
                    success : function(result){
                        if(result.code != 200){
                            $(".errorMessage").show().find("span").text(message(result['code']));
                        }else{
                            window.location.href = '/index';
                        }
                    }
                })
            }
        })
    }());
</script>
</body>
</html>
