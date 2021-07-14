<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.*,com.project.bean.NewsBean" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>最新消息 Latest News</title>
           
     <!-- <link rel="stylesheet" href="CSS/newstemplate.css"> -->
	<script src="jquery-3.6.0.js"></script>
	<script src="js/sortByMonth.js"></script>
	<link rel="stylesheet" href="CSS/userInterface.css">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<style>
	</style>
        </head>

        <body>
       <div class="page">
        <div class="topnav" id="top">
            <a class="nav-logo" href="#top"><img src="image/audi-logo.png" alt="logo" class="img-logo"></a>
            <a class="nav-title" href="#">試駕體驗</a>
            <a class="nav-title" href="NewsForUser">最新消息</a>
            <a class="nav-title" href="#">了解車型</a>
            <a class="nav-title" href="#">活動</a>
            <a class="nav-title" href="#">精品商城</a>
            <a class="nav-title" href="#">尋找最近的展示中心</a>
            <div class="nav-member">
                <a href="#"><img src="image/member.png" alt="member-icon">會員專區</a>
            </div>
        </div>
       
            <div id="container">
                <nav style="margin-top:100px">
                    <button id="secondHalfYear" class="2021070120211231">2021年07-12月</button>
                    <button id="firstHalfYear" class="2021010120210630">2021年01-06月</button> 
                    <button id="secondHalfYear2020" class="2020070120201231">2020年07-12月</button> 
                </nav>

                <!--         <form action="SearchByKey" method="get">
           關鍵字搜尋:<input type="text" name="keywords">
           <input type="submit" value="搜尋">
           </form> -->

                <c:forEach items="${sessionScope.newses}" var="news">
                    <ol>
                        <li><img src="data:image/png;base64,${news.base64Image}" width="563" height="350" /></li>
                        <li><strong>${news.title}</strong></li>
                        <li>${news.subtitle}<a href="DisplayOneNews?id=${news.id}">看更多資訊<i class="fas fa-angle-right"></i></a></li>
                    </ol>
                    <br>
                    <br>
                </c:forEach>

            </div>
            
            </div>
             

        </body>

        </html>