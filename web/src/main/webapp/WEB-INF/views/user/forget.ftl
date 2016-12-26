<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .ifNone{
            display: none;
        }
        body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td, hr, button, article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
            margin: 0;
            padding: 0;
            font: 14px/1.5 "Microsoft YaHei",tahoma,arial,'Hiragino Sans GB','\5b8b\4f53',sans-serif;
        }
        #header{
            width: 100%;
            height: 100px;
            border-bottom: 1px solid #e3e3e3;
            background-color: #f0f0f0;
        }
        .header-layout {
            width: 990px;
            height:100%;
            margin: 0 auto;
            padding: 30px 0;
            overflow: hidden;
            vertical-align: middle;
        }
        .header-layout h1,.header-layout h2{
            float: left;
            font-weight: 500;

        }
        .header-layout h1{
            width:130px;
            height: 40px;
            font-weight: 500;
            background: url(/static/img/logo.png) no-repeat;
        }

        .header-layout h2{
            width: auto;
            height: 30px;
            padding: 5px 0 0 10px;
            line-height: 30px;
            font-size: 24px;
            color: #303030;
            margin-left:30px;
        }
        #content{
            width:900px;
            margin:50px auto;
        }
        .messageDiv{
            margin:20px auto;
            text-align: left;
        }
        p.message{
            font-size:14px;
            color:#6c6c6c;
        }
        .userNameDiv{
            width:800px;
            margin:50px auto;
        }
        .textInput{
            width:190px;
            height:18px;
            padding:5px;
            border-radius: 4px;
            margin-left: 20px;
        }
        .errorMsg{
            color:#e4393c;
            font-size: 14px;
            margin-left:58px;
            line-height:25px;
        }
        .base_btn{
            margin-top:20px;
            color: #fff;
            border: 1px solid #f40;
            background-color: #f40;
            line-height: 36px;
            width:100px;
            border-radius: 4px;
        }
        .codeImg,.codeDiv{
            margin: 50px;
        }

    </style>
</head>
<body>
    <!--头部-->
    <div id="header">
        <div class="header-layout">
            <h1></h1>
            <h2>找回密码</h2>
        </div>
    </div>
    <!--头部-->


    <!--主体内容-->
    <div id="content">
        <div class="messageDiv">
            <p class="message">
                请输入你需要找回登录密码的账户名
            </p>
        </div>

        <div class="userNameDiv">
            <div class="errorMsg">错误</div>
            <div>
            <label for="" class="label_base">登录名：<input class="userName textInput" name="userName" type="text" placeholder="请输入您的用户名"></label>
            </div>
            <div><button class="sure_btn base_btn" type="button">确定</button></div>
        </div>

        <div class="codeImg ifNone">
            <label for="" class="label_base">邮箱或手机号：<input class="address textInput" type="text" name="address" placeholder="请输入绑定的邮箱或手机号"></label>
            <div><button class="get base_btn" type="button" >获取验证码</button></div>
        </div>

        <div class="codeDiv ifNone">
            <label for="" class="label_base">新密码：<input type="text" name="code" class="code textInput" placeholder="请输入新密码"></label>
            <div><button class="sure base_btn" type="button" >确定</button></div>
        </div>

    </div>
    <!--主体内容-->

    <script type="text/javascript" src="/static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/static/js/QK.js"></script>
<script>
    $(function(){
        $(".sure_btn").click(function(){
            var userName = $(".userName").val();
            console.log(userName)
            if(userName.length>0){
                $.ajax({
                    type : "GET",
                    url : '/user/resetPassword/'+userName,
                    success : function(result){
                        var userId = result['data'];
                        if(!userId){
                            $(".errorMsg").removeClass("ifNone").html('该用户名不存在');
                        }else{
                            $(".codeImg").removeClass("ifNone");
                            $(".errorMsg").html("存在该用户名！").css("color","green");
                            $(".sure_btn").addClass("ifNone");
                            $(".codeImg .get").click(function(){
                                var address = $(".address").val();
                                $.ajax({
                                    type : "POST",
                                    url : "/user/resetPassword/sendCode",
                                    data : {"address":address,"userId":userId},
                                    success : function(result){
                                        if(result['code']!=200){
                                            $(".errorMsg").html(message(result['code']));
                                        }else{
                                            $(".codeImg .sure").click(function(){
                                                var code = $(".code").val();
                                                $.ajax({
                                                    type : "POST",
                                                    url: "/user/resetPassword/checkedCode",
                                                    data : {"code":code,"address":address},
                                                    success : function(result){
                                                        console.log(result)
                                                        if(result['code']!=200){
                                                            $(".errorMsg").html(message(result['code']));
                                                        }else{
                                                            $(".codeDiv").removeClass("ifNone")
                                                        }
                                                    }
                                                })
                                            })
                                        }
                                    }
                                })
                            })
                        }
                    }
                });
            }else{
                $(".errorMsg").html("用户名不能为空！")
            }
        })
    }());

</script>

</body>
</html>