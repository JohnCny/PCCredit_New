<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input{
            border-radius: 5px;
        }
        .flow{
            padding: 30px 0 30px 30px;
        }
        .flow_index{
            width: 200px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            background-color: rgba(153,153,153,0.2);
        }
        .checked{
            background-color:rgba(17,148,299,0.2);
        }

        .usernameput{
            margin-top: 20px;
        }
        .usernameput input{
            width: 250px;
            height: 35px;
            border:1px solid rgba(153,153,153,0.5);
            padding: 5px;
        }
        .button_next{
            width: 250px;
            height: 30px;
            background-color: rgb(17,148,229);
            display: block;
            margin-top: 20px;
            text-decoration: none;
        }
        .button_a{
            text-decoration: none !important;
        }
        .line_flow li{
            float: left;
            list-style: none;
        }
        .editor-label label{
            width: 300px;
        }
        #formUl li label{
            float: left;
            font-size: 14px;
            font-weight: lighter;
            font-family: 微软雅黑;
            text-align: right;
            width: 100px;
            line-height: 35px;
        }
        #formUl li input{
            height: 35px;
        }
        #formUl li{
            list-style: none;
        }
        #formUl{
            margin-top: 50px;
        }
        .inpttext{
            border:1px solid rgba(153,153,153,0.5);
            padding: 5px;
            width: 120px;
            margin-left: 180px;
        }
        @media screen and (max-width: 920px) {
            .line_flow li{
                list-style: none;
                margin-top: 20px;
                float: none;
            }
            .inpttext{
                margin-left: 0px;
            }
        }
        .changepass{
            margin-left: 100px;
        }
        @media screen and (max-width: 635px){
            .changepass{
                margin-left: 0px;
            }
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>重置密码</h1>
    <h2>当前位置：安全中心 / <span class="active">（重置密码）</span></h2>
</#macro>
<#macro content>
    <div class="flow">
        <div class="flow_all">
            <ul class="line_flow">
                <li>
                    <div class="flow_index checked one">
                        <img class="oneImg" src="../../../static/images/onecheck.png" alt="">
                        <span>请输入用户名</span>
                    </div>
                </li>
                <li>
                    <div class="flow_index two">
                        <img class="twoImg" src="../../../static/images/two.png" alt="">
                        <span>安全验证</span>
                    </div>
                </li>
                <li>
                    <div class="flow_index three">
                        <img class="threeImg" src="../../../static/images/three.png" alt="">
                        <span>重置密码</span>
                    </div>
                </li>
            </ul>
        </div>
        <div style="clear: both;margin-top: 20px">
            <p class="errorMsg" style="display:block"></p>
        </div>
        <div class="usernameput usernameputone">
            <p> 请输入您需要找回的用户名</p>
            <input type="text" placeholder="用户名" class="userName">
            <a href="javascript:void(0);" class="button_a"><span class="btn btn-info button_next sure_btn" style="">下一步</span></a>
        </div>

        <div class="usernameput usernameputtwo" style="display: none">
            <p>为了您的账号安全，请完成身份验证</p>
            <p style="font-size: 16px;margin: 30px 0 0 0;color: rgb(51,51,51);">手机号码或绑定邮箱号：<input type="text" placeholder="请输入绑定的邮箱或手机号" class="address"></p>
            <input type="text" class="inpttext" style="">
            <input type="button" class="get" value="免费获取验证码" style="height: 35px;width:110px; background-color: rgb(17,148,229);display: inline-block;line-height: 35px;border-radius: 5px;text-align: center;color: #fff">
            <p style="font-size: 14px;margin-top: 30px;color: rgb(153,153,153);">邮箱不可用?<a href="" style="text-decoration: none">请使用手机验证</a></p>
            <a href="javascript:void(0);" class="button_a"><span class="btn btn-info button_next next_p" style="">下一步</span></a>
        </div>

        <div class="usernameput passwordChange" style="display: none">
            <ul id="formUl">
                <li>
                    <label class="changeSize">新密码：</label>
                    <input type="text" name="amDeliveryAmount" id="DeliveryAmount" class="form-control" value="" placeholder="请输入新密码"/>
                </li>
                <li>
                    <label class="changeSize">重复新密码：</label>
                    <input type="text" name="amStartTime" id="startTime" class="form-control" value="" placeholder="请再次输入新密码"/>
                </li>
             </ul>
            <a href="javascript:void(0)" class="button_a"><span class="btn btn-info button_next changepass">完成</span></a>
        </div>

    </div>


</#macro>

<#macro script>
    
</#macro>

<#macro js>)
    <script>
        $(function () {
            $(".sure_btn").click(function(){
                var userName = $(".userName").val();
                console.log(userName);
                if(userName.length>0){
                    $.ajax({
                        url:'/user/anon/resetPassword/'+userName,
                        type:"get",
                        success:function (res) {
                            var userId = res['data'];
                            if(!userId){
                                $(".errorMsg").html('该用户名不存在').css("color","red");
                            }else {
                                    $(".errorMsg").html('');
                                    $(".usernameputone").hide()
                                    $(".usernameputtwo").show();
                                    $(".one").removeClass("checked");
                                    $(".oneImg").attr("src" , "../../../static/images/one.png");
                                    $(".two").addClass("checked");
                                    $(".twoImg").attr("src" , "../../../static/images/twocheck.png");
                                    $(".get").click(function () {
                                        var address = $(".address").val();
                                        if(address == ""){
                                            $(".errorMsg").html('手机号或邮箱不能为空').css("color","red");
                                        }else{
                                                $(".errorMsg").html('');
                                                $.ajax({
                                                    type : "POST",
                                                    url : "/user/anon/resetPassword/sendCode",
                                                    data : {"address":address,"userId":userId},
                                                    success:function (res) {
                                                        if(res['code'] != 200){
                                                            $(".errorMsg").html(message(result['code']));
                                                        }else {
                                                            $(".next_p").click(function () {
                                                                if($(".inpttext") == ""){
                                                                    $(".errorMsg").html('验证码不能为空').css("color","red");
                                                                }else {
                                                                    $(".errorMsg").html('');
                                                                    var code = $(".inpttext").val();
                                                                    $.ajax({
                                                                        type : "POST",
                                                                        url: "/user/anon/resetPassword/checkedCode",
                                                                        data : {"code":code,"address":address},
                                                                        success:function (res) {
                                                                            if(res.code != 200){
                                                                                $(".errorMsg").html('验证码错误').css("color","red");
                                                                            }else{
                                                                                $(".errorMsg").html('');
                                                                                $(".usernameputtwo").hide();
                                                                                $(".passwordChange").show();
                                                                                $(".two").removeClass("checked");
                                                                                $(".three").addClass("checked");
                                                                                $(".twoImg").attr("src" , "../../../static/images/two.png");
                                                                                $(".threeImg").attr("src" , "../../../static/images/threecheck.png");
                                                                                var datas = res.data;
                                                                                console.log(datas);
                                                                                $(".changepass").click(function () {
                                                                                   var  password1 = $("#DeliveryAmount").val();
                                                                                    var password2 = $("#startTime").val();
                                                                                    if (password1 != password2){
                                                                                        $(".errorMsg").html('两次密码输入不一致').css("color","red");
                                                                                    }else {
                                                                                        $.ajax({
                                                                                            type:"post",
                                                                                            url:"/user/anon/resetPassword/"+ datas +"",
                                                                                            data:{"userId":userId,"password":password1},
                                                                                            success:function (res) {
                                                                                                if(res.code == 200){
                                                                                                    alert("重置成功");
                                                                                                }
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            });
                                                        }
                                                    }
                                                });
                                            }
                                        });
                            }
                        }
                    });
                }else {
                    $(".errorMsg").html('用户名不能为空').css("color","red");
                }
            })
        })
        var wait=60;
        function time(o) {
            if (wait == 0) {
                o.attr("disabled" , "");
                o.value="免费获取验证码";
                wait = 60;
            } else {
                o.attr("disabled", "disabled");
                o.value="重新发送(" + wait + ")";
                wait--;
                setTimeout(function() {
                            time(o)
                        }, 1000)
            }
        }
    </script>


</#macro>
