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
<h1>客户维护</h1>
<h2>当前位置：客户管理 / <span>客户维护</span></h2>
<div class="table-responsive" style="margin:50px auto; width:95%;">
    <table id="example" class="table table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>客户名称</th>
            <th>客户证件号码</th>
            <th>联系方式</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>


</div>
</#macro>

<#macro script>

<script>
    $(function () {

        var url = {
            "urlList": "/customerMaintenance/index",
        }
        var tableId = $("#example");
        var aoColumns = [
            {
                "mData": "cname"
            }, {
                "mData": "transferReason",
            }, {
                "mData": "tel",
            } ,
            {
                "mData": ""
            }];

        var options = {
            "urlList": url['urlList'],
            "tableId": tableId,
            "aoColumns": aoColumns
        }
        myDataTable(options);
    }());

</script>
</#macro>

<#macro js>


</#macro>
