<#include "layout/base.html"/>
<#assign title = "角色管理"/>
<#macro style>
<style>

</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>用户</h1>
<h2>当前位置：系统管理 / <span class="active">角色权限管理</span></h2>

</#macro>
<#macro content>
<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
    <div class="col-xs-1"></div>
    <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
        <h5>角色权限管理</h5>
    <#--<div class="search" style="width:95%">-->
    <#--<span>机构：<input type="text" class="short" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled"-->
    <#--name="orgId" id="orgId"></span>-->
    <#--<span>用户名称：<input type="text" class="short" name="username" id="username"></span>-->
    <#--<span> 身份证：<input type="text" name="idCardNumber" id="idCardNumber"></span>-->
    <#--<input class="searchBtn" type="button" value="搜 索">-->
    <#--</div>-->
        <div class="table-responsive list_show" style=" width:100%;">
            <table id="roleList" class="table table-bordered" style="width: 100%">
                <thead>
                <tr>
                    <th>角色名</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</#macro>

<#macro js>
<script>
    $(function () {
        var url = {}
        var tableId = $("#roleList");
        var ajax = {
            "type": "GET",
            "url": "/role/pageList",
//            "data": function (d) {
//                var QK_searchObj = {
//                    "idCardNumber": $("#idCardNumber").val(),
//                    "username": $("#username").val(),
//                    "orgId": $("#orgId").data("id"),
//                };
//                d.search = JSON.stringify(QK_searchObj);
//            }
        }
        var aoColumns = [{
            "mData": "roleName",
        }, {
            "mData": "id",
            "sDefaultContent": "",
            "render": function (data, type, full, meta) {
                var html = "";
                html += '<button class="btn btn-primary" data-id=' + data + '>编辑</button>'
                if (!full.status) {
                    html += '<button  class="btn btn-success activeBtn" data-id=' + data + ' data-status=' + full.status + '>点击锁定</button>';
                } else {
                    html += '<button  class="btn btn-default activeBtn" data-id=' + data + ' data-status=' + full.status + '>点击解锁</button>';
                }
                html += '<button class="btn btn-info resetBtn" data-id=' + data + '>重置密码</button>';
                html += '<button class="btn btn-primary" data-id=' + data + '>角色管理</button>'
                return html;
            }
        }];
        var options = {
            "ajax": ajax,
            "tableId": tableId,
            "aoColumns": aoColumns
        }
        myDataTable(options);
    })
</script>
</#macro>

