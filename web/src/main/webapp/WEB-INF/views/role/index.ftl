<#include "layout/base.html"/>
<#assign title = "角色权限管理"/>
<#macro css>
<link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
<link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
<link rel="stylesheet" href="/static/css/button.css"/>
</#macro>
<#macro style>
</#macro>
<#macro breadcrumb>
    <h3>
        角色权限管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active"> 角色权限管理</li>
    </ul>
</#macro>
<#macro content>

    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    角色权限管理
                </header>
                <div class="panel-body">
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
                </div>
            </section>
        </div>
    </div>
</#macro>
<#macro js>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>
<#macro script>
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



