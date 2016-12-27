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

    <div class="row new_customer">
        <div class=" cus_content">
            <div class="create">
                编辑
            </div>
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <form action="" id="contenttable">
                <input type="hidden" id="id" name="id" value="${tSysParameter.id}"/>
                <div class="widclas">
                    <label for="parameterName">参数名称：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input  id="parameterName" type="text" class="form-control" name="parameterName" value="${tSysParameter.parameterName}" placeholder="请输入至少2-10位汉字">
                    </div>
                </div>
                <div class="widclas">
                    <label for="parameterValue">参数值：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="parameterValue" type="text" class="form-control" name="parameterValue" value="${tSysParameter.parameterValue}" placeholder="请输入正确的手机号码">
                        <div class="message">${parameterValueError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="parameterNameZn">参数中文名：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input   id="parameterNameZn" type="text" class="form-control" name="parameterNameZn" value="${tSysParameter.parameterNameZn}" placeholder="请输入有效地址">
                        <div class="message">${parameterNameZnError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="parameterDescription">参数描述：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input   id="parameterDescription" type="text" class="form-control" name="parameterDescription" value="${tSysParameter.parameterDescription}" placeholder="请输入有效地址">
                        <div class="message">${parameterDescriptionError}</div>
                    </div>
                </div>

                <div class="col-xs-12 contain">
                    <button id="btn_submit" class="btn btn-success" style="background-color: #6F7691;border-radius: 0px;border: 1px solid #6F7691；">确定</button>
                    <a href="/system/index" type="reset" class="btn btn-default"style="border-radius: 0px;border: 1px solid #2bb8c4；">取消</a>
                </div>
            </form>
        </div>
    </div>


</#macro>
<#macro script>
<script>
    $(function () {
        var url = "/system";
        $("#btn_submit").click(function (e) {
            e.preventDefault();
            var Obj = $("#contenttable").serializeArray();
            console.log(Obj);
            $.ajax({
                type:"put",
                url:url,
                data:Obj,
                success: function(res){
                    if(res.code == 200){
                        location.href="/system/index";
                    }
                }
            });

        })
    })
</script>


</#macro>
<#macro js>

</#macro>