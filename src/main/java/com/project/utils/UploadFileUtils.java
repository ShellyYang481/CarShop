package com.project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class UploadFileUtils {

	public static byte[] convertToBytesArrays(Part filePart) throws IOException {

		
		
		InputStream fileContent = filePart.getInputStream();
		return IOUtils.toByteArray(fileContent);
			
		
	}
	
	
	public static byte[] base64ConvertToByte(String base64) {
		
		
		 byte[] res = Base64.getDecoder().decode(base64);
		 
		 return  res;
		
	}

}
