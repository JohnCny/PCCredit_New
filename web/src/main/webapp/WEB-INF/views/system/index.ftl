<#include "layout/base.html"/>
<#assign title = "系统管理"/>
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
    <h2>当前位置：系统管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>

    <h5>系统参数配置浏览</h5>

    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="example" class="table table-bordered" style="width: 100%" >
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

</#macro>

<#macro script>

</#macro>

<#macro js>

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
                    return  '<a onclick="deleRow()" class="editOne btn-info" href="/system/'+data+'">编辑</a>';
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
