<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>OA管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/main.css" rel="stylesheet">
    <style>
        input[type=password]{
            display: inline-block;
            height: 20px;
            padding: 4px 6px;
            margin-bottom: 10px;
            font-size: 14px;
            line-height: 20px;
            color: #555555;
            vertical-align: middle;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
        }
        .common{
            background-color: #f7f7f7;
        }
    </style>

</head>

<body>
<div class="content">
    <h1>修改密码</h1>
    <h2>当前位置：<span>修改密码</span></h2>
    <div class="report common">
        <h5>填写新密码</h5>
        <form id="Form">
            <table style="margin: 0 auto">
                <tr>
                    <td class="pull-right">原始密码<font class="red">*</font>：</td>
                    <td style="width:60%">
                        <div style="display: none" class="errorMessage"><span></span></div>
                        <input type="password" name="oldPassword" id="oldPassword" />
                    </td>
                </tr>
                <tr>
                    <td class="pull-right">新密码<font class="red">*</font>：</td>
                    <td>
                        <input type="password" name="newPassword" id="newPassword" >
                    </td>
                </tr>
                <tr>
                    <td class="pull-right">确认新密码<font class="red">*</font>：</td>
                    <td>
                        <input type="password" id="newPasswordAgain"/>
                    </td>
                </tr>
            </table>
            <p class="button" style="text-align:center;">
                <input id="change_button" type="button" value="提 交" style="margin-right:10px;"/>
                <input type="reset" value="重 置"/>
            </p>
        </form>
    </div><!--/row-fluid -->
</div><!--/content -->

<script src="/static/js/jquery-1.10.2.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/QK.js"></script>
<!--信息验证 -->
<script src="/static/js/SpryAssets/jquery.validate.min.js"></script>
<script src="/static/js/SpryAssets/messages_zh.js"></script>
<script type="text/javascript">
    $(function () {
        $("#change_button").click(function(){
            var oldPassword = $("#oldPassword").val();
            var newPassword = $("#newPassword").val();
            var newPasswordAgain = $("#newPasswordAgain").val();
            var data = {"oldPassword" : oldPassword,"newPassword" : newPassword};
            if(newPassword == newPasswordAgain){
                $.ajax({
                    type : "POST",
                    url : "/user/updatePassword",
                    data : data,
                    success : function(result){
                        if(result.code != 200){
                            $(".errorMessage").show().find("span").text(message(result['code']));
                        }else{
                            window.location.href = '/logout';
                        }
                    }
                })
            }else{
                $(".errorMessage").show().find("span").text('两次密码输入不一致！');
            }
        })
    }());

</script>

</body>
</html>
