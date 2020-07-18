import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ComboBoxExample extends JFrame{
	String[] fruits={"apple", "banana", "kiwi", "mango"};
	ImageIcon[] images={new ImageIcon("apple.jpg"), new ImageIcon("banana.jpg"), new ImageIcon("kiwi.jpg"), new ImageIcon("mango.jpg")};
	JLabel la;
	ComboBoxExample(){
		this.setTitle("콤보박스 활용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		JComboBox cb = new JComboBox(fruits);
		cb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb =(JComboBox)e.getSource();
				int index=jcb.getSelectedIndex();
				la.setIcon(images[index]);
			}

		});
		this.add(cb);
		la = new JLabel(images[0]);
		this.add(la);
		this.setLocationRelativeTo(null);
		this.setSize(300,300);
		this.setVisible(true);
	}
}


