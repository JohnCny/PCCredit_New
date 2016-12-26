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

</#macro>
<#macro breadcrumb>

    <h1>${title}</h1>
    <h2>当前位置：客户经理管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>

    <h5>客户经理列表</h5>
    <div class="table-responsive" style="margin:50px auto; width:95%;">
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

</#macro>

<#macro script>

</#macro>

<#macro js>

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
                    return  '<a class="editOne btn-info" href="/customerManagerLevel/'+data+'">管理</a>' +
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
