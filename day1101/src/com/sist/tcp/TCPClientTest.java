package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {
	
	public static void main(String[] args) {
	try {
		//1.������ ����� ��û
		Socket socket = new Socket("192.168.0.27",9001);
		//Socket socket = new Socket("127.0.0.1",9001);
		//Socket socket = new Socket("localhost",9001);
		
		//2.������ ���Ͽ� �����͸� �ְ� ���� ��Ʈ���� �����Ѵ�.
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		//3.��Ʈ���� ���Ͽ� �����͸� �ְ� �޴´�.
		//������ �������� 10���� ������ �о�鿩 ȭ�鿡 ����ϱ�
		for(int i =1;i<=10;i++) {
			int n = is.read();
			System.out.println("�����κ��� ���ŵ� ������:"+n);
			
			Thread.sleep(200);
		}
		
		//4.����ߴ� �ڿ��� �ݾ��ش�.
		is.close();
		os.close();
		socket.close();
		
		
	} catch (Exception e) {
		System.out.println("���ܹ߻�:"+e.getMessage());
	}
			
	}

}
