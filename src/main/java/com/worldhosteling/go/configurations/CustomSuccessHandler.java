package com.worldhosteling.go.configurations;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.services.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    //region    FIELDS / PROPERTIES
    @Value("${spring.security.authentication.method}")
    private String SECURITY_METHOD;
    //endregion

    private AccountService accountService;

    public CustomSuccessHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determineTargetUrl(authentication, request.getSession());

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication, HttpSession session) {

        String url = "/";

        // collect all roles from AD response
        List<String> roles = getRolesFromAuthorities(authentication);

        Consumer<String> setProfileInfo = role -> {
            session.setAttribute("accountType", role);
            session.setAttribute("email", authentication.getName());
            createAccount(session);
        };

        setProfileInfo.accept("ACCOUNT");

        logger.info("User: " + session.getAttribute("email") + " logged in.");

        return url;

    }

    private List<String> getRolesFromAuthorities(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority grantedAuthority : authorities) {
            roles.add(grantedAuthority.getAuthority());
        }

        roles.forEach(r -> logger.info("Role found: " + r));
        return roles;

    }

    private void createAccount(HttpSession session) {
        String email = session.getAttribute("email").toString();
        Optional<Account> account = Optional.ofNullable(accountService.findAccountByEmail(email));

        if (!account.isPresent()) {
            logger.info("The email: " + email + " does not exist. Please navigate to the sign up form or retry login.");
            // TODO: Need to throw up some exception to show popup
        } else {
            account.ifPresent(accountProfile -> {
                if (Objects.isNull(accountProfile.getAccountType())) {
                    logger.info("Updating role to " + session.getAttribute("accountType").toString() + " for account: " + email);
                    accountProfile.setAccountType(session.getAttribute("accountType").toString());
                    accountService.saveAccount(accountProfile);
                }
            });
        }

    }

}
