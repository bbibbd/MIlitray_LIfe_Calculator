package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameSetting extends JFrame {
	
	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
	}


	public void setButton () {
		JPanel confirmOrCancel = new JPanel();
		JButton confirm = new JButton("확인");
		JButton cancel = new JButton("취소");
		confirmOrCancel.add(confirm);
		confirmOrCancel.add(cancel);
		add(confirmOrCancel, BorderLayout.SOUTH);
		
	}
	
	public void setDate() {
		 JPanel textField = new JPanel();
		 GridLayout g = new GridLayout(0,1,5,5);
		 textField.setLayout(g);
		JTextField inputStartDate = new JTextField("입대일을 입력해주십시오");
		JTextField inputEndDate = new JTextField("전역일을 입력해주십시오");
		textField.add(inputStartDate);
		textField.add(inputEndDate);
		add(textField,BorderLayout.NORTH);	
	}
	
	public void showResult() {
		JTextArea textArea = new JTextArea(10,20);
		add(textArea,BorderLayout.CENTER);
		textArea.setEditable(false);	
	}
}
