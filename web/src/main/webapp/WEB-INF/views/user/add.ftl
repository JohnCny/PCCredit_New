<#include "layout/base.html"/>
<#assign title = "用户管理"/>
<#macro css>
    <link rel="stylesheet" href="/static/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/dataTables.tableTools.css"/>
    <link href="/static/css/zTree/metroStyle/metroStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/radio.css">
</#macro>
<#macro style>
<style>
    input, select,{
        border: 1px solid rgba(0, 0, 0, 0.2);
        height: 30px;
        border-radius: 5px
    }

    table, table tr, table tr td {
        background-color: #fff
    }
    .widclas {
        width: 20%;
        float: left;
        height: 80px;
        margin-left: 10%;
        margin-top: 30px;
    }
    @media screen and (max-width: 1300px) {
        .widclas {
            width: 30%;
            float: left;
            height: 80px;
            margin-left: 10%;
            margin-top: 30px;
        }
    }
    @media screen and (max-width: 980px) {
        .widclas {
            width: 80%;
            float: left;
            height: 80px;
            margin-left: 10%;
            margin-top: 30px;
        }
        .hideInput{display: block}
    }
    .ledd{
        margin-left: 10%;
        clear: both;
    }
    .contain{
        margin-left: 9.3%;
        margin-top: 30px;
    }
</style>
</#macro>

<#macro breadcrumb>
    <h3>
        新建用户
    </h3>
    <ul class="breadcrumb">
        <li>
            <a href="#">当前位置：新建用户</a>
        </li>
        <li class="active"> 新建用户</li>
    </ul>
</#macro>
<#macro content>
    <div class="row">
        <div class="col-sm-12">
            <div class="col-md-2 col-xs-12">
                <div class="report common list">
                    <section class="panel">
                        <header class="panel-heading">
                            机构列表
                        </header>
                        <div class="report common list">
                            <div class="treeBox" style="height: 581px;">
                                <ul id="treeDemo" class="ztree"></ul>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="col-md-10 col-xs-12">
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
                                            <label for="">姓名</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="userCname"placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">登录名</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="username"placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">员工工号</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="employeeNumber" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">电话</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="phone" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">年龄</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="age" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">性别</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <select name="sex" class="form-control">
                                                    <option>-&#45;&#45;请选择-&#45;&#45;</option>
                                                    <option value="1">男</option>
                                                    <option value="2">女</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">邮箱</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text" name="email" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">机构</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input class="form-control"  readonly="readonly" id="orgId" disabled="disabled" placeholder="请输入至少2-10位汉字">
                                                <input type="hidden" id="orgIdHidden" name="orgId">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">身份证</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <input  class="form-control" type="text"  name="idCardNumber" placeholder="请输入至少2-10位汉字">
                                            </div>
                                        </div>
                                        <div class="widclas">
                                            <label for="">用户类型</label>
                                            <div class="input-icon right">
                                                <i class="fa"></i>
                                                <select name="userType" class="form-control">
                                                    <option>-&#45;&#45;请选择-&#45;&#45;</option>
                                                    <option value="1">系统用户</option>
                                                    <option value="2">客户经理</option>
                                                    <option value="3">部门主管</option>
                                                    <option value="4">机构主管</option>
                                                </select>
                                            </div>
                                        </div>




                                        <div class="ledd">
                                            <label for="" style="">用户角色</label>
                                            <#list roleAll as temp>
                                                    <span class="hideInput">
                                                        <input id="roleId" type="radio" name="roleId"value="${temp.id}">
                                                        <label onclick="setRadio(this)"class="radio"  style="padding-left: 30px">${temp.roleNameZh}</label>
                                                    </span>
                                            </#list>
                                        </div>



                                        <div class="ledd">
                                            <label for="" style="display: inline-block">用户状态</label>
                                            <div class="input-icon right" style="display: inline-block">
                                                <i class="fa"></i>
                                                  <span class="hideInput">
                                                      <input type="radio" name="status" value="0">
                                                      <label onclick="setRadio(this)" class="radio" style="padding-left: 30px">正常</label>
                                                  </span>
                                                  <span class="hideInput">
                                                       <input type="radio" name="status" value="1">
                                                       <label onclick="setRadio(this)" class="radio" style="padding-left: 30px">锁定</label>
                                                  </span>
                                            </div>
                                        </div>
                                        <div class=" contain">
                                            <button id="btn_submit" class="btn btn-success submit">保存
                                            </button>
                                            <a href="/user" type="reset" class="btn btn-default back" style=" border: 1px solid rgba(0, 0, 0, 0.2);">返回</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</#macro>

<#macro js>
    <script type="text/javascript" src="/static/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="/static/js/ztree-org.js"></script>
    <script src="/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="/static/js/dataTables.tableTools.js" type="text/javascript"></script>
    <script src="/static/js/department.js" type="text/javascript"></script>
    <script src="/static/js/moment.min.js" type="text/javascript"></script>
</#macro>

<#macro script>
<script type="text/javascript">
    var urlMy = "/organization/orgAll";
    var setting = {
        data: {
            simpleData: {
                enable: true,
                pIdKey: "orgParentId"
            },
            key: {
                name: "orgName",
            }
        },
        callback: {
            onClick: onClick
        }
    };
    baseTree(urlMy, setting);
    function onClick(event, treeId, treeNode, clickFlag) {
        $("#orgId").attr("value", treeNode.orgName);
        $("#orgIdHidden").attr("value", treeNode.id);
    }
</script>
<script>
    function setRadio(obj) {//单选样式
        $(obj).parent().parent().find("input[type=radio]").attr("checked", false)
        $(obj).parent().parent().find("label").attr("class", "radio")
        $(obj).parent().find("input[type=radio]").attr("checked", true)
        $(obj).parent().find("label").attr("class", "radio radio_a")
    }
    $(function () {

        var url = "/user";
        $(".submit").click(function (e) {
            e.preventDefault();
            var obj = $("#userAdd").serializeArray();
            obj.push({"name": "roleId", "value": $("#roleId").val()});
            console.log(obj);
            $.ajax({
                type: "post",
                url: url,
                data: obj,
                success: function (res) {
                    if (res.code == 200) {
                        alert("添加成功");
                        location.href = "/user";
                    }
                }
            })
        })
    })
</script>
</#macro>
