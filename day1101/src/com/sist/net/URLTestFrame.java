package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;

public class URLTestFrame extends JFrame implements ActionListener {

	//url�� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ带 ��������� �����.
	JTextField jtf;
	
	//url�� ��� ������ �о�ͼ� ����ϱ� ���� TextArea�� ��������� �����.
	JTextArea jta;
	
	public URLTestFrame() {
		jtf = new JTextField(50);
		jta = new JTextArea();
		
		//�о���⸦ �����ų ��ư�� �����Ѵ�.
		JButton btn = new JButton("�о����");
		
		//�ؽ�Ʈ�ʵ�� ��ư��������� �г��� ����
		JPanel p = new JPanel();
		
		//�гο� �ؽ�Ʈ�ʵ�� ��ư�� ��´�.
		p.add(jtf);
		p.add(btn);
		
		//TextArea�� ��ũ�������� ���Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ����ִ� �г��� �������� ���ʿ� ��´�.
		add(p, BorderLayout.NORTH);
		
		//TextArea�� ���ΰ� �ִ� ��ũ������ �������� ����� ��´�.
		add(jsp, BorderLayout.CENTER);
		
		//�������� ũ�⸦ �����Ѵ�.
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� �����Ѵ�.
		setVisible(true);
		
		//��ư�� �̺�Ʈ�� ����Ѵ�.
		btn.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			//����ڰ� �Է��� ���ͳ��ּҸ� �о�ͼ� ��ü�� ����
			//���ͳݻ��� ������ü�� �����Ѵ�
			URL url = new URL( jtf.getText() );
		
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
				
				//�迭�� �ٽ� �о���̱� ���� ������ ����ش�.
				//�׷��� ������ �ǳ��� �̻��� �����Ⱑ ��µ� �� �ִ�.
				//byte���� �迭 data�� ��� 0���� �ʱ�ȭ�Ѵ�.
				//���� 0�� ���� �ڹٴ� int�� ����ϱ� ������ 
				//byte���� ����ȯ �Ѵ�.
				Arrays.fill(data,(byte)0);
			}
			
			//��ü ������ ���ڿ� ������ TextArea�� ����Ѵ�.
			jta.setText(str);
			
			//��Ʈ���� �ݾ��ش�.
			is.close();
		
		} catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
			
		}	
	}

}
