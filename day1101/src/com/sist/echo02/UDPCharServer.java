package com.sist.echo02;

//숙제 : 내가해본거
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class UDPCharServer {
	public static void main(String[] args) {
		try {	
			
		//클라이언트로부터 수신된 데이터를 담기위한 byte의 배열을 만든다.
		byte []data = new byte[100];


			while(true) {
				DatagramSocket socket = new DatagramSocket();
				DatagramPacket packet = new DatagramPacket(data, data.length);
				//Socket socket = server.accept();
				
				while(true) {
					socket.receive(packet);
				
					//클라이언트로부터 데이터를 수신한다.
					String msg = new String(data);
					System.out.println("수신된 데이터:"+ msg.trim());
					
					//클라이언트로부터 수신된 데이터를 그대로 메아리한다.
					socket.send(packet);
					
					//다음에 수신될 데이터를 위하여 배열을 깨끗이 비워준다.
					Arrays.fill(data, (byte)0);
				}
			}
		} catch (Exception e) {
		
		}
	}

}
