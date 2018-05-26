package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.AppManager;
import values.GlobalNum;

public class IntroPanel extends JPanel {

	private JButton startBtn;

	public IntroPanel() {

		setLayout(new FlowLayout());
		startBtn = new JButton("Start!");
		add(startBtn);

	}

	public void callActionListenter(ActionListener listener) {
		startBtn.addActionListener(listener);
	}

	// getter setter
	public JButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}

}