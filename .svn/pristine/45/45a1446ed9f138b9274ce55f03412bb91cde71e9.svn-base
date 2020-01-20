package tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.http.HttpServlet;

public class TestTCPIPSocket extends HttpServlet {
	
	private final static int port = 8266;
	@Override
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			try {
				while (true) {
					Socket clientSocket = serverSocket.accept();
					System.err.println("Listen Socket Start...");
					InputStream inputStream = clientSocket.getInputStream();
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					// 读取其它tcpip端口发送的字符信息
					System.err.println(bufferedReader.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
