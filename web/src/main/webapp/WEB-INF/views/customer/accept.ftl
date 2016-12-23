<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
<style>
    [v-cloak] {
        display: none
    }
    .common .center tr td{border:none;line-height:40px;background:none;}
    .common input{width:200px;}
    select{border: 1px solid #e2e2e2}
    .content h1 {
        color: #49586e;
        font-size: 25px;
        font-weight: normal;
        margin: 5px 0;
    }
    .content h2 {
        color: #999999;
        font-size: 14px;
        font-weight: normal;
        margin-top: 10px;
        margin-bottom: 10px;
    }
    .common{margin-top: 10px}
    #reason input{border: 1px solid #e2e2e2}
</style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
<h1>${title}</h1>
<h2>当前位置：客户管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
<h1>客户接收</h1>
<h2>当前位置：客户管理 / <span>客户接收</span></h2>
<div class="report common tableB">
    <h5>客户列表</h5>
    <table class="center">
        <tr>
            <th>选择</th>
            <th>客户名称</th>
            <th>客户证件号码</th>
            <th>移交原因</th>
        </tr>
        <tr onclick="selectTR2(this)">
            <td><span class="hideInput"><input type="checkbox" name="checkbox"/><label class="checkbox"></label></span></td>
            <td>客户1</td>
            <td>132366523366</td>
            <td>XXXXXXXXXXXXX</td>
        </tr>
        <tr onclick="selectTR2(this)">
            <td><span class="hideInput"><input type="checkbox" name="checkbox"/><label class="checkbox"></label></span></td>
            <td>客户2</td>
            <td>132366523366</td>
            <td>XXXXXXXXXXXXX</td>
        </tr>
        <tr onclick="selectTR2(this)">
            <td><span class="hideInput"><input type="checkbox" name="checkbox"/><label class="checkbox"></label></span></td>
            <td>客户3</td>
            <td>132366523366</td>
            <td>XXXXXXXXXXXXX</td>
        </tr>
        <tr onclick="selectTR2(this)">
            <td><span class="hideInput"><input type="checkbox" name="checkbox"/><label class="checkbox"></label></span></td>
            <td>客户4</td>
            <td>132366523366</td>
            <td>XXXXXXXXXXXXX</td>
        </tr>
    </table>
</div>
<p class="button">
    <input type="submit" value="接收"/>
    <input type="reset" class="del" value="拒绝"/>
</p>
</#macro>

<#macro script>
<script>
    $(function () {
        $.ajax({
            type:"get",
            url:"/customerTransfer/queryTransfer",
            success:function () {

            }
        });
    })
</script>
</#macro>

<#macro js>


</#macro>
