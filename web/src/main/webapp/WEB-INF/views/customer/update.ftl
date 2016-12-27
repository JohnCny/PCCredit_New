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
<form id="contenttable" action="">
    <#list dropDownList as dropDown>
    <h1>编辑客户信息</h1>
    <h2>当前位置：客户管理 / 客户信息查询 / 客户1 / <span>编辑客户信息</span></h2>
    <div class="report common">
        <h5>客户信息</h5>
        <input class="searchBtn" type="hidden" name="id" id="id" value="${tCustomerBasic.id}">
        <table>
            <tr>
                <td class="pull-right">客户名称：</td>
                <td colspan="3"><input type="text" id="cname" name="cname" value="${tCustomerBasic.cname}"></td>
            </tr>
            <tr>
                <td class="pull-right">证件类型：</td>
                <td>
                    <select name="certificateType">
                        <#list dropDown.cert as cert>
                            <option <#if tCustomerBasic.certificateType == cert.id>selected</#if>  value="${cert.id}">
                                ${cert.value}
                            </option>
                        </#list>
                    </select>
                </td>
                <td class="pull-right">证件号码：</td>
                <td><input type="text" disabled id="certificateNumber" name="certificateNumber" value="${tCustomerBasic.certificateNumber}"></td>
            </tr>
            <tr>
                <td class="pull-right">联系方式：</td>
                <td><input type="text" id="tel" name="tel" value="${tCustomerBasic.tel}"></td>
                <td class="pull-right">家庭住址：</td>
                <td><input type="text" id="homeAddress" name="homeAddress" value="${tCustomerBasic.homeAddress}"></td>
            </tr>
            <tr>
                <td class="pull-right">所属行业：</td>
                <td colspan="3">
                    <div class="selectResult" id="fzrhy"></div><br>
                    <select>
                        <option>---请选择---</option>
                        <option>呜呜呜呜呜呜</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="pull-right">婚姻状况：</td>
                <td>
                    <select name="marriageStatus">
                        <#list dropDown.marriageStatus as marriageStatus>
                            <option <#if tCustomerBasic.marriageStatus == marriageStatus.id>selected</#if>  value="${marriageStatus.id}">
                            ${marriageStatus.value}
                            </option>
                        </#list>
                    </select>
                </td>
                <td class="pull-right">文化程度：</td>
                <td>
                    <select name="educationDegree">
                        <#list dropDown.educationDegree as educationDegree>
                            <option <#if tCustomerBasic.educationDegree == educationDegree.id>selected</#if>  value="${educationDegree.id}">
                            ${educationDegree.value}
                            </option>
                        </#list>
                    </select>
                </td>
            </tr>
        </table>
    </div>
    <p class="button">
        <input type="button" id="btn_submit" value="保存" />
    </p>
    </#list>
</form>
</#macro>

<#macro script>
<script>
    $(function () {
        var url = "/customerBasic";
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
                     location.href="/customerBasic/index";
                    }
                }
            });

       })
    })

</script>
</#macro>

<#macro js>


</#macro>
