package com.tronsis.controller;

import com.tronsis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Derrick on 2018/1/3.
 */
@RestController
public class DemoController {

    private String from = "username.com";
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("simpleMail")
    public String simpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("Derrick<"+from+">");
        message.setTo("66458172@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        message.setSentDate(new Date());
        message.setReplyTo("邮件已收到！");
        mailSender.send(message);
        return "success";
    }

    @GetMapping("mimeMail")
    public String mimeMail(){
        try {
            InternetAddress address = new InternetAddress(MimeUtility.encodeText("Derrick") +
                    " <" + from + ">");
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(address);
            helper.setTo("66458172@qq.com");
            helper.setSubject("主题：有附件");
            helper.setText("有附件的邮件");

            FileSystemResource file = new FileSystemResource(new File("F:/Sodexo_api.md"));
            helper.addAttachment("附件-1.md", file);
            helper.addAttachment("附件-2.md", file);


            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Autowired
    private HelloService helloService;

    @RequestMapping("/autoConfig")
    public String index(){
        return helloService.sayHello();
    }
}
