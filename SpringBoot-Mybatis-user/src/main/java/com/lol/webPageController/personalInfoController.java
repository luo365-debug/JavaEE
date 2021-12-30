package com.lol.webPageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class personalInfoController {

    /**
     * 进入个人信息界面 personalInfo
     * */
    @GetMapping(value = "/personalInfo")
    /*public String personalInfoPage(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {*/
    public String personalInfoPage(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {

        //每次进入均更新一次界面

        /*ModelAndView mv = new ModelAndView();
        mv.addObject("person_uid", indexController.loginUser.getUid());
        mv.setViewName("/personalInfo");*/

        return "personalInfo";
    }

    /**
     * 注销当前用户
     * */
/*    @PostMapping(value = "/personalInfo")
    public String deletePerson(HttpServletRequest httpServletRequest){
        String userMethod=httpServletRequest.getParameter("UserMethod");
        if("注销当前账号".equals(userMethod)){
            String deleteId=indexController.loginUser.getId().toString();
            HttpClientUtil.sendDelete("http://localhost:9090/user/"+deleteId,"");
            System.out.println("注销 " + deleteId);
            //return "login";
        }
        //return "personalInfo";
        return "login";
    }*/

    /**
     * 修改个人信息界面 changePersonalInfo.html
     * */
    @PostMapping(value = "/changePersonalInfo")
    public void changeInfoPage(HttpServletRequest httpServletRequest,HttpServletResponse response)throws ServletException, IOException{
        String webUid=httpServletRequest.getParameter("uidUpdate");
        if(!StringUtils.isEmpty(webUid)){
            indexController.loginUser.setUid(Long.parseLong(webUid));
            httpServletRequest.getSession().setAttribute("loginUid",indexController.loginUser.getUid());
        }
        String webUsername=httpServletRequest.getParameter("usernameUpdate");
        if(!StringUtils.isEmpty(webUsername)){
            indexController.loginUser.setName(webUsername);
            httpServletRequest.getSession().setAttribute("LoginUserName",indexController.loginUser.getName());
        }
        String webPassword=httpServletRequest.getParameter("passwordUpdate");
        if(!StringUtils.isEmpty(webPassword)){
            indexController.loginUser.setPassword(webPassword);
            httpServletRequest.setAttribute("loginPassword",indexController.loginUser.getPassword());
            httpServletRequest.getSession().setAttribute("loginPassword",indexController.loginUser.getPassword());
        }
        String webTel=httpServletRequest.getParameter("telUpdate");
        if(!StringUtils.isEmpty(webTel)){
            indexController.loginUser.setTel(webTel);
            httpServletRequest.getSession().setAttribute("loginTel",indexController.loginUser.getTel());
        }
        String webAddress=httpServletRequest.getParameter("addressUpdate");
        if(!StringUtils.isEmpty(webAddress)){
            indexController.loginUser.setAddress(webAddress);
            httpServletRequest.getSession().setAttribute("loginAddress",indexController.loginUser.getAddress());
        }

        if("确定修改".equals(httpServletRequest.getParameter("UserMethod"))){
            HttpClientUtil.sendPut("http://localhost:9090/user",indexController.loginUser.UserPostBody());
            httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/personalInfoJSP.jsp").forward(httpServletRequest,response);
            //return "personalInfo";
        }
        /*return "changePersonalInfo";*/
    }

    /**
     * 进入个人信息修改界面
     * */
    @GetMapping(value = "/changePersonalInfo")
    public String changeInfoPage(){
        return "changePersonalInfo";
    }

}
