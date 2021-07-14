<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.project.bean.NewsBean"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯最新消息</title>
<link rel="stylesheet" href="/carproject/CSS/newstemplate.css"> 
<script src="/carproject/jquery-3.6.0.js"></script>
<script src="/carproject/js/previewImage.js"></script>
<script src="js/editNewsDataValidation.js"></script>
<style>
    span{
        width: 10px;
        font-size:10px; 
        color:red
    }
</style>
</head>
<body>
   <header>
        <h2>編輯最新消息</h2>
    </header>
    <div id="container">
    <form id="form"action="UpdateNews" method="post" enctype="multipart/form-data">
	 	<input type="hidden" name="id" value="${news.id}">
	 
    	<table class="box">
				<tr><td>標題
				<tr><td><input class="myitem" id="title" type="text" name="title" value="${news.title}" style="width:500px">
				 <span id="sp1" style="width:10px ;"></span>
				   <img src="">
				</td>
				<tr><td>副標題
				<tr><td><input class="myitem" id="subtitle" type="text" name="subtitle" value="${news.subtitle}" style="width:500px">	
        		<span id="sp2" style="width:10px "></span>
        		  <img src="">
				</td>
				<tr><td>上傳日期
				<tr><td><input class="myitem" id="uploaddate" type="date" name="uploadDate" value="${news.uploadDate}"/>
				 <span id="sp3" style="width:10px;"></span>
				   <img src="">
				</td>
				
				<tr><td>內文
				<tr><td><textarea class="myitem" id="content" name="content" rows="30" cols="70">${news.content}</textarea>
				<span id="sp4" style="width:10px;"></span>
				  <img src="">
				</td>
				
				<tr><td>圖片
				<tr><td>
				<div class="image">
				<img class="myitem" src="data:image/png;base64, ${news.base64Image}" width="200" height="200"/><img class="myitem" id="preview_img"  width="200" height="200"/>
				
				</div>
				<input id="input" type="file" name="image"/></td>
			    <tr><td>備註
			    <tr><td><input class="myitem" name="remarks" value="${news.remarks}" style="width:500px"></td>
				
				
				</table>
				<input type="submit" id="submitid" value="確認修改">
				</form>
			</div>
			
</body>

</html>