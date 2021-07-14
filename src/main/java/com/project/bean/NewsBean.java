package com.project.bean;

import java.io.Serializable;



import lombok.Data;

@Data
public class NewsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String subtitle;
	private String uploadDate;
	private String content;
	private byte[] image;

	private String remarks;
	private String base64Image;
	
	

	public NewsBean() {

	}


}
