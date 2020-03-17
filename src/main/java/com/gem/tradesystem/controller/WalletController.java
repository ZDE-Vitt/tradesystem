package com.gem.tradesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    @RequestMapping("/toWallet")
    public String toWallet(){
        return "wallet";
    }
}
