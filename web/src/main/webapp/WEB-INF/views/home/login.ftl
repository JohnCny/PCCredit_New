<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>乾康微贷管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <link href="/static/css/login.css" rel="stylesheet">
    <style type="text/css">

    </style>

</head>
<body>
<div class="login-box">
    <img src="../static/img/login-logo1.png"/>
    <form id="loginForm">
        <!--错误信息提示-->
			<span class="errorMessage">
				<img src="../static/img/error.png"/>&nbsp;<span></span>
			</span>
        <input  id="user" name="userName" type="text" class="login-input" placeholder="用户名">
        <input id="password" name="password" type="password" class="login-input" placeholder="密码">

        <input type="button" class="login-button" value="登&nbsp;&nbsp;录">
    </form>
</div>
<script type="text/javascript" src="/static/js/jquery-1.10.2.min.js"></script>

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
                        }
                        returnWebPage?viewName = /home/index
                    }
                })
            }

        })
    }());


    var obj = {
        '200' : '接口成功',
        '401' : '没有权限',
        '404' : '未找到',
        '500' : '服务器错误',
        '5001' : 'token失效',
        '5002' : '参数错误',
        '5003' : '用户已存在',
        '5004' : '密码错误',
        '5005' : '账号未激活',
        '5006' : '账号不存在',
        '5007' : '账号被锁定',
        '5008' : '验证码错误',
        '5009' : '登陆密码错误次数过多',
        '5010' : '验证码超时',
        '5011' : '没有登陆',
        '5012' : '没有权限',
        '5013' : '不是合法的邮箱或手机号',
        '5014' : '填写的绑定邮箱错误',
        '5015' : '填入的绑定手机号错误',
        '5016' : '修改密码:原密码错误',
        '5017' : '账号未激活',
        '5018' : '账号或密码为空',
        '5019' : '必填参数不能为空',
        '5020' : '操作失败',
        '5021' : '请求超时',
        '5022' : '登陆超时',
        '5023' : '接口签名不匹配',
        '5024' : '客户输入验证码为空',
    }
    function message(code){
        return obj[code]
    }
</script>
</body>
</html>
