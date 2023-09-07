package bdaytemplate.service;


import bdaytemplate.dao.EmployeeDAOImp;
import bdaytemplate.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	private EmployeeDAOImp employeeDAOImp;

	public EmailService(EmployeeDAOImp employeeDAOImp) {
		this.employeeDAOImp = employeeDAOImp;
	}

	@Value("${spring.mail.username}")
	private String senderEmail;

	public void sendEmailWithInlineImage() throws MessagingException {
		List<EmailRequest> to = employeeDAOImp.findAllWithBirthday();

		for (EmailRequest value : to) {
			String birthdayImagePath = "D:\\Downloads\\brthday.jpg";
			String secondImagePath = "D:\\Documents\\Msys logo.jpg"; // Provide the path to your second image
			String reportingManagerEmail = value.getreporting_manager();
			String cc = "anushanil2000@gmail.com";
			String bcc = "rhemanthecool23@gmail.com"; // Add the BCC recipient's email address

			FileSystemResource birthdayResource = new FileSystemResource(new File(birthdayImagePath));
			FileSystemResource secondResource = new FileSystemResource(new File(secondImagePath)); // Load the second image

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String someVariable = value.getName();
			String subject = "Birthday! " + someVariable;
			helper.setSubject(subject);

			helper.setFrom("Talent Management <" + senderEmail + ">");

			if (value.getEmail() != null) {
				helper.addTo(value.getEmail()); // Add the original recipient (employee)

				if (reportingManagerEmail != null) {
					helper.addCc(cc);
					// CC to reporting manager
				}

				// CC to sender
				helper.addCc(senderEmail);

				// Add BCC recipient
				helper.addBcc(bcc);

				// Modify the email content to include both images with tooltips (titles)
				String content = "<b>Dear " + value.getName() + ",</b><br><i>Msys wishes you a very Happy Birthday!</i>"
						+ "<br><img src='cid:brthday' alt='Birthday Image' /><br><br>"
						+ "<b>Best Regards,</b><br><b>Talent Management</b>"
						+ "<br><img src='cid:MsysLogo' alt='Second Image' title='Msys Logo' /><br><br>";

				helper.setText(content, true);

				// Add both inline images with unique Content-IDs
				helper.addInline("brthday", birthdayResource); // Birthday image
				helper.addInline("MsysLogo", secondResource); // Second image (use a unique Content-ID)

				mailSender.send(message);
			}
		}
	}
}