package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.AppManager;
import values.GlobalNum;

public class IntroPanel extends JPanel {
	
	private JButton startBtn = new JButton("Start!");
	
	public IntroPanel(){
		setLayout(new FlowLayout());
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AppManager.createAppManager().getPanelManager().setContentPane(GlobalNum.MAIN);
			}
		});
		
		add(startBtn);
	}
}
