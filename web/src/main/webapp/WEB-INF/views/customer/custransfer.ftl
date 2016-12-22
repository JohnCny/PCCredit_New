<#include "layout/base.html"/>

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

</#macro>
<#macro content>
    <div class="content">
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
                            </#list>>
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
                    url:"/customerTransfer/customerTransfer",
                    data:obj,
                    success:function () {

                    }
                });
            });

        })




    </script>

</#macro>
<#macro js>

</#macro>
