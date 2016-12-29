<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
<style>
    .btn{
        width: 100px;
        margin-left: 10px;
    }
    .tools span ,.tools input{
        margin-top: 10px;
    }
    .reset,.locks{
        margin: 0 5px 0;
    }
</style>
</#macro>
<#macro css>
    <link rel="stylesheet" href="/static/css/zTree/metroStyle/metroStyle.css">
</#macro>
<#macro breadcrumb>
    <h3>
        用户
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：用户管理</a>
        </li>
        <li class="active"> 用户</li>
    </ul>

</#macro>
<#macro content>
<div class="row">
    <div class="col-sm-3" style="background-color: #fff ;border-radius: 5px">
        <div class="report common list">
            <h5>机构列表</h5>
            <div class="treeBox" style="height: 581px;">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>

    <!--<div class="row">-->
        <!--<div class="col-md-2">-->
            <!--<section class="panel">-->
                <!--<header class="panel-heading">-->
                    <!--机构列表-->
                    <!--<span class="tools pull-right">-->
             <!--</span>-->
                <!--</header>-->
                <!--<div class="panel-body">-->
                    <!--<div class="table-responsive">-->
                            <!--<div class="treeBox" style="height: 581px;">-->
                                <!--<ul id="treeDemo" class="ztree"></ul>-->
                            <!--</div>-->
                    <!--</div>-->
                <!--</div>-->
            <!--</section>-->
        <!--</div>-->
    <!--</div>-->




    <!--<div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">-->
        <!--<h5>用户列表</h5>-->
        <!--<div class="search" style="width:95%">-->
            <!--<span>机构：<input type="text" class="short" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled"-->
                            <!--name="orgId" id="orgId" style="width: 160px"></span>-->
            <!--<span>用户名称：<input type="text" class="short" name="username" id="username"></span>-->
            <!--<span> 身份证：<input type="text" name="idCardNumber" id="idCardNumber"></span>-->
            <!--<input class="searchBtn" type="button" value="搜 索">-->
        <!--</div>-->
        <!--<div class="table-responsive list_show" style=" width:100%;">-->
            <!--<table id="userList" class="table table-bordered" style="width: 100%">-->
                <!--<thead>-->
                <!--<tr>-->
                    <!--<th>姓名</th>-->
                    <!--<th>性别</th>-->
                    <!--<th>联系方式</th>-->
                    <!--<th>邮件</th>-->
                    <!--<th>创建时间</th>-->
                    <!--<th>操作</th>-->
                <!--</tr>-->
                <!--</thead>-->
            <!--</table>-->
        <!--</div>-->
    <!--</div>-->



    <!--<div class="row">
        <div class="col-sm-8">
            <section class="panel">
                <header class="panel-heading">
                    系统参数配置浏览
                </header>
                <div class="panel-body">
                        <div class="row">
                          <span class="tools">
                            <span class="col-md-4 col-xs-4">机构：<input type="text" class="short" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled"name="orgId" id="orgId" style="width: 160px"></span>
                            <span class="col-md-4 col-xs-4">用户名称：<input type="text" class="short" name="username" id="username"></span>
                            <span class="col-md-3 col-xs-3"> 身份证：<input type="text" name="idCardNumber" id="idCardNumber"></span>
                            <input class="searchBtn pull-right col-md-1 col-xs-2" type="button" value="搜 索">
                            </span>
                        </div>
                    <div class="table-responsive">
                        <table id="userList" class="table table-bordered">
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
            </section>
        </div>
    </div>-->

    <div class="row">
        <div class="col-sm-9">
            <section class="panel">
                <header class="panel-heading">
                    系统参数配置浏览
                    <span class="tools pull-right">
                <!--<a href="javascript:;" class="fa fa-chevron-down"></a>-->
                        <!--<a href="javascript:;" class="fa fa-times"></a>-->
             </span>
                </header>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="userList" class="table table-bordered">
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
            </section>
        </div>
    </div>


</div>
</#macro>
<#macro js>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>
<#macro script>
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
                html += '<a class="label label-primary" href="/user/'+ data +'/updateUser" data-id=' + data + '>编辑</a>'
                if (!full.status) {
                    html += '<a  class="label label-success activeBtn locks" data-id=' + data + ' data-status=' + full.status + '>点击锁定</a>';
                } else {
                    html += '<a  class="label label-default activeBtn locks" data-id=' + data + ' data-status=' + full.status + '>点击解锁</a>';
                }
                html += '<a class="label label-info resetBtn reset" data-id=' + data + '>重置密码</a>';
                html += '<a class="label label-primary" data-id=' + data + '>角色管理</a>'
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

