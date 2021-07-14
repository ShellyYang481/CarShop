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

import com.google.gson.Gson;
import com.project.bean.NewsBean;
import com.project.common.DataBaseConnection;
import com.project.dao.NewsDao;
import com.project.daoImpl.NewsDaoImpl;

/**
 * Servlet implementation class NewsForUser
 */
@WebServlet("/NewsForUser")
public class NewsForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsForUser() {
        super();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBaseConnection dbc = new DataBaseConnection();
		try {
	    	DataSource ds;
			try {
				ds = dbc.openDataSource();
				conn = ds.getConnection();
				System.out.println("Connected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			NewsDao newsDao = new NewsDaoImpl(conn);
			ArrayList<NewsBean> newses = newsDao.queryAll();
//			for(NewsBean news:newses) {
//				System.out.println(news);
//			}
//			String json = new Gson().toJson(newses);
//			request.getSession().setAttribute("jsonNewses", json);
//			request.getSession().setAttribute("toJsonnewses", newses);
			request.getSession().setAttribute("newses", newses);
			conn.close();
			System.out.println("Connection closed");
			request.getRequestDispatcher("userhome.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
