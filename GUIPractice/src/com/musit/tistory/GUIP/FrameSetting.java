package com.musit.tistory.GUIP;

import java.awt.BorderLayout;		//전체 프레임을 동, 서, 남, 북, 중앙 5부분으로 나누어서 사용. 기본 프래임이 이 레이아웃을 사용
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/*
 JFrame을 상속받는 Frame클래스를 만든다.
 그런 후 Constructor을 생성해주는데 Factor은 각각 String title, int x, int y, int sixeX, int sizeY)
 title은 프레임 제목, int x와 int y는 실행 시 프래임의 좌표, int sizeX, sizeY는 가로와 세로 사이즈						 
*/

public class FrameSetting extends JFrame {

	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX, sizeY);
	}

	
	/*
	 JButton사용해서 버튼만들기
	 1. JButton (버튼이름) = new JButton(String) --> 버튼이름으로 initiating을 한 다음에, String에 버튼에 들어갈 글자를 쓴다.
	 2. add(버튼이름, 위치) --> 위치는 BorderLayout을 이용하여 지정(만약 JLabel이나 다른 panel과 BorderLayout이랑 겹치면 Main에서 나중에 불러온 것을 우선으로 세팅함
	 */
	public void setButton() {	//버튼을 만들기 위한 method

		JButton east = new JButton("E");	//동쪽에 위치하는 버튼
		JButton west = new JButton("W");//서쪽에 위치하는 버튼
		JButton center = new JButton("C");//중앙에 위치하는 버튼
		
		add(east,BorderLayout.EAST);	//add(버튼, 위치)
		add(west,BorderLayout.WEST);
		add(center,BorderLayout.CENTER);
	}
	
	/*
	 * 메뉴바 만드는 Method. JMenuBar을 이용하여 쉽게 만들 수 있음
	 */
	public void setMenuBar() {		
		JMenuBar menuBar = new JMenuBar();	//menuBar을 initiating
		JMenu mFile, mEdit, mHelp;	//메뉴바에 들어가는 변수 선언

		mFile = new JMenu("File");	 //변수를 각각 initiating하는데, string은 메뉴 항목을 적음, 실제로 실행시키면 메뉴바에 이 string이 뜬다.
		mEdit = new JMenu("Edit");
		mHelp = new JMenu("Help");
		setJMenuBar(menuBar);	//이건 뭔지 모르겠으나 해야함.. 아마 프레임에 메뉴바를 add하는게 아닐까...

		menuBar.add(mFile);	//메뉴바에 JMenu를 추가하는 과장
		menuBar.add(mEdit);
		menuBar.add(mHelp);

	}
	
	/*
	 * 이건 별거없고,,,그냥 라벨 붙이듯 텍스트만 붙여넣을 때 사용
	 * BorderLayout을 이용하여 위치 지정
	 */
	public void setJLabel() {

		JLabel label = new JLabel("Love You!");
		add(label,BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);	//라벨의 수평정렬의 위치를 정하는 method.

	}

	/*
	 * 말 그대로  CheckBox를 만드는 것(하나만)
	 */
	public void setJCheckBox() {
		JCheckBox box1 = new JCheckBox("Lee Cheeun");
		box1.setSelected(true);
		//box1.isSelected()	선택되었다? return true, 아니다? return false
		add(box1, BorderLayout.SOUTH);
		box1.setHorizontalAlignment(JCheckBox.CENTER);

	}

	/*
	 * 설문 조하살 때 그렇다, 아니다, 모르겠다와 같이 CheckBox가 2개 이상 중 하나를 선택해야할 때 쓴다.
	 */
	public void setJRadioButton() {	//CheckBox를 여러개 만들어서 하나를 선택하게 할때 쓰는 method
		JRadioButton r1 = new JRadioButton("yes");
		JRadioButton r2 = new JRadioButton("no");
		JRadioButton r3 = new JRadioButton("think");

		ButtonGroup g = new ButtonGroup();	//그룹을 만들어 3개 중 하나만 선택하도록 함
		g.add(r1);		g.add(r2);		g.add(r3);

		add(r1, BorderLayout.NORTH);
		add(r2, BorderLayout.SOUTH);
		add(r3, BorderLayout.CENTER);

		r1.setHorizontalAlignment(JRadioButton.CENTER);
		r2.setHorizontalAlignment(JRadioButton.CENTER);
		r3.setHorizontalAlignment(JRadioButton.CENTER);
	}

	/*
	 * 콤보박스는 누르면 리스트까 뜨게 하는것...(설명하기 힘드네 직접 해보셈)
	 */
	public void setJComboBox() {
		String [] love = {"Kim Gibeom","Choi Kwunseok","Hong Saehyeon","Jealous Guy"}; 

		JComboBox cb = new JComboBox(love);	//생성자는 JComboBox(String [])
		add(cb, BorderLayout.SOUTH);
		cb.setSelectedIndex(0);	//기본값으로 어떤 것을 선택할 것인가. index값이라 0이면 기범, 1이면 권석, 2이면 세현이 된다.
	}

	/*
	 * 콤보박스가 누르면 아래에 리스트가 뜨는것이라면, JList는 처음부터 리스트가 나와있고 그 중 하나 선택할 수 있게 한다.
	 */
	public void setJList() {
		String [] love = {"Kim Gibeom","Choi Kwunseok","Hong Saehyeon","Jealous Guy", "김기범", "최권석", "홍세현", "존 레논", "폴 맥카트니", "조지 해리슨", "링고 스타"}; 

		JList list1 = new JList(love);
		JScrollPane p = new JScrollPane(list1);	//list를 스크롤과 결합시킴

		add(p, BorderLayout.NORTH);	//결합시킨 P를 add에 하면 된다.
		list1.setSelectedIndex(0); 	//setSelectedIndices()는 복수선택이 되어있을때, getter도 똑같음
		list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION ); 	//사용자가 선택할 수 있는 범위에 제한을 거는 method,
		//여기서는 일정 범위의 연속적인 값만 선택하게 할 수 있다...?
		//ListSelectionModel.SINGLE_SELECTION => 한 값만 선택함
		//ListSelectionModel.MULTIPLE_INTERVAL_SELECTION  => 기본 값, 자유롭게 선택 가능
	}

	/*
	 * 텍스트를 입력창을 만든다. 네이버 검색창처럼 한 줄로 만들 때 사용
	 */
	public void setJTextField() {
		JTextField textField = new JTextField(20);	//화면에 20자만 표시됨, 나중에 Pannel에서 사용할 때
		textField.setText("I love you");
		add(textField, BorderLayout.NORTH);
		//textField.setEditable(false);		//편집을 불가능하게 하는 method, 기본값은 True이고, 안적어도 됨

	}		
	
	/*
	 * 텍스트입력창인데, 한 줄 이상을 보여줄 때 사용
	 */
	public void setJTextArea()	{
		JTextArea textArea = new JTextArea(5,20);	//5행, 20글자까지만 표시됨, 나중에 Pannel에서 사용할 때		
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		//textArea를 스크롤과 결합시킴, 스크롤에서 수직스크롤바는 항상 뜨게 했으며, 수평스크롤은 필요할 때 쓰게 했다. 
		//기분은 모두 AS_NEEDED
		textArea.setText("John Lennon\nPaul McCartney\nGeorge Harrison\nRingo Strarr");
		add(p, BorderLayout.CENTER);

	}
	
	/*
	 * 
	 */
	public void  setContainer() {
		JLabel head = new JLabel("Enter your name");	//라벨을 만들어서
		head.setHorizontalAlignment(JLabel.CENTER);
		add(head, BorderLayout.NORTH);	//프래임 북쪽에 배치

		JPanel pc = new JPanel();	//새로운 패널 pc를 만들어서
		JLabel name = new JLabel("Name: ");	//라벨 name과
		JTextField tf = new JTextField(20);	//텍스트필드 ft를

		pc.add(name);	pc.add(tf);	//판넬 pc에 넣은 후
		add(pc, BorderLayout.CENTER);	//그 판넬 pc를 프레임의 중앙에 넣는다.

		JPanel ps = new JPanel();	
		JButton b1 = new JButton("confirm");
		JButton b2 = new JButton("reset");

		ps.add(b1);	ps.add(b2);
		add(ps, BorderLayout.SOUTH);
	}
	
	
	
}
