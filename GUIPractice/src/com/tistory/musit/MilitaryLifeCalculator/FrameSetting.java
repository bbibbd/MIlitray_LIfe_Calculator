package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class FrameSetting extends JFrame {
	JTextField nameField = new JTextField("",15);
	ResultPanel resultP = new ResultPanel();
	JTextArea textArea = new JTextArea(5,20);
	String tx;

	private int sty, stm, std,  edy, edm, edd;
	private String name;

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


	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(true);
		setVisible(true);
		add(resultP,BorderLayout.CENTER);
	}


	public void setButton () {
		JPanel buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);

		JButton calculateBtn = new JButton("Calculate");
		buttonPanel.add(calculateBtn);

		calculateBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				Run gibeom = new Run(name, sty,  stm, std, edy,edm, edd);
				gibeom.calculating();
				showResult(gibeom.getFinalResult());
				tx = gibeom.getFinalResult().toString();
				
			}
		});


		JButton resetBtn = new JButton("Reset");
		buttonPanel.add(resetBtn);

		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showResult(new StringBuilder(""));
			}
		});


		JButton saveAsTxt = new JButton("Save as txt");
		buttonPanel.add(saveAsTxt);
		
		saveAsTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    OutputStream output = new FileOutputStream("C:\\Users\\ÅºÇö´ë´ë\\Documents\\Output.txt");
				    String str =tx;
				    byte[] by=str.getBytes();
				    output.write(by);
						
				} catch (Exception a) {
			            a.getStackTrace();
				}
			    }
			
			
		});
		
		buttonPanel.setLayout(fl);
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);


	}

	public void setDate() {

		GridLayout g = new GridLayout(3,4,2,2);
		StartEndInputPanel textField = new StartEndInputPanel(g);

		JPanel startPanel = new JPanel(new FlowLayout());
		JPanel endPanel = new JPanel();
		JPanel namePanel = new JPanel();
		
		JLabel startLabel = new JLabel("Start");
		JLabel endLabel = new JLabel("End  ");
		JLabel nameLabel = new JLabel("Name");
		

		this.name = nameField.getText();
		

		String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
		String [] startMonth = { "1","2","3","4","5","6","7","8","9","10","11","12"};		
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

		this.sty = Integer.parseInt(sty.getSelectedItem().toString());
		this.stm = Integer.parseInt(stm.getSelectedItem().toString());
		this.std =  Integer.parseInt(std.getSelectedItem().toString());
		
		sty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setSty(Integer.parseInt(str));
					System.out.println(str);
				}
			}
		});

		stm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStm(Integer.parseInt(str));
					System.out.println(str);
				}
			}
		});
		
		std.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStd(Integer.parseInt(str));
					System.out.println(str);
				}
			}
		});


		JComboBox edy = new JComboBox(endYear);
		JComboBox edm = new JComboBox(endMonth);
		JComboBox edd = new JComboBox(endDay);
		JScrollPane pedy = new JScrollPane(edy);
		JScrollPane pedm = new JScrollPane(edm);
		JScrollPane pedd = new JScrollPane(edd);

		this.edy = Integer.parseInt(edy.getSelectedItem().toString());
		this.edm = Integer.parseInt(edm.getSelectedItem().toString());
		this.edd =  Integer.parseInt(edd.getSelectedItem().toString());
		
		edy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdy(Integer.parseInt(str));
					System.out.println(str);
				}
			}
		});

		
		edm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdm(Integer.parseInt(str));
					System.out.println(str);
				}
			}
		});
	
		edd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox jbox = (JComboBox)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdd(Integer.parseInt(str));
					System.out.println(str);
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

	public void showResult(StringBuilder str) {


		textArea.setText(str.toString());
		textArea.setEditable(false);
		textArea.setFont(new Font("°íµñ",Font.TRUETYPE_FONT,17));


	}
	
	public void setResult() {
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));

		setVisible(true);

		
	}
	

}
