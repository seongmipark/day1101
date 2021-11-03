package com.sist.net;


import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//InetAddress naver = InetAddress.getByName("www.naver.com");
			//System.out.println(naver); // 네이버의 ip주소가 출력된다.
		
			InetAddress []list = InetAddress.getAllByName("www.naver.com");
			for(InetAddress naver : list) {
				System.out.println(naver);
			}
			
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
