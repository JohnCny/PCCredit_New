<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>

</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h2>客户</h2>
    <ul class="breadcrumb">
        <li><a href="/dashboard">首页</a></li>
        <li class="active">客户</li>
    </ul>
</#macro>
<#macro content>
    <div class="panel panel-default">
        <div class="panel-heading">
            请输入对应的条件查询
        </div>
        <div class="panel-body">
            <div class="col-md-12">
                <form class="form-horizontal formReset">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="cname" name="cname" style="width: 250px">
                        </div>

                        <label class="col-sm-2 control-label">联系方式：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="tel" name="tel" style="width: 250px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">证件号码：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="certificateNumber" name="certificateNumber" style="width: 250px">
                        </div>

                        <label class="col-sm-2 control-label">创建时间：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="createTime" name="createTime" style="width: 250px" onclick="laydate()">
                        </div>

                        <div class="col-sm-2">
                            <button style="width:50%" type="button" class="btn btn-success search" style="float: right;" >查 询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="table-responsive" style="margin:50px auto; width:100%;">
        <table id="example" class="table table-bordered tableCommon">
            <thead>
            <tr>
                <th><input type="checkbox" name="allChecked" /></th>
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

        var searchObj = {
            "cname":$("#cname").val(),
            "tel":$("#tel").val(),
            "certificateNumber":$("#certificateNumber").val(),
            "createTime":$("#createTime").val()
        };
        var tableId = $("#example");
        var ajax ={
            "type" : "GET",
            "url" : "/customerBasic/customer",
            "data" : function(d){
                d.search = searchObj
            }
        };
        var aoColumns = [{
            "mData" : "id",
        },{
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
                return  '<a class="btn btn-danger deleteOne" href="" data-id='+data+'>删除</a>';
            }
        }];

        var options = {
            "tableId" : tableId,
            "ajax" : ajax,
            "aoColumns" : aoColumns
        }
        myDataTable(options);

    </script>

</#macro>
