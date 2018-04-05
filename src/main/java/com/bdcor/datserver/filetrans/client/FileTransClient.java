package com.bdcor.datserver.filetrans.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.commons.lang.StringUtils;

import com.bdcor.datserver.filetrans.Constant;
import com.bdcor.datserver.filetrans.avro.proto.FileData;
import com.bdcor.datserver.filetrans.avro.proto.HandleResult;
import com.bdcor.datserver.filetrans.avro.proto.datFileTrans;

public class FileTransClient {

	private String ip = "";
	private int port = Constant.SERVER_PORT;
	public FileTransClient(String ip,String port){
		this.ip = ip;
		if(StringUtils.isNotBlank(port)){
			this.port = Integer.parseInt(port);
		}
	}
	
	
	public HandleResult fileTrans(String filePath,String fileName,byte[] bytes) throws IOException{
		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(ip,port));
        
		datFileTrans proxy = (datFileTrans) SpecificRequestor.getClient(datFileTrans.class, client);
       
		
		FileData fileData = toFileData(filePath,fileName,bytes);
        
		HandleResult result = proxy.convert(fileData);

        
        client.close();
        return result;
	}
	
	private FileData toFileData(String filePath,String fileName,byte[] bytes){
		FileData fileData = new FileData();
		Map<CharSequence, CharSequence> paramMap = new HashMap<CharSequence, CharSequence>();
		paramMap.put(Constant.MAP_FILE_DIR_KEY, filePath);
		paramMap.put(Constant.MAP_FILE_NAME_KEY, fileName);
		
		
		fileData.setParamsMap(paramMap);
		
		fileData.setFileBytes(ByteBuffer.wrap(bytes));
		
		return fileData;
	}
}
