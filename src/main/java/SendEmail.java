import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;
/**
 * @Author taomofan
 * @Date 2021/1/25 9:37 上午
 * @Version 1.0
 */
public class SendEmail {
public static void main(String[] args) throws MessagingException, GeneralSecurityException {
    //创建一个配置文件并保存
    Properties properties = new Properties();

    properties.setProperty("mail.host","smtp.qq.com");

    properties.setProperty("mail.transport.protocol","smtp");

    properties.setProperty("mail.smtp.auth","true");

    //QQ存在一个特性设置SSL加密
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.ssl.socketFactory", sf);

    //创建一个session对象
    Session session = Session.getDefaultInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("1226964596@qq.com","skyeaxyjbtkogjch");
        }
    });

    //开启debug模式
    session.setDebug(true);

    //获取连接对象
    Transport transport = session.getTransport();

    //连接服务器
    transport.connect("smtp.qq.com","1226964596@qq.com","skyeaxyjbtkogjch");

    //创建邮件对象
    MimeMessage mimeMessage = new MimeMessage(session);

    //邮件发送人
    mimeMessage.setFrom(new InternetAddress("1226964596@qq.com"));

    //邮件接收人
    mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("1171150827@qq.com"));

    //邮件标题
    mimeMessage.setSubject("Hello Mail");

    //邮件内容
    String b = "haha";
    int a = 12;
    String s = "今日待办共计" + a +"条";
    String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    <p>处理链接：<a href=\"http://www.baidu.com\">http://www.baidu.com</a></p>\n" +
            "</body>\n" +
            "\n" +
            "</html>";
    mimeMessage.setContent(s + html,"text/html;charset=UTF-8");

    //发送邮件
    transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

    //关闭连接
    transport.close();
}
public static MimeMessage complexEmail(Session session) throws MessagingException {
    //消息的固定信息
    MimeMessage mimeMessage = new MimeMessage(session);

    //发件人
    mimeMessage.setFrom(new InternetAddress("619046217@qq.com"));
    //收件人
    mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("619046217@qq.com"));
    //邮件标题
    mimeMessage.setSubject("带图片和附件的邮件");

    //邮件内容
    //准备图片数据
    MimeBodyPart image = new MimeBodyPart();
    DataHandler handler = new DataHandler(new FileDataSource("E:\\IdeaProjects\\WebEmail\\resources\\测试图片.png"));
    image.setDataHandler(handler);
    image.setContentID("test.png"); //设置图片id

    //准备文本
    MimeBodyPart text = new MimeBodyPart();
    text.setContent("这是一段文本<img src='cid:test.png'>","text/html;charset=utf-8");

    //附件
    MimeBodyPart appendix = new MimeBodyPart();
    appendix.setDataHandler(new DataHandler(new FileDataSource("E:\\IdeaProjects\\WebEmail\\resources\\测试文件.txt")));
    appendix.setFileName("test.txt");

    //拼装邮件正文
    MimeMultipart mimeMultipart = new MimeMultipart();
    mimeMultipart.addBodyPart(image);
    mimeMultipart.addBodyPart(text);
    mimeMultipart.setSubType("related");//文本和图片内嵌成功

    //将拼装好的正文内容设置为主体
    MimeBodyPart contentText = new MimeBodyPart();
    contentText.setContent(mimeMultipart);

    //拼接附件
    MimeMultipart allFile = new MimeMultipart();
    allFile.addBodyPart(appendix);//附件
    allFile.addBodyPart(contentText);//正文
    allFile.setSubType("mixed"); //正文和附件都存在邮件中，所有类型设置为mixed


    //放到Message消息中
    mimeMessage.setContent(allFile);
    mimeMessage.saveChanges();//保存修改

    return mimeMessage;
}
}
