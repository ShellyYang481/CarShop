<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
    <%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息確認</title>
</head>
<body>
<h2>
新增消息資料如下請確認
</h2>
<form action="AddNews" method="post" enctype="multipart/form-data">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#FFFFE1">
    <td>標題:</td>
    <% String title = request.getParameter("title");%>
    <td><%=title%></td>
  <input type="hidden" name="title" value="<%=title%>">
    
</tr>
<tr bgcolor="#F2F4FB">
    <td>副標題:</td>
        <% String subtitle = request.getParameter("subtitle");%>
    <td><%=subtitle%></td>
  <input type="hidden" name="subtitle" value="<%=subtitle%>">
</tr>
<tr bgcolor="#FFFFE1">
    <td>上傳日期:</td>
    <% String uploadDate = request.getParameter("uploadDate");%>
    <td><%=uploadDate%></td>
  <input type="hidden" name="uploadDate" value="<%=uploadDate%>">
</tr>
<tr bgcolor="#F2F4FB">
    <td width="150">內文:</td>
     <% String content = request.getParameter("content");%>
    <td><%=content%></td>
  <input type="hidden" name="content" value="<%=content%>">
</tr>
<tr bgcolor="#FFFFE1">
    <td>圖片</td>
       
        <% String imageName = request.getParameter("image");%>
    <td><%=imageName%></td>
  <input type="hidden" name="image" value="<%=request.getPart("image")%>">
</tr>
<tr bgcolor="#F2F4FB">
    <td>備註:</td>
     <% String remarks = request.getParameter("remarks");%>
    <td><%=remarks%></td>
  <input type="hidden" name="remarks" value="<%=remarks%>">
</tr>
</table>
<center>
<input type="submit" name="confirm" value="確認">
</center>
</form>
</body>
</html>