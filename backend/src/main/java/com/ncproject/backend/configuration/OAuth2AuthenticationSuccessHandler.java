package com.ncproject.backend.configuration;

import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/oauth2/redirect?status=ok");
    }
}
