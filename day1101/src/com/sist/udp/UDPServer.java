package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer {
	public static void main(String[] args) {
		//�����͸� �ְ�ޱ� ���ؼ� DatagramSocket��ü�� ����
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//�������� �����͸� ������� byte�� �迭�� �����
			byte []data = new byte[100];
			
			//sender�� �������� �����͸� �ޱ� ���� DatagramPacket��ü�� ����
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			
			System.out.println("Receiver�� ���۵Ǿ����ϴ�.");
			
			//Sender�� �������� �����͸� ��� �ޱ� ���Ͽ� ���� �ݺ������� ǥ��
			while(true) {
				//DatagramSocket�� receive�޼ҵ带 ���� �����͸� �޴´�.
				socket.receive(packet);
				
				//��¥�� �޾��� �����ʹ� byte�� �迭��(��Ŷ�� ���鶧 �� �迭) data�� ������ִ�.
				//�̰��� String�����ڸ� �̿��Ͽ� ���ڿ��� �����.  String(byte[] bytes)
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+msg.trim());
				
				//������ ���ŵǴ� �����͸� ���Ͽ� byte�� �迭 data�� ����ش�.
				Arrays.fill(data, (byte)0);
				
			}
			
			} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
			}
	}
}
