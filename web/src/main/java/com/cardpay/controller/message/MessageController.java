package com.cardpay.controller.message;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.message.model.TMessage;
import com.cardpay.mgt.message.service.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

/**
 * 消息controller
 *
 * @author chenkai
 */
@Api(value = "/api/message", description = "消息")
@RestController
@RequestMapping("/api/message")
public class MessageController extends BaseController<TMessage> {
    @Autowired
    private MessageService messageService;

    /**
     * 发送消息
     *
     * @param title     消息标题
     * @param content   消息内容
     * @param userId    消息所属用户id
     * @param type      消息类型(0 业务消息，1 非业务消息)
     * @param level     消息级别(0 正常消息，2 警告消息，3 错误消息)
     * @param broadcast 是否是广播消息(0 不是，1 是)
     * @return 消息id
     */
    @PostMapping
    @Transactional
    @SystemControllerLog("发送消息")
    public ResultTo sendMsg(String title, String content, int userId, int type, int level, int broadcast) {
        int messageId = messageService.messagePush(title, content, userId, type, level, broadcast);
        return new ResultTo().setData(messageId);
    }

    /**
     * 查询已读/为读消息数量
     *
     * @param flag 1已读, 0未读
     * @return 0未读, 1已读
     */
    @GetMapping("/{flag}")
    public ResultTo getReadMessage(@PathVariable("flag") int flag) {
        Integer mark = flag != 0 ? Constant.MSG_READ : Constant.MSG_UNREAD;
        Integer messageCount = messageService.getReadMessage(ShiroKit.getUserId(), mark);
        return new ResultTo().setData(messageCount);
    }

    /**
     * 将消息变更为已读
     *
     * @param messageId 消息Id
     * @return 数据库变记录
     */
    @PutMapping("/{id}")
    @Transactional
    public ResultTo setMessageIfRead(@PathVariable("id") int messageId) {
        int count = messageService.setMessageIfRead(messageId);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 获取用户信息列表
     *
     * @return 用户信息列表
     */
    @GetMapping
    public DataTablePage queryById() {
        Example example = new Example(TMessage.class);
        example.createCriteria().andEqualTo("userId", ShiroKit.getUserId());
        return dataTablePage(example);
    }

}
