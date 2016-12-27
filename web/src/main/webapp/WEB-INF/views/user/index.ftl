<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
<style>

</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>用户</h1>
<h2>当前位置：用户管理 / <span class="active">用户</span></h2>

</#macro>
<#macro content>
<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
    <div class="col-xs-3" style="background-color: #fff ;border-radius: 5px">
        <div class="report common list">
            <h5>机构列表</h5>
            <div class="treeBox" style="height: 581px;">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div class="col-xs-1"></div>
    <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
        <h5>用户列表</h5>
        <div class="search" style="width:95%">
            <span>机构：<input type="text" class="short" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled"
                            name="orgId" id="orgId"></span>
            <span>用户名称：<input type="text" class="short" name="username" id="username"></span>
            <span> 身份证：<input type="text" name="idCardNumber" id="idCardNumber"></span>
            <input class="searchBtn" type="button" value="搜 索">
        </div>
        <div class="table-responsive list_show" style=" width:100%;">
            <table id="userList" class="table table-bordered" style="width: 100%">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>联系方式</th>
                    <th>邮件</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</#macro>

<#macro script>
<script type="text/javascript" src="/static/js/ztree-org.js"></script>
</#macro>
<#macro js>
<script type="text/javascript">
    $(document).ready(function () {
        var urlMy = "/organization/orgAll";
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    pIdKey: "orgParentId"
                },
                key: {
                    name: "orgName",
                }
            },
            callback: {
                onClick: onClick
            }
        };
        baseTree(urlMy, setting);
        function onClick(event, treeId, treeNode, clickFlag) {
            $("#orgId").attr("value", treeNode.orgName);
            $("#orgId").attr("data-id", treeNode.id);

        }
    });
</script>
<script>
    $(function () {
        var tableId = $("#userList");
        var ajax = {
            "type": "GET",
            "url": "/user/pageList",
            "data": function (d) {
                var QK_searchObj = {
                    "idCardNumber": $("#idCardNumber").val(),
                    "username": $("#username").val(),
                    "orgId": $("#orgId").data("id"),
                };
                d.search = JSON.stringify(QK_searchObj);
            }
        }
        var aoColumns = [{
            "mData": "username",
        }, {
            "mData": "sex",
            "sDefaultContent": "",
            "render": function (data, type, full, meta) {
                return data ? "男" : "女";
            }
        }, {
            "mData": "tel",
        }, {
            "mData": "email",
        }, {
            "mData": "lastLoginTime",
            "sDefaultContent": "",
            "render": function (data, type, full, meta) {
                //时间格式化
                return moment(data).format("YYYY-MM-DD");
            }
        }, {
            "mData": "id",
            "sDefaultContent": "",
            "render": function (data, type, full, meta) {
                var html = "";
                html += '<a class="btn btn-primary" href="/user/'+ data +'/updateUser" data-id=' + data + '>编辑</a>'
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
            "urlNew":"/user/addUser",
            "ajax": ajax,
            "tableId": tableId,
            "aoColumns": aoColumns
        }
        myDataTable(options);
    })
</script>
</#macro>

