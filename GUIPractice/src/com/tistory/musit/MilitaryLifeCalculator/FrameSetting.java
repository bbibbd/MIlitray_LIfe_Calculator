package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;

public class FrameSetting extends JFrame {

	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		//setResizable(false);
	}


	public void setButton () {
		JPanel buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);
		buttonPanel.add(new JButton("계산"));
		buttonPanel.add(new JButton("초기화"));
		buttonPanel.add(new JButton("txt파일로 저장"));
		buttonPanel.setLayout(fl);
		//buttonPanel.setPreferredSize(new Dimension( 320, 120));
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);
	}

	public void setDate() {

		GridLayout g = new GridLayout(2,4,2,2);
		StartEndInputPanel textField = new StartEndInputPanel(g);
		
		JPanel startPanel = new JPanel(new FlowLayout());
		JPanel endPanel = new JPanel();
		JLabel startLabel = new JLabel("입대일");
		JLabel endLabel = new JLabel("전역일");


		String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
		String [] startMonth = {"1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] startDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		String [] endYear =  { "2019", "2020", "2021", "2022", "2023","2024","2025"};
		String [] endMonth = {"1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] endDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		JComboBox sty = new JComboBox(startYear);
		JComboBox stm = new JComboBox(startMonth);
		JComboBox std = new JComboBox(startDay);
		JScrollPane psty = new JScrollPane(sty);
		JScrollPane pstm = new JScrollPane(stm);
		JScrollPane pstd = new JScrollPane(std);
		
		JComboBox edy = new JComboBox(endYear);
		JComboBox edm = new JComboBox(endMonth);
		JComboBox Edd = new JComboBox(endDay);
		JScrollPane pedy = new JScrollPane(edy);
		JScrollPane pedm = new JScrollPane(edm);
		JScrollPane pedd = new JScrollPane(Edd);
		


		startPanel.add(startLabel); 
		startPanel.add(psty);	startPanel.add(pstm); startPanel.add(pstd);
		endPanel.add(endLabel); 
		endPanel.add(pedy); endPanel.add(pedm); endPanel.add(pedd);

		textField.add(startPanel);
		textField.add(endPanel);
		add(textField,BorderLayout.NORTH);	

		textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


	}

	public void showResult() {
		ResultPanel resultP = new ResultPanel();
		JLabel textArea = new JLabel();
		textArea.setPreferredSize(new Dimension( 0, 700));
		resultP.add(textArea,BorderLayout.CENTER);


		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW),"결과"));
		add(resultP,BorderLayout.CENTER);

	}
}
