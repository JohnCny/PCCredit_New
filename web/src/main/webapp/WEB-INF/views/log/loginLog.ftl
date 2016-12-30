<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
<style>
    #loginLogList th, #loginLogList td {
        text-align: center;
        vertical-align: middle;
    }
</style>
</#macro>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="/static/css/button.css"/>
</#macro>
<#macro breadcrumb>
    <h3>
        登录日志管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：系统管理</a>
        </li>
        <li class="active"> 登录日志管理</li>
    </ul>
</#macro>
<#macro content>
<!--<div class="search" style="width:95%">-->
    <!--<span>登陆账号：<input type="text" class="short" id="loginAccount"></span>-->
    <!--<span>操作：<select id="loginOperation" class="short">-->
         <!--<option value="">&#45;&#45;请选择&#45;&#45;</option>-->
            <!--<option value="1">登陆</option>-->
            <!--<option value="0">退出</option>-->
      <!--</select></span>-->
    <!--<span>操作时间：<input type="text" class="short" id="loginTime" onclick="laydate()"></span>-->

    <!--<input class="searchBtn" type="button" value="搜 索">-->
<!--</div>-->

<!--<div class="table-responsive" style="margin:50px auto; width:95%;">-->
    <!--<table id="loginLogList" class="table table-bordered" style="width: 100%">-->
        <!--<thead>-->
        <!--<tr>-->
            <!--<th>登入名</th>-->
            <!--<th>操作</th>-->
            <!--<th>操作时间</th>-->
            <!--<th>登入结果</th>-->
            <!--<th>IP地址</th>-->
        <!--</tr>-->
        <!--</thead>-->
    <!--</table>-->
<!--</div>-->




    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    登录日志管理
                </header>
                <div class="panel-body ">
                    <div class="table-responsive">
                        <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                            <div class="row-fluid">
                                <div class="search" >
                                    <span>登陆账号：<input type="text" class="short" id="loginAccount"></span>
                                    <span>
                                        操作：
                                        <select id="loginOperation" class="short">
                                            <option value="">--请选择--</option>
                                            <option value="1">登陆</option>
                                            <option value="0">退出</option>
                                      </select>
                                    </span>
                                    <span>操作时间：<input type="text" class="short" id="loginTime" onclick="laydate()"></span>
                                    <input class="searchBtn" type="button" value="搜 索">
                                </div>
                                <table id="loginLogList" class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>登入名</th>
                                        <th>操作</th>
                                        <th>操作时间</th>
                                        <th>登入结果</th>
                                        <th>IP地址</th>
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
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>

<#macro script>
<script>
    $(function () {
        var ajax = {
            "type": "GET",
            "url": "/loginLog/pageList",
            "data": function (d) {
                var QK_searchObj = {
                    "loginAccount": $("#loginAccount").val(),
                    "loginOperation": $("#loginOperation").val(),
                    "loginTime": $("#loginTime").val(),
                };
                d.search = JSON.stringify(QK_searchObj);
            }
        }
        var tableId = $("#loginLogList");
        var aoColumns = [{
            "mData": "loginAccount"
        }, {
            "mData": "loginOperation",
            "render": function (data, type, full, meta) {
                //时间格式化
                return data ? "登录" : "退出";
            }
        }, {
            "mData": "loginTime",
            "sDefaultContent": "",
            "render": function (data, type, full, meta) {
                //时间格式化
                return moment(data).format("YYYY-MM-DD HH:mm:ss");
            }
        }, {
            "mData": "loginResult",
            "render": function (data, type, full, meta) {
                var styleCss = "", text = "";
                switch (data) {
                    case 1 :
                        text = "账号不存在";
                        styleCss = "label-important";
                        break;
                    case 2 :
                        text = "密码错误";
                        styleCss = "label-important";
                        break;
                    case 3 :
                        text = "账号被锁定";
                        styleCss = "label-important";
                        break;
                    case 4 :
                        text = "账号被禁用";
                        styleCss = "label-important";
                        break;
                    case 5 :
                        text = "成功";
                        styleCss = "label-success";
                        break;
                    default :
                        text = "未知";
                        styleCss = "label-important";
                        break;
                }
                return '<span class="label ' + styleCss + '">' + text + '</span>';
            }
        }, {
            "mData": "loginIp",
        }];
        var options = {
            "ajax": ajax,
            "tableId": tableId,
            "aoColumns": aoColumns
        }
        myDataTable(options);
        $("#topPlugin").hide()
    }());

</script>
</#macro>

