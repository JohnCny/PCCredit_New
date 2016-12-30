<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input, select {
            margin-top: 0px;
            width: 70%
        }

        [v-cloak] {
            display: none
        }

        .cus_content {
            /*border: 1px solid #6F7691;*/
            padding-bottom: 30px;
            float: left;
            margin-left: 2.5%;
            background-color: #F7F7F7;
        }

        .widclas {
            width: 20%;
            float: left;
            height: 80px;
            margin-left: 10%;
            margin-top: 30px;
        }

        @media screen and (max-width: 1300px) {
            .widclas {
                width: 30%;
                float: left;
                height: 80px;
                margin-left: 10%;
                margin-top: 30px;
            }
        }
        .contain {
            margin: 50px 0 0 8.7%;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h3>
        客户编辑
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户编辑</a>
        </li>
        <li class="active"> 客户编辑</li>
    </ul>
</#macro>
<#macro content>




    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    客户编辑
                </header>
                <div class="panel-body">
                    <div class="table-responsive">
                        <form id="contenttable" action="">
                            <#list dropDownList as dropDown>
                                <div class="report common">
                                    <input class="searchBtn" type="hidden" name="id" id="id" value="${tCustomerBasic.id}">
                                    <div class="widclas">
                                        <label for="cname">姓名</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input type="text" id="cname" name="cname" class="form-control" value="${tCustomerBasic.cname}">
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="">证件类型</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select name="certificateType" class="form-control">
                                                <#list dropDown.cert as cert>
                                                    <option <#if tCustomerBasic.certificateType == cert.id>selected</#if>  value="${cert.id}">
                                                    ${cert.value}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="certificateNumber">证件号码</label>
                                        <div class="input-icon right">
                                            <i class="fa checkId"></i>
                                            <input type="text" disabled id="certificateNumber" class="form-control" name="certificateNumber" value="${tCustomerBasic.certificateNumber}">
                                            <div class="message" id="idMessage"></div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="tel">手机号码</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input type="text" id="tel" name="tel" class="form-control" value="${tCustomerBasic.tel}">
                                            <div class="message">${telError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="homeAddress">家庭住址</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input type="text" id="homeAddress" name="homeAddress" class="form-control" value="${tCustomerBasic.homeAddress}">
                                            <div class="message">${homeAddressError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="">婚姻状况</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select name="marriageStatus" class="form-control">
                                                <#list dropDown.marriageStatus as marriageStatus>
                                                    <option <#if tCustomerBasic.marriageStatus == marriageStatus.id>selected</#if>  value="${marriageStatus.id}">
                                                    ${marriageStatus.value}
                                                    </option>
                                                </#list>
                                            </select>
                                            <div class="message">${marriageError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="">教育情况</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select name="educationDegree" class="form-control">
                                                <#list dropDown.educationDegree as educationDegree>
                                                    <option <#if tCustomerBasic.educationDegree == educationDegree.id>selected</#if>  value="${educationDegree.id}">
                                                    ${educationDegree.value}
                                                    </option>
                                                </#list>
                                            </select>
                                            <div class="message">${eductionError}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 contain">
                                    <button id="btn_submit" class="btn btn-success">保存</button>
                                </div>
                            </#list>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>
</#macro>

<#macro script>
<script>
    $(function () {
        var url = "/customerBasic";
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
                     location.href="/customerBasic/index";
                    }
                }
            });

       })
    })

</script>
</#macro>

<#macro js>


</#macro>
