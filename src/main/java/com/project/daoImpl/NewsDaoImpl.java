package com.project.daoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.project.bean.NewsBean;
import com.project.common.DataBaseConnection;
import com.project.dao.NewsDao;


public class NewsDaoImpl implements NewsDao {
	
	public NewsDaoImpl(Connection conn) {
		this.conn=conn;
	}



	DataBaseConnection utils=new DataBaseConnection ();
	private Connection conn;
    
    @Override
	public void insertData(NewsBean news) throws FileNotFoundException{
		String sqlStr="Insert into Carnews(Title, Subtitle, UploadDate, Content, Img, Remarks)"
				+"Values(?,?,?,?,?,?)";
		try {

			PreparedStatement preState = conn.prepareStatement(sqlStr);
			preState.setString(1, news.getTitle());
			preState.setString(2, news.getSubtitle());
			preState.setString(3, news.getUploadDate());
			preState.setString(4, news.getContent());
			preState.setBytes(5, news.getImage());
			preState.setString(6, news.getRemarks());
			preState.execute();
			System.out.println("Insert completed!");
			preState.close();

		} catch (SQLException e) {
			System.out.println("insert data failed!");
			e.printStackTrace();
		}
	}
		
		// 透過id查詢新聞資訊
		@Override
		public NewsBean findById(int id) {
			String sqlStr = "select * from Carnews where ID = ?";
			NewsBean news = new NewsBean();
			try {
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setInt(1, id);
				ResultSet rs = preState.executeQuery();
				if(rs.next()) {
					news.setId(id);
					news.setTitle(rs.getString(2));
					news.setSubtitle(rs.getString(3));
					news.setUploadDate(rs.getString(4));
					news.setContent(rs.getString(5));
					String base64Image = Base64.getEncoder().encodeToString(rs.getBytes(6));
					news.setBase64Image(base64Image);
					news.setImage(rs.getBytes(6));
					news.setRemarks(rs.getString(7));
				}
			} catch (SQLException e) {
				System.out.println("Something went wrong!");
				e.printStackTrace();
			}
			return news;

		}
		
		// 透過id刪除一筆活動資料
		@Override
		public void deleteById(int id) {
			String sqlStr = "delete from Carnews where ID = ?";
			try {
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setInt(1, id);
				preState.execute();
				preState.close();

			} catch (SQLException e) {
				System.out.print("Something went wrong!");
			}

		}
		
		//透過News物件更新新聞
		@Override
		public void updateNews(NewsBean news) {
			String sqlStr = "Update Carnews set Title = ?, Subtitle=?, UploadDate=?, Content=?, Img=?, Remarks=? where id = ?";
			try {
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setString(1, news.getTitle());
				preState.setString(2, news.getSubtitle());
				preState.setString(3, news.getUploadDate());
				preState.setString(4, news.getContent());
				preState.setBytes(5, news.getImage());
				preState.setString(6, news.getRemarks());
				preState.setInt(7, news.getId());
				preState.execute();
				System.out.println("Insert completed!");
				preState.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		// 查詢完整table資料
		@Override
		public ArrayList<NewsBean> queryTable() throws SQLException, IOException {
			String sqlStr = "Select * from Carnews";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			ResultSet rs = preState.executeQuery();
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();
			while (rs.next()) {
				NewsBean news = new NewsBean();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setSubtitle(rs.getString(3));
				news.setUploadDate(rs.getString(4));
				news.setContent(rs.getString(5));
				String base64Image = Base64.getEncoder().encodeToString(rs.getBytes(6));
				news.setBase64Image(base64Image);
				news.setImage(rs.getBytes(6));
				news.setRemarks(rs.getString(7));
				list.add(news);
			}
			rs.close();
			preState.close();
			return (ArrayList<NewsBean>) list;
			
		}
		//使用者查詢新聞資訊
		@Override
		public ArrayList<NewsBean> queryAll() throws SQLException {
			String sqlStr = "Select * from Carnews";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			ResultSet rs = preState.executeQuery();
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();
			while (rs.next()) {
				NewsBean news = new NewsBean();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setSubtitle(rs.getString(3));
				news.setUploadDate(rs.getString(4));
//				System.out.println("substring"+subStr);
				news.setContent(rs.getString(5));
//				System.out.println("圖片的Bytes array="+ rs.getBytes(6));
				String base64Image = Base64.getEncoder().encodeToString(rs.getBytes(6));
				//System.out.println("base64Image="+base64Image);
				news.setBase64Image(base64Image);
				news.setRemarks(rs.getString(7));
				list.add(news);
			}
			rs.close();
			preState.close();
			return (ArrayList<NewsBean>) list;
			
		}
	
	    //關鍵字查詢
	    @Override
		public ArrayList<NewsBean> searchByKeywords(String keywords) {
			String sqlStr = "select * from Carnews where content like '%'+?+'%'";
			ResultSet rs = null;
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();

			try {
				System.out.println("keywords="+keywords);

				PreparedStatement preState = conn.prepareStatement(sqlStr);

				preState.setString(1, keywords);

				rs = preState.executeQuery();
				while (rs.next()) {

					NewsBean news = new NewsBean();
					news.setId(rs.getInt(1));
					news.setTitle(rs.getString(2));
					news.setSubtitle(rs.getString(3));
					news.setUploadDate(rs.getString(4));
					news.setContent(rs.getString(5));
					String base64Image = Base64.getEncoder().encodeToString(rs.getBytes(6));
					news.setBase64Image(base64Image);
					news.setImage(rs.getBytes(6));
					news.setRemarks(rs.getString(7));
					list.add(news);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return (ArrayList<NewsBean>) list;

		}

	@Override
	public ArrayList<NewsBean> queryTableByMonth(String startMonth,String endMonth) throws SQLException, IOException {
		String sqlStr = "Select * from Carnews where uploadDate BETWEEN ? and ?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setString(1, startMonth);
		preState.setString(2, endMonth);
		ResultSet rs = preState.executeQuery();
		ArrayList<NewsBean> list = new ArrayList<NewsBean>();
		while (rs.next()) {
			NewsBean news = new NewsBean();
			news.setId(rs.getInt(1));
			news.setTitle(rs.getString(2));
			news.setSubtitle(rs.getString(3));
			news.setUploadDate(rs.getString(4));
			news.setContent(rs.getString(5));
			String base64Image = Base64.getEncoder().encodeToString(rs.getBytes(6));
			news.setBase64Image(base64Image);
			news.setImage(rs.getBytes(6));
			news.setRemarks(rs.getString(7));
			list.add(news);
		}
		rs.close();
		preState.close();
		return (ArrayList<NewsBean>) list;
	}
	


}
