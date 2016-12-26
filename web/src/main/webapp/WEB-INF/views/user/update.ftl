<#include "layout/base.html"/>
<#assign title = "用户管理"/>
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
</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>用户</h1>
<h2>当前位置：用户管理 / <span class="active">用户</span></h2>

</#macro>
<#macro content>
<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
    <div class="col-xs-3" style="background-color: #fff ;border-radius: 5px">
        <div class="report common list">
            <h5>机构列表</h5>
            <div class="treeBox" style="height: 581px;">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div class="col-xs-1"></div>
    <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
        <div class="report common" style="display:inline-block;width:100%">
            <h5>填写用户信息</h5>
            <form action="" id="userAdd">
                <table>
                    <tr>
                        <td class="pull-right">姓名：</td>
                        <td><input type="text" name="userCname" value="${user.userCname}"></td>
                        <td class="pull-right">登录名：</td>
                        <td><input type="text" name="username" value="${user.username}"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">员工工号：</td>
                        <td><input type="text" name="employeeNumber" value="${user.employeeNumber}"></td>
                        <td class="pull-right">电话：</td>
                        <td><input type="text" name="phone" value="${user.phone}"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">年龄：</td>
                        <td><input type="text" name="age" value="${user.age}"></td>
                        <td class="pull-right">性别：</td>
                        <td>
                            <select name="sex">
                                <!-- <option>-&#45;&#45;请选择-&#45;&#45;</option>
                                 <option value="1">男</option>
                                 <option value="2">女</option>-->
                                <#if user.sex == 1>
                                    <option value="1" selected>男</option>
                                    <option value="2">女</option>
                                <#else>
                                    <option value="2" selected>女</option>
                                    <option value="1">男</option>
                                </#if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">邮箱：</td>
                        <td><input type="text" name="email" value="${user.email}"></td>
                        <td class="pull-right">机构：</td>
                        <td>
                            <input type="text" readonly="readonly" data-id="${org.id}" id="orgId"
                                   value="${org.orgName}">
                            <input type="hidden" id="orgHidden">
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td class="pull-right">用户角色：</td>
                        <td colspan="3">
                            <#list roleAll as temp>
                                <span class="hideInput">
                                <input id="roleId_${temp.id}" type="radio" data-id="${userRole.roleId}"
                                       value="${temp.id}">
                                <input type="hidden" id="roleHidden">
                                    <#if userRole.roleId == temp.id>
                                        <label onclick="setRadio(this,'roleId_${temp.id}')"
                                               class="radio radio_a">${temp.roleNameZh}</label>
                                    <#else>
                                        <label onclick="setRadio(this,'roleId_${temp.id}')"
                                               class="radio">${temp.roleNameZh}</label>
                                    </#if>
                            </span>
                            </#list>

                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">用户状态：</td>
                        <td colspan="3">
                            <#if user.status == 0>
                                <span class="hideInput"><input type="radio" name="status" value="0"
                                                               checked="checked"><label onclick="setRadio(this)"
                                                                                        class="radio radio_a">正常</label></span>
                                <span class="hideInput"><input type="radio" name="status" value="1"><label
                                        onclick="setRadio(this)" class="radio">锁定</label></span>
                            <#else>
                                <span class="hideInput"><input type="radio" name="status" value="0"><label
                                        onclick="setRadio(this)" class="radio">正常</label></span>
                                <span class="hideInput"><input type="radio" name="status" value="1"
                                                               checked="checked"><label onclick="setRadio(this)"
                                                                                        class="radio radio_a">锁定</label></span>
                            </#if>
                        </td>
                    </tr>
                </table>

                <p class="button">
                    <input type="button" value="保存" class="submit"/>
                    <input type="button" class="back" value="返回"/>
                </p>
            </form>
        </div>

    </div>
</div>



</#macro>

<#macro script>
<script type="text/javascript" src="/static/js/ztree-org.js"/>
</#macro>

<#macro js>
<script type="text/javascript">
    var urlMy = "/organization/orgAll";
    var setting = {
        data: {
            simpleData: {
                enable: true,
            }
        },
        callback: {
            onClick: onClick
        }
    };
    baseTree(urlMy, setting);
    function onClick(event, treeId, treeNode, clickFlag) {
        $("#orgId").attr("value", treeNode.name);
        $("#orgId").attr("data-id", treeNode.id);

    }
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


</script>

</#macro>
