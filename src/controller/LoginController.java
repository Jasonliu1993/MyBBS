package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javabean.*;
import process.ForumThemeProcess;
import process.LoginDataProcess;

/**
 * Created by Jason on 2/20/17.
 */
@WebServlet(name = "LoginController" ,urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //if(request.getServletPath())
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name + "@@@" + password);
        LoginData loginData = LoginDataProcess.getLoginDate(name);
        if (loginData.getPassword() != null && password.equals(loginData.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user",name);
            request.setAttribute("themeList",ForumThemeProcess.getForumTheme(0,20));
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainPage.jsp").forward(request, response);
        } else {
            getServletConfig().getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
