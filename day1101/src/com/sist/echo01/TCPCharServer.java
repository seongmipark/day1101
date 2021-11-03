package com.sist.echo01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPCharServer {
	public static void main(String[] args) {
		
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ������� byte�� �迭�� �����.
		byte []data = new byte[100];
		
		try {
		//1. ServerSocket�� ���� ������ �����Ѵ�
			ServerSocket server = new ServerSocket(9003);
			
			while(true) {//���Ѵ����·� Ŭ���̾�Ʈ�� ������ ��ٸ���.
				//Ŭ���̾�Ʈ�� ��û�� �����Ѵ�.
				Socket socket = server.accept();
				
				//���ϰ�ü�� ���ؼ� �����͸� �ְ���� ��Ʈ���� ����
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				
				//����� Ŭ���̾�Ʈ�ο� ����Ͽ� �����͸� �ְ�ޱ� ���Ͽ� �ݺ��� �̿�
				while(true) {
					//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�.
					is.read(data);
					String msg = new String(data);
					System.out.println("���ŵ� ������:"+ msg.trim());
					
					//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�.
					os.write(data);
					
					//������ ���ŵ� �����͸� ���Ͽ� �迭�� ������ ����ش�.
					Arrays.fill(data, (byte)0);
				}
			}
		} catch (Exception e) {
		
		}
	}

}
