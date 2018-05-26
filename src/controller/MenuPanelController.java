package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.AppManager;
import values.GlobalNum;
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
				if(obj == menuPanel.getWallBtn()) // 1
				{
					clicked = GlobalNum.WALL;
				}
				else if(obj == menuPanel.getDoorBtn()) //2
				{
					clicked = GlobalNum.DOOR;
				}
				else if(obj == menuPanel.getWindowBtn()) //3
				{
					clicked = GlobalNum.WINDOW;
				}
				else if(obj == menuPanel.getColorBtn()) //5
				{
					clicked = GlobalNum.COLOR;
				}
				else if(obj == menuPanel.getClearBtn())
				{
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
	//---------------------------------------
	
}
