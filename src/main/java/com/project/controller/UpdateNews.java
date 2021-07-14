package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.bean.NewsBean;
import com.project.common.DataBaseConnection;
import com.project.dao.NewsDao;
import com.project.daoImpl.NewsDaoImpl;
import com.project.utils.UploadFileUtils;

/**
 * Servlet implementation class UpdateNews
 */
@WebServlet("/UpdateNews")
@MultipartConfig
public class UpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 response.setContentType("text/html"); 
		  request.setCharacterEncoding("utf-8"); 
//		  response.setCharacterEncoding("utf-8");
		System.out.println("SUCESSFUL ! ! !");
		NewsBean news = new NewsBean();
		
		news.setTitle(request.getParameter("title"));
		news.setSubtitle(request.getParameter("subtitle"));
		news.setUploadDate(request.getParameter("uploadDate"));
		news.setContent(request.getParameter("content"));
		news.setImage(UploadFileUtils.convertToBytesArrays(request.getPart("image")));
		news.setRemarks(request.getParameter("remarks"));
		news.setId(Integer.parseInt(request.getParameter("id")));
		
//		System.out.println("title="+request.getParameter("title").trim());
//		System.out.println("subtitle="+request.getParameter("subtitle").trim());
//		System.out.println("uploadDate="+request.getParameter("uploadDate").trim());
//		System.out.println("content="+request.getParameter("content").trim());
//		System.out.println("image="+request.getParameter("image").trim());
//		System.out.println("remarks="+request.getParameter("remarks").trim());
		
		DataBaseConnection dbc = new DataBaseConnection();
		DataSource ds;
			try {
				ds = dbc.openDataSource();
				Connection conn = ds.getConnection();
				NewsDao newsDao = new NewsDaoImpl(conn);
				newsDao.updateNews(news);
				conn.close();
				response.sendRedirect("Home");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
