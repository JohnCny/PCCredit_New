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

    <h5>权限列表</h5>


    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="example" class="table table-bordered" style="width: 100%" >
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>联系方式</th>
                <th>操作权限</th>
            </tr>
            <#list roleAll as temp>
                <tr>
                    <td>${temp.roleName}</td>
                    <td>${temp.roleNameZh}</td>
                    <td>${temp.roleDescription}</td>
                    <td class="action">
                        <#if userRole>
                            <#list userRole as var>
                                <#if var.roleId == temp.id>
                                    <input type="checkbox" name="check" class="checkbox" checked="checked" value="${userId}" data-id="${temp.id}">
                                <#else>
                                    <#if var_index==0>
                                        <input type="checkbox" name="check" class="checkbox" value="${userId}" data-id="${temp.id}">
                                    </#if>
                                </#if>
                            </#list>
                        <#else>
                            <input type="checkbox" name="check" class="checkbox" value="${userId}" data-id="${temp.id}">
                        </#if>
                </tr>
            </#list>
            </thead>
        </table>
    </div>

</#macro>

<#macro script>
    <script>
        $(function () {
            $(".checkbox").on("click",function () {
                var userId = $(this).attr("value");
                var roleId = $(this).data("id");
//                if(that.prop("checked")){
//                    $.ajax({})
//                }else {
//                    alert(321)
//                }
                $.ajax({
                    type:"get",
                    url:"/user/"+userId+"/updateUserRole",
                    data:{"roleId": roleId},
                    success:function (res) {
                        if(res.code == 200){
                            alert("成功");
                        }else {
                            var isChecked = $(this).prop("checked");
                            if(isChecked){
                                $(this).prop("checked") == true;
                            }else {
                                $(this).prop("checked") == false;
                            }
                        }
                    }

                })
            })
        })

    </script>
</#macro>

<#macro js>



</#macro>
