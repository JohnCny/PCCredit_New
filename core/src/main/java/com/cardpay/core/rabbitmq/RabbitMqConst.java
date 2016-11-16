package com.cardpay.core.rabbitmq;
/**
 * rabbit消息相关常量定义
 *
 * @author johnmyiqn
 */
public interface RabbitMqConst {
	/**
     * 定义消息exchange
     *
     * @author johnmyiqn
     */
     String CARDPAY_MODEL_EX ="cardpay_model_exchange";
        /**
         * 评估模型广播消息推送
         */
     String CARDPAY_BROADCAST_EX = "cardpay_broadcast_exchange";

    /**
     * 定义消息routingKey
     *
     * @author johnmyiqn
     */
  
        /**
         * 评估模型消息提醒
         */
     String CARDPAY_MODEL_RK ="cardpay_model_routingKey";
        /**
         * 评估模型广播消息推送
         */
     String CARDPAY_BROADCAST_RK ="cardpay_broadcast_routingKey";

       
    /**
     * 定义消息Queque
     *
     * @author johnmyiqn
     */
        /**
         * 评估模型消息提醒
         */
     String CARDPAY_MODEL_QUEUE = "cardpay_model_queque";
    	/**
         * 评估模型广播消息推送
         */
     String CARDPAY_BROADCAST_QUEUE = "cardpay_broadcast_queue";
}