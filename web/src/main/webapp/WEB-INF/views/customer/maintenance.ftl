<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
<style>
    .add{margin-right: 5px}
    .look{margin-left: 5px}
</style>
</#macro>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="/static/css/button.css"/>
</#macro>
<#macro breadcrumb>
    <h3>
        客户
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户管理</a>
        </li>
        <li class="active">客户维护</li>
    </ul>
</#macro>
<#macro content>

    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    客户维护
                </header>
                <div class="panel-body">
                    <div class="table-responsive">
                        <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                            <div class="row-fluid">
                                <div class="search">
                                <span>客户名称：<input type="text" class="short" name="cname" id="cname" ></span>
                                <span>客户证件号码：<input type="text" name="certificateNumber" id="certificateNumber"></span>
                                <input class="searchBtn" type="button" value="搜 索">
                            </div>
                                <table id="example" class="table table-bordered">
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
    $(function () {
        var url = {
            "urlList": "/customerMaintenance/condition",
            "urlNew" : "/customerMaintenance"
        }
        var QK_searchObj = {
            "cname" : $("#cname").val(),
            "certificateNumber" : $("#certificateNumber").val(),
        };
        var tableId = $("#example");
        var ajax = {
            "type" : "GET",
            "url" : "/customerBasic/condition",
            "data" : function(d){
                var QK_searchObj = {
                    "cname" : $("#cname").val(),
                    "certificateNumber":$("#certificateNumber").val(),
                }
                d.search = JSON.stringify(QK_searchObj);
            }
        }
        var aoColumns = [
            {
                "mData": "cname"
            }, {
                "mData": "certificateNumber",
            }, {
                "mData": "tel",
            } ,
            {
                "mData" : "id",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a  class="label label-warning add" href="/customerMaintenance?customerId='+data+'">新增</a><a onclick="deleRow()" class="label label-info look" href="/customerMaintenance/'+data+'">查看</a>';
                }
            }];

        var options = {
            "urlList": url['urlList'],
            "urlNew" : url['urlNew'],
            "tableId": tableId,
            "aoColumns": aoColumns,
            "ajax" : ajax
        }
        myDataTable(options);
    }());

</script>
</#macro>


