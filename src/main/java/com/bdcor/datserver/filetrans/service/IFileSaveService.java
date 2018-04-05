package com.bdcor.datserver.filetrans.service;


public interface IFileSaveService{

	void saveFile(String dirPath,String fileName,byte[] fileBytes) throws RuntimeException;
	
}
