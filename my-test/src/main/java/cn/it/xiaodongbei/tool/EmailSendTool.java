package cn.it.xiaodongbei.tool;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * @Author cxc
 * @Date 2023/8/23 3:03 PM
 * @Version 1.0
 * @Description:
 */

public class EmailSendTool {
    // 邮箱服务器
    private String host;
    // 这个是你的邮箱用户名
    private String username;
    // 你的邮箱密码
    private String password;

    private Integer port;

    private String mail_head_name = "this is head of this mail";

    private String mail_head_value = "this is head of this mail";

    private String mail_to;

    private String mail_from;

    private String mail_subject = "this is the subject of this test mail";

    private String mail_body = "this is the mail_body of this test mail";

    private String personalName = "";

    public EmailSendTool() {
    }

    public EmailSendTool(String host, Integer port, String username, String password,
                         String mailto, String subject, String text, String name,
                         String head_name, String head_value) {
        this.host = host;
        this.port = 465;
        if (port != null) {
            this.port = port;
        }
        this.username = username;
        this.mail_from = username;
        this.password = password;
        this.mail_to = mailto;
        this.mail_subject = subject;
        this.mail_body = text;
        this.personalName = name;
        this.mail_head_name = head_name;
        this.mail_head_value = head_value;
    }

    /**
     * 此段代码用来发送普通电子邮件，过时方法
     *
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     * @throws UnsupportedEncodingException
     */
    @Deprecated
    public void send() throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        Authenticator auth = new Email_Autherticator(); // 进行邮件服务器用户认证
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", this.port + "");
        //邮箱发送服务器端口
        props.setProperty("mail.smtp.port", this.port + "");
        //	Session session = Session.getDefaultInstance(props, auth);
        Session session = Session.getInstance(props, auth);
        // 设置session,和邮件服务器进行通讯。
        MimeMessage message = new MimeMessage(session);
        // message.setContent("foobar, "application/x-foobar"); // 设置邮件格式
        message.setSubject(mail_subject); // 设置邮件主题
        message.setText(mail_body); // 设置邮件正文
        message.setHeader(mail_head_name, mail_head_value); // 设置邮件标题

        message.setSentDate(new Date()); // 设置邮件发送日期
        Address address = new InternetAddress(mail_from, personalName);
        message.setFrom(address); // 设置邮件发送者的地址
        Address toAddress = new InternetAddress(mail_to); // 设置邮件接收方的地址
        message.addRecipient(Message.RecipientType.TO, toAddress);
        Transport.send(message); // 发送邮件
    }

    /**
     * 新的发邮件方法
     */
    public void sendEmil() {
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //设置邮件会话参数
            Properties props = new Properties();
            //邮箱的发送服务器地址
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口
            props.setProperty("mail.smtp.port", "" + this.port);
            props.setProperty("mail.smtp.socketFactory.port", "" + this.port);
            props.put("mail.smtp.auth", "true");
            final String username = this.username;
            final String password = this.password;
            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            //通过会话,得到一个邮件,用于发送
            Message msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom(new InternetAddress(mail_from));
            //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_to, false));
            //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            //msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
            msg.setSubject(mail_subject);
            //设置邮件消息
            msg.setText(mail_body);
            //设置发送的日期
            msg.setSentDate(new Date());

            //调用Transport的send方法去发送邮件
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendEmilComplain() {
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //设置邮件会话参数
            Properties props = new Properties();
            //邮箱的发送服务器地址
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口
            props.setProperty("mail.smtp.port", "" + this.port);
            props.setProperty("mail.smtp.socketFactory.port", "" + this.port);
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.ssl.enable", true);
//设置安全证书
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            final String username = this.username;
            final String password = this.password;
            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            //通过会话,得到一个邮件,用于发送
            Message msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom(new InternetAddress(mail_from));
            //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_to, false));
            //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            //msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
            msg.setSubject(mail_subject);
            //设置邮件消息
            msg.setText(mail_body);
            //设置发送的日期
            msg.setSentDate(new Date());

            //调用Transport的send方法去发送邮件
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 用来进行服务器对用户的认证
     */
    public class Email_Autherticator extends Authenticator {
        public Email_Autherticator() {
            super();
        }

        public Email_Autherticator(String user, String pwd) {
            super();
            username = user;
            password = pwd;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail_head_name() {
        return mail_head_name;
    }

    public void setMail_head_name(String mail_head_name) {
        this.mail_head_name = mail_head_name;
    }

    public String getMail_head_value() {
        return mail_head_value;
    }

    public void setMail_head_value(String mail_head_value) {
        this.mail_head_value = mail_head_value;
    }

    public String getMail_to() {
        return mail_to;
    }

    public void setMail_to(String mail_to) {
        this.mail_to = mail_to;
    }

    public String getMail_from() {
        return mail_from;
    }

    public void setMail_from(String mail_from) {
        this.mail_from = mail_from;
    }

    public String getMail_subject() {
        return mail_subject;
    }

    public void setMail_subject(String mail_subject) {
        this.mail_subject = mail_subject;
    }

    public String getMail_body() {
        return mail_body;
    }

    public void setMail_body(String mail_body) {
        this.mail_body = mail_body;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public static void main(String[] args) {
        EmailSendTool sendEmail = new EmailSendTool("smtp.qq.com",
                465, "ssss@qq.com", "ssss", "sss@qq.com",
                "测试", "文本内容", "JEECMS", "", "");
        sendEmail.sendEmil();
		/*
		try {
			sendEmail.send();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
    }

}
