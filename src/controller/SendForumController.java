package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.Gson;
import javabean.ForumContent;
import javabean.ForumTheme;
import javabean.ResponseThemeList;
import process.ForumContentProcess;
import process.ForumThemeProcess;
import utility.DateUtility;
import utility.KeyValue;

/**
 * Created by Jason on 2/26/17.
 */
@WebServlet(name = "SendForumController", urlPatterns = "/SendForumController")
public class SendForumController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajax".equals(action)) {
            /***
             * 在贴纸主页中获取发帖的信息,以及跟新帖子的样式
             */
            String forumThemeIDPage = request.getParameter("forumThemeID");
            String forumContentFromPage = request.getParameter("contentArea");
            System.out.println("forumContentFromPage@@@@@" + forumContentFromPage);
            ForumContent forumContent = new ForumContent();
            HashMap<String,ForumContent> forumContentHashMap = new HashMap<String,ForumContent>();

            System.out.println("forumThemeIDPage@@@@@" + forumThemeIDPage);
            forumContent.setID(KeyValue.getKeyValue());
            forumContent.setOrderID((Integer.valueOf(ForumContentProcess.getForumContentCount(forumThemeIDPage))).toString() + 1);
            forumContent.setForumContent(forumContentFromPage);
            forumContent.setCreateUser((String) request.getSession().getAttribute("user"));
            forumContent.setCreateDateTime(DateUtility.getCurrentDate());
            forumContent.setForumThemeID(forumThemeIDPage);
            forumContentHashMap.put("I",forumContent);
            ForumContentProcess.setForumContent(forumContentHashMap);

            ArrayList<ForumContent> forumContents = new ArrayList<ForumContent>();
            forumContents.add(forumContent);
            Gson gson = new Gson();
            System.out.println("here!");
            String json = gson.toJson(forumContents);
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            System.out.println(json);

            out.write(json);
        } else if ("postForum".equals(action)) {
            /***
             * 获取发贴的信息
             */
            String forumThemeID = KeyValue.getKeyValue();
            String forumContentID = KeyValue.getKeyValue();
            String currentDate = DateUtility.getCurrentDate();
            ForumTheme forumTheme = new ForumTheme();
            ForumContent forumContent = new ForumContent();
            HashMap<String, ForumTheme> forumThemes = new HashMap<String, ForumTheme>();
            HashMap<String, ForumContent> forumContents = new HashMap<String, ForumContent>();
            LinkedList<ForumContent> forumContentLinkedList = new LinkedList<ForumContent>();

            forumTheme.setID(forumThemeID);
            forumTheme.setForumCreater((String) request.getSession().getAttribute("user"));
            forumTheme.setPostDatetime(currentDate);
            forumTheme.setForumTheme(request.getParameter("theme"));
            forumTheme.setForumContentID(forumContentID);
            forumThemes.put("I", forumTheme);
            ForumThemeProcess.setForumThmee(forumThemes);

            forumContent.setID(forumContentID);
            forumContent.setOrderID("0");
            forumContent.setForumContent(request.getParameter("contentArea"));
            forumContent.setForumThemeID(forumThemeID);
            forumContent.setCreateDateTime(currentDate);
            forumContent.setCreateUser((String) request.getSession().getAttribute("user"));
            forumContents.put("I", forumContent);
            ForumContentProcess.setForumContent(forumContents);

            forumContentLinkedList.add(forumContent);
            request.setAttribute("forumTheme", forumTheme);
            request.setAttribute("forumContents", forumContentLinkedList);
            request.setAttribute("forumCount", 1);
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainForumPage.jsp").forward(request, response);
        } else {
            /***
             * 跳转到帖子主页,获取到帖子相关信息
             */
            String ID = request.getParameter("themeID");
            int currentPage = Integer.parseInt(request.getParameter("page"));
            String type = request.getParameter("type");
            System.out.println(ID + "@@@" + currentPage);
            String theme = request.getParameter("theme");
            String content = request.getParameter("content");
            ForumTheme forumTheme = null;
            LinkedList<ForumContent> forumContents = new LinkedList<ForumContent>();

            forumTheme = ForumThemeProcess.getForumTheme(ID);
            forumContents = ForumContentProcess.getForumContent(forumTheme.getID(), 0, 20);
            request.setAttribute("forumTheme", forumTheme);
            request.setAttribute("forumContents", forumContents);
            request.setAttribute("forumCount", forumContents.size());
            System.out.println(forumContents.size());
            getServletConfig().getServletContext().getRequestDispatcher("/main/mainForumPage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
