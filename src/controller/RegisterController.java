package controller;

import javabean.LoginData;
import process.LoginDataProcess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

/**
 * Created by Jason on 2/22/17.
 */
@WebServlet(name = "RegisterController", urlPatterns = "/RegisterController")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginData loginData = new LoginData();
        loginData.setName(request.getParameter("name"));
        loginData.setPassword(request.getParameter("password"));
        loginData.setVersion(1);
        loginData.setLastLoginDate((new Date(System.currentTimeMillis())).toLocalDate().toString());
        HashMap<String, LoginData> loginDataHashMap = new HashMap<String, LoginData>();
        loginDataHashMap.put("I", loginData);
        LoginDataProcess.setLoginData(loginDataHashMap);
    }
}
