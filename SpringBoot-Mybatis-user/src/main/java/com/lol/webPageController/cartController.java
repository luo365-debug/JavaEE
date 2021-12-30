package com.lol.webPageController;

import com.lol.entity.User;
import com.lol.webPageController.HttpClientUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class cartController {

    /**
     * 立即下单
     * */
    @RequestMapping(value = "/cart")
    public void addBookToCart(HttpServletRequest httpServletRequest){
        String addbId=httpServletRequest.getParameter("addBookId");
    }
}
