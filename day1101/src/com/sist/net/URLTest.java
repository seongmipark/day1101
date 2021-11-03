package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//���ͳݻ��� ������ü�� �����Ѵ�
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
		
			//�� ������ ������ �о���̱� ���Ͽ� ��Ʈ���� �����Ѵ�
			InputStream is = url.openStream();
			
			//�ѹ��� �о���� byte���� �迭�� �����.
			byte []data = new byte[100];
			
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ �����,
			String str = "";
			
			//��Ʈ���� ���� �ƴҶ����� 100byte�� �о���δ�.
			while( is.read(data) != -1) {
				
				//�о���� btye�迭�� �����͸� ���ڿ��� ����� �����Ѵ�. 
				//str += new String(data);					
				
				//�ѱ۷� ó���ϱ�
				str += new String(data,"utf-8");	
			}
			
			//��ü ������ ���ڿ� ������ ����Ѵ�.
			System.out.println(str);
			
			//��Ʈ���� �ݾ��ش�.
			is.close();
		
		
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
			
		}

	}

}
