package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetupDialog extends JFrame {

	private JLabel askSentence;
	private JLabel widthLabel;
	private JLabel heightLabel;
	private JTextField widthTextField;
	private JTextField heightTextField;
	private JButton makeBtn;

	public SetupDialog() {
		this.setLayout(new FlowLayout());
		this.setSize(300, 200);
		
		/*
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));
		*/
		askSentence = new JLabel("가로 세로 길이를 입력해주세요");
		makeBtn = new JButton("만들기");
		
		
		// width panel
		JPanel widthPanel = new JPanel();
		widthPanel.setLayout(new FlowLayout());
		widthPanel.setSize(this.getWidth(), 30);
		
		widthLabel = new JLabel("가로");
		widthPanel.add(widthLabel);
		
		widthTextField = new JTextField(10);
		widthPanel.add(widthTextField);
		
		this.add(widthPanel);
		
		// height panel
		JPanel heightPanel = new JPanel();
		heightPanel.setLayout(new FlowLayout());
		heightPanel.setSize(this.getWidth(), 30);
		
		heightLabel = new JLabel("세로");
		heightPanel.add(heightLabel);
		
		
		heightTextField = new JTextField(10);
		heightPanel.add(heightTextField);
		
		this.add(widthPanel);
		this.add(heightPanel);
		
		this.add(askSentence);
		this.add(makeBtn);
		
		this.setVisible(true);
	}

	public void callActionListener(ActionListener listener) {
		makeBtn.addActionListener(listener);
		heightTextField.addActionListener(listener);
	}

	/// getter setter

	public JButton getMakeBtn() {
		return makeBtn;
	}

	public void setMakeBtn(JButton makeBtn) {
		this.makeBtn = makeBtn;
	}

	public JLabel getWidthLabel() {
		return widthLabel;
	}

	public void setWidthLabel(JLabel widthLabel) {
		this.widthLabel = widthLabel;
	}

	public JLabel getHeightLabel() {
		return heightLabel;
	}

	public void setHeightLabel(JLabel heightLabel) {
		this.heightLabel = heightLabel;
	}

	public JTextField getWidthTextField() {
		return widthTextField;
	}

	public void setWidthTextField(JTextField widthTextField) {
		this.widthTextField = widthTextField;
	}

	public JTextField getHeightTextField() {
		return heightTextField;
	}

	public void setHeightTextField(JTextField heightTextField) {
		this.heightTextField = heightTextField;
	}

	public JLabel getAskSentence() {
		return askSentence;
	}

	public void setAskSentence(JLabel askSentence) {
		this.askSentence = askSentence;
	}

}