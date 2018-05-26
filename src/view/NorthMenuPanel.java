package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.AppManager;

public class NorthMenuPanel extends JPanel{
	public NorthMenuPanel(){
		setLayout(new FlowLayout());		
	}
	
	public void addBtn(JButton btn){
		add(btn);
	}
}
