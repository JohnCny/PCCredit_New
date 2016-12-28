<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>

</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>${title}</h1>
    <h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
    <form class="content">
        <h1>新增角色</h1>
        <h2>当前位置：系统管理 / 角色权限管理 / <span>新增角色</span></h2>
        <div class="report common">
            <h5>填写角色信息</h5>
            <table>
                <tr>
                    <td class="pull-right">角色名称<font class="red">*</font>：</td>
                    <td><input type="text"></td>
                </tr>
            </table>
        </div>
        <div class="report common">
            <h5>配置角色权限</h5>
            <table>
                <tr>
                    <td class="pull-right">进件管理：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">客户管理：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">客户经理管理：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">贷后管理：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="pull-right">风险控制：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">产品管理：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">统计报表：</td>
                    <td>
                        <select class="short">
                            <option>---请选择---</option>
                            <option>维护</option>
                            <option>查询</option>
                            <option>无权限</option>
                        </select>
                    </td>
                    <td class="pull-right">系统管理：</td>
                    <td>
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
            <input type="button" value="保存" onclick="iframe('rule_list.html')"/>
            <input type="button" class="back" value="返回" onclick="iframe('rule_list.html')"/>
        </p>
    </form>

</#macro>

<#macro script>

</#macro>

<#macro js>
    

</#macro>
