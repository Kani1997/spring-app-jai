package bdaytemplate.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import bdaytemplate.dto.EmailRequest;
import bdaytemplate.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AppController {

	@Autowired(required=true)
	private JavaMailSender mailSender;

	@Autowired
	private EmailService emailService;


	@PostMapping("/error")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/emailwithimage")
	public String sendHTMLEmailWithInlineImage1(Model model) throws MessagingException {
		emailService.sendEmailWithInlineImage();
	    model.addAttribute("message", "An HTML email with inline image has been sent");
	    return "result";
	}

	@Scheduled(cron = "0 18 15 * * ?", zone = "Asia/Kolkata")
	// Daily at 10:10 AM IST
	public void sendHTMLEmailWithInlineImageDaily() throws MessagingException, IOException {
		emailService.sendEmailWithInlineImage();
	}

}
