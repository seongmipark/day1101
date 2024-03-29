package com.sist.echo01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TCPChatClient extends JFrame implements ActionListener,Runnable{
	
	//대화내용을 출력할 텍스트에리어를 멤버변수로 만든다
	JTextArea jta;
	
	//내가 대화내용을 입력할 텍스트필드를 멤버변수로
	JTextField jtf;
	
	//입출력스트림을 멤버변수로 만든다
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
				
		//멤버변수 텍스트에리어와 텍스트필드를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트를 등록한다
		btn.addActionListener(this);
		
		
		//텍스트필드와 버튼을 담기위한 패널을 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어를 스크롤팬으로 감싼다.
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에리어를 감싸고있는 스크롤팬을 담는다.
		add(jsp,BorderLayout.CENTER);
		
		//텍스트필드와 버튼을 담고있는 패널을 프레임의 아래에 담는다.
		add(p,BorderLayout.SOUTH);
		
		//프레임의 크기를 설정한다.
		setSize(600,400);
		setVisible(true);

		try {
			//통신을 위하여 서버에 접속을 요청한다.
			Socket socket = new Socket("192.168.0.27", 9003);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread t = new Thread(this);
		t.start();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPChatClient();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			//사용자가 입력한 텍스트필드의 내용을 서버로 보내도록 한다.
			//OutputStream의 void write(byte[] b) 메소드를 이용한다.
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//메세지를 전송하고 다음 메세지입력을 위하여 텍스트 필드를 깨끗이 지운다.
			jtf.setText("");
			
		} catch (Exception ex) {
		System.out.println("예외발생:"+ex.getMessage());
		}
		
	}


	//서버로부터 수신된 데이터를 계속 받도록 한다.
	//메인메소드나 생성자에서 스레드를 가동시킬 수 있다.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data);	
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");//텍스트에리어에 추가하는 메소드
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}



