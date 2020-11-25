package com.ncproject.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import java.util.UUID;
import com.ncproject.backend.model.User;

@Component
@AllArgsConstructor
public class LocallyCopyingOidcUserService extends OidcUserService {
    UserService userService;

    @Override
    public OidcUser loadUser(OidcUserRequest oidcUserRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(oidcUserRequest);

        userService.addUser(new User(
                new UUID( 0 , 0 ),
                oidcUser.getAttribute("email"),
                oidcUser.getAttribute("given_name"),
                oidcUser.getAttribute("family_name"),
                oidcUser.getAttribute("picture"),
                oidcUserRequest.getAccessToken().getTokenValue(),
                oidcUser.getExpiresAt()
                ));

        return oidcUser;
    }
}