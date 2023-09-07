//package net.codejava;
//
////import java.io.File;
////import java.util.Properties;
////
////import javax.mail.MessagingException;
////import javax.mail.internet.MimeMessage;
////
////import org.junit.jupiter.api.BeforeAll;
////import org.junit.jupiter.api.Test;
////import org.springframework.core.io.FileSystemResource;
////import org.springframework.mail.SimpleMailMessage;
////import org.springframework.mail.javamail.JavaMailSenderImpl;
////import org.springframework.mail.javamail.MimeMessageHelper;
////
////public class SpringEmailTest {
////
////	private static JavaMailSenderImpl mailSender;
////
////	@BeforeAll
////	public static void setup() {
////		mailSender = new JavaMailSenderImpl();
////		mailSender.setHost("smtp.gmail.com");
////		mailSender.setPort(465);
////		mailSender.setUsername("karnikathilgar001@gmail.com");
////		mailSender.setPassword("9095863339");
////
////		Properties properties = new Properties();
////		properties.setProperty("mail.smtp.auth", "true");
////		properties.setProperty("mail.smtp.starttls.enable", "true");
////
////		mailSender.setJavaMailProperties(properties);
////	}
////
////	@Test
////	public void testSendSimpleEmail() throws Exception {
////		String from = "karnikathilgar001@gmail.com";
////		String to = "anushanil2000@gmail.com";
////
////		SimpleMailMessage message = new SimpleMailMessage();
////		message.setFrom(from);
////		message.setTo(to);
////		message.setSubject("My 2nd email from Spring Boot");
////		message.setText("Hello guys, this is my 2nd email sent from Spring Boot.");
////
////		mailSender.send(message);
////	}
////
////	@Test
////	public void testSendHTMLEmail() throws MessagingException {
////		String from = "karnikathilgar001@gmail.com";
////		String to = "anushanil2000@gmail.com";
////
////		MimeMessage message = mailSender.createMimeMessage();
////		MimeMessageHelper helper = new MimeMessageHelper(message);
////
////		helper.setSubject("This is an HTML email");
////		helper.setFrom(from);
////		helper.setTo(to);
////
////		helper.setText("<b>Hey guys</b>,<br><i>Welcome to my home</i>", true);
////
////		mailSender.send(message);
////	}
////
////	@Test
////	public void testSendEmailWithAttachment() throws MessagingException {
////		String from = "karnikathilgar001@gmail.com";
////		String to = "anushanil2000@gmail.com";
////
////		MimeMessage message = mailSender.createMimeMessage();
////		MimeMessageHelper helper = new MimeMessageHelper(message, true);
////
////		helper.setSubject("Here's your e-book");
////		helper.setFrom(from);
////		helper.setTo(to);
////
////		helper.setText("<b>Dear master</b>,<br><i>Please find the book attached.</i>", true);
////
////		FileSystemResource file = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\SuccessFreelance-Preview.pdf"));
////		helper.addAttachment("FreelanceSuccess.pdf", file);
////
////		mailSender.send(message);
////	}
////
////	@Test
////	public void testSendEmailWithInlineImage() throws MessagingException {
////		String from = "karnikathilgar001@gmail.com";
////		String to = "anushanil2000@gmail.com";
////
////		MimeMessage message = mailSender.createMimeMessage();
////		MimeMessageHelper helper = new MimeMessageHelper(message, true);
////
////		helper.setSubject("Here's your pic");
////		helper.setFrom(from);
////		helper.setTo(to);
////
////		helper.setText("<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i><br><img src='cid:image001'/><br><b>Best Regards</b>", true);
////
////		FileSystemResource resource = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\images\\admiration.png"));
////		helper.addInline("image001", resource);
////
////		mailSender.send(message);
////	}
////}
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.util.Properties;
//
//@SpringBootTest
//@PropertySource("classpath:application.properties") // If you have properties to load
//public class SpringEmailTest {
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	@Test
//	public void testSendEmailWithInlineImage() throws MessagingException {
//		String from = "karnikathilgar001@gmail.com";
//		String to = "anushanil2000@gmail.com";
//
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//		helper.setSubject("Here's your pic");
//		helper.setFrom(from);
//		helper.setTo(to);
//
//		helper.setText("<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i><br><img src='cid:image001'/><br><b>Best Regards</b>", true);
//
//		FileSystemResource resource = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\images\\admiration.png"));
//		helper.addInline("image001", resource);
//
//		mailSender.send(message);
//	}
//}
