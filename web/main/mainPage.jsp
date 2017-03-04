<%@ page import="javabean.ForumTheme" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2/22/17
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BBS论坛</title>
    <script type="text/JavaScript" charset="utf-8" src="/js/jquery-3.1.1.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .title{
            width: 100%;
            height: 30px;
            line-height:30px;
            background-color: rgba(0,0,0,0.5);
            position: fixed;
            z-index: 9999;
        }
        .title span {
            padding-left: 300px;
        }
        .mainPage {
            width: 1000px;
            height: 1000px;
            margin: 0 auto;
            border: 1px solid white;
            box-sizing: border-box;
            background-color: #d5d5d5;
        }
        .mainPage .filled {
            height: 30px;
        }
        .mainList {
            width: 1000px;
            margin: 0 auto;
            list-style: none;
        }
        .mainList li:nth-child(2n + 1) {
            width: 1000px;
            height: 50px;
            line-height: 50px;
            font-size: 25px;
            font-weight: bold;
            text-align: center;
            background-color: #f2f2f2;
            border: 1px solid #d5d5d5;
            box-sizing: border-box;
        }
        .mainList li:nth-child(2n) {
            width: 1000px;
            height: 50px;
            line-height: 50px;
            font-size: 25px;
            font-weight: bold;
            text-align: center;
            background-color: #eff0f1;
            border: 1px solid #d5d5d5;
            box-sizing: border-box;
        }
        .mainList li span {
            display: inline-block;
            width: 900px;
            height: 50px;
            text-align: center;
        }
        .mainList li span a{
            color: #f02136;
            text-decoration: none;
        }
        .mainList li span a:hover{
            color: #c2e7e8;
            text-decoration: none;
        }
        .inputArea {
            width: 1000px;
            height: 300px;
            margin: 20px auto;
            border: 1px solid white;
        }
        .inputArea .themeArea {
            width: 1000px;
            height: 60px;
            padding-top: 20px;
            box-sizing: border-box;
        }
        .inputArea .themeArea .themeLabelArea{
            display: inline-block;
            width: 100px;
            height: 30px;
            padding-left: 30px;
            font-weight: bold;
        }
        .inputArea .themeArea .themeInputArea{
            width: 900px;
            height: 30px;
        }
        .inputArea .themeArea .themeInputArea input[type="text"]{
            width: 800px;
            height: 30px;
        }
        .inputArea .contentArea {
            width: 1000px;
            height: 200px;
        }
        .inputArea .contentArea .contentLabelArea {
            display: inline-block;
            width: 100px;
            height: 200px;
            padding-left: 30px;
            font-weight: bold;
        }
        .inputArea .contentArea .contentInputArea {
            width: 800px;
            height: 200px;
            resize: none;
        }
        .submitArea {
            height: 40px;
            width: 1000px;
            padding-left: 133px;
            padding-top: 7px;
        }
        .submitArea input[type = "submit"] {
            height: 30px;
            width: 50px;
            border: 1px solid white;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
    </style>
</head>
<body style="background-color: #d5d5d5">
    <div class="title">
        <span>欢迎:<%=session.getAttribute("user")%></span>
    </div>
    <div class="mainPage">
        <div class="filled"></div>
        <ul class="mainList">
            <%  for (ForumTheme forumTheme : (LinkedList<ForumTheme>)request.getAttribute("themeList")) {%>
            <li>
                <span><a href="/SendForumController?type=n&page=0&themeID=<%=forumTheme.getID()%>"><%=forumTheme.getForumTheme()%></a></span>
            </li>
            <%}%>
        </ul>
    </div>
    <form action="/SendForumController?action=postForum" method="post">
        <div class="inputArea">
            <div class="themeArea">
                <span class="themeLabelArea">
                    <label for="theme">主题:</label>
                </span>
                <span class="themeInputArea">
                    <input type="text" name="theme" id="theme">
                </span>
            </div>
            <div class="contentArea">
                <span class="contentLabelArea"></span>
                <textarea name="contentArea" id="contentArea" class="contentInputArea"></textarea>
            </div>
            <div class="submitArea">
                <input type="submit" class="inputBottom" value="发表帖子">
            </div>
        </div>
    </form>
</body>
</html>
