<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
</#macro>
<#macro style>
    <style>
        .reste,.locks{
            margin: 0 5px 0;
        }
    </style>

</#macro>
<#macro breadcrumb>
    <h3>
        用户管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active"> 用户管理</li>
    </ul>
</#macro>

<#macro content>
<div class="row">

    <div class="col-md-3">
        <div class="report common list">
            <section class="panel">
                <header class="panel-heading">
                    机构列表
                </header>
                <div class="treeBox">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </section>
        </div>
    </div>

        <div class="col-md-9">
            <section class="panel">
                <header class="panel-heading">
                    客户管理
                </header>
                <div class="panel-body">
                    <div class="table-responsive">

                        <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                            <div class="row-fluid">
                                        <!--<div class="">-->
                                         <!---->
                                            <!--<ul id="treeDemo" class="ztree"></ul>-->
                                        <!--</div>-->
                                <div class="search">
                                    <span>机构：<input type="text" class="form-control" aria-controls="dynamic-table" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled" name="orgId" id="orgId"></span>
                                    <span>用户名称：<input type="text" class="form-control" aria-controls="dynamic-table" name="username" id="username"></span>
                                    <span> 身份证：<input type="text" class="form-control" aria-controls="dynamic-table" name="idCardNumber" id="idCardNumber"></span>
                                    <input class="searchBtn" type="button" value="搜 索">
                                </div>
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
                    </div>
                </div>
            </section>
        </div>
    </div>


</#macro>
<#macro js>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>
<#macro script>
    <script>
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
                    html += '<a class="btn btn-info" style="padding: 5px 10px;" href="/user/'+ data +'/updateUser" data-id=' + data + '>编辑</a>'
                    if (!full.status) {
                        html += '<a  class="btn btn-danger locks"  style="padding: 5px 10px;" data-id=' + data + ' data-status=' + full.status + '>点击锁定</a>';
                    } else {
                        html += '<a  class="btn btn-default locks" style="padding: 5px 10px;" data-id=' + data + ' data-status=' + full.status + '>点击解锁</a>';
                    }
                    html += '<a class="btn btn-warning reste" style="padding: 5px 10px;" data-id=' + data + '>重置密码</a>';
                    html += '<a class="btn btn-success"  style="padding: 5px 10px;" data-id=' + data + '>角色管理</a>'
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




