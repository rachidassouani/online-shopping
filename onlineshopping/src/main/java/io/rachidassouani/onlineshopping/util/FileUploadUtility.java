package io.rachidassouani.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	private static final String ABSOLUTE_PATH = "/home/rassouani/eclipse-workspace/online-shopping/onlineshopping/src/main/webapp/assets/images/";
	private static String REAL_PATH = "";
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// getting the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		if (!new File(ABSOLUTE_PATH).exists()) {
			new File(ABSOLUTE_PATH).mkdirs();
		}
		
		try {
			// uploading ... project directory upload
			file.transferTo(new File(ABSOLUTE_PATH + code + ".jpg"));
			
			// uploading ... for the server
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
