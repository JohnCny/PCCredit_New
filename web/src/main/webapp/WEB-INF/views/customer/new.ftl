<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/radio.css">
</#macro>
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

<#macro breadcrumb>
    <h3>
       新建客户
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户管理</a>
        </li>
        <li class="active"> 新建客户</li>
    </ul>
</#macro>
<#macro content>
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    新建客户
                </header>
                <div class="panel-body">
                    <div class="table-responsive">

                            <form action="">
                                <#list dropDownList as dropDown>
                                    <div class="widclas">
                                        <label for="cname">姓名</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input id="cname" type="text" class="form-control" name="" value=""
                                                   placeholder="请输入至少2-10位汉字">
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="sex">性别</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select id="sex" type="text" name="" class="form-control">
                                                <option value="">&#45;&#45;请选择&#45;&#45;</option>
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
                                            <div class="message">${certificateTypeError}</div>

                                            <select id="certificateType" type="text" name="" class="form-control">
                                                <option value="">&#45;&#45;请选择&#45;&#45;</option>
                                                <#list dropDown.cert as cert>
                                                    <option value="${cert.id}">${cert.value}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="certificateNumber">证件号码</label>
                                        <div class="input-icon right">
                                            <i class="fa checkId"></i>
                                            <input data-error="${idNumberError}" id="certificateNumber" type="text"
                                                   class="form-control idNumber"
                                                   name="" value="${customerBasicInfo.idNumber}" placeholder="请输入有效证件号码">
                                            <div class="message" id="idMessage"></div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="tel">手机号码</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input data-error="${telError}" id="tel" type="text" class="form-control" name=""
                                                   value="${customerBasicInfo.tel}" placeholder="请输入正确的手机号码">
                                            <div class="message">${telError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="homeAddress">家庭住址</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <input id="homeAddress" type="text" class="form-control" name=""
                                                   value="${customerBasicInfo.homeAddress}" placeholder="请输入有效地址">
                                            <div class="message">${homeAddressError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="marriageStatus">婚姻状况</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select id="marriageStatus" type="text" name="" class="form-control">

                                                <option value="">&#45;&#45;请选择&#45;&#45;</option>
                                                <#list dropDown.marriageStatus as marriageStatus>
                                                    <option value="${marriageStatus.id}">${marriageStatus.value}</option>
                                                </#list>
                                            </select>
                                            <div class="message">${marriageError}</div>
                                        </div>
                                    </div>
                                    <div class="widclas">
                                        <label for="educationDegree">教育情况</label>
                                        <div class="input-icon right">
                                            <i class="fa"></i>
                                            <select id="educationDegree" type="text" class="form-control" name="">
                                                <option value="">&#45;&#45;请选择&#45;&#45;</option>
                                                <#list dropDown.educationDegree as educationDegree>
                                                    <option value="${educationDegree.id}">${educationDegree.value}</option>
                                                </#list>
                                            </select>
                                            <div class="message">${eductionError}</div>
                                        </div>
                                    </div>


                                    <div class="col-xs-12 contain">
                                        <button id="btn_submit" class="btn btn-success">确定
                                        </button>
                                        <a href="/customer/customer" type="reset" class="btn btn-default">取消</a>
                                    </div>
                                </#list>
                            </form>

                    </div>
                </div>
            </section>
        </div>
    </div>

</#macro>
<#macro js>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>
<#macro script>
<script>
    $(document).ready(function () {
        var url = "/customerBasic";
        var urls = "/customerBasic/idCardExist";
        var OBJ = {};
        var Obj = {};
        var arr = ["cname", "sex", "certificateType", "certificateNumber", "tel", "homeAddress", "marriageStatus", "educationDegree"];
        var createTime = "createTime", modifyTime = "modifyTime";

        $("#btn_submit").click(function (e) {
            e.preventDefault();
            for (var i = 0; i < arr.length; i++) {
                Obj[arr[i]] = $("#" + arr[i]).val();
            }
            var d = new Date();
            var vYear = d.getFullYear();
            var vMon = d.getMonth() + 1;
            var vDay = d.getDate();
            var h = d.getHours();
            var m = d.getMinutes();
            var se = d.getSeconds();
            var currentTime = vYear + "-" + vMon + "-" + vDay + " " + h + ":" + m + ":" + se;
            Obj[modifyTime] = currentTime;
            console.log(Obj);
            console.log(Obj["certificateNumber"]);
//                Obj = {"tUId":4156,"cname":"李明明",sex:41,certificateType:153,certificateNumber:123,tel:1535,homeAddress:15131,marriageStatus:12121,
//                    educationDegree:12313,userId:4135,customerManagerId:135132,createBy:110,createTime:'2016-12-16 10:25:36',modifyBy:1321,modifyTime:'2016-12-16 10:25:36',
//                    customerStatus:1231}
            $.ajax({
                type: "post",
                url: url,
                data: Obj,
                success: function (res) {
                    if (res.code == 200) {
                            location.href="/customerBasic/index";
                    }
                },
                error: function () {

                }
            });
        });
        $("#certificateNumber").blur(function () {
            var datas = $("#certificateNumber").val();
            console.log(datas);
            OBJ["identityCard"] = datas;
            console.log(OBJ);
            $.ajax({
                type: "get",
                url: urls,
                data: OBJ,
                success: function (res) {
                    if (res.code == 200) {

                    }
                },
                error:function () {
                    alert(dasdsd)
                }

            })
        });

    });
</script>

</#macro>
