package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class FrameSetting extends JFrame {		
 
	private static final long serialVersionUID = 1L;
	String tx = "Empty,,,";

	JTextField nameField = new JTextField("",14);	//이름 입력을 위한 TextField를 선언
	JTextArea textArea = new JTextArea(5,20);	//	resultP안에 들어가는 TextArea를 선언해 실제 결과를 출력할 수 있게 함.
	//최종 출력을 Txt파일로 저장하기위해 선언, reset버튼과 calculate버튼을 눌렀을 때 사용해야하기때문에

	int sty, stm, std,  edy, edm, edd;	//순서대로 입대년, 입대월, 입대일, 전역년, 전역월, 전역일을 변수로 선언
	@SuppressWarnings("unused")
	private String name;	//textField에 입력된 이름값을 저장하기위해  선언


	HashMap<String, String> userInfo = new HashMap<>();

	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {	//constructor을 생성 (frame이름, xy좌표, 크기)
		super(title);
		JOptionPane.showMessageDialog(null, "당신의 군생활이 궁금하신가요?","???",3);
		JOptionPane.showMessageDialog(null, "잘 오셨습니다. 당신의 군생활을 응원합니다!!!","???",2);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
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
					String fileName = String.format("%s님의 군생활(%s).txt",nameField.getText(),today);	//파일이름
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
	@SuppressWarnings("unchecked")
	public void setDate() {	
		GridLayout g = new GridLayout(3,4,2,2);
		StartEndInputPanel textField = new StartEndInputPanel(g);

		JPanel startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"Start"와 JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel endPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"End"와  JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//name과 textField를 넣는 panel
		
		JLabel startLabel = new JLabel("입대일");
		JLabel endLabel = new JLabel("전역일");
		JLabel nameLabel = new JLabel("이름 ");

		this.name = nameField.getText();
		//입대년도, 월, 일을 LIST로 만들어 JComboBox에 묶어둠
		String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
		String [] startMonth = { "1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] startDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		//전역년도, 월, 일을 LIST로 만들어 JComboBox에 묶어둠
		String [] endYear =  { "2019", "2020", "2021", "2022", "2023","2024","2025"};
		String [] endMonth = {"1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] endDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		JComboBox <String> sty = new JComboBox<String>(startYear);
		JComboBox <String> stm = new JComboBox<String>(startMonth);
		JComboBox <String> std = new JComboBox<String>(startDay);
		JScrollPane psty = new JScrollPane(sty);
		JScrollPane pstm = new JScrollPane(stm);
		JScrollPane pstd = new JScrollPane(std);

		this.sty = Integer.parseInt(sty.getSelectedItem().toString());	//Integer로 저장하기 위해 변환과정을 거침.
		this.stm = Integer.parseInt(stm.getSelectedItem().toString());
		this.std =  Integer.parseInt(std.getSelectedItem().toString());

		//각각 combobox에 입력된 값을 sty, sym, syd, edy, edm, edd에 저장함
		sty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setSty(Integer.parseInt(str));
				}
			}
		});
		
		stm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStm(Integer.parseInt(str));

				}
			}
		});
		
		std.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStd(Integer.parseInt(str));
				}
			}
		});

		JComboBox<String> edy = new JComboBox<String>(endYear);
		JComboBox<String> edm = new JComboBox<String>(endMonth);
		JComboBox<String> edd = new JComboBox<String>(endDay);
		JScrollPane pedy = new JScrollPane(edy);
		JScrollPane pedm = new JScrollPane(edm);
		JScrollPane pedd = new JScrollPane(edd);

		this.edy = Integer.parseInt(edy.getSelectedItem().toString());
		this.edm = Integer.parseInt(edm.getSelectedItem().toString());
		this.edd =  Integer.parseInt(edd.getSelectedItem().toString());

		edy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdy(Integer.parseInt(str));
				}
			}
		});
		
		edm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdm(Integer.parseInt(str));
				}
			}
		});
		
		edd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdd(Integer.parseInt(str));
				}
			}
		});
		
		startPanel.add(startLabel); 
		startPanel.add(psty);	startPanel.add(pstm); startPanel.add(pstd);
		endPanel.add(endLabel); 
		endPanel.add(pedy); endPanel.add(pedm); endPanel.add(pedd);
		namePanel.add(nameLabel); namePanel.add(nameField);
		
		textField.add(startPanel);
		textField.add(endPanel);
		textField.add(namePanel);
		add(textField,BorderLayout.NORTH);	

		textField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));
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
				String name = nameField.getText();	//nameField에 입력된 이름값을 불러오고
				
				if(name .equals("123")) {		//나의 Data 저장
					name = "김기범";		setSty(2019);	setStm(4);	setStd(1);	setEdy(2020);	setEdm(11);		setEdd(2);
				}
				
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

		JButton exitButton = new JButton("종료");	//text파일로 저장하는 버튼
		buttonPanel.add(exitButton);	
		//종료 버튼 클릭 시 이벤트
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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


}