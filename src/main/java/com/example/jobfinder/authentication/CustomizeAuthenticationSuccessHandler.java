package com.example.jobfinder.authentication;

import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.entity.person.HRManager;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.service.AccountService;
import com.example.jobfinder.service.HRManagerService;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private HRManagerService hrManagerService;

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        String username = authentication.getName();
        ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>(authentication.getAuthorities());
        GrantedAuthority grantedAuthority = (SimpleGrantedAuthority) list.get(0);
        String roleName = grantedAuthority.getAuthority();
        if(roleName.equals("ROLE_HRMANAGER")){
            HRManager hrManager = hrManagerService.findByAccountUsername(username);
            session.setAttribute("account",hrManager);
            httpServletResponse.sendRedirect("/admin/home");
        }
        if(roleName.equals("ROLE_USER") || roleName.equals("ROLE_VIPUSER")){
            User user = userService.findByAccountUsername(username);
            session.setAttribute("account",user);
            httpServletResponse.sendRedirect("/");
        }

    }
}
