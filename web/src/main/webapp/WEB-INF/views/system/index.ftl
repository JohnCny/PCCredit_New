<#include "layout/base.html"/>
<#assign title = "系统管理"/>
<#macro style>

</#macro>
<#macro css>

</#macro>
<#macro breadcrumb>
    <h1>${title}</h1>
    <h2>当前位置：系统管理 / <span class="active">${title}</span></h2>
</#macro>
<#macro content>
    <div class="content">
        <h1>数据字典管理</h1>
        <h2>当前位置：系统管理 / <span>数据字典管理</span></h2>
        <div class="report common tableB">
            <h5>数据字典列表</h5>
            <div class="search">
                <span>字典类别：<input type="text" class="short" name=""></span>
                <span>字典代码：<input type="text" class="short" name=""></span>
                <span>字典名称：<input type="text" class="short" name=""></span>
                <input type="button" value="搜 索">
            </div>
            <table class="center">
                <colgroup>
                    <col width="20%"></col>
                    <col width="20%"></col>
                    <col width="20%"></col>
                    <col width="20%"></col>
                    <col width="20%"></col>
                </colgroup>
                <tr>
                    <th>字典类别</th>
                    <th>字典代码</th>
                    <th>字典名称</th>
                    <th>银行代码</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>APPRETURESION</td>
                    <td>APPRETURESION01</td>
                    <td>身份信息不正确</td>
                    <td></td>
                    <td><button class="edit" onclick="iframe('edit_sjzd.html')"><i class="icon-pencil icon-white"></i>编辑</button></td>
                </tr>
                <tr>
                    <td>APPRETURESION</td>
                    <td>APPRETURESION02</td>
                    <td>居住地址缺失</td>
                    <td></td>
                    <td><button class="edit" onclick="iframe('edit_sjzd.html')"><i class="icon-pencil icon-white"></i>编辑</button></td>
                </tr>
            </table>

            <div class="page-div">
                <span style="CURSOR: pointer"><img src="../../../static/img/prev.png"/></span>
                &#160;第&#160;<font color="#0088cc">1</font>&#160;页&#160; /
                &#160;共&#160;<font color="#0088cc">1</font>&#160;页&#160;
                <span style="CURSOR: pointer"><img src="../../../static/img/next.png"/></span>
            </div>

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