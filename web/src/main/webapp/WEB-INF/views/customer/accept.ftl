<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
<style>
    [v-cloak] {
        display: none
    }
    .common .center tr td{border:none;line-height:40px;background:none;}
    .common input{width:200px;}
    select{border: 1px solid #e2e2e2}
    .content h1 {
        color: #49586e;
        font-size: 25px;
        font-weight: normal;
        margin: 5px 0;
    }
    .content h2 {
        color: #999999;
        font-size: 14px;
        font-weight: normal;
        margin-top: 10px;
        margin-bottom: 10px;
    }
    .common{margin-top: 10px}
    #reason input{border: 1px solid #e2e2e2}
</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>${title}</h1>
<h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
<h1>客户接收</h1>
<h2>当前位置：客户管理 / <span>客户接收</span></h2>

<div class="table-responsive" style="margin:50px auto; width:95%;">
    <table id="example" class="table table-bordered" style="width: 100%" >
        <thead>
        <tr>
            <th>选择</th>
            <th>客户名称</th>
            <th>客户证件号码</th>
            <th>移交原因</th>
        </tr>
        </thead>
    </table>
</div>
       <#-- <#list queryTransfer as transfer>
        <tr onclick="selectTR2(this)">
            <td><span class="hideInput"><input type="checkbox" name="checkbox"/><label class="checkbox"></label></span></td>
            <td hidden>${transfer.customerId}</td>
            <td>${transfer.cname}</td>
            <td>${transfer.certificateNumber}</td>
            <td>${transfer.transferReason}</td>
        </tr>
        </#list>-->

<p class="button">
    <input type="submit" value="接收"  id="btn_submit" />
    <input type="reset"  value="拒绝" id="btn_submit2"/>
</p>
</#macro>

<#macro script>

<script>
    $(function(){

        var url  = {
            "urlList":"/customerTransfer/queryTransfer",
        }
        var tableId = $("#example");
        var aoColumns = [{
            "mData" : "cname"
        },{
            "mData" : "certificateNumber",
        },{
            "mData" : "transferReason",
        }
        ];

        var options = {
            "urlList" : url['urlList'],
            "tableId" : tableId,
            "aoColumns" : aoColumns
        }
        myDataTable(options);
    }());

</script>
</#macro>

<#macro js>


</#macro>
