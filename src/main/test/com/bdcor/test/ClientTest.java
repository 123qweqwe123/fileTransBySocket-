package com.bdcor.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.bdcor.datserver.filetrans.avro.proto.HandleResult;
import com.bdcor.datserver.filetrans.client.FileTransClient;

public class ClientTest {

	@Test
	public void clientTest() throws IOException{
		
		FileTransClient client = new FileTransClient("172.31.131.144",null);
		
		HandleResult handleResult = client.fileTrans("13","text.txt",FileUtils.readFileToByteArray(new File("h://1.txt")));
		
		
		
	}
}
