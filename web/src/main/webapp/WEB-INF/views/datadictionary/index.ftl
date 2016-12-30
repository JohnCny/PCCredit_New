<#include "layout/base.html"/>
<#assign title = "数据字典管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="/static/css/button.css"/>

</#macro>
<#macro style>
</#macro>
<#macro breadcrumb>
    <h3>
        数据字典管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active"> 数据字典管理</li>
    </ul>
</#macro>
<#macro content>

<div class="row">
    <div class="col-sm-12">
        <section class="panel">
            <header class="panel-heading">
                数据字典列表
            </header>

            <div class="panel-body">
            <div class="table-responsive">
                    <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                        <div class="row-fluid">
                            <div class="search">
                                <span>字典类别：<input type="text" class="form-control" aria-controls="dynamic-table" name="dataType" id="dataType"></span>
                                <span>数据字典代码： <input type="text" class="form-control" aria-controls="dynamic-table" name="dataCode" id="dataCode"></span>
                                <span>字典名称：<input type="text" class="form-control" aria-controls="dynamic-table" name="dataName" id="dataName"></span>
                                <input class="searchBtn" type="button" value="搜 索">
                            </div>
                        <table id="example" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>字典类别</th>
                                <th>字典代码</th>
                                <th>字典名称</th>
                                <th>银行代码</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                        </table>
                        </div>
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
                "urlNew": "/dataDictionary",
                "urlDel": "/dataDictionary",
            }
            var ajax = {
                "type": "GET",
                "url": "/dataDictionary/pageList",
                "data": function (d) {
                    var QK_searchObj = {
                        "dataType": $("#dataType").val(),
                        "dataCode": $("#dataCode").val(),
                        "dataName": $("#dataName").val()
                    }
                    d.search = JSON.stringify(QK_searchObj);
                }
            }

            var tableId = $("#example");
            var aoColumns = [{
                "mData": "dataType"
            }, {
                "mData": "dataCode",
            }, {
                "mData": "dataName",
            }, {
                "mData": "bankCode",
            }, {
                "mData": "dataId",
                "sDefaultContent": "",
                "render": function (data, type, full, meta) {
                    return '<a onclick="deleRow()" class="btn btn-info" style="padding: 5px 10px;" href="/dataDictionary/' + data + '">编辑</a>'
                }
            }];

            var options = {
                "ajax": ajax,
                "urlNew": url['urlNew'],
                "urlDel": url['urlDel'],
                "tableId": tableId,
                "aoColumns": aoColumns
            }
            myDataTable(options);
        });

    </script>
</#macro>


