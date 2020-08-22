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
	JTextArea textArea = new JTextArea(5,20);	//	resultP안에 들어가는 TextArea를 선언해 실제 결과를 출력할 수 있게 함.
	
	int startYear, startMonth, startDate,  endYear, endMonth, endDate;	//순서대로 입대년, 입대월, 입대일, 전역년, 전역월, 전역일을 변수로 선언
	String userName = "";
	
	DataSettingFrame ds = new DataSettingFrame();
	MenuBarFrame mf = new MenuBarFrame();
	
	public MainFrame(String title, int x, int y, int sizeX, int sizeY) {	//constructor을 생성 (frame이름, xy좌표, 크기)
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
		textArea.setFont(new Font("고딕",Font.TRUETYPE_FONT,17));
		textArea.setEditable(false);
	}
	
	//메뉴바를 세팅하는 method
	public void setMenuBar() {
		mf.setMenuBar();
		setJMenuBar(mf.getMb());
	}

	//입대일, 전역일, 이름을 입력하기위한 Panel을 세팅하는 method
	public void setDataPanel() {	
		ds.setData();
		add(ds.getDataInputPanel(),BorderLayout.NORTH);	
		ds.getDataInputPanel().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));
	}

	//결과를 보여주는 Panel
	public void setResultPanel() {
		ResultPanel resultP = new ResultPanel();	
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating 할 때 
		setVisible(true);
	}
	
	//하단의 calculate, reset 버튼을 세팅해주는 method
	public void setButtonPanel() {		
		JPanel buttonPanel = new JPanel();	//버튼 3개가 들어가는 Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//가운데정렬하기 위해 FlowLayout을 선언
		JButton calculateBtn = new JButton("계산");	//계산하는 버튼 생성
		buttonPanel.add(calculateBtn);		//버튼패널에 계산버튼 추가

		//계산 버튼 클릭 시의 이벤트
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				
				startYear = ds.getSty();	startMonth = ds.getStm(); startDate = ds.getStd();
				endYear = ds.getEdy(); endMonth = ds.getEdm();	endDate = ds.getEdd();
				userName = ds.getNameField().getText();
				
				if(userName.equals("123")) {
					userName = " 김기범"; 	startYear=2019;	startMonth=4;	startDate=1;	endYear=2020;	endMonth=11;	endDate=2;	setName(userName);
				}
				
				String confirmMes = String.format("이름: %s \n입대일: %d년 %d월 %d일\n전역일: %d년 %d월 %d일\n맞으십니까?", userName,startYear,startMonth,startDate,endYear,endMonth,endDate);
				
				int answer = JOptionPane.showConfirmDialog(null,confirmMes, "confirm",JOptionPane.YES_NO_OPTION );
				if(answer ==JOptionPane.YES_OPTION) {
					if(userName.equals("김기범"))
						JOptionPane.showMessageDialog(null, "천재 프로그래머 김기범씨.!","???",3);
					if(userName.equals("조봉현")) 
						JOptionPane.showMessageDialog(null, "1소대 에이스 조봉현씨, 환영합니다.","???",3);
					if(userName.equals("전지훈")) 
						JOptionPane.showMessageDialog(null, "아프지마 지훈아 ㅎㅎ작업하러가야징","???",3);
					if(userName.equals("정훈")||userName.equals("정 훈")) 
						JOptionPane.showMessageDialog(null, "내가 잴 좋아하는 정훈!!환영","???",3);
					
					mf.setName(userName);
					Run gibeom = new Run(userName, startYear,  startMonth, startDate, endYear,endMonth, endDate);	//이름과 입대일, 전역일을 다 세팅해서 Initiating함
					try {
						gibeom.calculating();
						mf.setTx(gibeom.getFinalResult().toString());
						textArea.setText(mf.getTx());
					}	catch (DateTimeException er) {
						String errMessage = "날짜를 잘못입력하신듯하네요. \n다시입력해주시기 바랍니다.";
						textArea.setText(errMessage);
					}
				}
			}
		});

		JButton resetBtn = new JButton("초기화");	//reset버튼 initiating
		buttonPanel.add(resetBtn);	//버튼페널에 reset버튼 추가

		//초기화 버튼 클릭 시의 이벤트
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");	//결과에 빈 string을 출력하게 함
			}
		});
		
		JButton exitButton = new JButton("짬차이 계산기");	//text파일로 저장하는 버튼
		buttonPanel.add(exitButton);	
		//종료 버튼 클릭 시 이벤트
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JjamDifferenceCalculator jdc = new JjamDifferenceCalculator("짬차이 계산기", 760, 400, 400,330);
				jdc.calculateJjamDifference();
				jdc.setVisible(true);
			
			}

		});

		buttonPanel.setLayout(fl);	//buttonPanel을 FlowLayout CENTER로 정렬
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);
	}

}