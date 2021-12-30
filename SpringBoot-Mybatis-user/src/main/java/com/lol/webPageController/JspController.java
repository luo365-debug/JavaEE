package com.lol.webPageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class JspController {

    @RequestMapping("personalInfoJSP")
    public void personalInfoJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/personalInfoJSP.jsp").forward(request,response);
    }


    @RequestMapping("cartJSP")
    public void cartJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/cartJSP.jsp").forward(request,response);
    }

    @RequestMapping("myOderJSP")
    public void myOderJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/myOderJSP.jsp").forward(request,response);
    }

    @RequestMapping("releaseBookJSP")
    public void releaseBookJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/releaseBookJSP.jsp").forward(request,response);
    }
}
