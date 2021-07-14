<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${news.title}</title>
	<script src="jquery-3.6.0.js"></script>
	<script src="js/sortByMonth.js"></script>
<link rel="stylesheet" href="CSS/userInterface.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

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
                <nav  style="margin-top:100px">
                    <button id="secondHalfYear" class="2021070120211231">2021年07-12月</button>
                    <button id="firstHalfYear" class="2021010120210630">2021年01-06月</button> 
                </nav>    

                    <ol>
                        <li>${news.uploadDate}</li>
                        <li style="font-size:25px"><strong>${news.title}</strong></li>
                        <li><img src="data:image/png;base64,${news.base64Image}" width="563" height="350" /></li>
                        <li>${news.subtitle}</li>
                        <li>${news.content}</li>
                        <li>${news.remarks}</li>
                    </ol>
                  
					<a href="NewsForUser"><img src="image/goBack.jpg"></a>
            </div>
            </div>
         
</body>
</html>