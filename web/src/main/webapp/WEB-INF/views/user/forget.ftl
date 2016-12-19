<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .ifNone{
            display: none;
        }
    </style>
</head>
<body>
<div class="errorMsg ifNone"></div>
<input class="userName" name="userName" type="text" placeholder="请输入您的用户名">
<div class="codeImg ifNone" >
    <input type="text" placeholder="请输入绑定的邮箱或手机号">
    <button type="button" >获取验证码</button>
</div>

<script src="/static/js/QK.js"></script>
<script>
    var userName = $(".userName").val();
    $.ajax({
        type : "GET",
        url : 'user/resetPassword',
        data : {"userName" : userName},
        success : function(result){
            if(result['code'] != 200){
                $(".errorMsg").removeClass("ifNone").html(message(result['code']));
            }else{
                $(".userName").addClass("ifNone");
                $(".codeImg").removeClass("ifNone");
                $(".errorMsg").addClass("ifNone");
            }

        }
    });
</script>

</body>
</html>