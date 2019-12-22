package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServlet;

import org.apache.bsf.dbline.Buffer;

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
					OutputStream outputStream = clientSocket.getOutputStream();
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					// 读取其它tcpip端口发送的字符信息
					String msg = bufferedReader.readLine();
					if ("getDate".equals(msg)) {
						OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
						BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
						PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
						do{
							try {
								Thread.sleep(1000);
								printWriter.println("Server Date: " + new Date());
								printWriter.flush();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						while(true);
						//serverSocket.close();
					}
					if ("getTemprature".equals(msg)) {
						OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
						BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
						PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
						do{
							try {
								Thread.sleep(1000);
								printWriter.println("Server Date: " + new Date());
								printWriter.flush();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						while(true);
						//serverSocket.close();
					}
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
