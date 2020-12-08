package com.ncproject.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import java.util.UUID;
import java.time.ZonedDateTime;
import com.ncproject.backend.model.UserSummary;

@Component
@AllArgsConstructor
public class LocallyCopyingOAuth2UserService extends DefaultOAuth2UserService {
    private final UserSummaryService userSummaryService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        UUID uuid = (userSummaryService.userSummaryExistsByEmail(oAuth2User.getAttribute("email"))) ?
            userSummaryService.getUserSummaryByEmail(oAuth2User.getAttribute("email")).getId() :
            UUID.randomUUID();

        userSummaryService.saveUser(new UserSummary(
                uuid,
                oAuth2User.getAttribute("email"),
                oAuth2User.getAttribute("given_name"),
                oAuth2User.getAttribute("family_name"),
                oAuth2User.getAttribute("picture"),
                oAuth2UserRequest.getAccessToken().getTokenValue(),
                ZonedDateTime.now().minusYears(1).toInstant()
                ));

        return oAuth2User;
    }
}
