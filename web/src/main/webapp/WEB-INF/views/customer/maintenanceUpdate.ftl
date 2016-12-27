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
    <#list  tCustomerMaintenance as temptCustomerMaintenance>
        <tr onclick="selectTR(this);">
            <td>
                <span class="hideInput"><input type="radio" name="radio0"><label class="radio"></label></span>
            </td>
                <td>${temptCustomerMaintenance.maintenanceType}</td>
                <td>${temptCustomerMaintenance.operationTime?string("yyyy-MM-dd")}</td>
                <td>${temptCustomerMaintenance.operationName}</td>
        </tr>
    </#list>

    </table>
</div>
<div id="lllllllllll">
    <#list  tCustomerMaintenance as temptCustomerMaintenance>
<div class="report common"   style="display: none" id="whxx">
    <h5>维护信息</h5>
<table class="bxd" >
    <tr >
        <td>维护类型：<span>${temptCustomerMaintenance.maintenanceType}</span></td>
        <td>维护时间：<span>${temptCustomerMaintenance.operationTime?string("yyyy-MM-dd")}  </span></td>
    </tr>
    <tr>
        <td>维护人：<span>${temptCustomerMaintenance.operationName}</span></td>
        <td>维护纪要：<span>${temptCustomerMaintenance.maintennaceSummary}  </span></td>
    </tr>
</table>
</div>
    </#list>
</div>


<p class="button">
    <a href="/customerMaintenance/index" class="editOne btn-info">返回</a>
</p>

</#macro>

<#macro script>
<script>
    function selectTR(obj) {
        var index=$(obj).index();
        $("#lllllllllll #whxx").eq(index-1).show();
        $("#lllllllllll #whxx").eq(index-1).siblings().hide();
        $(obj).parent().find("tr td").css("background", "#fff");
        $(obj).find("td").css("background", "#dff0d8");//改变行背景
        $(obj).parent().find("").removeAttr("checked")
        $(obj).parent().find("label").attr("class", "radio")
        $(obj).find("input[type=radio]").attr("checked", "checked")
        $(obj).find("label").attr("class", "radio radio_a")//radio
    }

</script>
</#macro>

<#macro js>


</#macro>
