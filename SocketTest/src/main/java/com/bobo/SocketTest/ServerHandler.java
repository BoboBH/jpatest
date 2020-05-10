package com.bobo.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class ServerHandler implements Runnable{

	private final static int MESSAGE_COUNT=100;
	private final static int BUFFER_SIZE = 65536;
	private Socket socket;
	
	public ServerHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		new Thread( new Runnable() {
			
			public void run() {
				
				try {
					startListener();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					sendMessage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void startListener() throws IOException{
		System.out.println("Start listenting client.......");
		InputStream is = this.socket.getInputStream();
		byte[] buff = new byte[BUFFER_SIZE];
		try {
			while(true){
				int length = is.read(buff);
				if(length == 0){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String message = new String(buff,0,length,"UTF-8");
				System.out.println("Receive a Client message:" + message);
				if("exit".equals(message)){
					this.socket.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage() throws IOException{
		OutputStream os = this.socket.getOutputStream();
		int round = 1;
		while(true){
			System.out.println("Start sending message at round "+ round);
			for(int i = 0; i< MESSAGE_COUNT; i++){
				String message = "SERVER MESSAGE:ROUND=" + round +":" + "INDEX=" + i;
				os.write(message.getBytes("UTF-8"));
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Finish round " + round + " and Sleep for 1 minute for next round");
			round++;
		}
	}
	
}
