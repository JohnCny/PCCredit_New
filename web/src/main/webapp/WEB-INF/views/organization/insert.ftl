<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input,select,textarea{
            border: 1px solid lightgray;
            border-radius: 3px;
        }
        input,textarea,select{
            height: 30px;
            padding: 5px;
        }
        .rightRole{
            width: 100%;
            list-style: none;
            margin: 30px auto 0;
        }
        .rightRole li{
            float: left;
            margin-top: 20px;
        }
        .rightRole li select,.rightRole li input,.rightRole li textarea{
            width: 60%;
        }
        .rightRole li label{
            display: inline-block;
            width: 40%;
            color: #7a7676;
            font-weight: normal;
        }
    </style>
</#macro>
<#macro css>
    <link href="../../../static/css/main.css" rel="stylesheet">
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
            <input type="hidden" name="orgId" id="orgId">
        <form id="contenttable" action="">
            <div class="common report">
               <input class="searchBtn" type="hidden" name="id" id="id" value="${tOrganization.id}">
                <ul class="rightRole">
                    <li class="col-md-4 col-sm-12 col-xs-12">
                        <label>机构名称：</label>
                        <input type="text" id="orgName" name="orgName">
                    </li>
                    <li class="col-md-4 col-sm-12 col-xs-12">
                        <label>负责人：</label>
                        <input type="text" id="orgDirectorName" name="orgDirectorName">
                    </li>
                    <li class="col-md-4 col-sm-12 col-xs-12">
                        <label>后勤：</label>
                        <input type="text" id="orgLogisticsId" name="orgLogisticsId">
                    </li>
                </ul>
            </div>
        <p class="button">
            <!--<input type="button" id="btn_submit" value="保存" style="line-height: 30px;margin: 50px auto 0" />-->
            <a href="javascript:void(0);" class="btn btn-success" id="btn_submit">保存</a>
        </p>
        </form>
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
        $(function () {
            var url = "/organization";
            $("#btn_submit").click(function (e) {
                e.preventDefault();
                var Obj = $("#contenttable").serializeArray();
                console.log(Obj);
                $.ajax({
                    type:"post",
                    url:url,
                    data:Obj,
                    success: function(res){
                        if(res.code == 200){
                            location.href="/organization/index";
                        }
                    }
                });

            })
        })

    });

</script>

</#macro>
