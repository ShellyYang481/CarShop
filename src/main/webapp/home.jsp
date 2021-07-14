<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.project.bean.NewsBean"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="CSS/newstemplate.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script src="/carproject/jquery-3.6.0.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/sweetalert.js"></script>

<style>
.input{
width:500px
}
</style>
</head>
<body>

    <header>
        <h2>最新消息查詢 Latest News</h2>
    </header>
        <div id="container">

 		<form action="SearchById" method="get">
		
		透過ID搜尋:<input type="text" name="newsid">
			<input class="input1" type="submit" value="確定">
		</form>
		
		  <form action="DeleteNews" method="get">
                透過ID刪除文章:<input class="input1" type="text" id="id" name="id">
                <input type="submit" value="刪除">
                </form> 
                
           <form action="SearchByKey" method="get">
           關鍵字搜尋:<input class="input1" type="text" name="keywords">
           <input type="submit" value="搜尋">
           </form>
           <a href="HTML/addNews.html">新增文章</a>
	<br>
	
		<table>
			<tr style="background-color: #F0F0F0">
				<th>ID編號
				<th>標題
				<th>副標題
				<th>上傳日期
				<th>內文
				<th>圖片
				<th>備註
  
 	<c:forEach items="${sessionScope.newses}" var="news">
			<tr>
			    <td>${news.id}</td>
				<td>${news.title}</td>
				<td>${news.subtitle}</td>
				<td>${news.uploadDate}</td>
				<td>${news.content}</td>
			 <td><img src="data:image/png;base64, ${news.base64Image}" width="100" height="100"/></td>
				<%-- <td>${news.image}</td>  --%>
                <td>${news.remarks}</td>
             
			 <td>
			 <form action="DeleteNews" method="get">
			 	<input id="deleteid" name="id" type="hidden" value="${news.id}">
			 	<button class="delete" type="button"><i class="fas fa-trash-alt"></i></button>
				<!-- <a class="delete"><i class="fas fa-trash-alt"></i></a>  
				 -->
				 </form>
				</td> 
				
				<td>
				<a href="EditNews?id=${news.id}"><i class="fas fa-edit"></i></a>
				</td>
                
				</tr>     
				
		</c:forEach>
			<!-- <td><form action="DeleteNews" method="get">
				
				<input type="hidden" name="id" value="${news.id}">
				
				<input type="submit" value="刪除"/>
				
				</form> -->
				
				<!-- <form action="edit.jsp" method="get">
				<input type="hidden" name="id" value="${news.id}">
				<input type="submit" value="修改">
				</form> -->
			 <!-- </td> -->

	   
		</table>
		
	</div>

	
</body>
</html>