package com.tistory.musit.calculatorFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {
		
	public CalculatorFrame(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX, sizeY);
	}
	
	public void calculatorLayout() {
		JPanel numPad = new JPanel();
		GridLayout g = new GridLayout(0, 4, 5, 5);	
		numPad.setLayout(g);
		
		numPad.add(new JButton("%")); numPad.add(new JButton("CE")); numPad.add(new JButton("C")); numPad.add(new JButton("<--"));
		numPad.add(new JButton("1/x")); numPad.add(new JButton("x^2")); numPad.add(new JButton("r(x)")); numPad.add(new JButton("¡À"));
		numPad.add(new JButton("7")); numPad.add(new JButton("8")); numPad.add(new JButton("9")); numPad.add(new JButton("X"));
		numPad.add(new JButton("4")); numPad.add(new JButton("5")); numPad.add(new JButton("6")); numPad.add(new JButton("-"));
		numPad.add(new JButton("1")); numPad.add(new JButton("2")); numPad.add(new JButton("3")); numPad.add(new JButton("+"));
		numPad.add(new JButton("+/-")); numPad.add(new JButton("0")); numPad.add(new JButton(".")); numPad.add(new JButton("="));
		
		JTextField inputField = new JTextField(20);
		inputField.setText("input value");
		
		add(inputField,BorderLayout.NORTH); add(numPad, BorderLayout.CENTER);
		
	}
}
