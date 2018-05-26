package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import main.AppManager;
import model.Shape;
import values.GlobalNum;
import view.MainPanel;
import view.MenuPanel;
import view.ObjectDialog;

public class MenuPanelController {

	private MenuPanel menuPanel;
	private MainPanel mainPanel;
	private JsonParser jsonParser;
	private String clicked = "select";

	public MenuPanelController() {
		menuPanel = AppManager.createAppManager().getMenuPanel();
		mainPanel = AppManager.createAppManager().getMainPanel();
		jsonParser = AppManager.createAppManager().getJsonParser();

		menuPanel.setBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				// clicked selelct
				if (obj == menuPanel.getWallBtn()) // 1
				{
					clicked = GlobalNum.WALL;
				} else if (obj == menuPanel.getDoorBtn()) // 2
				{
					clicked = GlobalNum.DOOR;
				} else if (obj == menuPanel.getWindowBtn()) // 3
				{
					clicked = GlobalNum.WINDOW;
				} else if (obj == menuPanel.getColorBtn()) // 5
				{
					for (int i = MainPanel.shapeVec.size() - 1; i >= 0; i--) {
						Shape shape = MainPanel.shapeVec.get(i);
						if (shape.isCloseSpace()) {
							JOptionPane.showMessageDialog(null, "벽이 모두 막혀있습니다. 색깔을 바꿀 수 없습니다.");
							break;
						}
						if (shape.getState() == true) {
							JColorChooser jColorChooser = new JColorChooser();
							Color color = jColorChooser.showDialog(null, "Color", Color.WHITE);
							shape.setRed(color.getRed());
							shape.setGreen(color.getGreen());
							shape.setBlue(color.getBlue());
							shape.setColor(color);
							shape.setColorSelected(true);
							AppManager.createAppManager().getCanvasPanel().repaint();
							break;
						}
					}
				} else if (obj == menuPanel.getClearBtn()) {
					mainPanel.shapeVec.removeAllElements();
					AppManager.createAppManager().getCanvasPanel().repaint();
					clicked = GlobalNum.CLEAR;
				} else if (obj == menuPanel.getBasicOneBtn()) {
					Image img = menuPanel.getBasicOneIcon().getImage();
					if(AppManager.createAppManager().getCanvasPanel().getWidth() == 0){
						return;
					}
					MainPanel.shapeVec.addElement(new Shape(img, "./image/washer.png", 10, 10, 50, 50, "세탁기",
							AppManager.createAppManager().getCanvasPanel().getWidth(),
							AppManager.createAppManager().getCanvasPanel().getHeight()));
					AppManager.createAppManager().getCanvasPanel().repaint();
				} else if (obj == menuPanel.getBasicTwoBtn()) {
					if(AppManager.createAppManager().getCanvasPanel().getWidth() == 0){
						return;
					}	
					Image img = menuPanel.getBasicTwoIcon().getImage();
					MainPanel.shapeVec.addElement(new Shape(img, "./image/refrigerator.png", 10, 10, 50, 50, "냉장고",
							AppManager.createAppManager().getCanvasPanel().getWidth(),
							AppManager.createAppManager().getCanvasPanel().getHeight()));
					AppManager.createAppManager().getCanvasPanel().repaint();
				} else if (obj == menuPanel.getPlusBtn()) {
					Shape shape = new Shape();
					AppManager.createAppManager().setObjectDialog(new ObjectDialog(shape, 0));
					AppManager.createAppManager().setObjectDialogController(new ObjectDialogController(shape, 0));
					ObjectDialog objectDialog = AppManager.createAppManager().getObjectDialog();
					objectDialog.setVisible(true);
				}

			}
		});
	}

	// getter setter
	public String getClicked() {
		return clicked;
	}

	public void setClicked(String clicked) {
		this.clicked = clicked;
	}
	// ---------------------------------------

}
