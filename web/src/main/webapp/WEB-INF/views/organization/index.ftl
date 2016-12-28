<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>

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
            <div class="treeBox" >
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div class="col-xs-1"></div>
    <div class="col-xs-8" style="background-color: #ffffff; border-radius: 5px">
        <h5>机构信息</h5>
        <div class="search" style="width:95%">
            <span>机构：<input type="text" class="short" placeholder="请在左侧选择机构" readonly="readonly" disabled="disabled"
                            name="orgId" id="orgId"></span>
        </div>
        <div class="table-responsive list_show" style=" width:100%;">
            <table id="userList" class="table table-bordered" style="width: 100%">
                <thead>
                <tr>
                    <th>机构名称</th>
                    <th>负责人</th>
                    <th>后勤</th>
                    <th>父机构</th>
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
            edit: {
                enable: true,
                showRemoveBtn: false,
                showRenameBtn: false
            },
            check:{
                enable: true,
                autoCheckTrigger:true
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

</#macro>
