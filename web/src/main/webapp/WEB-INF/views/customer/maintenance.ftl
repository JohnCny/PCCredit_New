<#include "layout/base.html"/>
<#assign title = "客户"/>
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

</#macro>
<#macro breadcrumb>
<h1>${title}</h1>
<h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
<h1>客户维护</h1>
<div class="table-responsive" style="margin:50px auto; width:95%;">

    <div class="search" style="width:95%">
        <span>客户名称：<input type="text" class="short" name="cname" id="cname" ></span>
        <span>客户证件号码：<input type="text" name="certificateNumber" id="certificateNumber"></span>
        <input class="searchBtn" type="button" value="搜 索">
    </div>
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

</#macro>

<#macro script>

<script>
    $(function () {

        var url = {
            "urlList": "/customerMaintenance/index",
            "urlNew" : "/customerMaintenance/new"
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
                "mData" : "id",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a onclick="deleRow()" class="editOne btn-info" href="/customerBasic/'+data+'">编辑</a><a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>删除</a>';
                }
            }];

        var options = {
            "urlList": url['urlList'],
            "urlNew" : url['urlNew'],
            "tableId": tableId,
            "aoColumns": aoColumns
        }
        myDataTable(options);
    }());

</script>
</#macro>

<#macro js>


</#macro>
