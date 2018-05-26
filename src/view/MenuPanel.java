package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.AppManager;
import model.Shape;
import values.GlobalNum;

public class MenuPanel extends JPanel{
	
	private PanelManager panelManager;
	private CanvasPanel canvasPanel;
	private Shape drawingShape = null;
	private Shape eraseShape = null;

	private JButton wallBtn;
	
	private JButton doorBtn;
	private JButton windowBtn;
	
	private JButton colorBtn;
	private JButton clearBtn;
	
	public MenuPanel()
	{
		wallBtn = new JButton(GlobalNum.WALL);
		doorBtn = new JButton(GlobalNum.DOOR);
		windowBtn = new JButton(GlobalNum.WINDOW);		
		colorBtn = new JButton(GlobalNum.COLOR);
		clearBtn = new JButton(GlobalNum.CLEAR);
		
		add(wallBtn);
		add(doorBtn);
		add(windowBtn);
		add(colorBtn);
		add(clearBtn);				
	}
	
	
	
	public PanelManager getPanelManager() {
		return panelManager;
	}
	public void setPanelManager(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}
	public void setCanvasPanel(CanvasPanel canvasPanel) {
		this.canvasPanel = canvasPanel;
	}
	public Shape getDrawingShape() {
		return drawingShape;
	}
	public void setDrawingShape(Shape drawingShape) {
		this.drawingShape = drawingShape;
	}
	public Shape getEraseShape() {
		return eraseShape;
	}
	public void setEraseShape(Shape eraseShape) {
		this.eraseShape = eraseShape;
	}
	public JButton getWallBtn() {
		return wallBtn;
	}
	public void setWallBtn(JButton wallBtn) {
		this.wallBtn = wallBtn;
	}
	public JButton getDoorBtn() {
		return doorBtn;
	}
	public void setDoorBtn(JButton doorBtn) {
		this.doorBtn = doorBtn;
	}
	public JButton getWindowBtn() {
		return windowBtn;
	}
	public void setWindowBtn(JButton windowBtn) {
		this.windowBtn = windowBtn;
	}
	public JButton getColorBtn() {
		return colorBtn;
	}
	public void setColorBtn(JButton colorBtn) {
		this.colorBtn = colorBtn;
	}
	public JButton getClearBtn() {
		return clearBtn;
	}
	public void setClearBtn(JButton clearBtn) {
		this.clearBtn = clearBtn;
	}

	public void setBtnListener(ActionListener listener){
		
		wallBtn.addActionListener(listener);
		doorBtn.addActionListener(listener);
		windowBtn.addActionListener(listener);
		colorBtn.addActionListener(listener);
		clearBtn.addActionListener(listener);
	}
		

}
