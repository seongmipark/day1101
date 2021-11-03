//java UDPSender 192.168.0.27 �ȳ� -> args[0]: ip�ּ� / arg[1]:msg
//java UDPSender 192.168.0.27 �ݰ����ϴ�


package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
	public static void main(String[] args) {
		
		
		String ip = args[0];
		String msg = args[1];
		
		
		//udp��Ŀ��� �����͸� �ְ�ޱ� ���ؼ��� DatagramSocket�� �ʿ��ϴ�.
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket(9002);
		
			//�������� �ּ� ip�� ���� inetAddress��ü�� �����Ѵ�.
			InetAddress addr = InetAddress.getByName(ip);
			
			//�����ϰ��� �ϴ� ���ڿ� msg�� byte�� �迭�� �����.
			byte []data = msg.getBytes();
			
			//udp����� ���������� ���� ��Ŷ�� �����Ѵ�.
			DatagramPacket packet = new DatagramPacket(data, data.length, addr , 9002);
			
			//DatagramSocket�� send�޼ҵ带 ���� �����͸� ����
			socket.send(packet);
			
			//������ �ݾ��ش�
			socket.close();
		
		} catch (Exception e) {
		System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
