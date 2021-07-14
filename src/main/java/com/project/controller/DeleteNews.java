package com.project.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.common.DataBaseConnection;
import com.project.dao.NewsDao;
import com.project.daoImpl.NewsDaoImpl;

/**
 * Servlet implementation class DeleteNews
 */
@WebServlet("/DeleteNews")
public class DeleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			DataBaseConnection dbc = new DataBaseConnection();
			DataSource ds = dbc.openDataSource();
			Connection conn = ds.getConnection();
			 NewsDao newsDao = new NewsDaoImpl(conn);
//			 newsDao.deleteById(Integer.parseInt(request.getParameter("id")));
//			 System.out.println(request.getParameter("id"));
			 newsDao.deleteById(id);
			 System.out.println(id);
			 conn.close();
//			 request.getRequestDispatcher("/Home").forward(request, response);
			 response.sendRedirect("Home");
			 
		} catch (Exception e) {
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
