<#include "layout/base.html"/>
<#assign title = "角色权限管理"/>
<#macro style>

</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>${title}</h1>
<h2>当前位置：系统管理 / <span class="active">角色权限管理</span></h2>
</#macro>
<#macro content>

<h5>角色权限管理</h5>

<div class="table-responsive" style="margin:50px auto; width:95%;">
    <table id="example" class="table table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>角色名称</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>

</#macro>

<#macro script>

</#macro>

<#macro js>

<script>
    var url = {
        "urlList": "/role/pageList",
        "urlNew": "/role/addPage",
        "urlEdit": "/role/updatePage"
    }
    var tableId = $("#example");
    var ajax = {
        "type": "GET",
        "url": url["urlList"],
    };
    var aoColumns = [{
        "mData": "roleName",
    }, {
        "mData": "id",
        "sDefaultContent": "",
        "render": function (data, type, full, meta) {
            return '<a class="btn btn-info editOne" href="" data-id=' + data + '>编辑</a>';
        }
    }];

    var options = {
        "urlNew": url['urlNew'],
        "urlDel": url['urlDel'],
        "urlEdit": url['urlEdit'],
        "tableId": tableId,
        "ajax": ajax,
        "aoColumns": aoColumns
    }
    myDataTable(options);

</script>

</#macro>
