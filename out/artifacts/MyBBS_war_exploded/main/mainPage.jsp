<%--
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
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .title{
            width: 100%;
            height: 30px;
            line-height:30px;
            position: fixed;
            z-index: 9999;
        }
        .mainPage {
            width: 1000px;
            height: 1000px;
            margin: 0 auto;
            border: 1px solid white;
            box-sizing: border-box;
            background-color: #d5d5d5;
        }
        .mainList {
            width: 1000px;
            margin: 0 auto;
            list-style: none;
            background-color: ;
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
        .submitArea button {
            height: 30px;
            width: 50px;
        }
    </style>
</head>
<body style="background-color: #d5d5d5">
    <div class="title">
        sadfasd
    </div>
    <div class="mainPage">
        <ul class="mainList">
            <li>
                <span>sdfadf</span>
            </li>
            <li>
                <span>sdf</span>
            </li>
        </ul>
    </div>
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
            <textarea name="contectArea" id="contectArea" class="contentInputArea"></textarea>
        </div>
        <div class="submitArea">
            <button class="inputBottom">发表帖子</button>
        </div>
    </div>
</body>
</html>
