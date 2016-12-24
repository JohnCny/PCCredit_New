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
<div class="report common">
    <h5>维护记录</h5>
    <table class="center">
        <tr>
            <th>选择</th>
            <th>维护类型</th>
            <th>维护时间</th>
            <th>维护人</th>
        </tr>
        <tr onclick="selectTR(this);$('#whxx').show()">
            <td><span class="hideInput"><input type="radio" name="radio0"><label class="radio"></label></span></td>
            <td>${tCustomerMaintenance.maintenanceType}</td>
            <td>2016-05-12</td>
            <td>${tCustomerMaintenance.operationName}</td>
        </tr>
    </table>
</div>
<div class="report common" style="display:none;" id="whxx">
    <h5>维护信息</h5>
    <table class="bxd">
        <tr>
            <td>维护类型：<span>${tCustomerMaintenance.maintenanceType}</span></td>
            <td>维护时间：<span>2016-05-12</span></td>
        </tr>
        <tr>
            <td>维护人：<span>${tCustomerMaintenance.operationName}</span></td>
            <td>维护纪要：<span>${tCustomerMaintenance.maintennaceSummary}</span></td>
        </tr>
    </table>
</div>

<p class="button">
    <input type="button" value="返回"  onclick="iframe('khwh_list.html')"/>
</p>

</#macro>

<#macro script>

</#macro>

<#macro js>


</#macro>
