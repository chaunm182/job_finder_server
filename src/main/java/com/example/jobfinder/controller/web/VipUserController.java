package com.example.jobfinder.controller.web;

import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.entity.account.Role;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.service.UserService;
import com.example.jobfinder.vnpay.VnPayConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class VipUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/upgrade-vip")
    public String showUpgradeVipUserPage(){
        return "web/upgrade-vip";
    }

    @GetMapping("/upgrade-vip/process-upgrade")
    public void processUpgrade(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {

        HttpSession session=  request.getSession();
        User user  = (User) session.getAttribute("account");
        StringBuilder payURLBuilder = new StringBuilder(VnPayConfiguration.PAY_URL).append("?");
        Map<String,String> params = new LinkedHashMap<>();
        params.put("vnp_Amount",VnPayConfiguration.AMOUNT);
        params.put("vnp_Command",VnPayConfiguration.COMMAND);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formater.format(date);
        params.put("vnp_CreateDate",dateString);

        params.put("vnp_CurrCode",VnPayConfiguration.CURR_CODE);

        String ipAddress = request.getRemoteAddr();
        params.put("vnp_IpAddr",ipAddress);
        params.put("vnp_Locale",VnPayConfiguration.LOCALE);
        params.put("vnp_OrderInfo",VnPayConfiguration.ORDER_INFO_PREFIX+" "+user.getAccount().getUsername());
        params.put("vnp_OrderType",VnPayConfiguration.ORDER_TYPE);
        params.put("vnp_ReturnUrl",VnPayConfiguration.RETURN_URL);
        params.put("vnp_TmnCode",VnPayConfiguration.TMN_CODE);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yMdHms");
        String orderId = simpleDateFormat.format(date);
        params.put("vnp_TxnRef",orderId);
        params.put("vnp_Version",VnPayConfiguration.VERSION);
        String query = VnPayConfiguration.getQuery(params);
        response.sendRedirect(payURLBuilder.toString()+query);
    }

    @GetMapping("/upgrade-vip/order-status")
    public String showOrderStatus(@RequestParam Map<String,String> params, HttpSession session) throws NoSuchAlgorithmException {
        params.remove("vnp_SecureHashType");
        String hash = params.remove("vnp_SecureHash");
        String secureHash = VnPayConfiguration.getSecureHash(params);
        if(hash.equalsIgnoreCase(secureHash)){
            User currentUser = (User) session.getAttribute("account");
            Account account = currentUser.getAccount();
            Role role = new Role();
            role.setId(4); //VIP User
            account.setRole(role);

            userService.save(currentUser);

            return "web/order-status";
        }
        return "access-denied";


    }
}
