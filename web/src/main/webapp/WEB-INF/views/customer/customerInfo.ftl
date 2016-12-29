<#include "layout/base.html"/>
<#assign title = "客户"/>
<#macro style>
    <style>
        .myTab {margin:0;}
        .myTab li{display:inline-block;list-style:none;background:#fff;border:1px solid #eff0f4;color:#bbb;padding:7px 15px;border-radius:5px 5px 0 0;margin-right:1px;cursor:pointer;}
        .myTab .active{color:#fff;background: #65cea7!important;border:1px solid #65cea7;}
        .tabContent{border:1px solid #65cea7;width:98%;margin-bottom:20px;}
        .tabPage{background:#fff;margin:0;padding-bottom:20px;}
        .tabPage .report{width:100%;padding-bottom:30px;}
        .tabContent .report{float:none;margin:0;padding:10px;}
        .tabContent .report table{margin:10px;width:98%;}
        .tabContent3{width:auto;overflow:hidden}
        .content h1{color: #49586e;font-size: 25px;font-weight: normal;margin:5px 0;}
        .content h2{color: #999999;font-size: 14px;font-weight: normal;margin-top:0;}
        .content h2 span{color: #65CEA7;}
        .report{float:left;background:#fff;border-radius:5px;width:98%;margin-bottom:20px;}
        .report h5{border-bottom: 1px dotted #c0c0c0;border-bottom: 1px dotted rgba(0, 0, 0, 0.2);padding: 15px;text-transform: uppercase;color: #535351;font-size: 16px;font-weight: bold;}
        .report table{width:95%;margin-top:20px;border-collapse: collapse;margin-bottom:20px;}
        .report table tr:nth-child(2n){background:#f7f7f7;}
        .report table tr th{border-bottom: 2px solid #ddd;color: #7a7676;font-size:14px;line-height:35px;}
        .report table tr td{border-bottom: 1px solid #ddd;color: #7a7676;text-align:center;font-size:14px;line-height:35px;}

        /*新增报销*/
        .common table{background: #f7f7f7;padding:0 20px;}
        .common table tr th{border-bottom:0;text-align:left;line-height:45px;}
        .common table tr td{border-bottom:0;text-align:left;line-height:45px;}
        .common .treeBox{margin-left:1em;}
        .button{text-align:center;width:98%;}
        .button input{width:90px;line-height:30px;font-family: 微软雅黑;margin:0 5px;border-radius: 5px;color: #fff;background-color: #5cb85c;border:1px solid #4cae4c;}
        .button input:hover{background-color: #47a447;}
        .button .del{background-color: #d9534f;border-color: #d43f3a;}
        .button .del:hover{background-color: #d2322d;}
        .button .back{background-color: #fff;border-color: #cccccc;color:#333359;}
        .button .back:hover{background-color: #ebebeb;}
    </style>
</#macro>
<#macro css>
</#macro>
<#macro breadcrumb>
    <h3>
        客户
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：客户管理</a>
        </li>
        <li class="active"> 客户信息查看</li>
    </ul>
</#macro>
<#macro content>

    <form class="content">
        <ul class="myTab">
            <li class="active" onclick="setTab2(this,'jbxx')">客户基本信息</li>
            <li onclick="setTab2(this,'dkqk')">客户贷款情况</li>
            <li onclick="setTab2(this,'khwhjl')">客户维护记录</li>
            <li onclick="setTab2(this,'dhjkjl')">贷后监控记录</li>
            <li onclick="setTab2(this,'csjl')">逾期/不良催收记录</li>
            <li onclick="setTab2(this,'yjjl')">客户移交记录</li>
        </ul>
        <!--*******************************************客户基本信息*******************************************************-->
        <div class="tabContent" id="jbxx">
            <div class="report common">
                <h5>基本信息</h5>
                <table class="bxd">
                    <tr>
                        <td>客户名称：<span>${tCustomerBasic.cname}</span></td>
                        <td>性别：<span>男</span></td>
                    </tr>
                    <tr>
                        <td>证件类型：<span>身份证</span></td>
                        <td>证件号码：<span>${tCustomerBasic.certificateNumber}</span></td>
                    </tr>
                    <tr>
                        <td>联系方式：<span>${tCustomerBasic.tel}</span></td>
                        <td>家庭住址：<span>${tCustomerBasic.homeAddress}</span></td>
                    </tr>
                    <tr>
                        <td>婚姻状况：<span>${tCustomerBasic.marriageStatus}</span></td>
                        <td>文化程度：<span>${tCustomerBasic.educationDegree}</span></td>
                    </tr>
                </table>
            </div>
        </div>
        <!--*******************************************客户贷款情况*******************************************************-->
        <div class="tabContent" id="dkqk" style="display:none;">
            <div class="report common">
                <h5>贷款情况</h5>
                <table class="bxd">
                    <tr>
                        <td>产品：<span>产品1</span></td>
                        <td>申请日期：<span>XXXXXXXXXXXXXX</span></td>
                    </tr>
                    <tr>
                        <td>是否申请成功：
                            <span class="label label-success" style="color:#fff;">是</span>
                            <span class="label label-important" style="color:#fff;">否</span>
                        </td>
                        <td>额度：<span>XXXXXXXXXXXXXX</span></td>
                    </tr>
                    <tr>
                        <td>利率：<span>XXXXXXXXXXXXXX</span></td>
                        <td>放款日期：<span>XXXXXXXXXXXXXX</span></td>
                    </tr>
                    <tr>
                        <td colspan="2">当前余额：<span>￥20000</span></td>
                    </tr>
                </table>
            </div>
        </div>
        <!--*******************************************客户维护记录*******************************************************-->
        <div class="tabContent" id="khwhjl" style="display:none;">
            <div class="report common">
                <h5>维护记录</h5>
                <table class="center whTable">
                    <tr>
                        <th>选择</th>
                        <th>维护类型</th>
                        <th>维护时间</th>
                        <th>维护人</th>
                    </tr>

                </table>
            </div>
        </div>
        <!--*******************************************贷后监控记录*******************************************************-->
        <div class="tabContent" id="dhjkjl" style="display:none;">
            <div class="report common">
                <h5>贷后监控记录</h5>
                <table class="center">
                    <tr>
                        <th>客户经理</th>
                        <th>贷后监控方式</th>
                        <th>贷后监控结果</th>
                    </tr>
                    <tr>
                        <td>admin</td>
                        <td>上门</td>
                        <td>XXXX</td>
                    </tr>
                </table>
            </div>
        </div>
        <!--*******************************************逾期/不良催收记录*******************************************************-->
        <div class="tabContent" id="csjl" style="display:none;">
            <div class="report common">
                <h5>逾期/不良催收记录</h5>
                <table class="center">
                    <tr>
                        <th>催收原因</th>
                        <th>金额</th>
                        <th>催收日期</th>
                        <th>催收客户经理</th>
                    </tr>
                    <tr>
                        <td>逾期</td>
                        <td>1000</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                    </tr>
                    <tr>
                        <td>不良</td>
                        <td>1000</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                    </tr>
                </table>
            </div>
        </div>
        <!--*******************************************客户移交记录*******************************************************-->
        <div class="tabContent" id="yjjl" style="display:none;">
            <div class="report common">
                <h5>客户移交记录</h5>
                <table class="center transferd">
                    <tr>
                        <th>移交日期</th>
                        <th>原客户经理</th>
                        <th>移交后客户经理</th>
                        <th>移交原因</th>
                        <th>移交结果</th>
                    </tr>

                </table>
            </div>
        </div>
        <p class="button">
            <input type="button" value="返回" class=""  onclick="iframe('kh_list.html')"/>
        </p>
    </form>

</#macro>

<#macro script>
    <!--<script src="../../../static/js/main.js"></script>-->
</#macro>

<#macro js>
    <script>
        function setTab2(obj,id){//切换tab页
            $(obj).parent().find("li").attr("class","")
            $(obj).attr("class","active")
            $(".tabContent").hide();
            $("#"+id).show();
        }
        function selectTR(obj){//单选行
            $(obj).parent().find("tr td").css("background","#fff");
            $(obj).find("td").css("background","#dff0d8");//改变行背景
            $(obj).parent().find("").removeAttr("checked")
            $(obj).parent().find("label").attr("class","radio")
            $(obj).find("input[type=radio]").attr("checked","checked")
            $(obj).find("label").attr("class","radio radio_a")//radio
        }
        $(function () {
            var href = location.href;
            console.log(href);
            var hrefs = href.split("/");
            console.log(hrefs);
            var lens = hrefs.length;
            console.log(lens);
            var Id = hrefs[lens - 1];
            console.log(Id);
            var Url = "/customerMaintenance/maintenance/" + Id;
            var Urls = "/customerTransfer/transfer/" + Id;
            console.log(Url)
            $.ajax({
                type:"get",
                url:Url,
                success:function (res) {

                    console.log(res.data.length)
                    var datas = res.data;
                    console.log(datas);
                    var html = '' , htmls = '';
                    for(var i = 0; i <= datas.length-1;i++){
                        console.log(i);
                        html += '<tr onclick="selectTR(this);$(\'#whxx' + i +'\').show();$(\'#whxx' + i +'\').siblings(\'div.showz\').hide()" class="prevet">';
                        html += '<td><span class="hideInput"><input type="radio" name="radio0"><label class="radio"></label></span></td>';
                        html += '<td>'+datas[i].maintenanceType+'</td>';
                        html += '<td>'+datas[i].operationTime +'</td>';
                        html += '<td>'+datas[i].operationName+'</td>';
                        html += '</tr>';
                        console.log(html)
                        $(".whTable").append(html);
                        html="";


                        htmls += ' <div class="report common showz" style="display:none;" id="whxx'+ i +'">';
                        htmls += ' <h5>维护信息</h5>';
                        htmls += ' <table class="bxd">';
                        htmls += '<tr><td>维护类型：<span>'+datas[i].maintenanceType+'</span></td><td>维护时间：<span>'+datas[i].operationTime +'</span></td></tr>';
                        htmls += '<tr><td>维护人：<span>'+datas[i].operationName+'</span></td><td>维护纪要：<span>'+datas[i].maintennaceSummary+'</span></td></tr>';
                        htmls += '</table>';
                        htmls += '</div>';
                        $("#khwhjl").append(htmls);
                        htmls = '';
                    }
                }
            });
            $.ajax({
                type:'get',
                url: Urls,
                success:function (res) {
                    var datas = res.data;
                    console.log(datas.length);
                    var html = "";
                    for(var i = 0; i <= datas.length-1;i++){
                        html += '<tr><td>'+ datas[i].transferTime+'</td><td>'+datas[i].originCustomerManager+'</td><td>'+datas[i].nowCustomerManager+'</td><td>'+datas[i].transferReason+'</td>';
                        if(datas[i].transferStatus == 0){
                            html += '<td><span class="label label-important">未接收</span></td> </tr>'
                        }else if(datas[i].transferStatus == 1){
                            html += '<td><span class="label label-success">成功</span></td></tr>';
                        }else {
                            html += '<td><span class="label label-important">失败</span></td></tr>';
                        }
                        $(".transferd").append(html);
                        html ='';
                    }
                }
            })
        });
    </script>


</#macro>
