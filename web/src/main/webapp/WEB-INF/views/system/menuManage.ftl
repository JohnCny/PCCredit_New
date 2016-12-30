<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="/static/css/radio.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
</#macro>
<#macro style>
<style>
</style>
</#macro>
<#macro breadcrumb>
    <h3>
        系统设置
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active"> 菜单管理</li>
    </ul>
</#macro>

<#macro content>
    <div class="row">
        <div class="col-md-12">
            <div class="report common list">
                <section class="panel">
                    <header class="panel-heading">
                        菜单权限设置
                    </header>
                    <div class="treeBox">
                        <ul id="treeDemo" class="ztree"></ul>
                        <div>
                      <#list roleAll as temp>
                            <span class="hideInput">
                                <input id="roleId" type="radio" name="roleId" value="${temp.id}" <#if temp.id=currentUserRole>checked="checked"</#if>>
                                <label onclick="setRadio(this)"<#if temp.id=currentUserRole>class="radio radio_a"<#else>class="radio"</#if>>
                                    ${temp.roleNameZh}
                                </label>
                            </span>
                        </#list>
                  </div>
             <div>
                <input id="saveMenu" type="button" value="保存菜单">
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
    <script>
        var roleId = 2;
        var urlMy = "/menu/allAuth?roleId="+roleId;
        var setting = {
            edit: {
                enable: true,
                showRemoveBtn: false,
            },
            check:{
                enable: true,
                autoCheckTrigger:true
            },
            data: {
                key:{
                    name:"menuNameZh",
                    children:"menuLists",
                    checked:"seeAuth"
                },
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onCheck: zTreeOnCheck,
                beforeDrop: beforeDrop,
                onRename: onRename

            }
        };

        baseTree(urlMy, setting);

        function zTreeOnCheck(event, treeId, treeNode) {
            var oldId = !treeNode.seeAuth?treeNode.seeAuthId:-1;
            var newId = oldId==-1?treeNode.seeAuthId:-1;
            var isSuc = false;
            console.log("roleId:"+roleId+",oldId:"+oldId+",newId:"+newId);
            $.get("/role", { roleId: roleId, oldAuthorityId: oldId,newAuthorityId:newId},
                function(msg){
                    if(msg.code == 200){
                        isSuc = true;
                    }else{
                        isSuc = false;
                    }
                }
            );
            return isSuc;
        }

        function onRename(e, treeId, treeNode, isCancel) {
            var arr = [];
            var isSuc = false;
            arr[0] = {
                menuNameZh:treeNode.menuNameZh,
                id:treeNode.id
            }
            $.ajax({
                type:"put",
                url:"/menu",
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

        function beforeDrop(treeId, treeNodes, targetNode, moveType) {
            var arr = [];
            var isSuc = false;
            $(treeNodes).each(function(i){
                var dataJson = {
                    id:this.id,
                    menuParentId:targetNode.id
                };
                arr[i] = dataJson;
            })

            $.ajax({
                type:"put",
                url:"/menu",
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


        $("#saveMenu").click( function () {
            $.get("/menu/refresh",
                function(msg){
                    if(msg.code==200){
                        alert("保存成功")
                        location.reload()
                    }
                }
            );
        });

        function setRadio(obj) {//单选样式
            $(obj).parent().parent().find("input[type=radio]").attr("checked", false)
            $(obj).parent().parent().find("label").attr("class", "radio")
            $(obj).parent().find("input[type=radio]").attr("checked", true)
            $(obj).parent().find("label").attr("class", "radio radio_a")
            roleId = $(obj).parent().find("input[type=radio]").val();
            var url = "/menu/allAuth?roleId="+roleId;
            baseTree(url, setting);
        }
    </script>
</#macro>
