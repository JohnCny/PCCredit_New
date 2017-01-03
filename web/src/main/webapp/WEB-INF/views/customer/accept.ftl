<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
<style>

</style>
</#macro>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="/static/css/button.css"/>
</#macro>
<#macro breadcrumb>
    <h3>
        客户接收
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户接收</a>
        </li>
        <li class="active"> 客户接收</li>
    </ul>
</#macro>
<#macro content>
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    数据字典列表
                </header>
                <div class="panel-body ">
                    <div class="table-responsive">
                        <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                            <div class="row-fluid">
                                <div class="search" >
                                    <span>客户名称：<input type="text" class="short" name="cname" id="cname"></span>
                                    <span>客户证件号码：<input type="text" name="certificateNumber" id="certificateNumber"></span>
                                    <input class="searchBtn" type="button" value="搜 索">
                                </div>
                                <table id="example" class="table table-bordered deleteAllTable" >
                                    <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>客户名称</th>
                                        <th>客户证件号码</th>
                                        <th>移交原因</th>
                                    </tr>
                                    </thead>
                                </table>
                                <p class="button">
                                    <input type="submit" value="接收" id="btn_submit" class="btn btn-success"/>
                                    <input type="reset" value="拒绝" id="btn_submit2" class="btn btn-default"/>
                                </p>
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
    $(function () {
        var tableId = $("#example");
        var ajax = {
            type : "GET",
            url : "/customerTransfer/queryTransfer",
        }
        var aoColumns = [
            {
                "mData": "customerId",
                "render":function (data,full) {
                    var html = "";
                    html += '<input type="checkbox" class="check" value='+data+' name="checkbox">';
                    return  html;
                }
            },
            {
                "mData": "cname"
            }, {
                "mData": "certificateNumber",
            }, {
                "mData": "transferReason",
            }];

        var options = {
            "tableId": tableId,
            "ajax" :ajax,
            "aoColumns": aoColumns
        }
        myDataTable(options);
    }());

    $(function () {
        var ids = [];
        var userIds = [];
        var obj = {};
        var keyobj = {};
        var url = "/customerTransfer/accept";
        $("#btn_submit").click(function () {
            $("input[name='checkbox']:checkbox:checked").each(function(){
                var id = $(this).val();
                ids.push(id);
            })
            var tempid = ids.join(",");
            obj["customerIds"] = tempid;
            obj["flag"] = 1;
            console.log(obj);
            console.log(tempid);
            $.ajax({
                type:"put",
                url : url,
                data: obj,
                success:function (res) {
                    if(res.code == 200){
                        alert("接收成功");
                        location.href="/customerTransfer/accept";
                    }
                }
            });
        });
        $("#btn_submit2").click(function () {
            $("input[name='checkbox']:checkbox:checked").each(function(){
                var id = $(this).val();
                userIds.push(id);
            })
            var tempid = userIds.join(",");
            keyobj["customerIds"] = tempid;
            keyobj["flag"] = 2;
            console.log(keyobj);
            console.log(tempid);
            $.ajax({
                type:"put",
                url : url,
                data: keyobj,
                success:function (res) {
                    if(res.code == 200){
                        alert("拒绝成功");
                        location.href="/customerTransfer/accept";
                    }
                }
            })

        })

        })

</script>
</#macro>


