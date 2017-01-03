<#include "layout/base.html"/>

<#macro style>
    <style>
        [v-cloak] {
            display: none
        }
        .common .center tr td{border:none;line-height:40px;background:none;}
        .common input{width:200px;}
        .center tr th,.center tr td{text-align:center;border:none;line-height:40px;}
        .common .center tr td{background:#fff;}
        .common .center .edit{margin-top:-4px;}
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

         .center tr th,.tjbb table tr th{font-size:12px;line-height:30px; border: none}
         .center tr td,.tjbb table tr td{font-size:12px;line-height:20px;height:20px;}
         .center .no-border th{border:1px solid #ddd;background:#ddd}
         .center .count th{border:1px solid #eee;background:#eee;}
         .center font{color:rgb(62, 152, 197);}
         .center .noBorder tr td{border:none;}
            table{margin: 0 auto;border:none}
        .edit{font-family: 微软雅黑;width:auto;padding:0 8px;border-radius: 3px;line-height:25px;color: #fff;background-color: #f0ad4e;border:1px solid #eea236;}
        .edit:hover{background-color: #ed9c28;}
        .edit i{vertical-align:middle;margin:-3px 3px 0 -3px;}
         .center tr td select{ margin-top: 10px}
        .info{background-color: #84b4dc;border:1px solid #73a1c8;}
        .info:hover{background-color: #6d9dc6;}
        .button input{margin-top: 50px}
        .center tr td input{margin-top: 4px}
        .center tr td select{border-radius: 5px}
        .center{width: 80%;}
    </style>
</#macro>
<#macro css>
    <!--<link rel="stylesheet" href="/static/css/main.css">-->
</#macro>
<#macro breadcrumb>
    <h3>
        客户移交
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户管理</a>
        </li>
        <li class="active"> 客户移交</li>
    </ul>
</#macro>
<#macro content>
     <!--<div class="content">
         <h1>客户移交</h1>
         <h2>当前位置：客户管理 / <span>客户移交</span></h2>
         <div class="report common">
             <h5>客户列表</h5>
             <table class="center">
                 <tr>
                     <td style="width:45%"><b>现有客户</b></td>
                     <td style="width:10%">&nbsp;</td>
                     <td style="width:45%"><b>移交客户</b></td>
                 </tr>
                 <tr>
                     <td>
                         <select name="" multiple="multiple" size="10" style="width:90%" id="xykh">
                             <#list queryCustomer as cus>
                                 <option value="" id="${cus.id}">${cus.name}</option>
                             </#list>
                         </select>
                     </td>
                     <td>
                         <input type="button" class="edit info" value=">>" onclick="addroles('xykh','yjkh')" style="width:70px;"><br>
                         <input type="button" class="edit info" value="<<" onclick="addroles('yjkh','xykh')" style="width:70px;">
                     </td>
                     <td>
                         <select multiple="multiple" size="10" style="width:90%" id="yjkh" name="roles">

                         </select>
                     </td>
                 </tr>
             </table>

             <table style="margin-top:-20px;padding-top:20px;">
                 <tr>
                     <td style="float:none;width:10%;text-align:right;padding-right:10px;">移交原因：</td>
                     <td id="reason"><input type="text" id = "reso"/></td>
                 </tr>
             </table>
         </div>
         <p class="button">
             <input type="submit" value="移交" id="btn_submit"/>
         </p>
     </div>-->





    <div class="row">
    <div class="col-sm-12">
        <section class="panel">
            <header class="panel-heading">
                客户移交
                    <span class="tools pull-right">
                <!--<a href="javascript:;" class="fa fa-chevron-down"></a>-->
                        <!--<a href="javascript:;" class="fa fa-times"></a>-->
             </span>
            </header>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="center">
                        <tr>
                            <td style="width:45%"><b>现有客户</b></td>
                            <td style="width:10%">&nbsp;</td>
                            <td style="width:45%"><b>移交客户</b></td>
                        </tr>
                        <tr>
                            <td>
                                <select name="" multiple="multiple" size="10" id="xykh" style="width: 70%; margin-left: -10%">
                                    <#list queryCustomer as cus>
                                        <option value="" id="${cus.id}">${cus.name}</option>
                                    </#list>
                                </select>
                            </td>
                            <td>
                                <input type="button" class="edit info" value=">>" onclick="addroles('xykh','yjkh')" style="width:70px;"><br>
                                <input type="button" class="edit info" value="<<" onclick="addroles('yjkh','xykh')" style="width:70px;">
                            </td>
                            <td>
                                <select multiple="multiple" size="10" style="width:70%;margin-left: 10%" id="yjkh" name="roles">

                                </select>
                            </td>
                        </tr>
                    </table>
                   <!-- <table style="margin-top:-20px;padding-top:20px;">
                        <tr>
                            <td style="float:none;width:10%;text-align:right;padding-right:10px;">移交原因：</td>
                            <td id="reason"><input type="text" id = "reso"/></td>
                        </tr>
                    </table>-->
                    <p class="button" style="text-align: center">
                    <input type="submit" value="移交" id="btn_submit" class="btn btn-success"/>
                    </p>

                </div>
            </div>
        </section>
    </div>
</div>
</#macro>
<#macro script>
    <script>
        //添加移交客户
        function addroles(id1,id2){
            var select=document.getElementById(id1)
            var roles=document.getElementById(id2)
            if(select.selectedIndex!=-1){//选取值不为空时执行
                $("<option id='"+ select.options[select.selectedIndex].id+"'>"+select.options[select.selectedIndex].text+"</option>").appendTo("#"+id2); //添加option项
                $("#"+id1+" option:selected").remove();
            }
            else
                alert("请先选择职能，然后再添加！！");
        }

        $(function () {
            var obj={} ,url = "/customerTransfer/customerTransfer";
            $("#btn_submit").click(function () {
                var id = $("#yjkh option");
                console.log(id.length);
                var arrAjax = "";
                $.each(id,function (i,item) {
                    if (!i) {
                        arrAjax += item.id;
                    } else {
                        arrAjax += "," + item.id;
                    }

                    console.log("arrAjax:"+arrAjax);

                });
                obj.customerIds = arrAjax;
                var reaso = $("#reso").val();
                obj.reason = reaso;
                console.log(obj);
                $.ajax({
                    type:"put",
                    url:"/customerTransfer",
                    data:obj,
                    success:function () {
                        location = "/customerTransfer"
                    }
                });
            });

        })




    </script>

</#macro>
<#macro js>

</#macro>
