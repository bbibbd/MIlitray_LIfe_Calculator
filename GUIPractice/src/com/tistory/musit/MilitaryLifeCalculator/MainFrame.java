package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {		

	private static final long serialVersionUID = 1L;
	String tx = "Empty,,,";
	JTextArea textArea = new JTextArea(5,20);	//	resultP안에 들어가는 TextArea를 선언해 실제 결과를 출력할 수 있게 함.

	
	int sty, stm, std,  edy, edm, edd;	//순서대로 입대년, 입대월, 입대일, 전역년, 전역월, 전역일을 변수로 선언
	String name;
	
	DataSettingFrame ds = new DataSettingFrame();
	
	public MainFrame(String title, int x, int y, int sizeX, int sizeY) {	//constructor을 생성 (frame이름, xy좌표, 크기)
		super(title);
		JOptionPane.showMessageDialog(null, "당신의 군생활이 궁금하신가요?","???",3);
		JOptionPane.showMessageDialog(null, "잘 오셨습니다. 당신의 군생활을 응원합니다!!!","???",2);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
		textArea.setEditable(false);
	}
	
	public void setDate() {
		sty = ds.getSty();	stm = ds.getStm(); std = ds.getStd();
		edy = ds.getEdy(); edm = ds.getEdm();	edd = ds.getEdd();
		name = ds.getNameField().getText();
	}

	public void showResult(StringBuilder str) {
		textArea.setText(str.toString());
		textArea.setEditable(false);
		textArea.setFont(new Font("고딕",Font.TRUETYPE_FONT,17));
	}

	public void setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mFile, mHelp;
		JMenuItem  exportToTxtFile, aboutProgram, howToUse;

		mFile = new JMenu("파일");	exportToTxtFile = new JMenuItem("결과 저장");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("사용법");
		mFile.add(exportToTxtFile);		
		mHelp.add(howToUse);	mHelp.add(aboutProgram);	
		menuBar.add(mFile); 
		menuBar.add(mHelp);	

		//export to txt file
		exportToTxtFile.addActionListener(new ActionListener() {	//txt파일로 내보내기 
			public void actionPerformed(ActionEvent e) {
				try
				{
					SimpleDateFormat format1 = new SimpleDateFormat ( "yy년MM월dd일 EEE요일");
					String today= format1.format (System.currentTimeMillis());
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

	//입대일, 전역일, 이름을 입력하기위한 Panel
	public void setData() {	
		ds.setData();
		add(ds.getDataInputPanel(),BorderLayout.NORTH);	
		ds.getDataInputPanel().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));
	}

	//결과를 보여주는 method
	public void setResult() {
		ResultPanel resultP = new ResultPanel();	
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating 할 때 
		setVisible(true);
	}
	//하단의 calculate, reset 버튼을 세팅해주는 method
	public void setButton () {		
		JPanel buttonPanel = new JPanel();	//버튼 3개가 들어가는 Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//가운데정렬하기 위해 FlowLayout을 선언
		JButton calculateBtn = new JButton("계산");	//계산하는 버튼 생성
		buttonPanel.add(calculateBtn);		//버튼패널에 계산버튼 추가

		//계산 버튼 클릭 시의 이벤트
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.printf("%s/ %d %d %d\n", name, sty, stm, std);
				
				if(name.equals("123")) {
					name = " 김기범"; 	sty=2019;	stm=4;	std=1;	edy=2020;	edm=11;	edd=2;	setName(name);
				}
				String confirmMes = String.format("이름: %s \n입대일: %d년 %d월 %d일\n전역일: %d년 %d월 %d일\n맞으십니까?", name,sty,stm,std,edy,edm,edd);
				
				int answer = JOptionPane.showConfirmDialog(null,confirmMes, "confirm",JOptionPane.YES_NO_OPTION );
				if(answer ==JOptionPane.YES_OPTION) {
					if(name.equals("김기범"))
						JOptionPane.showMessageDialog(null, "천재 프로그래머 김기범씨.!","???",3);
					if(name.equals("조봉현")) 
						JOptionPane.showMessageDialog(null, "1소대 에이스 조봉현씨, 환영합니다.","???",3);
					if(name.equals("전지훈")) 
						JOptionPane.showMessageDialog(null, "아프지마 지훈아 ㅎㅎ작업하러가야징","???",3);
					if(name.equals("정훈")||name.equals("정 훈")) 
						JOptionPane.showMessageDialog(null, "내가 잴 좋아하는 정훈!!환영","???",3);

					Run gibeom = new Run(name, sty,  stm, std, edy,edm, edd);	//이름과 입대일, 전역일을 다 세팅해서 Initiating함
					try {
						gibeom.calculating();
						tx = gibeom.getFinalResult().toString();
						showResult(gibeom.getFinalResult());		//StringBuilder형태의 결과를 가져와서 textArea에 출력
					}	catch (DateTimeException er) {
						String errMessage = "날짜를 잘못입력하신듯하네요. \n다시입력해주시기 바랍니다.";
						showResult(new StringBuilder(errMessage));
					}
				}
				
			}
		});

		JButton resetBtn = new JButton("초기화");	//reset버튼 initiating
		buttonPanel.add(resetBtn);	//버튼페널에 reset버튼 추가

		//초기화 버튼 클릭 시의 이벤트
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showResult(new StringBuilder(""));	//결과에 빈 string을 출력하게 함
				tx = "empty,,, ";
			}
		});

		JButton exitButton = new JButton("짬차이 계산기");	//text파일로 저장하는 버튼
		buttonPanel.add(exitButton);	
		//종료 버튼 클릭 시 이벤트
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}

		});

		buttonPanel.setLayout(fl);	//buttonPanel을 FlowLayout CENTER로 정렬
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);

	}


	public int getSty() {
		return sty;
	}

	public void setSty(int sty) {
		this.sty = sty;
	}

	public int getStm() {
		return stm;
	}

	public void setStm(int stm) {
		this.stm = stm;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getEdy() {
		return edy;
	}

	public void setEdy(int edy) {
		this.edy = edy;
	}

	public int getEdm() {
		return edm;
	}

	public void setEdm(int edm) {
		this.edm = edm;
	}

	public int getEdd() {
		return edd;
	}

	public void setEdd(int edd) {
		this.edd = edd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}