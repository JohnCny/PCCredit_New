<#include "layout/base.html"/>
<#assign title = "系统管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
</#macro>
<#macro style>

</#macro>

<#macro breadcrumb>
    <h3>
        系统管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active"> 系统管理</li>
    </ul>
</#macro>
<#macro content>
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    系统参数配置浏览
                    <span class="tools pull-right">
                <!--<a href="javascript:;" class="fa fa-chevron-down"></a>-->
                <!--<a href="javascript:;" class="fa fa-times"></a>-->
             </span>
                </header>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered" >
                            <thead>
                            <tr>
                                <th>参数名称	</th>
                                <th>参数值</th>
                                <th>参数中文名</th>
                                <th>参数描述</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>修改人</th>
                                <th>修改时间</th>
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

    <!--<script src="/static/js/datatables/datatables.min.js"-->
            <!--type="text/javascript"></script>-->
    <!--<script src="/static/js/datatables/plugins/bootstrap/datatables.bootstrap.js"-->
            <!--type="text/javascript"></script>-->

</#macro>

<#macro script>
    <script>
        $(function(){

            var url  = {
                "urlNew" : "/system",
                "urlDel" : "",
            }
            var ajax = {
                "type" : "GET",
                "url" : "/system",
                "data" : function(d){
//                    var QK_searchObj = {
//                        "userCname" : $("#userCname").val(),
//                        "employeeNumber":$("#employeeNumber").val(),
//                        "levelId":$("#levelId").val()
//                    }
//                    d.search = JSON.stringify(QK_searchObj);
                }
            }

            var tableId = $("#example");
            var aoColumns = [{
                "mData" : "parameterName"
            },{
                "mData" : "parameterValue",
            },{
                "mData" : "parameterNameZn",
            },{
                "mData" : "parameterDescription",
            },{
                "mData" : "createBy",
            },{
                "mData" : "createTime",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    //时间格式化
                    return  moment(data).format("YYYY-MM-DD");
                }
            },{
                "mData" : "modifyBy",

            },{
                "mData" : "modifyTime",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    //时间格式化
                    return  moment(data).format("YYYY-MM-DD");
                }
            },{
                "mData" : "id",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a onclick="deleRow()" class="btn-info" href="/system/'+data+'">编辑</a>';
                }
            }];

            var options = {
                "ajax" : ajax,
                "urlNew" : url['urlNew'],
                "urlDel" : url['urlDel'],
                "tableId" : tableId,
                "aoColumns" : aoColumns,
            }

            myDataTable(options);
            $("#topPlugin").hide();
        }());

    </script>
</#macro>


