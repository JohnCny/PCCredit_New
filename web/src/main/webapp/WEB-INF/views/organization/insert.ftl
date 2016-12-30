<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro css>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
</#macro>
<#macro style>
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
    <div class="row">
        <div class="col-sm-12">
            <div class="col-xs-2">
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
            <div class="col-xs-10" style="background-color: #ffffff; border-radius: 5px">
                <section class="panel">
                    <header class="panel-heading">
                        机构信息
                    </header>
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
                            <a href="javascript:void(0);" class="btn btn-success" id="btn_submit">保存</a>
                        </p>
                    </form>

                </section>
            </div>
        </div>
    </div>
</#macro>
<#macro js>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
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
