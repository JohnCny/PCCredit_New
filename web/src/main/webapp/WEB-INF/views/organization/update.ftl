<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro css>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
</#macro>
<#macro style>
    <style>
        .distance{
            margin-top: -20px;
        }
        .dis{
            margin-top: 20px;
        }
    </style>

</#macro>

<#macro breadcrumb>
    <h3>
        机构管理编辑
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：机构管理编辑</a>
        </li>
        <li class="active"> 机构管理编辑</li>
    </ul>
</#macro>
<#macro content>
    <div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
        <div class="col-md-12">

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

            <div class="col-md-9" style="background-color: #ffffff; border-radius: 5px">
                <section class="panel">
                    <header class="panel-heading">
                        机构信息
                    </header>
                    <div class="portlet-body">
                            <input type="hidden" name="orgId" id="orgId">
                        <form id="contenttable" action="">

                            <input class="searchBtn" type="hidden" name="id" id="id" value="${tOrganization.id}">
                        <div class="row dis">
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="orgName">机构名称</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input id="orgName" type="text" class="form-control distance" name="orgName" value="${tOrganization.orgName}">
                                    <div class="message"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="orgDirectorName">负责人</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input id="orgDirectorName" type="text" class="form-control distance" name="orgDirectorName" value="${tOrganization.orgDirectorName}">
                                    <div class="message"></div>
                                </div>
                            </div>


                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="orgLogisticsId">后勤</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input id="orgLogisticsId" type="text" class="form-control distance" name="orgLogisticsId" value="${tOrganization.orgLogisticsId}">
                                    <div class="message"></div>
                                </div>
                            </div>
                        </div>
                            <div class="col-md-3 col-xs-12" style="margin-left: -25px;margin-bottom: 20px;">
                                <a href="javascript:void(0);" class="btn btn-success" id="btn_submit">保存</a>
                            </div>
                        </form>
                    </div>
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
                        type:"put",
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
