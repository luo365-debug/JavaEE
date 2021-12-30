package com.lol.webPageController;

import com.lol.entity.User;
import com.lol.webPageController.HttpClientUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    public static User loginUser;

    /**
     * 进入登录页
     * http://localhost:9090
     * */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 登录请求
     * */
    @PostMapping(value = "/login")
    public String main(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model){
        String userMethod=httpServletRequest.getParameter("UserMethod");

        if("登录".equals(userMethod)) {
            String idWeb = httpServletRequest.getParameter("idLogin");
            String passwordWeb = httpServletRequest.getParameter("passwordLogin");

            if (!StringUtils.isEmpty(idWeb)
                    && !StringUtils.isEmpty(passwordWeb)) {

                try {
                    //已有输入——>在数据库注册表中查找user
                    String userSQL = HttpClientUtil.sendGet("http://localhost:9090/user/" + idWeb, "");
                    User user = new User();
                    if (!StringUtils.isEmpty(userSQL)) {
                        user = user.buildUser(idWeb, userSQL);
                    }

                    if (Integer.parseInt(idWeb) == user.getId()
                            && passwordWeb.equals(user.getPassword())) {
                        //账号已注册，且密码对应
                        httpSession.setAttribute("loginUser", user);

                        loginUser = user;

                        httpServletRequest.getSession().setAttribute("loginId", loginUser.getId());
                        httpServletRequest.getSession().setAttribute("loginUid", loginUser.getUid());
                        httpServletRequest.getSession().setAttribute("LoginUserName", loginUser.getName());
                        httpServletRequest.getSession().setAttribute("loginPassword", loginUser.getPassword());
                        httpServletRequest.getSession().setAttribute("loginTel", loginUser.getTel());
                        httpServletRequest.getSession().setAttribute("loginAddress", loginUser.getAddress());


                        //登陆成功，重定向进入index页面
                        return "redirect:/index";
                    }
                    else {
                            model.addAttribute("msg", "账号或密码错误");
                            System.out.println("账号或密码错误");
                            return "login";
                    }
                }
                catch(Exception e){
                        e.printStackTrace();
                        model.addAttribute("msg", "登录失败");
                        return "login";
                }

            }
            else {
                model.addAttribute("msg", "输入账号和密码");
                return "login";
            }
        }
        else if("注册".equals(userMethod)){
            //注册
            //判断网页输入的user.id是否在数据库中出现过
            String id = httpServletRequest.getParameter("idRegister");
            if (!StringUtils.isEmpty(id)) {

                String userSQL = HttpClientUtil.sendGet("http://localhost:9090/user/" + id, "");

                if (StringUtils.isEmpty(userSQL)) {
                    //未出现过——>新增value = "/user", method = RequestMethod.POST
                    String uid=httpServletRequest.getParameter("uidRegister");
                    String username = httpServletRequest.getParameter("usernameRegister");
                    String password = httpServletRequest.getParameter("passwordRegister");
                    String tel = httpServletRequest.getParameter("telRegister");
                    String address=httpServletRequest.getParameter("addressRegister");

                    User newUser=new User(Integer.parseInt(id),Long.parseLong(uid),username,password,tel,address);
                    HttpClientUtil.sendPost("http://localhost:9090/user",newUser.UserPostBody());
                    System.out.println("新增" + newUser.toString());
                    loginUser=newUser;

                    return "login";
                } else {
                    model.addAttribute("msg","该账号已被使用");
                    return "login";
                }
            }
            else {
                model.addAttribute("msg", "注册时账号和密码不能为空");
                return "login";
            }
        }
        System.out.println("其他");
        return "login";
    }

    /**
     * 登陆成功进入主界面
     * */
    @GetMapping("/index")
    public String indexPage(HttpSession httpSession){

        Object loginUser=httpSession.getAttribute("loginUser");

        if(loginUser!=null){
            return "index";
        }
        else{
            //返回登陆界面
            return "login";
        }
    }


}
