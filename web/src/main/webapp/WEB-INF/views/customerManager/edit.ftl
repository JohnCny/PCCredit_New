<#include "layout/base.html"/>

<#macro style>
    <style>
        input,select{
            margin-top: 10px;
            width:70%
        }
        [v-cloak] {
            display: none
        }
        .cus_content{
            border: 1px solid #6F7691;
            padding-bottom: 30px;
            float: left;
        }

        .widclas{
            width: 20%;
            float: left;
            height:80px;
            margin-left: 10%;
            margin-top: 50px;
        }
        @media screen and (max-width: 1300px){
            .widclas{
                width: 30%;
                float: left;
                height:80px;
                margin-left: 10%;
                margin-top: 50px;
            }
        }
        .new_customer{
            padding: 50px;
        }
        .create{
            width: 100%;
            min-width: 700px;
            height: 30px;
            background-color: #6F7691;
            font-size: 16px;
            line-height: 30px;
            font-weight: bold;
            padding-left: 8px;
            color: #ffffff;
        }
        .contain{
            margin: 50px 0 0 8.7%;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>

</#macro>
<#macro content>

    <form class="content" href="/customerManager" method="post">
        <input type="hidden" name="id" value="${customerManager.userId}">
        <h1>管理</h1>
        <h2>当前位置：客户管理 / 客户经理管理 / ${customerManager.userCname} / <span>管理</span></h2>
        <div class="report common">
            <h5>客户经理信息</h5>
            <table>
                <tr>
                    <td class="pull-right">当前级别：</td><td><span class="blue">${customerManager.levelName}</span></td>
                    <td class="pull-right">系统建议：</td><td><span class="blue">${customerManager.systemLevel}</span></td>
                </tr>
                <tr>
                    <td class="pull-right">级别调整：</td>
                    <td>
                        <select name="levelId">
                            <#list customerManagerLevel as cml>
                                <option value="${cml.id}">${cml.value}</option>
                            </#list>
                        </select>
                    </td>
                    <td class="pull-right">是否暂停进件：</td>
                    <td><input type="text" name="status" value="${customerManager.status}"></td>
                </tr>
            </table>
        </div>
        <p class="button">
            <input type="submit" id="btn_submit" value="保存" />
            <input type="button" class="back" value="返回" onclick="iframe('khjl_list.html')"/>
        </p>
    </form>

</#macro>
<#macro script>
    <script>
        $(document).ready(function(){
            var url = "/customerBasic";
            var Obj = {};
            var arr = ["id","levelId","status"];

            $("#btn_submit").click(function (e) {
                e.preventDefault();
                for(var i = 0; i < arr.length; i++){
                    Obj[arr[i]]=$("#"+arr[i]).val();
                }
                console.log(Obj);
//                Obj = {"tUId":4156,"cname":"李明明",sex:41,certificateType:153,certificateNumber:123,tel:1535,homeAddress:15131,marriageStatus:12121,
//                    educationDegree:12313,userId:4135,customerManagerId:135132,createBy:110,createTime:'2016-12-16 10:25:36',modifyBy:1321,modifyTime:'2016-12-16 10:25:36',
//                    customerStatus:1231}
                $.ajax({
                    type:"put",
                    url:url,
                    data:Obj,
                    success: function(res){
                        if(res.code == 200){
                            location.href="/customerBasic/index";
                        }
                    },
                    error:function () {
                        alert("失败")
                    }
                });
            });
        });
    </script>

</#macro>
<#macro js>

</#macro>