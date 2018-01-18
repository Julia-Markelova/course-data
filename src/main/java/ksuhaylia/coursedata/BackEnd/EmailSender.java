package ksuhaylia.coursedata.BackEnd;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

/**
 * Created by ymark on 11.12.2017.
 */
public class EmailSender {

    public void sendEmail(String eMail, int code, String message, String subject)
    {

        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
            context.load("classpath:mailContext.xml");
            context.refresh();
            JavaMailSender mailSender = context.getBean("mailSender", JavaMailSender.class);
            SimpleMailMessage templateMessage = context.getBean("templateMessage", SimpleMailMessage.class);

            // Создаём потокобезопасную копию шаблона.
            SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);

            //TODO: Сюда напишите свой e-mail получателя.
            mailMessage.setTo(eMail);

            mailMessage.setText(message+" "+ code);
            mailMessage.setSubject(subject);
            try {
                mailSender.send(mailMessage);
                System.out.println("Mail sended");
            } catch (MailException mailException) {
                System.out.println("Mail send failed.");
                mailException.printStackTrace();
            }
        }
    }



}
