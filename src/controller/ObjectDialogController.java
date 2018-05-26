package controller;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import main.AppManager;
import model.Shape;
import view.MainPanel;
import view.ObjectDialog;

public class ObjectDialogController {

	private ObjectDialog objectDialog;
	private Shape shape;
	private int mode;

	public ObjectDialogController(Shape shape, int mode) {
		this.shape = shape;
		objectDialog = AppManager.createAppManager().getObjectDialog();
		this.mode = mode;

		objectDialog.callActionPerformed(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == objectDialog.getOkBtn()) {
					System.out.println("ok");

					shape.setName(objectDialog.getNameTextField().getText());

					try {
						int widthTemp = Integer.parseInt(objectDialog.getWidthTextField().getText());
						widthTemp = (int) (widthTemp * MainPanel.rate);
						shape.setWidth(widthTemp);
					} catch (Exception e) {
						errorDialog();
						return;
					}

					try {
						int heigthTemp = Integer.parseInt(objectDialog.getHeightTextField().getText());
						heigthTemp = (int) (heigthTemp * MainPanel.rate);
						shape.setHeight(heigthTemp);
					} catch (Exception e) {
						errorDialog();
						return;
					}
					if (shape.getName().equals("") || shape.getWidth() == 0 || shape.getHeight() == 0) {
						JOptionPane.showMessageDialog(objectDialog, "올바른 입력을 해주세요", "입력 에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (shape.getImgPath() == null) {
						shape.setImgPath("./image/default.png");
					}
					Image img = new ImageIcon(shape.getImgPath()).getImage();
					if(mode == 0){
						MainPanel.shapeVec.addElement(new Shape(img, shape.getImgPath(), 10, 10, shape.getWidth(),
								shape.getHeight(), shape.getName()));						
					}
					AppManager.createAppManager().getCanvasPanel().repaint();
					objectDialog.dispose();

				} else if (ae.getSource() == objectDialog.getImageBtn()) {

					FileDialog dialog;
					StringBuilder sb = new StringBuilder("");
					String imgPath;
					dialog = new FileDialog(AppManager.createAppManager().getMainFrame(), "Load image",
							FileDialog.LOAD);
					dialog.setDirectory(".");
					dialog.setVisible(true);

					if (dialog.getFile() == null)
						return;
					System.out.println(dialog.getFile());

					sb.append("./image/");
					if (dialog.getFile().contains(".txt") || dialog.getFile().contains(".hwp")
							|| dialog.getFile().contains(".jar") || dialog.getFile().contains(".md")
							|| dialog.getFile().contains(".pptx")) {
						JOptionPane.showMessageDialog(objectDialog, "그림 파일이 아닙니다. 기본 이미지로 대체합니다.", "파일 입력 에러",
								JOptionPane.ERROR_MESSAGE);
						sb.append("default.png");
					} else {
						sb.append(dialog.getFile());
					}
					imgPath = sb.toString();
					shape.setImgPath(imgPath);

				} else {
					System.out.println("cancel");
					objectDialog.dispose();
				}
			}
		});
	}

	private void errorDialog() {
		JOptionPane.showMessageDialog(objectDialog, "숫자를 입력해 주세요.", "숫자 에러", JOptionPane.ERROR_MESSAGE);
	}

}