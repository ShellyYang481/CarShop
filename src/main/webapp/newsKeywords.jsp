<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,com.project.bean.NewsBean"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Keywords Search Result</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" href="/carproject/CSS/newstemplate.css"> 
</head>
<body>
  <header>
        <h2>關鍵字搜尋結果</h2>
    </header>
          <div id="container">
          <a href="Home"><i class="fas fa-home"></i>回到主頁面</a>
          <table>
			<tr style="background-color: #F0F0F0">
				<th>ID編號
				<th>標題
				<th>副標題
				<th>上傳日期
				<th>內文
				<th>圖片
				<th>備註
				</th>
          <c:forEach items="${sessionScope.newses}" var="news">
          <tr>
          <td>${news.id}</td>
          <td>${news.title}</td>
		<td>${news.subtitle}</td>
		<td>${news.uploadDate}</td>
		<td>${news.content}</td>
		<td><img src="data:image/png;base64, ${news.base64Image}" width="100" height="100"/></td> 
		<td>${news.remarks}</td>
          </tr>
          
          </c:forEach>
          </table>
          </div>
</body>
</html>