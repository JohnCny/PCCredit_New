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
    <div class="col-xs-3" style="background-color: #fff ;border-radius: 5px;height: 705px">
        <div class="report common list">
            <h5>机构列表</h5>
            <div class='treeBox'>
                <ul id='treeDemo' class='ztree'></ul>
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
                        <td><input type="text" name="userCname"></td>
                        <td class="pull-right">登录名：</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">员工工号：</td>
                        <td><input type="text" name="employeeNumber"></td>
                        <td class="pull-right">电话：</td>
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">年龄：</td>
                        <td><input type="text" name="age"></td>
                        <td class="pull-right">性别：</td>
                        <td>
                            <select name="sex">
                                <option>---请选择---</option>
                                <option value="1">男</option>
                                <option value="2">女</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">邮箱：</td>
                        <td><input type="text" name="email"></td>
                        <td class="pull-right">机构：</td>
                        <td><input type="text" name="orgId" value="3"></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td class="pull-right">用户角色：</td>
                        <td colspan="3">
                            <#list roleAll as temp>
                                <span class="hideInput"><input id="roleId" type="radio" name="roleId"
                                                               value="${temp.id}"><label onclick="setRadio(this)"
                                                                                         class="radio">${temp.roleNameZh}</label></span>
                            </#list>
                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">用户状态：</td>
                        <td colspan="3">
                            <span class="hideInput"><input type="radio" name="status" value="0"><label
                                    onclick="setRadio(this)" class="radio">正常</label></span>
                            <span class="hideInput"><input type="radio" name="status" value="1"><label
                                    onclick="setRadio(this)" class="radio">锁定</label></span>
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
        function setRadio(obj) {//单选样式
            $(obj).parent().parent().find("input[type=radio]").attr("checked", false)
            $(obj).parent().parent().find("label").attr("class", "radio")
            $(obj).parent().find("input[type=radio]").attr("checked", true)
            $(obj).parent().find("label").attr("class", "radio radio_a")
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
