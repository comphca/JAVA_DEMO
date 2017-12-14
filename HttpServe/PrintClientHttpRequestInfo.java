package Server;
/*
 * 
 * 打印 客户端HTTP请求信息  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 创建服务器  并 启动
 */
public class PrintClientHttpRequestInfo {
	private ServerSocket server;
	
	public static void main(String[] args) throws IOException {
		PrintClientHttpRequestInfo ser = new PrintClientHttpRequestInfo();
		ser.start();
	}
	
	/*
	 * 启动方法
	 */
	public void start(){
		try {
			server = new ServerSocket(8888);

			this.receive(); //启动的时候就调用接收
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 接受客户端
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			
			//接收客户端请求的信息
			StringBuilder sb = new StringBuilder();
			String msg = null;
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));
			
			while((msg = br.readLine()).length() > 0){
				sb.append(msg);
				sb.append("\r\n");
				if(null == msg){
					break;
				}
			}
			System.out.println(sb.toString().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 停止服务器
	 */
	public void stop(){
		
	}
}
