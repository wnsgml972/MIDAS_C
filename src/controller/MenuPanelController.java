package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import main.AppManager;
import model.Shape;
import values.GlobalNum;
import view.MainPanel;
import view.MenuPanel;

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
				}
				else if (obj == menuPanel.getDoorBtn()) // 2
				{
					clicked = GlobalNum.DOOR;
				} 
				else if (obj == menuPanel.getWindowBtn()) // 3
				{
					clicked = GlobalNum.WINDOW;
				}
				else if (obj == menuPanel.getColorBtn()) // 5
				{
					for (int i = MainPanel.shapeVec.size() - 1; i >= 0; i--) {
						Shape shape = MainPanel.shapeVec.get(i);
						if (shape.getState() == true) {
							JColorChooser jColorChooser = new JColorChooser();
							Color color = jColorChooser.showDialog(null, "Color", Color.WHITE);
							shape.setRed(color.getRed());
							shape.setGreen(color.getGreen());
							shape.setBlue(color.getBlue());
							shape.setColor(color);
							AppManager.createAppManager().getCanvasPanel().repaint();
							break;
						}
					}
				} else if (obj == menuPanel.getClearBtn()) {
					mainPanel.shapeVec.removeAllElements();
					AppManager.createAppManager().getCanvasPanel().repaint();
					clicked = GlobalNum.CLEAR;
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
