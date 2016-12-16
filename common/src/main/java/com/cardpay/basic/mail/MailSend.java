package com.cardpay.basic.mail;

import com.cardpay.basic.redis.RedisClient;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 邮件发送基础类
 * @author rankai
 */
@Component
public class MailSend {
    /**
     * mail发送类
     */
    @Autowired
    private JavaMailSender javaMailSender;
    /**
     * 建立邮件消息
     */
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    /**
     * 线程池对象
     */
    @Autowired
    private TaskExecutor taskExecutor;

    /**
     * 发送邮件
     *
     * @param email   email地址
     * @param content 发送类容
     */
    public void send(String email, String content) {
        this.taskExecutor.execute(new SendMailThread(null, email, null, content));
    }

    /**
     * 发送邮件
     *
     * @param path    附件路径
     * @param email   email地址
     * @param content 发送类容
     */
    public void send(List<String> path, String email, String content) {
        this.taskExecutor.execute(new SendMailThread(path, email, null, content));
    }

    /**
     * 发送邮件
     *
     * @param path    附件路径数组
     * @param emails  收件人数组
     * @param content 发送内容
     */
    public void send(List<String> path, String[] emails, String content) {
        if (emails != null) {
            for (int i = 0; i < emails.length; i++)
                this.taskExecutor.execute(new SendMailThread(path, emails[i], null, content));
        }
    }

    /**
     * 发送指定模板邮件
     *
     * @param map          邮件模板数据
     * @param path         附件路径
     * @param email        收件人地址
     * @param templateName 邮件模板名称
     */
    public void send(Map<String, String> map, List<String> path, String email, String templateName) {
        String receiveAddress = email;
        String text = "";
        try {
            // 从FreeMarker模板生成邮件内容 有问题暂新new一个
            FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        this.taskExecutor.execute(new SendMailThread(path, receiveAddress, null, text));
    }

    /**
     * 内部线程类，利用线程池异步发邮件
     */
    private class SendMailThread implements Runnable {
        private List<String> path;
        private String receiveAddress;
        private String subject;
        private String content;

        /**
         * 类构造方法
         *
         * @param path           附件列表
         * @param receiveAddress 收件人地址
         * @param subject        邮件主题
         * @param content        邮件内容
         */
        private SendMailThread(List<String> path, String receiveAddress, String subject, String content) {
            super();
            this.path = path;
            this.receiveAddress = receiveAddress;
            this.subject = subject;
            this.content = content;
        }

        @Override
        public void run() {
            sendMail(path, receiveAddress, subject, content);
        }
    }

    /**
     * 发送带有附件邮件
     *
     * @param path           附件地址列表
     * @param receiveAddress 收件人email地址
     * @param subject        邮件主题
     * @param content        邮件内容
     */

    public void sendMail(List<String> path, String receiveAddress, String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(simpleMailMessage.getFrom());// 发件箱
            messageHelper.setSentDate(new Date());// 发送时间
            if (subject != null) { // 邮件标题
                messageHelper.setSubject(subject);
            } else {
                messageHelper.setSubject(simpleMailMessage.getSubject());
            }
            if (path != null && path.size() > 0) {
                for (String str : path) {
                    // 添加附件(2种方式)
                    FileSystemResource rarfile = new FileSystemResource(new File(str));
                    // (方式1)<img src='cid:file'/> 此处将文件内容嵌入邮件页面中
                    // 这里的'cid:file'与addInline('file',rarfile)中的file对应
                    // messageHelper.addInline("file", rarfile);
                    String[] array = str.split("/");
                    if (array.length <= 0)
                        array = str.split("//");
                    if (array.length > 0) {
                        // 解决附件名中文乱码问题
                        messageHelper.addAttachment(MimeUtility.encodeWord(array[array.length]), rarfile);
                    }
                }
            }
            messageHelper.setTo(receiveAddress); // 收件箱
            messageHelper.setText(content, true);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
