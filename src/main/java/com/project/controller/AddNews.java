package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
@MultipartConfig
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		NewsBean news = new NewsBean();
		// NewsSqlExecute newsDao = new NewsSqlExecute();
//		out.print(request.getParameter("title"));
//	
//		out.print(request.getParameter("subtitle"));
//		out.print(request.getParameter("uploadDate"));
//		out.print(request.getParameter("content"));
//		out.print(request.getParameter("image"));
//		out.print(request.getParameter("remarks"));

		news.setTitle(request.getParameter("title"));
		news.setSubtitle(request.getParameter("subtitle"));
		news.setUploadDate(request.getParameter("uploadDate"));
		news.setContent(request.getParameter("content"));
		byte[] bt = UploadFileUtils.convertToBytesArrays(request.getPart("image"));
		news.setImage(bt);
		news.setRemarks(request.getParameter("remarks"));
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			DataSource ds = dbc.openDataSource();
			Connection conn = ds.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			newsDao.insertData(news);
			response.sendRedirect("Home");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
