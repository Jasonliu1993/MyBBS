<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2/27/17
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子</title>
    <script charset="utf-8">
        function ajax2SendForum() {
            $.ajax({
                url: '/SendForumController?action=ajax',
                type: "POST",//请求方式：get或post
                scriptCharset: 'utf-8',
                dataType: "json",//数据返回类型：xml、json、script
                cache: false,
                data: {
                    'theme': $("#theme").val(),
                    'content': $("#contentArea").val()
                },//自定义提交的数据
                success: function (json) {
                    if (json.Message !== null || json.Message !== undefined || json.Message !== '') {
                        /*document.getElementById('inputText').value = '';*/
                        for (var i = 0; i < json.length; i++) {
                            alert(json[i].theme)
                            //alert(json.ResponseThemeList.themeID + "@@" + json.ResponseThemeList.theme + "@@" + json.ResponseThemeList.currentPage + "@@" + json.ResponseThemeList.totalPage);
                            //document.getElementById('displayArea').innerHTML += '<div align="left"><p id="' + ID + '">' + json[i].message + '</p></div>';
                        }
                    }
                },
                error: function (json) {
                    alert("This is Error!")
                }
            })
        }
    </script>
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
            height: 2500px; /*250的倍数*/
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
        .mainList li {
            width: 1000px;
            height: 250px;
        }
        .mainList li span {
            display: inline-block;
        }
        .mainList li .info {
            width: 200px;
            height: 250px;
            float: left;
            border: 1px solid white;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        .mainList li .forumContent {
            float: right;
            width: 790px;
            height: 250px;
            border: 1px solid white;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        .mainList li .forumContent .mainForumContent {
            width: 730px;
            height: 170px;
            padding: 20px;
            margin: 0 auto;
            background-color: #e7e8e8;
            word-wrap: break-word;
            font-size: 14px;
            line-height: 24px;
        }
        .mainList li .forumContent .replyForum {
            width: 730px;
            height: 30px;
            margin: 5px auto;
        }
        .mainList li .forumContent .replyForum .datetime {
            float: left;
            width: 200px;
            height: 30px;
            line-height: 30px;
        }
        .mainList li .forumContent .replyForum .reply {
            color: #c2e7e8;
            float: right;
            width: 100px;
            height: 10px;
            line-height: 30px;
            text-decoration: none;
        }
        .mainList li .forumContent .replyForum .reply:hover {
            color: #f02136;
            float: right;
            width: 100px;
            height: 10px;
            line-height: 30px;
            text-decoration: none;
        }
        .inputArea {
            width: 1000px;
            height: 300px;
            margin: 20px auto;
            border: 1px solid white;
        }
        .inputArea .contentArea {
            width: 800px;
            height: 200px;
            margin: 25px auto;
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
        .submitArea button {
            height: 30px;
            width: 50px;
        }
    </style>
</head>
<body style="background-color: #d5d5d5">
<div class="title">
    <span>欢迎: sadfasd</span>
</div>
<div class="mainPage">
    <div class="filled"></div>
    <ul class="mainList">
        <li>
            <span class="info">sdfadf</span>
            <span class="forumContent">
                <div class="mainForumContent">lkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkbrjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaflkjdfasldkjqwelgkadjgaslkcjalsdfjadfaf
                </div>
                <div class="replyForum">
                    <span class="datetime">2016-01-20 16:30:27</span>
                    <a href="#" class="reply">回复</a>
                </div>
            </span>
        </li>
        <li>
            <span class="info">sdfadf</span>
            <span class="forumContent">
                <div class="mainForumContent">adfaf</div>
                <div class="replyForum">
                    <span class="datetime">2016-01-20 16:41:29</span>
                    <a href="#" class="reply">回复</a>
                </div>
            </span>
        </li>
    </ul>
</div>
<div class="inputArea">
    <div class="contentArea">
        <span class="contentLabelArea"></span>
        <textarea name="contentArea" id="contentArea" class="contentInputArea"></textarea>
    </div>
    <div class="submitArea">
        <button class="inputBottom" onclick="ajax2SendForum()">回复</button>
    </div>
</div>
</body>
</html>
