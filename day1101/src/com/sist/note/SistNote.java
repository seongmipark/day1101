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
	
	String fileName = "���� ����";
	
	File file; //�⺻�� null
	//�̹� ���ϸ��� ���� ��� ����� �ʰ� �� ���Ͽ� �����ϵ��� �ϱ� ���Ͽ�
	//File��ü�� ��������� �����.
	
	JTextArea jta;
	JFileChooser jfc;
	
	//�޸����� ������ ����� ������ �ִ��� ���¸� �����ϱ� ���� ������ ����
	boolean isNew;
	
	

	public SistNote() {
		jta = new JTextArea();
		
		//isNew�� �⺻���� false�� ����
		isNew = false;
		
		jfc = new JFileChooser("c:/myData");
		
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("����");
		
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		jmb.add(mn_file);
		setJMenuBar(jmb);
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		
		//�ؽ�Ʈ����� Ű�̺�Ʈ�� ����Ѵ�.
		jta.addKeyListener(this);
		
		

		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		
		if(cmd.equals("������")) {
			
			if(isNew = true) {
			int re =  JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?");
			//re 0 : �����ϰ������   1: ������ϰ� ������   2: ���嵵���ϰ�����ϵ����ϰ�
			switch(re) {
				case 0:saveFile();
				case 1:
					jta.setText("");
					fileName = "���� ����";
					setTitle(fileName);
					isNew = false;
					file = null;
					break;
				case 2: return;
				}
		} else {
			jta.setText("");
			fileName = "���� ����";
			setTitle(fileName);
			isNew = false;
			file = null;
		}
		
			
		}else if(cmd.equals("����")) {
				
			int re = jfc.showOpenDialog(this);
		
			try {
			if(re == 0) {
				//����� ������ ������� file�� ����
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
					JOptionPane.showMessageDialog(this, "������ �о�Խ��ϴ�.");
					
					fileName  = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));

					
					setTitle(fileName);
					
				}
			
			}catch (Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}
			
			
			isNew = false;
			
			
			
		}else if(cmd.equals("����")) {
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
		
		//Ű�� ������ ���� true
		isNew = true;
	}
	
	
	
	public void saveFile() {
		
		
		//�̹� ������ ���ٸ� ������ �����ϱ� ���� ���̾�α׸� ����
		//�̹� ������ �ִٸ� �� �̸����� �����ϵ��� �Ѵ�.
		
		int re = 0;
		//�̹� �����̸��� �ִ� ���¿��� (=File�� null�� �ƴ� ����)
		//������ ������ ������ �����ؾ� �Ѵ�.
		//�׷��� ���� �� ó�� ������ �����ϸ�(File = null�� ����)����
		//������ ������ ������ �����ϴ� ���̾�α׿��� '���'�� ������ �ʰ�
		//'����'�� ���������� �����ϵ��� ó���ؾ� �Ѵ�.
		//�̰��� ���ÿ� ó���ϱ� ���� re�� �⺻�� 0�� �ش�.
		//�̹� ������ ������ ������ if�� ������ �ʾ� re�� �״�� 0�� �����ϰ� �ִ�.
		//���� ������ ���� ���¸� ������ if�� ������
		//����� ���̾�α׿��� '���'�� ������ re=1�� �ȴ�.
		
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
				
				JOptionPane.showMessageDialog(this, "���Ϸ� �����߽��ϴ�.");
					
				fileName  = file.getName();

				fileName = fileName.substring(0,fileName.indexOf("."));
				
				setTitle(fileName);
				
			} catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
			
			isNew = false;
			
			
		}
	}
	
	
	
	
	

}
