<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input, select, textarea {
            border: 1px solid lightgray;
            border-radius: 3px;
        }

        input, textarea, select {
            height: 30px;
            padding: 5px;
        }

        .rightRole {
            width: 100%;
            list-style: none;
        }

        .rightRole li {
            float: left;
            margin-top: 20px;
        }

        .rightRole li select, .rightRole li input, .rightRole li textarea {
            width: 60%;
        }

        .rightRole li label {
            width: 50%;
            color: #7a7676;
            font-weight: normal;
        }
        .contain{
            margin: 2% 0 0 2.5%;
        }
        @media screen and (max-width: 788px){
            .contain{
                margin: 2% 0 0 5.5%;
            }
        }
        @media screen and (max-width: 1030px){
            .contain{
                margin: 2% 0 0 5.7%;
            }
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h3>
        新增角色
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：系统管理/ 角色权限管理 </a>
        </li>
        <li class="active"> 新增角色</li>
    </ul>
</#macro>
<#macro content>
    <!--<form class="content" id="roleMes">-->
    <!--<div class="report common">-->
    <!--<h5>填写角色信息</h5>-->
    <!--<ul class="rightRole">-->
    <!--<li class="col-md-4 col-sm-12 col-xs-12">-->
    <!--<label for="">角色名称:</label>-->
    <!--<input type="text" name="roleName">-->
    <!--</li>-->
    <!--<li class="col-md-4 col-sm-6 col-xs-12">-->
    <!--<label for="dfaa">是否启用:</label>-->
    <!--<select name="roleStatus" id="dfaa">-->
    <!--<option value="1">启用</option>-->
    <!--<option value="0">禁用</option>-->
    <!--</select>-->
    <!--</li>-->
    <!--<li class="col-md-4 col-sm-6 col-xs-12">-->
    <!--<label for="dddf">描述信息:</label>-->
    <!--<textarea name="roleDescription" id="dddf">-->

    <!--</textarea>-->
    <!--</li>-->
    <!--</ul>-->
    <!--</div>-->
    <!--<div class="report common">-->
    <!--<h5>配置角色权限</h5>-->
    <!--<ul class="rightRole">-->
    <!--<#list authorityGroups as temp>-->
    <!--<li class="col-md-4 col-sm-6 col-xs-12">-->
    <!--<label for="roleled">${temp.groupName}</label>-->
    <!--<select name="authorityId" id="roleled">-->
    <!--<option value="-1">-&#45;&#45;请选择-&#45;&#45;</option>-->
    <!--<#list temp.authorityList as var>-->
    <!--<option value="${var.id}">${var.authorityNameZh}</option>-->
    <!--</#list>-->
    <!--</select>-->
    <!--</li>-->
    <!--</#list>-->
    <!--</ul>-->
    <!--</div>-->
    <!--<p class="button">-->
    <!--<input type="button" value="保存" class="submited"/>-->
    <!--<input type="button" class="back" value="返回"/>-->
    <!--</p>-->
    <!--</form>-->
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    新增角色
                    <span class="tools pull-right">
             </span>
                </header>

                <div class="panel-body">
                    <div class="table-responsive">
                        <form class="content" id="roleMes">
                            <div class="report common">
                                <ul class="rightRole">
                                    <li class="col-md-4 col-sm-12 col-xs-12">
                                        <label for="">角色名称:</label>
                                        <input type="text" name="roleName">
                                    </li>
                                    <li class="col-md-4 col-sm-12 col-xs-12">
                                        <label for="dfaa">是否启用:</label>
                                        <select name="roleStatus" id="dfaa">
                                            <option value="1">启用</option>
                                            <option value="0">禁用</option>
                                        </select>
                                    </li>
                                    <li class="col-md-4 col-sm-12 col-xs-12">
                                        <label for="dddf">描述信息:</label>
                                        <textarea name="roleDescription" id="dddf"></textarea>
                                    </li>
                                </ul>
                            </div>
                            <div class="report common">
                                <ul class="rightRole">
                                    <h5>以下选项不可手动选择</h5>
                                    <#list authorityGroups as temp>
                                        <li class="col-md-4 col-sm-6 col-xs-12">
                                            <label for="roleled">${temp.groupName}</label>
                                            <select name="authorityId" id="roleled">
                                                <option value="-1">---请选择---</option>
                                                <#list temp.authorityList as var>
                                                    <option value="${var.id}">${var.authorityNameZh}</option>
                                                </#list>
                                            </select>
                                        </li>
                                    </#list>
                                </ul>
                            </div>
                            <!-- <p class="button">
                                 <input type="button" value="保存" class="submited"/>
                                 <input type="button" class="back" value="返回"/>
                             </p>-->
                            <div class="col-xs-12 contain">
                                <!--<button id="btn_submit" class="btn btn-success submited">保存</button>-->
                                <a href="javascript:void (0);" id="btn_submit" class="btn btn-success submited">保存</a>
                                <a href="/role/rolePage" type="reset" class="btn btn-default">返回</a>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>
</#macro>

<#macro script>

</#macro>

<#macro js>
    <script>
        $(function () {
            var url = "/role/add";
            $(".submited").click(function () {
                var data = $("#roleMes").serializeArray();
                console.log(data);
                $.ajax({
                    url: url,
                    data: data,
                    type: "post",
                    success: function (res) {
                        if (res.code == 200) {
                            alert("创建成功");
                            location.href = "/role/rolePage"
                        }
                    }
                })
            });
        });
    </script>

</#macro>
