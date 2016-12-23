<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
    <style>
        input,select{border:1px solid  rgba(0, 0, 0, 0.2);height: 30px;border-radius: 5px}
        table, table  tr,table  tr td {background-color: #fff}
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>用户</h1>
    <h2>当前位置：用户管理 / <span class="active">用户</span></h2>

</#macro>
<#macro content>
    <div class="row" style="background-color: #efefef;width: 100%;margin-left: 0" >
        <div class="col-xs-3" style="background-color: #fff ;border-radius: 5px">
            <div class="report common list" >
                <h5>机构列表</h5>
                <div class='treeBox'><ul id='treeDemo' class='ztree'></ul></div>
            </div>
        </div>
        <div class="col-xs-1"></div>
        <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
            <div class="report common" style="display:inline-block;width:100%">
                <h5>填写用户信息</h5>
                <table>
                    <tr>
                        <td class="pull-right">姓名：</td>
                        <td><input type="text"></td>
                        <td class="pull-right">登录名：</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">用户类型：</td>
                        <td>
                            <select>
                                <option>---请选择---</option>
                                <option>系统用户</option>
                                <option>客户经理</option>
                                <option>部门主管</option>
                                <option>机构主管</option>
                            </select>
                        </td>
                        <td class="pull-right">员工工号：</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td class="pull-right">年龄：</td>
                        <td><input type="text"></td>
                        <td class="pull-right">性别：</td>
                        <td>
                            <span class="hideInput"><input type="radio" name="radio"><label onclick="setRadio(this)" class="radio">男</label></span>
                            <span class="hideInput"><input type="radio" name="radio"><label onclick="setRadio(this)" class="radio">女</label></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">邮箱：</td>
                        <td><input type="text"></td>
                        <td class="pull-right">电话：</td>
                        <td><input type="text"></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td class="pull-right">用户角色：</td>
                        <td colspan="3">
                            <span class="hideInput"><input type="radio" name="radio1"><label onclick="setRadio(this)" class="radio">系统管理员</label></span>
                            <span class="hideInput"><input type="radio" name="radio1"><label onclick="setRadio(this)" class="radio">客户经理</label></span>
                            <span class="hideInput"><input type="radio" name="radio1"><label onclick="setRadio(this)" class="radio">客户经理主管</label></span>
                            <span class="hideInput"><input type="radio" name="radio1"><label onclick="setRadio(this)" class="radio">管理岗</label></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="pull-right">用户状态：</td>
                        <td colspan="3">
                            <span class="hideInput"><input type="radio" name="radio2"><label onclick="setRadio(this)" class="radio">激活</label></span>
                            <span class="hideInput"><input type="radio" name="radio2"><label onclick="setRadio(this)" class="radio">未激活</label></span>
                        </td>
                    </tr>
                </table>
                <p class="button">
                    <input type="button" value="保存" onclick="iframe('user.html')"/>
                    <input type="button" class="back" value="返回" onclick="iframe('user.html')"/>
                </p>
            </div>

        </div>
    </div>



</#macro>

<#macro script>
    <script>

    </script>

</#macro>

<#macro js>



    </script>

</#macro>
