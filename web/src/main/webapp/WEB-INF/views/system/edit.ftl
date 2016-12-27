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
            <form action="">
                <div class="widclas">
                    <label for="type">字典类别：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input  id="type" type="text" class="form-control" name="" value="${dataDictionary.type}" placeholder="请输入至少2-10位汉字">
                    </div>
                </div>

                <div class="widclas">
                    <label for="code">字典代码：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="code" type="text" class="form-control" name="" value="${dataDictionary.code}" placeholder="请输入正确的手机号码">
                        <div class="message">${telError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="dataName">字典名称：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input   id="dataName" type="text" class="form-control" name="" value="${dataDictionary.dataName}" placeholder="请输入有效地址">
                        <div class="message">${homeAddressError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="bankCode">银行代码：</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input   id="bankCode" type="text" class="form-control" name="" value="${dataDictionary.bankCode}" placeholder="请输入有效地址">
                        <div class="message">${homeAddressError}</div>
                    </div>
                </div>
                <div class="col-xs-12 contain">
                    <button id="btn_submit" class="btn btn-success" style="background-color: #6F7691;border-radius: 0px;border: 1px solid #6F7691；">确定</button>
                    <a href="/customer/customer" type="reset" class="btn btn-default"style="border-radius: 0px;border: 1px solid #2bb8c4；">取消</a>
                </div>
            </form>
        </div>
    </div>


</#macro>
<#macro script>
    <script>
        $(document).ready(function(){
            var url = "/customerBasic";
            var Obj = {};
            var arr = ["cname","sex","certificateType","certificateNumber","tel","homeAddress","marriageStatus","educationDegree"];
            var createTime = "createTime",modifyTime = "modifyTime";

            $("#btn_submit").click(function (e) {
                e.preventDefault();
                for(var i = 0; i < arr.length; i++){
                    Obj[arr[i]]=$("#"+arr[i]).val();
                }
                var d = new Date();
                var vYear = d.getFullYear();
                var vMon = d.getMonth() + 1;
                var vDay = d.getDate();
                var h = d.getHours();
                var m = d.getMinutes();
                var se = d.getSeconds();
                var currentTime = vYear + "-" + vMon + "-" + vDay+" "+ h + ":" + m + ":" + se;
                Obj[createTime] = currentTime;
                Obj[modifyTime] = currentTime;
                console.log(Obj);
//                Obj = {"tUId":4156,"cname":"李明明",sex:41,certificateType:153,certificateNumber:123,tel:1535,homeAddress:15131,marriageStatus:12121,
//                    educationDegree:12313,userId:4135,customerManagerId:135132,createBy:110,createTime:'2016-12-16 10:25:36',modifyBy:1321,modifyTime:'2016-12-16 10:25:36',
//                    customerStatus:1231}
                $.ajax({
                    type:"post",
                    url:url,
                    data:Obj,
                    success: function(res){
                        if(res.code == 200){
                            //location.href="/customerBasic/success";
                        }
                    },
                    error:function () {

                    }
                });
            });

        });
    </script>

</#macro>
<#macro js>

</#macro>