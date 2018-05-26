package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.AppManager;
import model.Shape;

public class ObjectDialog extends JFrame implements ActionListener {
	//private MainPanel mainPanel;
	
	private Shape shape;
	
	private JPanel jPanel;
	
	private JPanel imgPanel;
	private JButton imgBtn;
	// private imgPath
	
	private JPanel namePanel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JPanel widthPanel;
	private JLabel widthLabel;
	private JTextField widthTextField;
	
	private JPanel heightPanel;
	private JLabel heightLabel;
	private JTextField heightTextField;
	
	private JPanel btnPanel;
	private JButton okBtn;
	private JButton cancelBtn;
	
	public ObjectDialog(Shape shapeTemp) { // , ObjectClass objClass
		
		//mainPanel = AppManager.createAppManager().getMainPanel();
		
		shape = shapeTemp;
		
		//this.setSize(250, 400);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new FlowLayout());
		this.setLocation(100, 200);
		
		// default value
		// img
		
		
		
		// name panel
		namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		namePanel.setSize(this.getWidth(), 30);
		
		nameLabel = new JLabel("이름");
		namePanel.add(nameLabel);
		
		nameTextField = new JTextField(shape.getName());
		nameTextField.setColumns(10);
		namePanel.add(nameTextField);
		
		this.add(namePanel);
		
		
		// width panel
		widthPanel = new JPanel();
		widthPanel.setLayout(new FlowLayout());
		widthPanel.setSize(this.getWidth(), 30);
		
		widthLabel = new JLabel("가로");
		widthPanel.add(widthLabel);
		
		String widthString = String.valueOf(shape.getWidth());
		widthTextField = new JTextField(widthString);
		widthTextField.setColumns(10);
		widthPanel.add(widthTextField);
		
		this.add(widthPanel);
		
		// height panel
		heightPanel = new JPanel();
		heightPanel.setLayout(new FlowLayout());
		heightPanel.setSize(this.getWidth(), 30);
		
		heightLabel = new JLabel("세로");
		heightPanel.add(heightLabel);
		
		
		String heightString = String.valueOf(shape.getHeight());
		heightTextField = new JTextField(heightString);
		heightTextField.setColumns(10);
		heightPanel.add(heightTextField);
		
		this.add(heightPanel);
		
		// button panel
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setSize(this.getWidth(), 30);
		
		okBtn = new JButton("저장");
		okBtn.addActionListener(this);
		btnPanel.add(okBtn);
		
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(this);
		btnPanel.add(cancelBtn);
		
		this.add(btnPanel);
		this.pack();
	}
	
	private void errorDialog() {
		JOptionPane.showMessageDialog(this,
			    "숫자를 입력해 주세요",
			    "숫자 에러",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == okBtn) {
			System.out.println("ok");
			
			shape.setName(nameTextField.getText());
			
			try {
				int widthTemp = Integer.parseInt(widthTextField.getText());
				shape.setWidth(widthTemp);
			} catch(Exception e) {
				errorDialog();
				return;
			}
			
			try {
				int heigthTemp = Integer.parseInt(heightTextField.getText());
				shape.setHeight(heigthTemp);
			} catch(Exception e) {
				errorDialog();
				return;
			}
		}
		else {
			System.out.println("cancel");
		}
		dispose();
	}
}
