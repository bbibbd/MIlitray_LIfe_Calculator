package com.tistory.musit.calculatorFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {	//JFrame 클래스를 상속받아 CalculatorFrame을 만든다.
		
	public CalculatorFrame(String title, int x, int y, int sizeX, int sizeY) {	//constructor
		super(title);
		setLocation(x,y);
		setSize(sizeX, sizeY);
	}
	
	public void calculatorLayout() {
		JPanel numPad = new JPanel();		//숫자입력판을 만들기 위한 JPanel을 numPad로 initiating한다.
		GridLayout g = new GridLayout(0, 4, 5, 5);	//numpad를 위한 레이아웃을 GridLayout을 사용함 (행, 열, 수평갭, 수직갭)
		numPad.setLayout(g);
		
		numPad.add(new JButton("%")); numPad.add(new JButton("CE")); numPad.add(new JButton("C")); numPad.add(new JButton("<--"));
		numPad.add(new JButton("1/x")); numPad.add(new JButton("x^2")); numPad.add(new JButton("r(x)")); numPad.add(new JButton("÷"));
		numPad.add(new JButton("7")); numPad.add(new JButton("8")); numPad.add(new JButton("9")); numPad.add(new JButton("X"));
		numPad.add(new JButton("4")); numPad.add(new JButton("5")); numPad.add(new JButton("6")); numPad.add(new JButton("-"));
		numPad.add(new JButton("1")); numPad.add(new JButton("2")); numPad.add(new JButton("3")); numPad.add(new JButton("+"));
		numPad.add(new JButton("+/-")); numPad.add(new JButton("0")); numPad.add(new JButton(".")); numPad.add(new JButton("="));
		
		JTextField inputField = new JTextField(20);	//숫자입력창을 만들기 위한 JTextField inputField를 initiating한다.
		inputField.setText("input value");
		
		add(inputField,BorderLayout.NORTH); add(numPad, BorderLayout.CENTER);
		
	}
}
