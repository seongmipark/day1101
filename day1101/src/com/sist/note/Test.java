package com.sist.note;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "�޸�.txt";
		//String []arr = data.split(".");
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		
		//��ħǥ(.)���δ� �и��� �� ����.
	
		//���ϸ��� ��ħǥ(.)���ִ� ��ġ�� �˾Ƴ���
		//���ڿ��� ó������ ��ħǥ���� ����
		String result = data.substring(0, data.indexOf("."));
		System.out.println(result);		
		
	
	
	}

}
