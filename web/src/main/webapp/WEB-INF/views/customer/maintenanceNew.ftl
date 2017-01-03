<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        input,select{
            margin-top: 10px;
            width:100%
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
            width: 40%;
            float: left;
            height:80px;
            margin-left: 10%;
            margin-top: 30px;
        }
        @media screen and (max-width: 1300px){
            .widclas{
                width: 90%;
                float: left;
                height:80px;
                margin-left: 10%;
                margin-top: 50px;
            }
        }
        .contain{
            margin-left:10.2%;
            clear: both;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h3>
        新增维护记录
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：新增维护记录</a>
        </li>
        <li class="active"> 新增维护记录</li>
    </ul>
</#macro>
<#macro content>
<!--<form action="">-->

    <!--<h1>新增维护记录</h1>-->
    <!--<h2>当前位置：客户管理 / 客户维护 / 客户1 / <span>新增维护记录</span></h2>-->
    <!--<div class="report common">-->
        <!--<h5>维护记录</h5>-->
        <!--<table>-->
            <!--<tr>-->
                <!--<input class="searchBtn" type="hidden" name="id" id="id" value="${tCustomerBasic.id}">-->
                <!--<td class="pull-right">维护类型：</td>-->
                <!--<td>-->
                    <!--<#list dropDownList as dropDown>-->
                    <!--<select>-->
                        <!--<#list dropDown.maintenanceType as type>-->
                            <!--<option name="maintenanceType" id="maintenanceType" value="${type.id}">${type.value}</option>-->
                            <!--</#list>-->
                    <!--</select>-->
                    <!--</#list>-->
                <!--</td>-->
            <!--</tr>-->
            <!--<tr>-->
                <!--<td class="pull-right">联系方式：</td>-->
                <!--<td><textarea name="maintennaceSummary" id="maintennaceSummary"></textarea></td>-->
            <!--</tr>-->
        <!--</table>-->
    <!--</div>-->
    <!--<p class="button">-->
        <!--<input type="button" id="btn_submit" value="保存" onclick="iframe('khwh_list.html')"/>-->
    <!--</p>-->
<!--</form>-->




    <div class="row">
        <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        用户列表
                    </header>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                <div class="row-fluid">
                                    <form action="" id="userAdd">
                                        <div class="widclas">
                                            <label for="">维护类型</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <#list dropDownList as dropDown>
                                                    <select class="form-control" style="width: 50%">
                                                        <#list dropDown.maintenanceType as type>
                                                            <option name="maintenanceType" id="maintenanceType" value="${type.id}">${type.value}</option>
                                                        </#list>
                                                    </select>
                                                </#list>
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">联系方式</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input type="text" name="maintennaceSummary" id="maintennaceSummary" class="form-control" style="width: 50%">
                                            </div>
                                        </div>
                                        <div class=" contain">
                                            <button id="btn_submit" class="btn btn-success submit" style="margin-top: 30px">保存</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
        </div>
    </div>
</#macro>

<#macro script>
<script>
    $(function () {
        var url = "/customerMaintenance";
        var arr = ["id", "maintenanceType","maintennaceSummary"];
        var Obj = {};
        $("#btn_submit").click(function (e) {
            e.preventDefault();
            for(var i = 0; i < arr.length; i++){
                Obj[arr[i]]=$("#"+arr[i]).val();
            }
            $.ajax({
                type:"post",
                url:url,
                data:Obj,
                success: function(res){
                    if(res.code == 200){
                        location.href="/customerMaintenance/index";
                    }
                    }
            });
        })
    })
</script>
</#macro>

<#macro js>


</#macro>
