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

<form class="content">
    <h1>调整</h1>
    <h2>当前位置：客户管理 / 客户经理级别定义 <span>新增</span></h2>
    <div class="report common">
        <h5>客户经理级别信息</h5>
        <table>
            <tr>
                <td class="pull-right">级别名称：</td>
                <td><input type="text" name="levelName" id="levelName" ></td>
                <td class="pull-right">对应额度：</td>
                <td><input type="text" name="levelCredit" id="levelCredit"></td>
            </tr>
            <tr>
                <td class="pull-right">逾期容忍率：</td>
                <td><input type="text" name="overdueTolerateRate" id="overdueTolerateRate"></td>
                <td class="pull-right">不良容忍率：</td>
                <td><input type="text" name="badloanTolerateRate" id="badloanTolerateRate"></td>
            </tr>
            <tr>
                <td class="pull-right">贷后监控容忍量：</td>
                <td><input type="text" name="postloanMonitorTolerateNum" id="postloanMonitorTolerateNum"></td>
                <td class="pull-right">该级别贷款最小额度：</td>
                <td><input type="text" name="loanLimitMin" id="loanLimitMin"></td>
            </tr>
            <tr>
                <td class="pull-right">该级别贷款最小笔数：</td>
                <td><input type="text" name="loanNumberMin" id="loanNumberMin"></td>
                <td class="pull-right">该级别最小逾期率：</td>
                <td><input type="text" name="overdueRateMin" id="overdueRateMin"></td>
            </tr>
            <tr>
                <td class="pull-right">该级别最小不良率</td>
                <td colspan="3"><input type="text" name="badloanRateMin" id="badloanRateMin"></td>
            </tr>
        </table>
    </div>
    <p class="button">
        <input type="button" id="btn_submit" value="保存"/>
        <input type="button" class="back" value="返回"/>
    </p>
</form>


</#macro>
<#macro script>
    <script>
        $(document).ready(function(){
            var url = "/customerManagerLevel";
            var Obj = {};
            var arr = ["levelName","levelCredit","overdueTolerateRate","badloanTolerateRate","postloanMonitorTolerateNum"
                ,"loanLimitMin","loanNumberMin","overdueRateMin","badloanRateMin"];

            $("#btn_submit").click(function (e) {
                e.preventDefault();
                for(var i = 0; i < arr.length; i++){
                    Obj[arr[i]]=$("#"+arr[i]).val();
                }
                console.log(Obj);
                $.ajax({
                    type:"post",
                    url:url,
                    data:Obj,
                    success: function(res){
                        if(res.code == 200){
                            location.href="/customerManagerLevel/index";
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