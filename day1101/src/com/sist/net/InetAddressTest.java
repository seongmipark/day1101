package com.sist.net;


import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//InetAddress naver = InetAddress.getByName("www.naver.com");
			//System.out.println(naver); // ���̹��� ip�ּҰ� ��µȴ�.
		
			InetAddress []list = InetAddress.getAllByName("www.naver.com");
			for(InetAddress naver : list) {
				System.out.println(naver);
			}
			
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
