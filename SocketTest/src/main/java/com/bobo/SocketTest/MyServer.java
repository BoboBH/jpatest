package com.bobo.SocketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	private static final int MESSAGE_COUNT= 100;
	
	private int port;
	public MyServer(int port){
		this.port = port;
	}
	
	public void start(){
		System.out.println("Start run socket server............");
		try {
			ServerSocket ss = new ServerSocket(port);
			while(true){
				System.out.println("it is ready to be connected....");
				Socket socket = ss.accept();
				ServerHandler sh = new ServerHandler(socket);
				new Thread(sh).start();;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
