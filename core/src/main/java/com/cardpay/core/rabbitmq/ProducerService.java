package com.cardpay.core.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 生产者类,发送rabbirtMq消息
 * @author johnmyiqn
 */
@Service
public class ProducerService {

	/**
	 * rabbitMq消息模板类
	 */
	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 发送模型评估消息提醒
	 * @param msg 消息
	 * @param routingKey (可以为空，设置为默认的routingKey)
	 */
	public void sendModelMessage(RabbitMqMessage msg, String routingKey){
		if(msg != null){
			String rk = routingKey == null ? RabbitMqConst.CARDPAY_MODEL_RK : routingKey;
			sendMessage(RabbitMqConst.CARDPAY_MODEL_EX, rk, msg);
		}
	}

	/**
	 * 发送{@link RabbitMqMessage}消息
	 * @param msg RabbitMqMessage 消息
	 * @param exchange 交换器名称
	 * @param routingKey 路由皱键
     */
	private void sendMessage(String exchange, String routingKey, RabbitMqMessage msg ) {
		try {
			//发送消息
			amqpTemplate.convertAndSend(exchange, routingKey, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}