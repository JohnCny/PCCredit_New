<#include "layout/base.html"/>

<#macro style>
    <style>
        input,select{
            width:80%
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
        .new_customer{
            padding: 50px;
        }
        .create{
            width: 100%;
            height: 30px;
            background-color: #6F7691;
            font-size: 16px;
            line-height: 30px;
            font-weight: bold;
            padding-left: 8px;
            color: #ffffff;
        }
        .contain{
            margin: 50px 0 0 140px;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro content>

        <div class="row new_customer">
            <div class=" cus_content">
                <div class="create">
                    新建
                </div>
                <!-- BEGIN EXAMPLE TABLE PORTLET-->

                <form action="" id="customer_new">
                <div class="widclas">
                    <label for="cname">姓名</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input  id="cname" type="text" class="form-control" name="" value="" placeholder="请输入至少2-10位汉字">
                    </div>
                </div>
                <div class="widclas">
                    <label for="nationality">客户状态</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="sex" type="text"  name="sex" class="form-control">
                            <option value="">--请选择--</option>
                            <option value="1">正常</option>
                            <option value="0">高风险用户</option>
                            <option value="0">黑白单用户</option>
                            <option value="0">禁用客户</option>
                        </select>
                        <div class="message">${nationalityError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="sex">性别</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="sex" type="text"  name="sex" class="form-control">
                            <option value="">--请选择--</option>
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
                        <div class="message">${sexError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="certificateType">证件类型</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="certificateType" type="text" name="certificateType" class="form-control">
                            <option value="">--请选择--</option>
                            <option value="1" selected>身份证</option>
                        </select>
                        <div class="message">${certificateTypeError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="certificateNumber">证件号码</label>
                    <div class="input-icon right">
                        <i class="fa checkId"></i>
                        <input data-error="${idNumberError}" id="certificateNumber" type="text" class="form-control idNumber" name="certificateNumber" value="${customerBasicInfo.idNumber}" placeholder="请输入有效证件号码">
                        <div class="message" id="idMessage"></div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="homeAddress">家庭住址</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input data-error="${homeAddressError}"  id="homeAddress" type="text" class="form-control" name="homeAddress" value="${customerBasicInfo.homeAddress}" placeholder="请输入有效地址">
                        <div class="message">${homeAddressError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="zipCode">邮编</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input data-error="${zipCodeError}" id="zipCode" type="text" class="form-control" name="zipCode" value="${customerBasicInfo.zipCode}" placeholder="请输入正确的邮编">
                        <div class="message">${zipCodeError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="email">电子邮箱</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input data-error="${emailError}" id="email" type="text" class="form-control" name="email" value="${customerBasicInfo.email}" placeholder="请输入有效的电子邮件地址">
                        <div class="message">${emailError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="tel">手机号码</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input data-error="${telError}" id="tel" type="text" class="form-control" name="tel" value="${customerBasicInfo.tel}" placeholder="请输入正确的手机号码">
                        <div class="message">${telError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="marriage">婚姻状况</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="marriage" type="text"  name="marriage" class="form-control" >
                            <option value="">--请选择--</option>
                            <option value="1">未婚</option>
                            <option value="2">已婚</option>
                            <option value="3">离婚</option>
                            <option value="4">丧偶</option>
                        </select>
                        <div class="message">${marriageError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="educationDegree">教育情况</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="educationDegree" type="text" class="form-control" name="eduction" >
                            <option value="">--请选择--</option>
                            <option value="1">本科以上</option>
                            <option value="2">本科</option>
                            <option value="3">大专</option>
                            <option value="4">高中/中专</option>
                            <option value="5">初中及以下</option>
                        </select>
                        <div class="message">${eductionError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="residenceAddress">户籍地址</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="residenceAddress" type="text" class="form-control" name="residenceAddress" placeholder="请输入您的户籍地址">
                        <div class="message">${residenceAddressError}</div>
                    </div>
                </div>
                <div class="widclas">
                    <label for="ifLegalPerson">是否为法人</label>
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select id="ifLegalPerson" type="text" class="form-control" name="ifLegalPerson" >
                            <option value="">--请选择--</option>
                            <option value="1">法人</option>
                            <option value="0">自然人</option>
                        </select>
                        <div class="message">${ifLegalPersonError}</div>
                    </div>
                </div>

                <div class="col-xs-12 contain">
                    <button id="btn_submit" class="btn btn-success" style="background-color: #6F7691;border-radius: 0px;border: 1px solid #6F7691；">确定</button>
                    <a href="/customers/originalInformation/list" type="reset" class="btn btn-default"style="border-radius: 0px;border: 1px solid #2bb8c4；">取消</a>
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
            var arr = ["cname","sex","certificateType","certificateNumber","tel","homeAddress","educationDegree"];
            var createTime = "createTime",modifyTime = "modifyTime", viewName = "viewName";

            $("#btn_submit").click(function () {
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
                conso
                console.log(Obj);le.log(currentTime);
                $.ajax({
                    type:"post",
                    url:url,
                    data:Obj,
                    success: function(){

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