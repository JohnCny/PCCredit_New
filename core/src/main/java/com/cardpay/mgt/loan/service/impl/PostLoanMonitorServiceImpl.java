package com.cardpay.mgt.loan.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.loan.dao.PostLoanMonitorMapper;
import com.cardpay.mgt.loan.model.PostLoanMonitor;
import com.cardpay.mgt.loan.model.vo.AddLoanVo;
import com.cardpay.mgt.loan.service.PostLoanMonitorService;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后监控服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 14:51
 */
@Service
public class PostLoanMonitorServiceImpl extends BaseServiceImpl<PostLoanMonitor> implements PostLoanMonitorService {

    @Autowired
    private PostLoanMonitorMapper postLoanMonitorMapper;

    @Autowired
    private TApplicationMapper applicationMapper;

    @Autowired
    private TCustomerBasicMapper customerBasicMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<AddLoanVo> loanMonitorAddPageList(Map<String, Object> map) {
        return postLoanMonitorMapper.loanMonitorAddPageList(map);
    }

    @Override
    public ResultTo addLoan(Integer applicationId) {
        TApplication application = applicationMapper.selectByPrimaryKey(applicationId);
        if (application == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(application.getCustomerId());
        Product product = productMapper.selectByPrimaryKey(application.getProductId());
        if (product == null || customerBasic == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        PostLoanMonitor postLoanMonitor = new PostLoanMonitor();
        postLoanMonitor.setApplicationId(applicationId);

        int count = postLoanMonitorMapper.insertSelective(postLoanMonitor);
        if (count > 0) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    @Override
    public List<AddLoanVo> loanMonitorPageList(Map<String, Object> map) {
        return postLoanMonitorMapper.loanMonitorPageList(map);
    }
}
