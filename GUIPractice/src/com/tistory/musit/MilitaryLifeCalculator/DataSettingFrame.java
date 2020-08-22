package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DataSettingFrame extends JFrame {

	private String name;
	private String titleBorder = "Input Data";

	public int sty, stm, std, edy, edm, edd;
	
	JTextField nameField = new JTextField("",14);

	GridLayout g = new GridLayout(3,4,2,2);
	StartEndInputPanel dataInputPanel = new StartEndInputPanel(g);
	
	public void setData(){

		JPanel startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"Start"와 JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel endPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"End"와  JComboBox 3개(년, 월, 일)을 넣는 panel
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//name과 textField를 넣는 panel

		JLabel startLabel = new JLabel("입대일");
		JLabel endLabel = new JLabel("전역일");
		JLabel nameLabel = new JLabel("이름 ");


		this.name = nameField.getText();
		//입대년도, 월, 일을 LIST로 만들어 JComboBox에 묶어둠
		String [] startYear = {"2019", "2020", "2021", "2022", "2023"};
		String [] startMonth = { "1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] startDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		//전역년도, 월, 일을 LIST로 만들어 JComboBox에 묶어둠
		String [] endYear =  { "2020", "2021", "2022", "2023","2024","2025"};
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

		dataInputPanel.add(startPanel);
		dataInputPanel.add(endPanel);
		dataInputPanel.add(namePanel);
		add(dataInputPanel,BorderLayout.NORTH);	

		dataInputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), titleBorder));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	public StartEndInputPanel getDataInputPanel() {
		return dataInputPanel;
	}
	
	public void setDataInputPanel(StartEndInputPanel dataInputPanel) {
		this.dataInputPanel = dataInputPanel;
	}
	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public String getTitleBorder() {
		return titleBorder;
	}

	public void setTitleBorder(String titleBorder) {
		this.titleBorder = titleBorder;
	}
}
