package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBarFrame extends JFrame {
	
	JMenuBar mb = new JMenuBar();
	String tx = "empty,,,";
	String name = "";

	public void setMenuBar() {

		JMenu mFile, mHelp;
		JMenuItem  exportToTxtFile, aboutProgram, howToUse;

		mFile = new JMenu("파일");	exportToTxtFile = new JMenuItem("결과 저장");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("사용법");
		mFile.add(exportToTxtFile);		
		mHelp.add(howToUse);	mHelp.add(aboutProgram);	
		mb.add(mFile); 
		mb.add(mHelp);	

		//export to txt file
		SimpleDateFormat format1 = new SimpleDateFormat ( "yy년MM월dd일 EEE요일");
		String today= format1.format (System.currentTimeMillis());
		
		exportToTxtFile.addActionListener(new ActionListener() {	//txt파일로 내보내기 
			public void actionPerformed(ActionEvent e) {
				try
				{
					String fileName = String.format("%s님의 군생활(%s).txt",name,today);	//파일이름
					FileWriter fw = new FileWriter(fileName,false); 
					BufferedWriter bw = new BufferedWriter(fw);
					String str = tx;
					bw.write(str);
					bw.newLine(); // 줄바꿈
					bw.close();
					JOptionPane.showMessageDialog(null, String.format("%s로 저장되었습니다.",fileName),"saved",1);
				}
				catch (IOException er)
				{
					System.err.println(er); // 에러가 있다면 메시지 출력
					System.exit(1);
				}
			}
		});

		//about...탭 클릭시
		aboutProgram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String about = "Maker: Bluemini \nContact: bbibbochaa74@gmail.com\nVersion: 2020-09 (3.1.1)\r\n" + 
						"This program tells you about your military life. \nThere is no copyright. You can use it as you want and share it.\n\n저는 2020년 11월 2일에 전역합니다. ㅂㅇㅂㅇ\t";
				JOptionPane.showMessageDialog(null, about,"about",1);
			}
		});

		//사용법 클릭시
		howToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String howToUse = "1. 입대일과 전역일을 선택하여 입력합니다.\n2. 이름을 입력합니다.\n3. 하단의 계산버튼을 클릭합니다.\n4. 그러면 중앙에 결과가 나타날 것입니다.\n\n*초기화버튼을 눌러서 결과창을 비울 수 있습니다.";
				JOptionPane.showMessageDialog(null, howToUse,"사용법",1);
			}
		});
	}
	
	public JMenuBar getMb() {
		return mb;
	}
	
	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public void setName(String name) {
		this.name = name;
	}

}
