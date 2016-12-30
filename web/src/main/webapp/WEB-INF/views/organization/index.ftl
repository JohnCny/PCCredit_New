<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
</#macro>
<#macro style>
    <style>

    </style>
</#macro>
<#macro breadcrumb>
    <h3>
        机构管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">机构</a>
        </li>
        <li class="active"> 机构管理</li>
    </ul>
</#macro>


<#macro content>
    <div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
        <div class="col-sm-12">

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

    <!--<div class="col-xs-1"></div>-->

            <div class="col-xs-9" style="background-color: #ffffff; border-radius: 5px">
                <section class="panel">
                    <header class="panel-heading">
                        机构信息
                    </header>
                    <div class="portlet-body">
                        <div class="table-responsive">
                            <table id="userList" class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>机构名称</th>
                                    <th>负责人</th>
                                    <th>后勤</th>
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
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>

<#macro script>
    <script type="text/javascript">
        $(document).ready(function () {
            var urlMy = "/organization";
            var setting = {
                data: {
                    simpleData: {
                        enable: true
                    },
                    key: {
                        name: "orgName",
                        children: "organizationList",
                    }
                },
                edit: {
                    enable: true,
                    showRemoveBtn: false,
                    showRenameBtn: false
                },
                callback: {
                    onClick: onClick,
                    beforeDrop: beforeDrop
                }
            };

            baseTree(urlMy, setting);
            function onClick(event, treeId, treeNode, clickFlag) {
                $("#orgId").attr("value", treeNode.orgName);
                $("#orgId").attr("data-id", treeNode.id);

            }

            function beforeDrop(treeId, treeNodes, targetNode, moveType) {
                var arr = [];
                var isSuc = false;
                $(treeNodes).each(function(i){
                    var dataJson = {
                        id:this.id,
                        orgParentId:targetNode.id
                    };
                    arr[i] = dataJson;
                })

                $.ajax({
                    type:"put",
                    url:"/organization/move",
                    contentType: "application/json; charset=utf-8",
                    data:JSON.stringify(arr),
                    success: function(msg){
                        if(msg.code == 200){
                            location.reload()
                            isSuc = true;
                        }else{
                            isSuc = false;
                        }
                    }
                });
                return isSuc;
            }


            var ajax = {
                "type" : "GET",
                "url" : "/organization/pageList",
                "data" : function(d){
                    var QK_searchObj = {
                        "orgName" :$("#orgId").val()
                    }
                    d.search = JSON.stringify(QK_searchObj);
                }

            }

            var url  = {
                "urlNew" : "/organization/add",
                "urlDel" : "/organization/"
            }

            var tableId = $("#userList");
            var aoColumns = [{
                "mData": "orgName"
            }, {
                "mData": "orgDirectorName"

            }, {
                "mData": "orgLogisticsId",
            }, {
                "mData": "id",
                "sDefaultContent": "",
                "render": function (data, type, full, meta) {
                    return '<a onclick="deleRow()" class="btn  btn-info" href="/organization/toAdd">添加</a><a onclick="deleRow()" class="btn btn-info" href="/organization/' + data + '">编辑</a><a class="btn btn-danger deleteOne delete" href="javaScript:;" data-id='+data+'>删除</a>';
                }
            }];
            var options = {
                "urlNew" : url['urlNew'],
                "urlDel" : url['urlDel'],
                "ajax" : ajax,
                "tableId" : tableId,
                "aoColumns" : aoColumns
            }
            myDataTable(options);

        });

    </script>
</#macro>
