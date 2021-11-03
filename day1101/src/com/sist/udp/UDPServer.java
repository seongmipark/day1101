package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer {
	public static void main(String[] args) {
		//데이터를 주고받기 위해서 DatagramSocket객체를 생성
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//보내오는 데이터를 담기위한 byte의 배열을 만든다
			byte []data = new byte[100];
			
			//sender가 보내오는 데이터를 받기 위해 DatagramPacket객체를 생성
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			
			System.out.println("Receiver가 동작되었습니다.");
			
			//Sender가 보내오는 데이터를 계속 받기 위하여 문한 반복문으로 표현
			while(true) {
				//DatagramSocket의 receive메소드를 통해 데이터를 받는다.
				socket.receive(packet);
				
				//진짜로 받아진 데이터는 byte의 배열인(패킷을 만들때 준 배열) data에 담아져있다.
				//이것을 String생성자를 이용하여 문자열로 만든다.  String(byte[] bytes)
				String msg = new String(data);
				System.out.println("수신된 데이터:"+msg.trim());
				
				//다음에 수신되는 데이터를 위하여 byte의 배열 data를 비워준다.
				Arrays.fill(data, (byte)0);
				
			}
			
			} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
			}
	}
}
