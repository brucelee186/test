package tcpip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	
	public static void main(String[] args) {
	    
        try {
			Socket socket = new Socket("192.168.0.211", 8266);  
			OutputStream outputStream = socket.getOutputStream();  
			outputStream.write(("Hello server with java").getBytes());  
			outputStream.flush();  
			System.out.println(socket);  
			  
			while(true){
				InputStream is = socket.getInputStream();  
				byte[] bytes = new byte[1024];  
				int n = is.read(bytes);  
				System.out.println(new String(bytes, 0, n));  
			}
			  
//			is.close();  
//			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
