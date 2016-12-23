<#include "layout/base.html"/>

<#macro style>
    <style>
        input,select{
            margin-top: 10px;
            width:70%
        }
        [v-cloak] {
            display: none
        }
        .cus_content{
            border: 1px solid #6F7691;
            padding-bottom: 30px;
            float: left;
        }

        .widclas{
            width: 20%;
            float: left;
            height:80px;
            margin-left: 10%;
            margin-top: 50px;
        }
        @media screen and (max-width: 1300px){
            .widclas{
                width: 30%;
                float: left;
                height:80px;
                margin-left: 10%;
                margin-top: 50px;
            }
        }
        .new_customer{
            padding: 50px;
        }
        .create{
            width: 100%;
            min-width: 700px;
            height: 30px;
            background-color: #6F7691;
            font-size: 16px;
            line-height: 30px;
            font-weight: bold;
            padding-left: 8px;
            color: #ffffff;
        }
        .contain{
            margin: 50px 0 0 8.7%;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>

</#macro>
<#macro content>

    <form class="content">
        <h1>管理</h1>
        <h2>当前位置：客户管理 / 客户经理管理 / ${customerManager.cName} / <span>管理</span></h2>
        <div class="report common">
            <h5>客户经理信息</h5>
            <table>
                <tr>
                    <td class="pull-right">当前级别：</td><td><span class="blue">${customerManager.levelName}</span></td>
                    <td class="pull-right">系统建议：</td><td><span class="blue">${customerManager.systemLevel}</span></td>
                </tr>
                <tr>
                    <td class="pull-right">级别调整：</td>
                    <td>
                        <select>
                            <#list customerManagerLevel as cml>
                                <option id="${cml.id}">${cml.value}</option>
                            </#list>
                        </select>
                    </td>
                    <td class="pull-right">是否暂停进件：</td>
                    <td><input type="text" value="${customerManager.ifPause}"></td>
                </tr>
            </table>
        </div>
        <p class="button">
            <input type="button" value="保存" onclick="iframe('khjl_list.html')"/>
            <input type="button" class="back" value="返回" onclick="iframe('khjl_list.html')"/>
        </p>
    </form>

</#macro>
<#macro script>
    <script>
        $(document).ready(function(){

        });
    </script>

</#macro>
<#macro js>

</#macro>