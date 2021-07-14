package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class SearchByKey
 */
@WebServlet("/SearchByKey")
public class SearchByKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByKey() {
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
		
		String keywords = request.getParameter("keywords");
		DataBaseConnection dbc = new DataBaseConnection();
		DataSource ds;
		ArrayList<NewsBean> list =null;
		try {
			ds = dbc.openDataSource();
			Connection conn = ds.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			list = newsDao.searchByKeywords(keywords);
			request.getSession().setAttribute("newses", list);
			request.getRequestDispatcher("newsKeywords.jsp").forward(request,response);
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
