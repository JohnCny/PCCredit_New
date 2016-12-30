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
        数据字典编辑
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：数据字典编辑</a>
        </li>
        <li class="active"> 数据字典编辑</li>
    </ul>
</#macro>
<#macro content>

    <!--<div class="row new_customer">-->
        <!--<div class=" cus_content">-->
            <!--<div class="create">-->
                <!--编辑-->
            <!--</div>-->
            <!--&lt;!&ndash; BEGIN EXAMPLE TABLE PORTLET&ndash;&gt;-->
            <!--<form action="" id="contenttable">-->
                <!--<input type="hidden" id="dataId" name="dataId" value="${dataDictionary.dataId}"/>-->
                <!--<div class="widclas">-->
                    <!--<label for="dataType">字典类别：</label>-->
                    <!--<div class="input-icon right">-->
                        <!--<i class="fa"></i>-->
                        <!--<input  id="dataType" type="text" class="form-control" name="dataType" value="${dataDictionary.dataType}" placeholder="请输入至少2-10位汉字">-->
                    <!--</div>-->
                <!--</div>-->

                <!--<div class="widclas">-->
                    <!--<label for="dataCode">字典代码：</label>-->
                    <!--<div class="input-icon right">-->
                        <!--<i class="fa"></i>-->
                        <!--<input id="dataCode" type="text" class="form-control" name="dataCode" value="${dataDictionary.dataCode}" placeholder="请输入正确的手机号码">-->
                        <!--<div class="message">${telError}</div>-->
                    <!--</div>-->
                <!--</div>-->
                <!--<div class="widclas">-->
                    <!--<label for="dataName">字典名称：</label>-->
                    <!--<div class="input-icon right">-->
                        <!--<i class="fa"></i>-->
                        <!--<input   id="dataName" type="text" class="form-control" name="dataName" value="${dataDictionary.dataName}" placeholder="请输入有效地址">-->
                        <!--<div class="message">${homeAddressError}</div>-->
                    <!--</div>-->
                <!--</div>-->
                <!--<div class="widclas">-->
                    <!--<label for="bankCode">银行代码：</label>-->
                    <!--<div class="input-icon right">-->
                        <!--<i class="fa"></i>-->
                        <!--<input   id="bankCode" type="text" class="form-control" name="bankCode" value="${dataDictionary.bankCode}" placeholder="请输入有效地址">-->
                        <!--<div class="message">${homeAddressError}</div>-->
                    <!--</div>-->
                <!--</div>-->
                <!--<div class="col-xs-12 contain">-->
                    <!--<button id="btn_submit" class="btn btn-success" style="background-color: #6F7691;border-radius: 0px;border: 1px solid #6F7691；">确定</button>-->
                    <!--<a href="/system/index" type="reset" class="btn btn-default"style="border-radius: 0px;border: 1px solid #2bb8c4；">取消</a>-->
                <!--</div>-->
            <!--</form>-->
        <!--</div>-->
    <!--</div>-->

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
                                    <form action="" id="contenttable">
                                        <input type="hidden" id="dataId" name="dataId" value="${dataDictionary.dataId}"/>
                                        <div class="widclas">
                                            <label for="dataType">字典类别：</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  id="dataType" type="text" class="form-control" name="dataType" value="${dataDictionary.dataType}" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>

                                        <div class="widclas">
                                            <label for="dataCode">字典代码：</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input id="dataCode" type="text" class="form-control" name="dataCode" value="${dataDictionary.dataCode}" placeholder="请输入正确的手机号码">
                                                <div class="message">${telError}</div>
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="dataName">字典名称：</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input   id="dataName" type="text" class="form-control" name="dataName" value="${dataDictionary.dataName}" placeholder="请输入有效地址">
                                                <div class="message">${homeAddressError}</div>
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="bankCode">银行代码：</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input   id="bankCode" type="text" class="form-control" name="bankCode" value="${dataDictionary.bankCode}" placeholder="请输入有效地址">
                                                <div class="message">${homeAddressError}</div>
                                            </div>
                                        </div>
                                        <div class="contain">
                                            <button id="btn_submit" class="btn btn-success " style="margin-top: 50px">保存
                                            </button>
                                            <a href="/dataDictionary/index" type="reset" class="btn btn-default " style=" border: 1px solid rgba(0, 0, 0, 0.2);margin-top: 50px">返回</a>
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
        var url = "/dataDictionary";
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
                        location.href="/dataDictionary/index";
                    }
                }
            });

        })
    })
</script>
</#macro>
<#macro js>

</#macro>