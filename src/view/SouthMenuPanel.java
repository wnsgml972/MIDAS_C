package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SouthMenuPanel extends JPanel{
	public SouthMenuPanel(){
		setLayout(new FlowLayout());		
		setBackground(Color.lightGray);
	}
	
	public void addBtn(JButton btn){
		add(btn);
	}
}
