<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro style>
    <style>

    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>用户</h1>
    <h2>当前位置：用户管理 / <span class="active">用户</span></h2>
</#macro>
<#macro content>
    <h5>用户列表</h5>
    <div class="search" style="width:95%">
        <span>机构：<select name="" id="organization" class="">
            <option value="">--请输入--</option>
            <#list topOrganization as organization>
                    <option value="${organization.id}">${organization.orgName}</option>
            </#list>>
        </select></span>
        <span>用户名称：<input type="text" class="short" name="username" id="username" ></span>
        <span> 邮件：<input type="text" name="email" id="email"></span>
        <input class="searchBtn" type="button" value="搜 索">
    </div>

    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="userList" class="table table-bordered" style="width: 100%" >
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

</#macro>

<#macro script>
    <script>
        $(function () {
            var url = ""
            $("#organization").change(function () {
                var parentId = $("#organization>option:selected").attr("value");
                console.log(parentId);
                if (parentId != ""){
                    $.ajax({
                        type:"get",
                        url:"/organization/byParentId",
                        data:{"parentId" : parentId},
                        success:function (res) {
                            if(res.code == 200){
                                if(res.data == ""){

                                }
                            }
                        }
                    })
                }
            })
        });
    </script>

</#macro>

<#macro js>

    <script>
        var url  = {

        }
        var QK_searchObj = {
            "email" : $("#email").val(),
        }
        var tableId = $("#userList");
        var ajax = {
            "type" : "GET",
            "url" : "/user/pageList",
            "data" : function(d){
                d.search = JSON.stringify(QK_searchObj);
                d.name = " ";
                d.IdNumber = " ";
            }
        }
        var aoColumns = [{
            "mData" : "username",
        },{
            "mData" : "sex",
            "sDefaultContent" : "",
            "render" : function(data, type, full, meta) {
                return	data?"男":"女";
            }
        },{
            "mData" : "tel",
        },{
            "mData" : "email",
        },{
            "mData" : "lastLoginTime",
            "sDefaultContent" : "",
            "render" : function(data, type, full, meta) {
                //时间格式化
                return  moment(data).format("YYYY-MM-DD");
            }
        },{
            "mData" : "id",
            "sDefaultContent" : "",
            "render" : function(data, type, full, meta) {
                var html = "";
                if(!full.status){
                    html += '<button  class="btn btn-success activeBtn" data-id='+data+' data-status='+full.status+'>点击锁定</button>';
                }else{
                    html += '<button  class="btn btn-default activeBtn" data-id='+data+' data-status='+full.status+'>点击解锁</button>';
                }
                html += '<button class="btn btn-info resetBtn" data-id='+data+'>重置密码</button>';
                html += '<button class="btn btn-primary" data-id='+data+'>角色管理</button>'
                return  html;
            }
        }];

        var options = {
            "ajax" : ajax,
            "tableId" : tableId,
            "aoColumns" : aoColumns
        }
        myDataTable(options);

    </script>

</#macro>
