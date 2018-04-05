package com.bdcor.datserver.filetrans.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.bdcor.datserver.filetrans.service.IFileSaveService;

public class FileSaveServiceImpl implements IFileSaveService {

	@Override
	public void saveFile(String dirPath, String fileName, byte[] fileBytes)
			throws RuntimeException {
		Properties prop = new Properties();
		InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
		try {
			prop.load(in);
			String rootPath = prop.getProperty("upload_file_path");
			String fileDirAndName = rootPath+File.separator+dirPath+File.separator+fileName;
			FileUtils.writeByteArrayToFile(new File(fileDirAndName), fileBytes);
			
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
