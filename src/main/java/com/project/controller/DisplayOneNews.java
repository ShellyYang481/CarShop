package com.project.controller;

import java.io.IOException;
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
 * Servlet implementation class DisplayOneNews
 */
@WebServlet("/DisplayOneNews")
public class DisplayOneNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOneNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBaseConnection dbc = new DataBaseConnection();
		try {
	    	DataSource ds;
	    	Connection conn = null;
	    	NewsBean news = new NewsBean();
			try {
				ds = dbc.openDataSource();
				conn = ds.getConnection();
				System.out.println("Connected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			NewsDao newsDao = new NewsDaoImpl(conn);
			int id = Integer.parseInt(request.getParameter("id"));
			news = newsDao.findById(id);

//				System.out.println(news);
			
			request.getSession().setAttribute("news", news);
			conn.close();
			System.out.println("Connection closed");
			request.getRequestDispatcher("displayNewsDetail.jsp").forward(request, response);
			
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
