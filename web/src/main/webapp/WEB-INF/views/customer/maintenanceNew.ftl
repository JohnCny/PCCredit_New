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
<form action="">

    <h1>新增维护记录</h1>
    <h2>当前位置：客户管理 / 客户维护 / 客户1 / <span>新增维护记录</span></h2>
    <div class="report common">
        <h5>维护记录</h5>
        <table>
            <tr>
                <input class="searchBtn" type="hidden" name="id" id="id" value="${tCustomerBasic.id}">
                <td class="pull-right">维护类型：</td>
                <td>
                    <#list dropDownList as dropDown>
                    <select>
                        <#list dropDown.maintenanceType as type>
                            <option name="maintenanceType" id="maintenanceType" value="${type.id}">${type.value}</option>
                            </#list>
                    </select>
                    </#list>
                </td>
            </tr>
            <tr>
                <td class="pull-right">联系方式：</td>
                <td><textarea name="maintennaceSummary" id="maintennaceSummary"></textarea></td>
            </tr>
        </table>
    </div>
    <p class="button">
        <input type="button" id="btn_submit" value="保存" onclick="iframe('khwh_list.html')"/>
    </p>
</form>

</#macro>

<#macro script>
<script>
    $(function () {
        var url = "/customerMaintenance";
        var arr = ["id", "maintenanceType","maintennaceSummary"];
        var Obj = {};
        $("#btn_submit").click(function (e) {
            e.preventDefault();
            for(var i = 0; i < arr.length; i++){
                Obj[arr[i]]=$("#"+arr[i]).val();
            }
            $.ajax({
                type:"post",
                url:url,
                data:Obj,
                success: function(res){
                    if(res.code == 200){
                        location.href="/customerMaintenance/index";
                    }
                    }
            });
        })
    })
</script>
</#macro>

<#macro js>


</#macro>
