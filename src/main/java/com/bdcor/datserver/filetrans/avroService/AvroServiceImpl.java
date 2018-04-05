package com.bdcor.datserver.filetrans.avroService;

import java.util.Map;

import org.apache.avro.AvroRemoteException;

import com.bdcor.datserver.filetrans.Constant;
import com.bdcor.datserver.filetrans.avro.proto.FileData;
import com.bdcor.datserver.filetrans.avro.proto.HandleResult;
import com.bdcor.datserver.filetrans.avro.proto.datFileTrans;
import com.bdcor.datserver.filetrans.service.IFileSaveService;
import com.bdcor.datserver.filetrans.service.impl.FileSaveServiceImpl;

public class AvroServiceImpl implements datFileTrans {

	
	IFileSaveService fileSaveService = new FileSaveServiceImpl();
	
	@Override
	public HandleResult convert(FileData fileData) throws AvroRemoteException {
		Map<CharSequence, CharSequence> paramParam = fileData.getParamsMap();
		
		String dirPath = null;
		String fileName = null;
		for(Object key:paramParam.keySet()){
			CharSequence value = paramParam.get(key);
			
			if(key.toString().equals(Constant.MAP_FILE_DIR_KEY)){
				dirPath = value.toString();
			}
			if(key.toString().equals(Constant.MAP_FILE_NAME_KEY)){
				fileName = value.toString();
			}
			
		}
		
		byte[] fileBytes = fileData.fileBytes.array();
		
		HandleResult handlerResult = new HandleResult();
		try{
			fileSaveService.saveFile(dirPath.toString(), fileName.toString(), fileBytes);
			handlerResult.setResultType(Constant.HANDLER_RESULT_SUC);	
			handlerResult.setResultStr("");	
		}catch(Exception e){
			handlerResult.setResultType(Constant.HANDLER_RESULT_FAILT);
			handlerResult.setResultStr(e.getMessage());	
		}
		
		
		
		
		return handlerResult;
	}

}
