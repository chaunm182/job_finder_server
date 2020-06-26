package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.mail.SubscribeMail;
import com.example.jobfinder.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=\"utf-8\"";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;
    @Override
    public void sendMail(SubscribeMail mail) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"UTF-8");
        //set content
        Context context = new Context();
        context.setVariable("firstName",mail.getUser().getFullName().getFirstName());
        context.setVariable("lastName",mail.getUser().getFullName().getLastName());
        context.setVariable("post",mail.getPost());
        String content = templateEngine.process("web/mail-subscribe",context);
        try {
            mimeMessageHelper.setTo(new InternetAddress(mail.getSendTo()));
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessage.setContent(content,CONTENT_TYPE_TEXT_HTML);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
