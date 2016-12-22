<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        .delete,.editOne{
            margin-left: 20px;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>

    <h1>${title}</h1>
    <h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>

    <h5>客户列表</h5>
    <div class="search" style="width:95%">
        <span>客户名称：<input type="text" class="short" name="cname" id="cname" ></span>
        <span>客户证件号码：<input type="text" name="certificateNumber" id="certificateNumber"></span>
        <input type="button" value="搜 索">
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
    </div>

</#macro>

<#macro script>

</#macro>

<#macro js>

    <script>
        var url  = {
            "urlList":"/customerBasic/condition",
            "urlNew" : "/customerBasic/new",
            "urlDel" : "/customerBasic",
        }
        var tableId = $("#example");
        var searchObj = {
            "cname":$("#cname").val(),
            "tel":$("#tel").val(),
            "certificateNumber":$("#certificateNumber").val(),
            "createTime":$("#createTime").val()
        };
        var ajax ={
            "type" : "GET",
            "url" : url["urlList"],
            "data" : function(d){
                d.search = searchObj
            }
        };
        var aoColumns = [{
            "mData" : "cname",
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
                return  '<a onclick="deleRow()" class="btn btn-info editOne" href="/customerBasic/'+data+'">编辑</a><a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>删除</a>';
            }
        }];

        var options = {
            "urlNew" : url['urlNew'],
            "urlDel" : url['urlDel'],
            "tableId" : tableId,
            "ajax" : ajax,
            "aoColumns" : aoColumns
        }
        myDataTable(options);

    </script>

</#macro>
