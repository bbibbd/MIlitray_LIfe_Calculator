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




public class FrameSetting extends JFrame {		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//FrameSetting

	JTextField nameField = new JTextField("",14);	//이름 입력을 위한 TextField를 선언
	JTextArea textArea = new JTextArea(5,20);	//	resultP안에 들어가는 TextArea를 선언해 실제 결과를 출력할 수 있게 함.
		//최종 출력을 Txt파일로 저장하기위해 선언, reset버튼과 calculate버튼을 눌렀을 때 사용해야하기때문에

	private int sty, stm, std,  edy, edm, edd;	//순서대로 입대년, 입대월, 입대일, 전역년, 전역월, 전역일을 변수로 선언
	@SuppressWarnings("unused")
	private String name;	//textField에 입력된 이름값을 저장하기위해  선언



	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {	//constructor을 생성 (frame이름, xy좌표, 크기)
		super(title);
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
		
		JMenu mFile, mEdit, mHelp;
		JMenuItem saveUser, loadUser, exportToTxtFile, aboutProgram, howToUse;
		
		mFile = new JMenu("File");	saveUser = new JMenuItem("Save User");	loadUser = new JMenuItem("Load User");	exportToTxtFile = new JMenuItem("Export to Txt File");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("How to use");

		
		mFile.add(saveUser);	mFile.add(loadUser);	mFile.add(exportToTxtFile);		
		mHelp.add(aboutProgram);	mHelp.add(howToUse);
		menuBar.add(mFile); // TODO 사용자 저장, 사용자 불러오기, 결과 내보내기
		menuBar.add(mHelp);	// TODO 프로그램 정보, 사용방법 적혀있는 창 띄우기

		aboutProgram.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				String about = "Maker: Bluemini \nContact: bbibbochaa74@gmail.com\nVersion: 2020-09 (3.0.2)\r\n" + 
						"Build id: 20200806-1200\nThis program tells you about your military life. \nThere is no copyright. You can use it as you want and share it.\t";
				JOptionPane.showMessageDialog(null, about,"about",1);
			}
		});
		
		howToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String howToUse = "1. 입대일과 전역일을 선택하여 입력합니다.\n2. 이름을 입력합니다.\n3. 하단의 계산버튼을 클릭합니다.\n4. 그러면 중앙에 결과가 나타날 것입니다.";
				JOptionPane.showMessageDialog(null, howToUse,"about",1);
			}
		});
	}

	
	@SuppressWarnings("unchecked")
	public void setDate() {	//입대일, 전역일, 이름을 입력하기위한 Panel

		GridLayout g = new GridLayout(3,4,2,2);
		StartEndInputPanel textField = new StartEndInputPanel(g);

		JPanel startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"Start"와 JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel endPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"End"와  JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//name과 textField를 넣는 panel

		JLabel startLabel = new JLabel("입대일");
		JLabel endLabel = new JLabel("전역일");
		JLabel nameLabel = new JLabel("이름 ");

		this.name = nameField.getText();
		// TODO JComboBox의 기본값을 숫자가 아닌 년도, 월, 일 이런식으로 만들기
		//입대년도, 월, 일을 LIST로 만들어 JComboBox에 묶어둠
		String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
		//String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
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

	public void setResult() {
		ResultPanel resultP = new ResultPanel();	//결과를 보여주는Panel인데, size를 재정리하기위해서 ResultPanel extends JPanel를 만들어서 overRide해서 불러옴
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating 할 때 
		setVisible(true);

	}
	
	
	public void setButton () {		//하단의 calculate, reset 버튼을 세팅해주는 method

		JPanel buttonPanel = new JPanel();	//버튼 3개가 들어가는 Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//가운데정렬하기 위해 FlowLayout을 선언

		JButton calculateBtn = new JButton("계산");	//계산하는 버튼 생성
		buttonPanel.add(calculateBtn);		//버튼패널에 계산버튼 추가

		//계산 버튼 클릭 시의 이벤트
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();	//nameField에 입력된 이름값을 불러오고
				Run gibeom = new Run(name, sty,  stm, std, edy,edm, edd);	//이름과 입대일, 전역일을 다 세팅해서 Initiating함
				gibeom.calculating();
				showResult(gibeom.getFinalResult());		//StringBuilder형태의 결과를 가져와서 textArea에 출력

			}
		});

		JButton resetBtn = new JButton("초기화");	//reset버튼 initiating
		buttonPanel.add(resetBtn);	//버튼페널에 reset버튼 추가

		//reset버튼 클릭 시의 이벤트
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showResult(new StringBuilder(""));	//결과에 빈 string을 출력하게 함
			}
		});

		JButton exitButton = new JButton("종료");	//text파일로 저장하는 버튼
		buttonPanel.add(exitButton);	

		//Save as txt버튼 클릭 시 이벤트
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