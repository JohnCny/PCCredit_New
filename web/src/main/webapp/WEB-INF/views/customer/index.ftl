<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        .edit{
            margin: 0 5px 0;
        }
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
        <li class="active"> 客户管理</li>
    </ul>
</#macro>
<#macro content>

  <!--  <h5>客户列表</h5>
    <div class="search" style="width:95%">
        <span>客户名称：<input type="text" class="short" name="cname" id="cname" ></span>
        <span>客户证件号码：<input type="text" name="certificateNumber" id="certificateNumber"></span>
        <input class="searchBtn" type="button" value="搜 索">
    </div>

    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="example" class="table table-bordered" style="width: 100%" >
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>联系方式</th>
                <th>证件号码</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>-->




    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    客户管理
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
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>联系方式</th>
                                        <th>证件号码</th>
                                        <th>创建时间</th>
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

        $(function(){

            var url  = {
                "urlNew" : "/customerBasic/",
                "urlDel" : "/customerBasic/",
            }
            var QK_searchObj = {
                "cname" : $("#cname").val(),
                "certificateNumber" : $("#certificateNumber").val(),
            };
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
            var tableId = $("#example");
            var aoColumns = [{
                "mData" : "cname"
            },{
                "mData" : "sex",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return	data?"男":"女";
                }
            },{
                "mData" : "tel",
            },{
                "mData" : "certificateNumber",
            },{
                "mData" : "createTime",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    //时间格式化
                    return  moment(data).format("YYYY-MM-DD");
                }
            },{
                "mData" : "id",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a href="/customerBasic/customerInfo/'+data+'" class="btn btn-info">查看</a><a onclick="deleRow()" class="btn btn-warning edit " href="/customerBasic/'+data+'">编辑</a><a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>禁用</a>';
                }
            }];



            var options = {
                "urlNew" : url['urlNew'],
                "urlDel" : url['urlDel'],
                "ajax" : ajax,
                "tableId" : tableId,
                "aoColumns" : aoColumns
            }
            myDataTable(options);
        }());

    </script>
</#macro>


