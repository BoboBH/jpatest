package com.bobo.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

	private static final int BUFFER_SIZE=65536;
	private static final int MESSAGE_COUNT = 1000;
	private Socket socket;
	private String host;
	private int port;
	private InputStream in;
	private OutputStream os;

	public MyClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void startListener(){
		byte[] buff = new byte[BUFFER_SIZE];
		String message = "";
		while(true){
			try {
				int length = in.read(buff);
				if(length > 0)
				{
					message=new String(buff,0,length,"UTF-8");
					System.out.println("Receive a server Message:" + message);
					if("exit".equals(message))
						this.socket.close();
				}
				else{
					try {
						System.out.println("No message received and will sleep 1 second");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMessage(){
		int round = 1;
		String message = "";
		while(true){
			try{
				for(int i = 0; i< MESSAGE_COUNT;i++){
					if(round == 10)
						message = "exit";
					else{
						message = "Client Message: round=" + round + "; index=" + i;
					}
					os.write(message.getBytes("UTF-8"));
					os.flush();
					Thread.sleep(1000);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("Finish round " + round + " and will sleep for 30 seconds...");
			try {
				Thread.sleep(30 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			round++;
		}
	}
	
	public void init() {
		try {
			this.socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reconnect() {

		try {
			if (in != null)
				in.close();
			if(os != null)
				os.close();
			if(socket != null)
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.init();
		
	}

}
