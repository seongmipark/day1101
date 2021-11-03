package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.KeyListener;



public class SistNote extends JFrame implements ActionListener, KeyListener{
	
	String fileName = "제목 없음";
	
	File file; //기본값 null
	//이미 파일명이 있을 경우 물어보지 않고 이 파일에 저장하도록 하기 위하여
	//File객체를 멤버변수로 만든다.
	
	JTextArea jta;
	JFileChooser jfc;
	
	//메모장의 내용이 변경된 내용이 있는지 상태를 저장하기 위한 변수를 선언
	boolean isNew;
	
	

	public SistNote() {
		jta = new JTextArea();
		
		//isNew에 기본값을 false를 설정
		isNew = false;
		
		jfc = new JFileChooser("c:/myData");
		
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("파일");
		
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		jmb.add(mn_file);
		setJMenuBar(jmb);
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		
		//텍스트에리어에 키이벤트를 등록한다.
		jta.addKeyListener(this);
		
		

		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		
		if(cmd.equals("새파일")) {
			
			if(isNew = true) {
			int re =  JOptionPane.showConfirmDialog(this, "저장하시겠습니까?");
			//re 0 : 저장하고새파일   1: 저장안하고 새파일   2: 저장도안하고새파일도안하고
			switch(re) {
				case 0:saveFile();
				case 1:
					jta.setText("");
					fileName = "제목 없음";
					setTitle(fileName);
					isNew = false;
					file = null;
					break;
				case 2: return;
				}
		} else {
			jta.setText("");
			fileName = "제목 없음";
			setTitle(fileName);
			isNew = false;
			file = null;
		}
		
			
		}else if(cmd.equals("열기")) {
				
			int re = jfc.showOpenDialog(this);
		
			try {
			if(re == 0) {
				//열어온 파일을 멤버변수 file에 저장
				file = jfc.getSelectedFile();
				
					FileReader fr = new FileReader(file);
					this.setTitle(file.getName());
				
					int ch;
					
		
					String data="";
					
					while(true) {
	
						ch=fr.read();
						if(ch == -1) {
							break;
						}
						data = data + (char)ch;
					}
					jta.setText(data);
					
					
					fr.close();
					JOptionPane.showMessageDialog(this, "파일을 읽어왔습니다.");
					
					fileName  = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));

					
					setTitle(fileName);
					
				}
			
			}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			
			
			isNew = false;
			
			
			
		}else if(cmd.equals("저장")) {
			saveFile();
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//키를 누르는 순간 true
		isNew = true;
	}
	
	
	
	public void saveFile() {
		
		
		//이미 파일이 없다면 파일을 선택하기 위한 다이얼로그를 띄우고
		//이미 파일이 있다면 그 이름으로 저장하도록 한다.
		
		int re = 0;
		//이미 파일이름이 있는 상태에서 (=File이 null이 아닌 상태)
		//저장을 누르면 무조건 저장해야 한다.
		//그런데 이제 막 처음 파일을 저장하면(File = null인 상태)에서
		//저장을 누르면 파일을 선택하는 다이얼로그에서 '취소'를 누르지 않고
		//'저장'을 눌렀을때만 저장하도록 처리해야 한다.
		//이것을 동시에 처리하기 위해 re에 기본값 0을 준다.
		//이미 파일이 있으면 다음의 if를 만나지 않아 re는 그대로 0을 유지하고 있다.
		//만약 파일이 없는 상태면 다음의 if를 만나서
		//띄어진 다이얼로그에서 '취소'를 만나면 re=1이 된다.
		
		if(file == null) {
		re = jfc.showSaveDialog(this);
		if(re == 0) {
			File file = jfc.getSelectedFile();
			}
		}
		
		if(re == 0) {
			File file = jfc.getSelectedFile();
			
		
			try {
				FileWriter fw = new FileWriter(file);
						
				fw.write(jta.getText());
					
				fw.close();
				
				JOptionPane.showMessageDialog(this, "파일로 저장했습니다.");
					
				fileName  = file.getName();

				fileName = fileName.substring(0,fileName.indexOf("."));
				
				setTitle(fileName);
				
			} catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
			
			isNew = false;
			
			
		}
	}
	
	
	
	
	

}
