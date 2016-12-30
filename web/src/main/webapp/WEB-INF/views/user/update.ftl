<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/radio.css">
</#macro>
<#macro style>
<style>
    input, select {
        border: 1px solid rgba(0, 0, 0, 0.2);
        height: 30px;
        border-radius: 5px
    }

    table, table tr, table tr td {
        background-color: #fff
    }

    .captap {
        width: 80px;
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
    @media screen and (max-width: 980px) {
        .widclas {
            width: 80%;
            float: left;
            height: 80px;
            margin-left: 10%;
            margin-top: 30px;
        }
        .hideInput{display: block}
    }
    .ledd{
        margin-left: 10%;
        clear: both;
    }
    .contain{
        margin-left: 9.3%;
        margin-top: 30px;
    }
    </style>
</#macro>

<#macro breadcrumb>
    <h3>
        用户编辑
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：用户编辑</a>
        </li>
        <li class="active"> 用户编辑</li>
    </ul>
</#macro>
<#macro content>
<!--<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">-->
    <!--&lt;!&ndash;<div class="col-xs-3" style="background-color: #fff ;border-radius: 5px">&ndash;&gt;-->
        <!--&lt;!&ndash;<div class="report common list">&ndash;&gt;-->
            <!--&lt;!&ndash;<h5>机构列表</h5>&ndash;&gt;-->
            <!--&lt;!&ndash;<div class="treeBox" style="height: 581px;">&ndash;&gt;-->
                <!--&lt;!&ndash;<ul id="treeDemo" class="ztree"></ul>&ndash;&gt;-->
            <!--&lt;!&ndash;</div>&ndash;&gt;-->
        <!--&lt;!&ndash;</div>&ndash;&gt;-->
    <!--&lt;!&ndash;</div>&ndash;&gt;-->
    <!--<div class="col-xs-1"></div>-->
    <!--<div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">-->
        <!--<div class="report common" style="display:inline-block;width:100%">-->
            <!--<h5>填写用户信息</h5>-->
            <!--<form action="" id="userAdd">-->
                <!--<table>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">姓名：</td>-->
                        <!--<td>-->
                            <!--<input type="text" name="userCname" value="${user.userCname}">-->
                            <!--<input type="hidden" id="id" name="id" value="${user.id}">-->
                        <!--</td>-->
                        <!--<td class="pull-right">登录名：</td>-->
                        <!--<td><input type="text" name="username" value="${user.username}"></td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td class="pull-right captap">员工工号：</td>-->
                        <!--<td><input type="text" name="employeeNumber" value="${user.employeeNumber}"></td>-->
                        <!--<td class="pull-right">电话：</td>-->
                        <!--<td><input type="text" name="phone" value="${user.phone}"></td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">年龄：</td>-->
                        <!--<td><input type="text" name="age" value="${user.age}"></td>-->
                        <!--<td class="pull-right">性别：</td>-->
                        <!--<td>-->
                            <!--<select name="sex">-->
                                <!--<option value="1" <#if user.sex == 1>selected</#if>>男</option>-->
                                <!--<option value="2" <#if user.sex == 2>selected</#if>>女</option>-->
                            <!--</select>-->
                        <!--</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">邮箱：</td>-->
                        <!--<td><input type="text" name="email" value="${user.email}"></td>-->
                        <!--<td class="pull-right">机构：</td>-->
                        <!--<td>-->
                            <!--<input type="text" readonly="readonly" disabled="disabled" id="orgId" value="${org.orgName}">-->
                            <!--<input type="hidden" id="orgHidden" data-id="${org.id}">-->
                        <!--</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">身份证：</td>-->
                        <!--<td><input type="text" readonly="readonly" disabled="disabled" value="${user.idCardNumber}"></td>-->
                        <!--<td class="pull-right">用户类型：</td>-->
                        <!--<td>-->
                            <!--<select name="userType">-->
                                <!--<option value="1" <#if user.userType == 1>selected</#if>>系统用户</option>-->
                                <!--<option value="2" <#if user.userType == 2>selected</#if>>客户经理</option>-->
                                <!--<option value="3" <#if user.userType == 3>selected</#if>>部门主管</option>-->
                                <!--<option value="4" <#if user.userType == 4>selected</#if>>机构主管</option>-->
                            <!--</select>-->
                        <!--</td>-->
                    <!--</tr>-->
                <!--</table>-->
                <!--<table>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">用户角色：</td>-->
                        <!--<td colspan="3">-->
                            <!--<#list roleAll as temp>-->
                                <!--<span class="hideInput">-->
                                <!--<input id="roleId_${temp.id}" type="radio" data-id="${userRole.roleId}"-->
                                       <!--value="${temp.id}">-->
                                <!--<input type="hidden" id="roleHidden">-->
                                    <!--<#if userRole.roleId == temp.id>-->
                                        <!--<label onclick="setRadio(this,'roleId_${temp.id}')"-->
                                               <!--class="radio radio_a">${temp.roleNameZh}</label>-->
                                    <!--<#else>-->
                                        <!--<label onclick="setRadio(this,'roleId_${temp.id}')"-->
                                               <!--class="radio">${temp.roleNameZh}</label>-->
                                    <!--</#if>-->
                            <!--</span>-->
                            <!--</#list>-->

                        <!--</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td class="pull-right">用户状态：</td>-->
                        <!--<td colspan="3">-->
                            <!--<#if user.status == 0>-->
                                <!--<span class="hideInput"><input type="radio" name="status" value="0"-->
                                                               <!--checked="checked"><label onclick="setRadio(this)"-->
                                                                                        <!--class="radio radio_a">正常</label></span>-->
                                <!--<span class="hideInput"><input type="radio" name="status" value="1"><label-->
                                        <!--onclick="setRadio(this)" class="radio">锁定</label></span>-->
                            <!--<#else>-->
                                <!--<span class="hideInput"><input type="radio" name="status" value="0"><label-->
                                        <!--onclick="setRadio(this)" class="radio">正常</label></span>-->
                                <!--<span class="hideInput"><input type="radio" name="status" value="1"-->
                                                               <!--checked="checked"><label onclick="setRadio(this)"-->
                                                                                        <!--class="radio radio_a">锁定</label></span>-->
                            <!--</#if>-->
                        <!--</td>-->
                    <!--</tr>-->
                <!--</table>-->

                <!--<p class="button">-->
                    <!--<input type="button" value="保存" class="submit"/>-->
                    <!--<input type="button" class="back" value="返回"/>-->
                <!--</p>-->
            <!--</form>-->
        <!--</div>-->

    <!--</div>-->
<!--</div>-->



















    <div class="row">
        <div class="col-sm-12">

            <div class="col-md-3">
                <div class="report common list">
                    <section class="panel">
                        <header class="panel-heading">
                            用户编辑
                        </header>
                        <div class="treeBox">
                            <ul id="treeDemo" class="ztree"></ul>
                        </div>
                    </section>
                </div>
            </div>

            <div class="col-xs-9">
                <section class="panel">
                    <header class="panel-heading">
                        用户列表
                    </header>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                <div class="row-fluid">
                                    <form action="" id="userAdd">
                                        <div class="widclas">
                                            <label for="">姓名</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control"  name="userCname" value="${user.userCname}" placeholder="请输入至少2-10位汉字">
                                                <input type="hidden" id="id" name="id" value="${user.id}">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">登录名</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="username" value="${user.username}"placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">员工工号</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="employeeNumber" value="${user.employeeNumber}" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">电话</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="phone" value="${user.phone}" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">年龄</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="age" value="${user.age} placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">性别</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <select name="sex" class="form-control">
                                                    <option value="1" <#if user.sex == 1>selected</#if>>男</option>
                                                    <option value="2" <#if user.sex == 2>selected</#if>>女</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">邮箱</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="email" value="${user.email}" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">机构</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input class="form-control"  readonly="readonly"  id="orgId" value="${org.orgName}" disabled="disabled" placeholder="请输入至少2-10位汉字">
                                                <input type="hidden" id="orgHidden" data-id="${org.id}">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">身份证</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text"  name="idCardNumber"  readonly="readonly" disabled="disabled" value="${user.idCardNumber}">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">用户类型</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <select name="userType" class="form-control">
                                                    <option value="1" <#if user.userType == 1>selected</#if>>系统用户</option>
                                                    <option value="2" <#if user.userType == 2>selected</#if>>客户经理</option>
                                                    <option value="3" <#if user.userType == 3>selected</#if>>部门主管</option>
                                                    <option value="4" <#if user.userType == 4>selected</#if>>机构主管</option>
                                                </select>
                                            </div>
                                        </div>




                                        <div class="ledd">
                                            <label for="" style="">用户角色</label>
                                            <#list roleAll as temp>
                                                <span class="hideInput">
                                                <input id="roleId_${temp.id}" type="radio" data-id="${userRole.roleId}"
                                                       value="${temp.id}">
                                                <input type="hidden" id="roleHidden">
                                                    <#if userRole.roleId == temp.id>
                                                        <label onclick="setRadio(this,'roleId_${temp.id}')"
                                                               class="radio radio_a" style="padding-left: 30px">${temp.roleNameZh}</label>
                                                    <#else>
                                                        <label onclick="setRadio(this,'roleId_${temp.id}')"
                                                               class="radio" style="padding-left: 30px">${temp.roleNameZh}</label>
                                                    </#if>
                                            </span>
                                            </#list>
                                        </div>



                                        <div class="ledd">
                                            <label for="" style="display: inline-block">用户状态</label>
                                            <div class="input-icon right" style="display: inline-block">
                                                <i class="fa"></i>
                                                <#if user.status == 0>
                                                <span class="hideInput">
                                                    <input type="radio" name="status" value="0"checked="checked">
                                                    <label onclick="setRadio(this)"class="radio radio_a" style="padding-left: 30px">正常</label>
                                                </span>
                                                <span class="hideInput"><input type="radio" name="status" value="1"><label
                                                        onclick="setRadio(this)" class="radio" style="padding-left: 30px">锁定</label></span>
                                                                    <#else>
                                                <span class="hideInput"><input type="radio" name="status" value="0"><label
                                                        onclick="setRadio(this)" class="radio" style="padding-left: 30px">正常</label></span>
                                                <span class="hideInput"><input type="radio" name="status" value="1"
                                                                               checked="checked"><label onclick="setRadio(this)"
                                                                                                        class="radio radio_a" style="padding-left: 30px">锁定</label></span>
                                                </#if>
                                            </div>
                                        </div>
                                        <div class=" contain">
                                            <button id="btn_submit" class="btn btn-success submit">保存
                                            </button>
                                            <a href="/user" type="reset" class="btn btn-default back" style=" border: 1px solid rgba(0, 0, 0, 0.2);">返回</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>

</#macro>



<#macro script>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>
<#macro js>
<script type = "text/javascript" >
        $(document).ready(function () {
            var urlMy = "/organization/orgAll";
            var setting = {
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: "orgParentId"
                    },
                    key: {
                        name: "orgName",
                    }
                },
                callback: {
                    onClick: onClick
                }
            };
            baseTree(urlMy, setting);
            function onClick(event, treeId, treeNode, clickFlag) {
                $("#orgId").attr("value", treeNode.orgName);
                $("#orgHidden").attr("name", "orgid");
                var orgIds = $("#orgHidden").data("id") + "," + treeNode.id
                $("#orgHidden").attr("value", orgIds);

            }
        });
</script>
<script>
    function setRadio(obj, inputId) {//单选样式
        $(obj).parent().parent().find("input[type=radio]").attr("checked", false)
        $(obj).parent().parent().find("label").attr("class", "radio")
        $(obj).parent().find("input[type=radio]").attr("checked", true)
        $(obj).parent().find("label").attr("class", "radio radio_a")

        $("#roleHidden").attr("name", "roleId");
        var value = $("#" + inputId).data("id") + "," + $("#" + inputId).val();
        $("#roleHidden").attr("value", value);
    }
    $(function () {

        var url = "/user";
        $(".submit").click(function (e) {
            e.preventDefault();
            var obj = $("#userAdd").serializeArray();
            obj.push({"name": "roleId", "value": $("#roleId").val()});
            console.log(obj);
            $.ajax({
                type: "post",
                url: url,
                data: obj,
                success: function (res) {
                    if (res.code == 200) {
                        alert("添加成功");
                        location.href = "/user";
                    }
                }
            })
        })
    })
</script>
</#macro>
