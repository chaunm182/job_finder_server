package com.example.jobfinder.controller.web;


import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.entity.account.Role;
import com.example.jobfinder.service.AccountService;
import com.example.jobfinder.vnpay.VnPayConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/order")
    public  String showOrderInMobile(@RequestParam Map<String,String> params){
        params.remove("vnp_SecureHashType");
        String hash = params.remove("vnp_SecureHash");
        String secureHash = VnPayConfiguration.getSecureHash(params);
        if(hash.equalsIgnoreCase(secureHash)){
            String orderInfo = params.get("vnp_OrderInfo");
            String[] strings = orderInfo.split(" ");
            String username = strings[strings.length-1];
            Account account = accountService.findAccountByUsername(username);
            Role role = new Role();
            role.setId(4); //VIP USER
            account.setRole(role);
            accountService.save(account);
            return "web/order-mobile";
        }
        return "access-denied";
    }
}
