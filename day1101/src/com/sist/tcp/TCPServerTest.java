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
			//1.���������� �����Ѵ�.
			ServerSocket server = new ServerSocket(9001);
				System.out.println("������ �����Ǿ����ϴ�.");			 
			
			//2.Ŭ���̾�Ʈ�� ������ ���Ѵ����·� ��ٷ��� �Ѵ�.
			while(true) {
				
				//3.Ŭ���̾�Ʈ�� ������ �����Ѵ�.
				//�� �޼ҵ�� ������ ��û�� Ŭ���̾�Ʈ�� ����� �ϱ� ����
				//���� ��ü�� ��ȯ�Ѵ�. �̷� ������ ������ �����̶� �Ѵ�.
				Socket socket = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�.");
				
				//4.�����͸� �ְ� ���� ��Ʈ���� �����Ѵ�.
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				Thread.sleep(1000);
				
				//5.��Ʈ���� ���� �����͸� �ְ� �޴´�
				//��û�� Ŭ���̾�Ʈ���� 10���� ������ ������ ����� �������� �սô�.
				for(int i =1;i<=10;i++) {
					int n = r.nextInt(100);
					//0���� 100������ ������ �����

					System.out.println("������ ���� �ϳ��� ��������ϴ�."+n);
					
					Thread.sleep(1000);
					//0.1�� ���ð�		
					
					os.write(n);
					//�� ������ Ŭ���̾�Ʈ���� ����Ѵ�
					

				}
				
				System.out.println("Ŭ���̾�Ʈ���� �����͸� ��� �����½��ϴ�.");
				
				//6.����ߴ� �ڿ����� �ݾ��ش�.
				is.close();
				os.close();
				socket.close();
				
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		

	}

}

