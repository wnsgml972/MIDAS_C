package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.AppManager;
import view.CanvasPanel;
import view.MainPanel;
import view.MenuPanel;

public class MenuPanelController {

	private MenuPanel menuPanel;
	private MainPanel mainPanel;
	private JsonParser jsonParser;
	private String clicked ="select";
	
	public MenuPanelController()
	{
		menuPanel = AppManager.createAppManager().getMenuPanel();
		mainPanel = AppManager.createAppManager().getMainPanel();
		jsonParser = AppManager.createAppManager().getJsonParser();
		
		menuPanel.setBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				//clicked selelct
				if(obj == menuPanel.getRectBtn()) // 1
				{
					menuPanel.setBackground(Color.WHITE);
					clicked = "rectangle";
				}
				else if(obj == menuPanel.getLineBtn()) //2
				{
					menuPanel.setBackground(Color.red);
					clicked = "line";
				}
				else if(obj == menuPanel.getCircleBtn()) //3
				{
					menuPanel.setBackground(Color.pink);
					clicked = "circle";
				}
				else if(obj == menuPanel.getEraseBtn()) // 4
				{
					menuPanel.setBackground(Color.BLACK);
					clicked = "erase";
				}
				else if(obj == menuPanel.getColorBtn()) //5
				{
					menuPanel.setBackground(Color.BLUE);
					clicked = "color";
				}
				else if(obj == menuPanel.getClearBtn())
				{
					menuPanel.setBackground(Color.YELLOW);
					mainPanel.shapeVec.removeAllElements();
					AppManager.createAppManager().getCanvasPanel().repaint();
					clicked = "clear";
					
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
	//---------------------------------------
	
}
