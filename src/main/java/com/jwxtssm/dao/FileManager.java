package com.jwxtssm.dao;

import com.jwxtssm.exception.CustomException;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Repository
public class FileManager {
	public static void removeFile(String address) throws CustomException {
		File file = new File(address);
		if (file.exists()) {
			file.delete();
		} else {
			throw new CustomException("操作:删除文件,文件不存在!");
		}
	}

	public static boolean addFile(MultipartFile multipartFile, String fullFileName) throws CustomException {
		if (!multipartFile.isEmpty()) {
			File tempFile = new File(fullFileName);
			if (tempFile.exists()) throw new CustomException("操作:写入文件,文件已经存在,写入失败!");
			try {
				multipartFile.transferTo(tempFile);
			} catch (IOException e) {
				e.printStackTrace();
				throw new CustomException("操作:写入文件,IO错误!");
			}
			return true;
		} else {
			return false;
		}
	}
}
