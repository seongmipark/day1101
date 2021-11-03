package com.sist.tcp;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		try {
			//1.서버소켓을 생성한다.
			ServerSocket server = new ServerSocket(9001);
				System.out.println("서버가 가동되었습니다.");			 
			
			//2.클라이언트의 접속을 무한대기상태로 기다려야 한다.
			while(true) {
				
				//3.클라이언트의 접속을 수락한다.
				//이 메소드는 연결을 요청한 클라이언트와 통신을 하기 위한
				//소켓 객체를 반환한다. 이런 소켓을 데이터 소켓이라 한다.
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속했습니다.");
				
				//4.데이터를 주고 받을 스트림을 생성한다.
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				Thread.sleep(1000);
				
				//5.스트림을 통해 데이터를 주고 받는다
				//요청한 클라이언트한테 10개의 정수를 난수로 만들어 내보도록 합시다.
				for(int i =1;i<=10;i++) {
					int n = r.nextInt(100);
					//0에서 100사이의 난수를 만든다

					System.out.println("서버가 난수 하나를 만들었습니다."+n);
					
					Thread.sleep(1000);
					//0.1초 대기시간		
					
					os.write(n);
					//그 난수를 클라이언트에게 출력한다
					

				}
				
				System.out.println("클라이언트에게 데이터를 모두 내보냈습니다.");
				
				//6.사용했던 자원들을 닫아준다.
				is.close();
				os.close();
				socket.close();
				
			}
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		

	}

}

