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
    <h2>当前位置：客户经理管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>

    <h5>客户经理列表</h5>
    <div class="search" style="width:95%">
        <span>客户经理名称：<input type="text" class="short" name="userCname" id="userCname" ></span>
        <span>工号：<input type="text" name="employeeNumber" id="employeeNumber"></span>
        <span>级别：
            <select name="levelId" id="levelId">
                <option id="-1" value="-1">所有级别</option>
                <#list customerManagerLevel as cml>
                    <option id="${cml.id}" value="${cml.id}">${cml.value}</option>
                </#list>
            </select>
        </span>
        <input class="searchBtn" type="button" value="搜 索">
    </div>

    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="customerManagerList" class="table table-bordered" style="width: 100%" >
            <thead>
            <tr>
                <th>客户经理</th>
                <th>工号</th>
                <th>当前级别	</th>
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
        $(function(){

            var url  = {
                "urlNew" : "/customerManager/toAdd",
                "urlDel" : "/customerManager/",
            }
            var ajax = {
                "type" : "GET",
                "url" : "/customerManager/pageList",
                "data" : function(d){
                    var QK_searchObj = {
                        "userCname" : $("#userCname").val(),
                        "employeeNumber":$("#employeeNumber").val(),
                        "levelId":$("#levelId").val()
                    }
                    d.search = JSON.stringify(QK_searchObj);
                }
            }
            var tableId = $("#customerManagerList");
            var aoColumns = [{
                "mData" : "userCname"
            },{
                "mData" : "employeeNumber",
            },{
                "mData" : "levelName",
            },{
                "mData" : "userId",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a class="editOne btn-info" href="/customerManager/'+data+'">管理</a>' +
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
