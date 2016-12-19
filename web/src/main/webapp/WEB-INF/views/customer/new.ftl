<#include "layout/base.html"/>

<#macro style>
    <style>
        [v-cloak] {
            display: none
        }
    </style>
</#macro>
<#macro css>

</#macro>
<#macro content>
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-plus-circle"></i>
                        新建
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>
                        <!--<a href="" class="fullscreen" data-original-title="" title=""> </a>-->
                        <!--<a href="javascript:;" class="remove" data-original-title="" title=""> </a>-->
                    </div>
                </div>

                <div class="portlet-body">
                    <form id="form_sample_2" action="/customers/originalInformation" method="POST">
                        <input type="hidden" name="token" value="${token}">
                        <div class="row">
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="cname">姓名</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input data-error="${cnameError}" id="cname" type="text" class="form-control" name="cname" value="${customerBasicInfo.cname}" placeholder="请输入至少2-10位汉字">
                                    <div class="message">${cnameError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="nationality">国籍</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input id="nationality" type="text" class="form-control" name="nationality" value="中国" readonly>
                                    <div class="message">${nationalityError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="sex">性别</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="sex" type="text" class="form-control" name="sex" >
                                        <option value="">--请选择--</option>
                                        <option value="1">男</option>
                                        <option value="0">女</option>
                                    </select>
                                    <div class="message">${sexError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="certificateType">证件类型</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="certificateType" type="text" class="form-control" name="certificateType">
                                        <option value="">--请选择--</option>
                                        <option value="1" selected>身份证</option>
                                    </select>
                                    <div class="message">${certificateTypeError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="idNumber">证件号码</label>
                                <div class="input-icon right">
                                    <i class="fa checkId"></i>
                                    <input data-error="${idNumberError}" id="idNumber" type="text" class="form-control idNumber" name="idNumber" value="${customerBasicInfo.idNumber}" placeholder="请输入有效证件号码">
                                    <div class="message" id="idMessage"></div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="homeAddress">家庭住址</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input data-error="${homeAddressError}"  id="homeAddress" type="text" class="form-control" name="homeAddress" value="${customerBasicInfo.homeAddress}" placeholder="请输入有效地址">
                                    <div class="message">${homeAddressError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="zipCode">邮编</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input data-error="${zipCodeError}" id="zipCode" type="text" class="form-control" name="zipCode" value="${customerBasicInfo.zipCode}" placeholder="请输入正确的邮编">
                                    <div class="message">${zipCodeError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="email">电子邮箱</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input data-error="${emailError}" id="email" type="text" class="form-control" name="email" value="${customerBasicInfo.email}" placeholder="请输入有效的电子邮件地址">
                                    <div class="message">${emailError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="tel">手机号码</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input data-error="${telError}" id="tel" type="text" class="form-control" name="tel" value="${customerBasicInfo.tel}" placeholder="请输入正确的手机号码">
                                    <div class="message">${telError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="typeOfResidence">住宅性质</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="typeOfResidence" type="text" class="form-control" name="typeOfResidence">
                                        <option value="">--请选择--</option>
                                        <option value="0">租住</option>
                                        <option value="1">全房产</option>
                                        <option value="2">按揭</option>
                                    </select>
                                    <div class="message">${typeOfResidenceError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="marriage">婚姻状况</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="marriage" type="text" class="form-control" name="marriage" >
                                        <option value="">--请选择--</option>
                                        <option value="1">未婚</option>
                                        <option value="2">已婚</option>
                                        <option value="3">离婚</option>
                                        <option value="4">丧偶</option>
                                    </select>
                                    <div class="message">${marriageError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="eduction">教育情况</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="eduction" type="text" class="form-control" name="eduction" >
                                        <option value="">--请选择--</option>
                                        <option value="1">本科以上</option>
                                        <option value="2">本科</option>
                                        <option value="3">大专</option>
                                        <option value="4">高中/中专</option>
                                        <option value="5">初中及以下</option>
                                    </select>
                                    <div class="message">${eductionError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="residenceAddress">户籍地址</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <input id="residenceAddress" type="text" class="form-control" name="residenceAddress" placeholder="请输入您的户籍地址">
                                    <div class="message">${residenceAddressError}</div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                <label for="ifLegalPerson">是否为法人</label>
                                <div class="input-icon right">
                                    <i class="fa"></i>
                                    <select id="ifLegalPerson" type="text" class="form-control" name="ifLegalPerson" >
                                        <option value="">--请选择--</option>
                                        <option value="1">法人</option>
                                        <option value="0">自然人</option>
                                    </select>
                                    <div class="message">${ifLegalPersonError}</div>
                                </div>
                            </div>
                            <div class="col-xs-12">
                                <button id="btn_submit" class="btn btn-success">确定</button>
                                <a href="/customers/originalInformation/list" type="reset" class="btn btn-default">取消</a>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</#macro>
<#macro script>


</#macro>
<#macro js>

</#macro>