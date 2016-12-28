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
        }
        .rightRole li{
            float: left;
            margin-top: 20px;
        }
        .rightRole li select,.rightRole li input,.rightRole li textarea{
            width: 60%;
        }
        .rightRole li label{
            width: 40%;
            color: #7a7676;
            font-weight: normal;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>新增角色</h1>
    <h2>当前位置：系统管理 / 角色权限管理 / <span>新增角色</span></h2>
</#macro>
<#macro content>
    <form class="content" id = "roleMes">
        <div class="report common">
            <h5>填写角色信息</h5>
            <!--<table width="95%" border="1" cellpadding="2" cellspacing="1" style="margin: 50px auto 0">
                <tr>
                    <td class="pull-right" width="90px" nowrap>角色名称<font class="red">*</font>：</td>
                    <td width="400px" nowrap><input type="text"></td>
                    <td class="pull-right" width="100px" nowrap>是否启用<font class="red">*</font>：</td>
                    <td width="400px" nowrap>
                        <select name="" id="">
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                        </select>
                    </td>
                </tr>
            </table>-->
            <ul class="rightRole">
                <li class="col-md-4 col-sm-12 col-xs-12">
                    <label for="">角色名称:</label>
                    <input type="text" name="roleName">
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <label for="dfaa">是否启用:</label>
                    <select name="roleStatus" id="dfaa">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <label for="dddf">描述信息:</label>
                    <textarea name="roleDescription" id="dddf">

                    </textarea>
                </li>
            </ul>
        </div>
        <div class="report common">
            <h5>配置角色权限</h5>
            <!--<table  width="95%" border="1" cellpadding="2" cellspacing="1" style="margin: 50px auto 0">-->
                    <!--<#list authorityGroup as temp>-->
                        <!--<#if temp_index%3==0>-->
                            <!--<tr>-->
                        <!--</#if>-->
                        <!--<td class="pull-right" width="100px" nowrap>${temp.groupName}</td>-->
                        <!--<td width="100px" nowrap>-->
                            <!--<select class="short" name="authorityId">-->
                                <!--<option value="-1">-&#45;&#45;请选择-&#45;&#45;</option>-->
                                <!--<#list temp.authorityList as var>-->
                                    <!--<option value="${var.id}">${var.authorityNameZh}</option>-->
                                <!--</#list>-->
                            <!--</select>-->
                        <!--</td>-->
                        <!--<#if temp_index%3==0>-->
                            <!--</tr>-->
                        <!--</#if>-->
                    <!--</#list>-->
            <!--</table>-->
            <ul class="rightRole">
                <#list authorityGroup as temp>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <label for="roleled">${temp.groupName}</label>
                    <select name="authorityId" id="roleled">
                        <option value="-1">---请选择---</option>
                        <#list temp.authorityList as var>
                        <option value="">${var.authorityNameZh}</option>
                        </#list>
                    </select>
                </li>
                </#list>
            </ul>
        </div>
        <p class="button">
            <input type="button" value="保存" class="submited"/>
            <input type="button" class="back" value="返回"/>
        </p>
    </form>

</#macro>

<#macro script>

</#macro>

<#macro js>
    <script>
        $(function () {
            var url ="/role/add";
            $(".submited").click(function () {
                var data = $("#roleMes").serializeArray();
               $.ajax({
                   url:url,
                   data:data,
                   type:"post",
                   success:function (res) {
                       if(res.code == 200){
                           alert("创建成功");
                       }
                   }
               })
            });
        });
    </script>

</#macro>
