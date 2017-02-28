package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import javabean.ResponseThemeList;

/**
 * Created by Jason on 2/26/17.
 */
@WebServlet(name = "SendForumController", urlPatterns =  "/SendForumController")
public class SendForumController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajax".equals(action)){
            ResponseThemeList responseThemeList = new ResponseThemeList();

            responseThemeList.setTheme("中国你好");
            responseThemeList.setTheme("测试主题标语");
            responseThemeList.setCurrentPage("2");
            responseThemeList.setTotalPage("1");
            ArrayList<ResponseThemeList> responseThemeLists = new ArrayList<ResponseThemeList>();
            responseThemeLists.add(responseThemeList);
            Gson gson = new Gson();
            System.out.println("here!");
            String json = gson.toJson(responseThemeLists);
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            System.out.println(json);

            out.write(json);
        } else {
            String theme = request.getParameter("theme");
            String content = request.getParameter("content");
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainForumPage.jsp").forward(request,response);
        }
    }
}
