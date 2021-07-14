package com.project.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.bean.NewsBean;

public interface NewsDao {

	void insertData(NewsBean news) throws FileNotFoundException;

	// 透過id查詢新聞資訊
	NewsBean findById(int id);

	// 透過id刪除一筆活動資料
	void deleteById(int id);

	//透過News物件更新新聞
	void updateNews(NewsBean news);

	// 查詢完整table資料
	ArrayList<NewsBean> queryTable() throws SQLException, IOException;

	//使用者查詢新聞資訊
	ArrayList<NewsBean> queryAll() throws SQLException;

	//關鍵字查詢
	ArrayList<NewsBean> searchByKeywords(String keywords);
	
	//依照月份顯示新聞
	ArrayList<NewsBean> queryTableByMonth(String startMonth,String endMonth) throws SQLException, IOException;
	
	
}