package com.sist.echo02;

//���� : �����غ���
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class UDPCharServer {
	public static void main(String[] args) {
		try {	
			
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ������� byte�� �迭�� �����.
		byte []data = new byte[100];


			while(true) {
				DatagramSocket socket = new DatagramSocket();
				DatagramPacket packet = new DatagramPacket(data, data.length);
				//Socket socket = server.accept();
				
				while(true) {
					socket.receive(packet);
				
					//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�.
					String msg = new String(data);
					System.out.println("���ŵ� ������:"+ msg.trim());
					
					//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�.
					socket.send(packet);
					
					//������ ���ŵ� �����͸� ���Ͽ� �迭�� ������ ����ش�.
					Arrays.fill(data, (byte)0);
				}
			}
		} catch (Exception e) {
		
		}
	}

}
