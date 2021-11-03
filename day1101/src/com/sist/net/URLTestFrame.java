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

	//url을 입력받기 위한 텍스트필드를 멤버변수로 만든다.
	JTextField jtf;
	
	//url의 모든 내용을 읽어와서 출력하기 위한 TextArea를 멤버변수로 만든다.
	JTextArea jta;
	
	public URLTestFrame() {
		jtf = new JTextField(50);
		jta = new JTextArea();
		
		//읽어오기를 수행시킬 버튼을 생성한다.
		JButton btn = new JButton("읽어오기");
		
		//텍스트필드와 버튼을담기위한 패널을 생성
		JPanel p = new JPanel();
		
		//패널에 텍스트필드와 버튼을 담는다.
		p.add(jtf);
		p.add(btn);
		
		//TextArea를 스크롤팬으로 감싼다.
		JScrollPane jsp = new JScrollPane(jta);
		
		//텍스트필드와 버튼을 담고있는 패널을 프레임의 위쪽에 담는다.
		add(p, BorderLayout.NORTH);
		
		//TextArea를 감싸고 있는 스크롤팬을 프레임의 가운데에 담는다.
		add(jsp, BorderLayout.CENTER);
		
		//프레임의 크기를 설정한다.
		setSize(800,600);
		
		//프레임을 화면에 보이도록 설정한다.
		setVisible(true);
		
		//버튼에 이벤트를 등록한다.
		btn.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			//사용자가 입력한 인터넷주소를 읽어와서 객체를 생성
			//인터넷상의 문서객체를 생성한다
			URL url = new URL( jtf.getText() );
		
			//그 문서의 내용을 읽어들이기 위하여 스트림을 생성한다
			InputStream is = url.openStream();
			
			//한번에 읽어들일 byte형의 배열을 만든다.
			byte []data = new byte[100];
			
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만든다,
			String str = "";
			
			//스트림의 끝이 아닐때까지 100byte씩 읽어들인다.
			while( is.read(data) != -1) {
				
				//읽어들인 btye배열의 데이터를 문자열로 만들어 누적한다. 
				//str += new String(data);					
				
				//한글로 처리하기
				str += new String(data,"utf-8");
				
				//배열을 다시 읽어들이기 전에 깨끗이 비워준다.
				//그렇지 않으면 맨끝에 이상한 쓰레기가 출력될 수 있다.
				//byte형의 배열 data를 모두 0으로 초기화한다.
				//숫자 0이 오면 자바는 int로 취급하기 때문에 
				//byte으로 형변환 한다.
				Arrays.fill(data,(byte)0);
			}
			
			//전체 누적된 문자열 변수를 TextArea에 출력한다.
			jta.setText(str);
			
			//스트림을 닫아준다.
			is.close();
		
		} catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
			
		}	
	}

}
