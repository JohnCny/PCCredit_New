package com.cardpay.core.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.common.log.LogTemplate;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 消费者类,接收rabbirtMq消息
 * @author johnmyiqn
 */
@Service
public class ConsumerService{

	/**
	 * 消息监听类
	 * @param message 消息
	 * @param channel 会话
	 */
//	@RabbitListener(bindings = @QueueBinding(
//			value = @Queue(value = RabbitMqConst.CARDPAY_MODEL_QUEUE, durable = "true"),
//			exchange = @Exchange(value = RabbitMqConst.CARDPAY_MODEL_EX, type = ExchangeTypes.FANOUT , ignoreDeclarationExceptions = "true"),
//            key = RabbitMqConst.CARDPAY_MODEL_RK))
//	public void onMessage(Message message,Channel channel){
//		String messageJson = null;
//		try {
//			//确认消息
//			channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
//			// 获取消息
//			if(message.getBody() != null){
//
//				messageJson = new String(message.getBody(), "UTF-8");
//				//创建消息实体
//				RabbitMqMessage msg = JSON.parseObject(messageJson, RabbitMqMessage.class);
//
//				// 处理消息，插入数据库
//
//				// 给指定在线用户发送消息
//			}
//		} catch (Exception e) {
//			LogTemplate.error(ConsumerService.class,e,"消息发送失败",messageJson);
//		}
//	}
}