package com.ncproject.backend.controllers;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.ncproject.backend.model.PendingInvitation;
import com.ncproject.backend.model.UserSummary;
import com.ncproject.backend.services.UserSummaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InvitationController {
    UserSummaryService userSummaryService;

    @PostMapping("/api/invitation")
    Message addInvitation(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                          @RequestBody PendingInvitation pendingInvitation) throws MessagingException, IOException, GeneralSecurityException {
        UserSummary userSummary = userSummaryService
                .getUserSummaryByAccessToken(client.getAccessToken().getTokenValue());
        Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(userSummary.getAccessToken());

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(pendingInvitation.getFrom()));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(pendingInvitation.getTo()));
        email.setSubject(pendingInvitation.getSubject());
        email.setText(pendingInvitation.getBodyText());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName("JustMeet")
                .build();
        message = service.users().messages().send(pendingInvitation.getFrom(), message).execute();

        return message;
    }
}