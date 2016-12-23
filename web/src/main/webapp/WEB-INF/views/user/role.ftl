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

    <h5>客户列表</h5>


    <div class="table-responsive" style="margin:50px auto; width:95%;">
        <table id="example" class="table table-bordered" style="width: 100%" >
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>联系方式</th>
                <th>操作</th>
            </tr>
            <#list roleAll as roleAll>
                <tr>
                    <td>${roleAll.roleName}</td>
                    <td>${roleAll.roleNameZh}</td>
                    <td>${roleAll.roleDescription}</td>
                    <td class="action">
                        <#list userRole as userRole>
                            <#if userRole.roleId == roleAll.id>
                                <input type="checkbox" name="check" class="checkbox" checked="checked" value="${userRole.userId}" data-id="${roleAll.id}">
                                <#else>
                                <input type="checkbox" name="check" class="checkbox" value="${userRole.userId}" data-id="${roleAll.id}">
                            </#if>

                        </#list>


                    </td>
                </tr>


            </#list>
            </thead>
        </table>
    </div>

</#macro>

<#macro script>
    <script>
        $(function () {
            var roleAllid =
            $(".checkbox").on("click",function () {
                var userId = $(this).attr("value");
                var roleId = $(this).data("id");

//                if(that.prop("checked")){
//                    $.ajax({})
//                }else {
//                    alert(321)
//                }
                console.log(roleId);
                $.ajax({
                    type:"get",
                    url:"/user/"+userId+"/updateUserRole",
                    data:{"roleId": roleId},
                    success:function (res) {
                        if(res.code == 200){
                            alert("成功");
                        }
                    }

                })
            })
        })

    </script>
</#macro>

<#macro js>



</#macro>
