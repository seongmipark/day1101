package com.sist.echo02;

//���� : �����غ���
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener,Runnable{
	
	//��ȭ������ ����� �ؽ�Ʈ����� ��������� �����
	JTextArea jta;
	
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 ���������
	JTextField jtf;
	
	//����½�Ʈ���� ��������� �����
	DatagramSocket socket;
	DatagramPacket packet;

	public UDPChatClient() {
				
		//������� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� ����Ѵ�
		btn.addActionListener(this);
		
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ�������� ���Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ����� ���ΰ��ִ� ��ũ������ ��´�.
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ����ִ� �г��� �������� �Ʒ��� ��´�.
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ �����Ѵ�.
		setSize(600,400);
		setVisible(true);
		
		try { 
			socket = new DatagramSocket(9004);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread t = new Thread(this);
		t.start();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new UDPChatClient();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �Ѵ�.
			byte []data = jtf.getText().getBytes();
			
			//// ���� ���� �ּ� ����
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			
			//udp����� ���������� ���� ��Ŷ�� �����Ѵ�.
			packet = new DatagramPacket(data, data.length,addr,9004);
			
			//DatagramSocket�� send�޼ҵ带 ���� �����͸� ����
			socket.send(packet);
			
			//������ �ݾ��ش�
			//socket.close();
			
			//�޼����� �����ϰ� ���� �޼����Է��� ���Ͽ� �ؽ�Ʈ �ʵ带 ������ �����.
			jtf.setText("");
			
		} catch (Exception ex) {
		System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}


	//�����κ��� ���ŵ� �����͸� ��� �޵��� �Ѵ�.
	//���θ޼ҵ峪 �����ڿ��� �����带 ������ų �� �ִ�.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramPacket packet;		
		byte []data = new byte[100];
		while(true) {
			try {
				//�����͸� �����ϱ� ���� ��Ŷ�� ���� ����
				packet = new DatagramPacket(data, data.length);

				socket.receive(packet);
				String msg = new String(data);
				//String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");//�ؽ�Ʈ����� �߰��ϴ� �޼ҵ�
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}



