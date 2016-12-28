<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        .btn{
            width: 80px;
            margin-left: 10px;
        }
        .list_show table tr th,.list_show table tr td{
            text-align: center;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>${title}</h1>
<h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
    <div class="col-xs-3" style="background-color: #fff ;border-radius: 5px">
        <div class="report common list">
            <h5>机构列表</h5>
            <div class="treeBox">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div class="col-xs-1"></div>
    <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
        <h5>机构信息</h5>
        <div class="search" style="width:95%">
            <input type="hidden" name="orgId" id="orgId">
        </div>
        <div class="table-responsive list_show" style=" width:100%;">
            <table id="userList" class="table table-bordered" style="width: 100%">
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
</div>

</#macro>

<#macro script>
<script type="text/javascript" src="/static/js/ztree-org.js"></script>
</#macro>

<#macro js>
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
                return '<a onclick="deleRow()" class="btn editOne btn-info " href="/organization/toAdd">添加</a><a onclick="deleRow()" class="btn editOne btn-info" href="/organization/' + data + '">编辑</a><a class="btn btn-danger deleteOne delete editOne" href="javaScript:;" data-id='+data+'>删除</a>';
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
