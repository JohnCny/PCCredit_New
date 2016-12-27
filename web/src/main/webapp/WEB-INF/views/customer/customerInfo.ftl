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

    <form class="content">
        <h1>查看客户信息</h1>
        <h2>当前位置：客户管理 / 客户信息查询 / 客户1 / <span>查看客户信息</span></h2>
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
                <table class="center">
                    <tr>
                        <th>选择</th>
                        <th>维护类型</th>
                        <th>维护时间</th>
                        <th>维护人</th>
                    </tr>
                    <tr onclick="selectTR(this);$('#whxx').show()">
                        <td><span class="hideInput"><input type="radio" name="radio0"><label class="radio"></label></span></td>
                        <td>编辑基本信息</td>
                        <td>2016-05-12</td>
                        <td>admin</td>
                    </tr>
                </table>
            </div>
            <div class="report common" style="display:none;" id="whxx">
                <h5>维护信息</h5>
                <table class="bxd">
                    <tr>
                        <td>维护类型：<span>编辑基本信息</span></td>
                        <td>维护时间：<span>2016-05-12</span></td>
                    </tr>
                    <tr>
                        <td>维护人：<span>admin</span></td>
                        <td>维护纪要：<span>XXXXXXXXXXXXXX</span></td>
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
                <table class="center">
                    <tr>
                        <th>移交日期</th>
                        <th>原客户经理</th>
                        <th>移交后客户经理</th>
                        <th>移交原因</th>
                        <th>移交结果</th>
                    </tr>
                    <tr>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td><span class="label label-success">成功</span></td>
                    </tr>
                    <tr>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td>XXXX</td>
                        <td><span class="label label-important">失败</span></td>
                    </tr>
                </table>
            </div>
        </div>
        <p class="button">
            <input type="button" value="返回"  onclick="iframe('kh_list.html')"/>
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
        $(function () {
            var href = location.href;
            console.log(href);
            var hrefs = href.split("/");
            console.log(hrefs);
            var lens = hrefs.length;
            console.log(lens);
            var Id = hrefs[lens - 1];
            console.log(Id);
            $.ajax({
                type
            })
        });
    </script>


</#macro>
