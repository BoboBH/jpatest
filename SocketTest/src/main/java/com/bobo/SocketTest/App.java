package com.bobo.SocketTest;


/**
 * Hello world!
 *
 */
public class App 
{
	private static final int PORT = 8990;
    public static void main( String[] args )
    {
        System.out.println( "Socket Test start running...........!" );
        if(args.length == 0){
        	runClient();
        }        
        else if("server".equals(args[0])){
        	runServer();
        }
    }
    private static void runServer(){
    	MyServer server = new MyServer(PORT);
    	server.start();
    }
    private static void runClient(){

    	System.out.println("Run client.........");
    	final MyClient client = new MyClient("localhost",PORT);
    	client.init();
    	Runnable receiver = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				client.startListener();
			}
		};
		Runnable sender = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				client.sendMessage();
			}
		};
		Thread tr = new Thread(receiver);
		Thread ts = new Thread(sender);
		tr.start();
		ts.start();
    }
}
