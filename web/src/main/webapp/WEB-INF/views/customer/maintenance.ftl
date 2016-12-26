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
<h1>客户维护</h1>
<h2>当前位置：客户管理 / <span>客户维护</span></h2>
<div class="report common tableB">
    <h5>客户列表</h5>
    <div class="search">
        <span>客户名称：<input type="text" class="short" name=""></span>
        <span>客户证件号码：<input type="text" name=""></span>
        <input type="button" value="搜 索"/>
    </div>
    <table class="center">
        <tr>
            <th>客户名称</th>
            <th>客户证件号码</th>
            <th>联系方式</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>客户1</td>
            <td>XXXXXXXXXXXXX</td>
            <td>132366523366</td>
            <td>
                <button class="edit downLoad" onclick="iframe('new_whjl.html')"><i class="icon-plus icon-white"></i>新增维护记录</button>
                <button class="edit info" onclick="iframe('check_whjl.html')"><i class="icon-eye-open icon-white"></i>查看</button>
            </td>
        </tr>
    </table>

    <div class="page-div">
        <span style="CURSOR: pointer"><img src="../../../static/img/prev.png"/></span>
        &#160;第&#160;<font color="#0088cc">1</font>&#160;页&#160; /
        &#160;共&#160;<font color="#0088cc">1</font>&#160;页&#160;
        <span style="CURSOR: pointer"><img src="../../../static/img/next.png"/></span>
    </div>

</div>
</#macro>

<#macro script>

</#macro>

<#macro js>


</#macro>
