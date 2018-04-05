package com.bdcor.datserver.filetrans;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;

import com.bdcor.datserver.filetrans.avro.proto.datFileTrans;
import com.bdcor.datserver.filetrans.avroService.AvroServiceImpl;

public class ServiceMain {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if (args.length != 1) {
            System.out.println("服务ip必须填写");
            System.exit(1);
        }
		
		ip = args[0];
		
		startServer();
		
		System.in.read();
	}
	
    
	public static String ip = "";
	private static int port = Constant.SERVER_PORT;
	private static Server server;
    public static void startServer() throws IOException {
        server = new NettyServer(new SpecificResponder(datFileTrans.class, new AvroServiceImpl()), new InetSocketAddress(ip,port));
    }
}
