<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro css>
</#macro>
<#macro style>
    <style>
        .dis{
            margin-top: 20px;
        }
    </style>
</#macro>

<#macro breadcrumb>
    <h3>
        客户管理
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">客户经理级别定义</a>
        </li>
        <li class="active"> ${customerManagerLevel.levelName} / <span>调整</span> </li>
    </ul>
</#macro>
<#macro content>

    <div class="row">
        <div class="col-md-12">
            <section class="panel">
                <header class="panel-heading">
                    客户经理级别信息
                </header>
            <div class="portlet-body">

                <form id="contenttable" action="">
                    <div class="row dis">
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="levelName">级别名称</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="levelName" type="text" class="form-control distance" name="levelName" value="${customerManagerLevel.levelName}" disabled>
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="levelCredit">对应额度</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="levelCredit" type="text" class="form-control distance" name="levelCredit"  value="${customerManagerLevel.levelCredit}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="overdueTolerateRate">逾期容忍率</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="overdueTolerateRate" type="text" class="form-control distance" name="overdueTolerateRate"  value="${customerManagerLevel.overdueTolerateRate}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="badloanTolerateRate">不良容忍率</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="badloanTolerateRate" type="text" class="form-control distance" name="badloanTolerateRate"  value="${customerManagerLevel.badloanTolerateRate}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="postloanMonitorTolerateNum">贷后监控容忍量</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="postloanMonitorTolerateNum" type="text" class="form-control distance" name="postloanMonitorTolerateNum"  value="${customerManagerLevel.postloanMonitorTolerateNum}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="loanLimitMin">该级别贷款最小额度</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="loanLimitMin" type="text" class="form-control distance" name="loanLimitMin"  value="${customerManagerLevel.loanLimitMin}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="loanNumberMin">该级别贷款最小笔数</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="loanNumberMin" type="text" class="form-control distance" name="loanNumberMin"  value="${customerManagerLevel.loanNumberMin}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="overdueRateMin">该级别最小逾期率</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="overdueRateMin" type="text" class="form-control distance" name="overdueRateMin"  value="${customerManagerLevel.overdueRateMin}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                            <label for="badloanRateMin">该级别最小不良率</label>
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <input id="badloanRateMin" type="text" class="form-control distance" name="badloanRateMin"  value="${customerManagerLevel.badloanRateMin}">
                                <div class="message"></div>
                            </div>
                        </div>
                        <div class="col-md-12 col-xs-12" style="margin-bottom: 20px;">
                            <input class="btn btn-success" type="button" id="btn_submit" value="保存"/>
                            <input type="button"  class="btn btn-info" class="back" value="返回"/>
                        </div>
                    </div>

                </form>
            </div>
            </section>
        </div>
    </div>
</#macro>
<#macro script>
    <script>
        $(document).ready(function(){
            var url = "/customerManagerLevel";
            var Obj = {};
            var arr = ["id","levelName","levelCredit","overdueTolerateRate","badloanTolerateRate","postloanMonitorTolerateNum"
                ,"loanLimitMin","loanNumberMin","overdueRateMin","badloanRateMin"];

            $("#btn_submit").click(function (e) {
                e.preventDefault();
                for(var i = 0; i < arr.length; i++){
                    Obj[arr[i]]=$("#"+arr[i]).val();
                }
                console.log(Obj);
                $.ajax({
                    type:"put",
                    url:url,
                    data:Obj,
                    success: function(res){
                        if(res.code == 200){
                            location.href="/customerManagerLevel/index";
                        }
                    },
                    error:function () {
                        alert("失败")
                    }
                });
            });
        });
    </script>

</#macro>
<#macro js>

</#macro>