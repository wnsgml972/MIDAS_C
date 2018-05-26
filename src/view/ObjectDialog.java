package view;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.AppManager;
import model.Shape;

public class ObjectDialog extends JFrame implements ActionListener {
	// private MainPanel mainPanel;

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

	public ObjectDialog(Shape shapeTemp) {

		shape = shapeTemp;

		this.setLayout(new GridLayout(2, 3));
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

		// img panel
		imagePanel = new JPanel();
		imagePanel.setLayout(new FlowLayout());
		imagePanel.setSize(this.getWidth(), 30);

		imageBtn = new JButton("이미지 삽입");
		imageBtn.addActionListener(this);
		imagePanel.add(imageBtn);

		this.add(imagePanel);

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
		JOptionPane.showMessageDialog(this, "숫자를 입력해 주세요", "숫자 에러", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == okBtn) {
			System.out.println("ok");

			shape.setName(nameTextField.getText());

			try {
				
				/* width */
				int widthTemp = Integer.parseInt(widthTextField.getText());
				shape.setWidth(widthTemp);
			} catch (Exception e) {
				errorDialog();
				return;
			}

			try {
				
				/* height */
				int heigthTemp = Integer.parseInt(heightTextField.getText());
				shape.setHeight(heigthTemp);
			} catch (Exception e) {
				errorDialog();
				return;
			}
			if(shape.getName()  == null  || shape.getWidth()  == 0 ||
					shape.getWidth() == 0 ){
				JOptionPane.showMessageDialog(this, "올바른 입력을 해주세요", "입력 에러", JOptionPane.ERROR_MESSAGE);
			}
			if(shape.getImgPath() == null){
				shape.setImgPath("./image/default.png");
			}
			Image img = new ImageIcon(shape.getImgPath()).getImage();
			MainPanel.shapeVec.addElement(new Shape(img, shape.getImgPath() ,10, 10,  shape.getWidth(), shape.getHeight(), shape.getName()));
			AppManager.createAppManager().getCanvasPanel().repaint();
			dispose();
			
		} else if (ae.getSource() == imageBtn) {
			
			// 수정
			FileDialog dialog;
			StringBuilder sb = new StringBuilder("");
			String imgPath;
			dialog = new FileDialog(AppManager.createAppManager().getMainFrame(), "Load image", FileDialog.LOAD);
			dialog.setDirectory(".");
			dialog.setVisible(true);

			if (dialog.getFile() == null)
				return;
			System.out.println(dialog.getFile());
			
			sb.append("./image/");
			if(dialog.getFile().contains(".txt") || dialog.getFile().contains(".hwp") || dialog.getFile().contains(".jar")
					 || dialog.getFile().contains(".md") || dialog.getFile().contains(".pptx") ){
				JOptionPane.showMessageDialog(this, "그림 파일이 아닙니다. 기본 이미지로 대체합니다.", "파일 입력 에러", JOptionPane.ERROR_MESSAGE);
				sb.append("default.png");
			}
			else {
				sb.append(dialog.getFile());
			}
			imgPath = sb.toString();
			shape.setImgPath(imgPath);
			
		} else {
			System.out.println("cancel");
			dispose();
		}
	}
}
