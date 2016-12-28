<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input,select{
            border: 1px solid lightgray;
            border-radius: 3px;
        }
        input{
            height: 35px;
            padding: 5px;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>新增角色</h1>
    <h2>当前位置：系统管理 / 角色权限管理 / <span>新增角色</span></h2>
</#macro>
<#macro content>
    <form class="content">
        <div class="report common">
            <h5>填写角色信息</h5>
            <table>
                <tr>
                    <td class="pull-right" width="100px" nowrap>角色名称<font class="red">*</font>：</td>
                    <td width="900px" nowrap><input type="text"></td>
                </tr>
            </table>
        </div>
        <div class="report common">
            <h5>配置角色权限</h5>
            <table  width="95%" border="1" cellpadding="2" cellspacing="1">
                <tr>
                    <td class="pull-right" width="80px" nowrap>进件管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="80px" nowrap>客户管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="110px" nowrap>客户经理管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="80px" nowrap>贷后管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="pull-right" width="80px" nowrap>风险控制：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="80px" nowrap>产品管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="80px" nowrap>统计报表：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right" width="80px" nowrap>系统管理：</td>
                    <td width="100px" nowrap>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
        <p class="button">
            <input type="button" value="保存"/>
            <input type="button" class="back" value="返回"/>
        </p>
    </form>

</#macro>

<#macro script>

</#macro>

<#macro js>
    <script>
        $(function () {

        });
    </script>

</#macro>
