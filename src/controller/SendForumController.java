package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.Date;

import com.google.gson.Gson;
import javabean.ForumTheme;
import javabean.ResponseThemeList;
import utility.DateUtility;
import utility.KeyValue;

/**
 * Created by Jason on 2/26/17.
 */
@WebServlet(name = "SendForumController", urlPatterns =  "/SendForumController")
public class SendForumController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajax".equals(action)){
            /***
             * 在贴纸主页中获取发帖的信息,以及跟新帖子的样式
             */
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
        } else if ("postForum".equals(action)) {
            /***
             * 获取发贴的信息
             */
            String forumContentID = KeyValue.getKeyValue();
            ForumTheme forumTheme = new ForumTheme();
            LinkedList<ForumTheme> forumThemes = new LinkedList<ForumTheme>();
            forumTheme.setID(KeyValue.getKeyValue());
            forumTheme.setForumCreater((String) request.getSession().getAttribute("user"));
            forumTheme.setPostDatetime(DateUtility.getCurrentDate());
            forumTheme.setForumTheme(request.getParameter("theme"));
            forumTheme.setForumContentID(forumContentID);
        } else {
            /***
             * 跳转到帖子主页,获取到帖子相关信息
             */
            String ID = request.getParameter("themeID");
            int currentPage = Integer.parseInt(request.getParameter("page"));
            System.out.println(ID + "@@@" + currentPage);
            String theme = request.getParameter("theme");
            String content = request.getParameter("content");
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainForumPage.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
