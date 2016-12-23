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
<form class="content">
    <h1>编辑客户信息</h1>
    <h2>当前位置：客户管理 / 客户信息查询 / 客户1 / <span>编辑客户信息</span></h2>
    <div class="report common">
        <h5>客户信息</h5>
        <input class="searchBtn" type="hidden"  id="id" value="${tCustomerBasic.id}">
        <table>
            <tr>
                <td class="pull-right">客户名称：</td>
                <td colspan="3"><input type="text" id="cname" value="${tCustomerBasic.cname}"></td>
            </tr>
            <tr>
                <td class="pull-right">证件类型：</td>
                <td>
                    <select disabled >
                        <option id="certificateType">${tCustomerBasic.certificateType}</option>
                    </select>
                </td>
                <td class="pull-right">证件号码：</td>
                <td><input type="text" disabled id="certificateNumber" value="${tCustomerBasic.certificateNumber}"></td>
            </tr>
            <tr>
                <td class="pull-right">联系方式：</td>
                <td><input type="text" id="tel" value="${tCustomerBasic.tel}"></td>
                <td class="pull-right">家庭住址：</td>
                <td><input type="text" id="homeAddress" value="${tCustomerBasic.homeAddress}"></td>
            </tr>
            <tr>
                <td class="pull-right">所属行业：</td>
                <td colspan="3">
                    <div class="selectResult" id="fzrhy"></div><br>
                    <select onchange="checkSelect(this,'fzrhy')">
                        <option>---请选择---</option>
                        <option>呜呜呜呜呜呜</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="pull-right">婚姻状况：</td>
                <td>
                    <select>
                        <option id="marriageStatus">${tCustomerBasic.marriageStatus}</option>
                    </select>
                </td>
                <td class="pull-right">文化程度：</td>
                <td>
                    <select>
                        <option id="educationDegree">${tCustomerBasic.educationDegree}</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>
    <p class="button">
        <input type="button" id="btn_submit" value="保存" onclick="iframe('khwh_list.html')"/>
    </p>
</form>
</#macro>

<#macro script>
<script>
    $(function () {
        var url = "/customerBasic";
        var arr = ["id", "cname","certificateNumber", "certificateType", "tel", "homeAddress", "marriageStatus", "educationDegree"];
        var Obj = {};
        $("#btn_submit").click(function (e) {
            e.preventDefault();
            for(var i = 0; i < arr.length; i++){
                Obj[arr[i]]=$("#"+arr[i]).val();
            }
            $.ajax({
                type:"put",
                url:url,
                data:Obj,
                success: function(res){
                    if(res.code == 200){
                      /*  location.href="/customerMaintenance/index";*/
                    }
                }
            });
        })
    })
</script>
</#macro>

<#macro js>


</#macro>
