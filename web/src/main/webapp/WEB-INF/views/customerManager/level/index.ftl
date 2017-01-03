<#include "layout/base.html"/>
<#assign title = "客户经理"/>
<#macro style>
    <style>
        .delete{
            margin-left: 10px;
        }
        .editOne{
            margin-right: 10px;
            color: #fff;
            background-color: #1e92ff;
            /*border-color: #46b8da;*/
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            touch-action: manipulation;
            cursor: pointer;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }
        .editOne:hover{
            text-decoration: none;
            color: #fff;
            background-color: #1f7acf;
        }
        #example tbody td,#example thead th{
           text-align: center;
            line-height: #1f7acf;
            box-sizing: border-box;
        }
        #example tbody{
            position: relative;
            top:1px;
        }
    </style>
</#macro>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
</#macro>
<#macro breadcrumb>
    <h3>
        客户经理管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户经理管理</a>
        </li>
        <li class="active"> 客户经理管理</li>
    </ul>
</#macro>
<#macro content>
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    客户经理管理
                </header>

                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="customerManagerLevelList" class="table table-bordered" style="width: 100%" >
                            <thead>
                            <tr>
                                <th>级别名称	</th>
                                <th>对应额度	</th>
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
        $(function(){

            var url  = {
                "urlNew" : "/customerManagerLevel/toAdd",
                "urlDel" : "/customerManagerLevel/",
            }
            var ajax = {
                "type" : "GET",
                "url" : "/customerManagerLevel/pageList",
            }
            var tableId = $("#customerManagerLevelList");
            var aoColumns = [{
                "mData" : "levelName"
            },{
                "mData" : "levelCredit",
            },{
                "mData" : "id",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a class="btn btn-info" href="/customerManagerLevel/'+data+'">管理</a>' +
                            '<a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>删除</a>';
                }
            }];

            var options = {
                "ajax" : ajax,
                "urlNew" : url['urlNew'],
                "urlDel" : url['urlDel'],
                "tableId" : tableId,
                "aoColumns" : aoColumns
            }
            myDataTable(options);
        }());

    </script>
</#macro>

