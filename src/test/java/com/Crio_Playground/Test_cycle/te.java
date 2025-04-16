package com.duracell.API.Test_cycle;

import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.SubjectTerm;
import java.util.Properties;

public class te {

    private static String emailContent;

    @When("I check the email inbox for temporary credentials")
    public void iCheckEmailInboxForTemporaryCredentials() throws Exception {
        String host = "imap.gmail.com"; // Use your email provider's IMAP server
        String username = "testuser@example.com";
        String password = "your-email-password";

        // Configure email session
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        Session session = Session.getInstance(properties);

        // Connect to the email inbox
        Store store = session.getStore();
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Search for the email with the subject
        Message[] messages = inbox.search(new SubjectTerm("Your Temporary Credentials"));
        Assert.assertTrue("No email found!", messages.length > 0);

        // Extract email content
        MimeBodyPart mimeBodyPart = (MimeBodyPart) messages[0].getContent();
        emailContent = mimeBodyPart.getContent().toString();

        inbox.close(false);
        store.close();
    }
}

