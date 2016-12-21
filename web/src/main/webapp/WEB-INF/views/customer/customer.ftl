<#include "layout/base.html"/>

<#macro style>
    <style>
        [v-cloak] {
            display: none
        }
        .row{
            width: 95%;
            margin: 50px auto 0px;
            border: 1px solid #6F7691;
        }
        .caption{
            width: 100%;
            height: 40px;
            background-color: #6F7691;
            font-size: 16px;
            font-weight: bold;
            line-height: 40px;
            color: #ffffff;
            padding-left: 10px;
        }
        .portlet-body{
            width: 95%;
            margin: 0 auto;
        }
        .btn-success{
            margin-top: 20px;
        }
        .table-striped{
            margin-top: 20px;
        }
        .table-striped thead tr th{
            text-align: center;
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro content>
    <div class="row">
        <div class=" ">
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-user"></i>
                        全部客户
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>
                        <!--<a href="" class="fullscreen" data-original-title="" title=""> </a>-->
                        <!--<a href="javascript:;" class="remove" data-original-title="" title=""> </a>-->
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-striped table-bordered table-hover  order-column" id="dtCustomers">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件号码</th>
                            <th>家庭地址</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list tCustomerBasicList as customer>
                        <tr>
                            <th>${customer.id}</th>
                            <th>${customer.cname}</th>
                            <th>${customer.sex}</th>
                            <th>${customer.certificateNumber}</th>
                            <th>${customer.homeAddress}</th>
                        </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</#macro>
<#macro script>
    <script>
        $(function () {
            $.ajax({
                type:"get",
                url:"/customerBasic/success"
            });
        })
//        $(function () {
//            var url = "/customerBasic/api/list";
//            $.ajax({
//                type:"get",
//                url:url,
//                success:function (data) {
//                    var result = data['data'];
//                    console.log(result[0].id);
//                    for(var i = 0; i <= result.length; i ++){
//                        $(".table-striped tbody tr:eq(i) td" +
//                                "" +
//                                "").html(result[0].id);
//                    }
//                }
//            })
//        })
    </script>


</#macro>
<#macro js>

</#macro>
