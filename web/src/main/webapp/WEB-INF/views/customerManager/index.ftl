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
        <span>客户经理名称：<input type="text" class="short" name="cname" id="cname" ></span>
        <span>工号：<input type="text" name="certificateNumber" id="certificateNumber"></span>
        <span>级别：
            <select>
                <#list customerManagerLevel as cml>
                    <option value="" id="${cml.id}">${cml.value}</option>
                </#list>
            </select>
        </span>
        <input type="button" value="搜 索">
    </div>

    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="example" class="table table-bordered" style="width: 100%" >
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
                "urlList":"/customerManager/pageList",
                "urlNew" : "/customerManager/new",
                "urlDel" : "/customerManager/",
            }
            var tableId = $("#example");
            var aoColumns = [{
                "mData" : "cName"
            },{
                "mData" : "id",
            },{
                "mData" : "levelName",
            },{
                "mData" : "userId",
                "sDefaultContent" : "",
                "render" : function(data, type, full, meta) {
                    return  '<a onclick="deleRow()" class="editOne btn-info" href="/customerManager/'+data+'">管理</a>' +
                            '<a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>删除</a>';
                }
            }];

            var options = {
                "urlList" : url['urlList'],
                "urlNew" : url['urlNew'],
                "urlDel" : url['urlDel'],
                "tableId" : tableId,
                "aoColumns" : aoColumns
            }
            myDataTable(options);
        }());

    </script>

</#macro>
