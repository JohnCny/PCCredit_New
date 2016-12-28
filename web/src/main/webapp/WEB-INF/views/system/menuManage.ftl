<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
<style>
    input, select {
        border: 1px solid rgba(0, 0, 0, 0.2);
        height: 30px;
        border-radius: 5px
    }

    table, table tr, table tr td {
        background-color: #fff
    }
</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>系统设置</h1>
<h2>当前位置：系统管理 / <span class="active">菜单管理</span></h2>

</#macro>
<#macro content>
<div class="row" style="background-color: #efefef;width: 100%;margin-left: 0">
    <div class="col-xs-5" style="background-color: #ffffff; border-radius: 5px">
        <div class="report common" style="display:inline-block;width:100%">
            <div class="report common list">
                <h5>菜单权限设置</h5>
                <div class="treeBox">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
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
</div>



</#macro>

<#macro script>
<script type="text/javascript" src="/static/js/ztree-org.js"></script>
</#macro>
<#macro js>
<script type="text/javascript">
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
