package com.vengeang.minipos.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {
	public static String saveFile(String fileServerPath,MultipartFile multipartFile) throws IllegalStateException, IOException {
		LocalDateTime now = LocalDateTime.now();
        String timeStamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String fileName = "";
		String originalFile = multipartFile.getOriginalFilename();
		int lastIndex = originalFile.lastIndexOf(".");
        if(lastIndex == -1){
            fileName = timeStamp;
        }
        String fileExtension = originalFile.substring(lastIndex);
        fileName = timeStamp + fileExtension;
		String destinationPath = fileServerPath + fileName;
		multipartFile.transferTo(new File(destinationPath));
		return fileName;
	}
}
