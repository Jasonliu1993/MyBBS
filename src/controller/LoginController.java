package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javabean.*;
import process.LoginDataProcess;

import java.util.*;

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
        if (loginData.getPassword().equals(password)) {
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainPage.jsp").forward(request, response);
        }
    }
}
