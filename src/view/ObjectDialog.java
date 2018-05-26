package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Shape;

public class ObjectDialog extends JFrame {

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

	private JPanel imagePanel;
	private JButton imageBtn;

	private JPanel btnPanel;
	private JButton okBtn;
	private JButton cancelBtn;
	
	private int mode;

	public ObjectDialog(Shape shape, int mode) {

		this.shape = shape;
		this.setLayout(new GridLayout(2, 3));
		this.setLocation(100, 200);
		this.mode = mode;

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

		

		String widthString = String.valueOf((int)(shape.getWidth() / MainPanel.rate));			

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

		String heightString = String.valueOf((int)(shape.getHeight()  / MainPanel.rate));
		
		heightTextField = new JTextField(heightString);
		heightTextField.setColumns(10);
		heightPanel.add(heightTextField);

		this.add(heightPanel);

		// img panel
		imagePanel = new JPanel();
		imagePanel.setLayout(new FlowLayout());
		imagePanel.setSize(this.getWidth(), 30);

		imageBtn = new JButton("이미지 삽입");
		imagePanel.add(imageBtn);

		this.add(imagePanel);

		// button panel
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setSize(this.getWidth(), 30);

		okBtn = new JButton("저장");
		btnPanel.add(okBtn);

		cancelBtn = new JButton("취소");
		btnPanel.add(cancelBtn);

		this.add(btnPanel);

		this.pack();
	}

	public void callActionPerformed(ActionListener listener) {
		okBtn.addActionListener(listener);
		imageBtn.addActionListener(listener);
	}

	// getter setter

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	public JPanel getImgPanel() {
		return imgPanel;
	}

	public void setImgPanel(JPanel imgPanel) {
		this.imgPanel = imgPanel;
	}

	public JButton getImgBtn() {
		return imgBtn;
	}

	public void setImgBtn(JButton imgBtn) {
		this.imgBtn = imgBtn;
	}

	public JPanel getNamePanel() {
		return namePanel;
	}

	public void setNamePanel(JPanel namePanel) {
		this.namePanel = namePanel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JPanel getWidthPanel() {
		return widthPanel;
	}

	public void setWidthPanel(JPanel widthPanel) {
		this.widthPanel = widthPanel;
	}

	public JLabel getWidthLabel() {
		return widthLabel;
	}

	public void setWidthLabel(JLabel widthLabel) {
		this.widthLabel = widthLabel;
	}

	public JTextField getWidthTextField() {
		return widthTextField;
	}

	public void setWidthTextField(JTextField widthTextField) {
		this.widthTextField = widthTextField;
	}

	public JPanel getHeightPanel() {
		return heightPanel;
	}

	public void setHeightPanel(JPanel heightPanel) {
		this.heightPanel = heightPanel;
	}

	public JLabel getHeightLabel() {
		return heightLabel;
	}

	public void setHeightLabel(JLabel heightLabel) {
		this.heightLabel = heightLabel;
	}

	public JTextField getHeightTextField() {
		return heightTextField;
	}

	public void setHeightTextField(JTextField heightTextField) {
		this.heightTextField = heightTextField;
	}

	public JPanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(JPanel imagePanel) {
		this.imagePanel = imagePanel;
	}

	public JButton getImageBtn() {
		return imageBtn;
	}

	public void setImageBtn(JButton imageBtn) {
		this.imageBtn = imageBtn;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public JButton getOkBtn() {
		return okBtn;
	}

	public void setOkBtn(JButton okBtn) {
		this.okBtn = okBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
}