package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.bean.NewsBean;
import com.project.common.DataBaseConnection;
import com.project.dao.NewsDao;
import com.project.daoImpl.NewsDaoImpl;

/**
 * Servlet implementation class SearchById
 */
@WebServlet("/SearchById")
public class SearchById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		String ID = request.getParameter("newsid");
		int id = Integer.parseInt(ID);
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			DataSource ds = dbc.openDataSource();
			Connection conn = ds.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			NewsBean news = new NewsBean();
			news = newsDao.findById(id);
			PrintWriter out = response.getWriter();
			out.write("<html>");
			out.write("<head>");
			out.write("<link rel='stylesheet' href='../carproject/CSS/newstemplate.css'>");
			out.write("</head>");
			out.write("<body>");
			out.write("<header>");
			out.print("<h2>查詢結果</h2>");
			out.print("<link rel='stylesheet' href='https://pro.fontawesome.com/releases/v5.10.0/css/all.css' integrity='sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p' crossorigin='anonymous'/>");
				
			out.write("</header>");
			out.write("<div id='container'>");
			
			out.print("<b>新聞ID編號:</b>");
			out.print(news.getId());
			out.write("<br>");
			out.write("<br>");
			out.print("<b>標題:</b>");
			out.print(news.getTitle());
			out.write("<br>");
			out.write("<br>");
			out.print("<b>副標題:</b>");
			out.print(news.getSubtitle());
			out.write("<br>");
			out.write("<br>");
			out.print("<b>上傳日期:</b>");
			out.print(news.getUploadDate());
			out.write("<br>");
			out.write("<br>");
			out.print("<b>內文:</b>");
			out.print(news.getContent());
			out.write("<br>");
			out.write("<br>");
			out.print("<b>圖片:</b>");
			out.print("<img src='data:image/png;base64,"+news.getBase64Image()+"' width='100' height='100'/>");
			out.write("<br>");
			out.write("<br>");
			out.print("<b>備註:</b>");
			out.print(news.getRemarks());
			out.write("<br>");
			out.write("<br>");
			out.write("<a href='Home' style='text-align:center; padding-left:450px'><i class=\"fas fa-home\"></i></a>");
			out.write("</div>");
			out.write("</body>");
			out.write("</html>");
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
