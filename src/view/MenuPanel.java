package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.AppManager;
import model.Shape;
import values.GlobalNum;

public class MenuPanel extends JPanel {

	private PanelManager panelManager;
	private CanvasPanel canvasPanel;
	private Shape drawingShape = null;

	private JButton wallBtn;
	private JButton doorBtn;
	private JButton windowBtn;
	private JButton colorBtn;
	private JButton clearBtn;

	private JButton plusBtn;
	private JButton basicOneBtn;
	private ImageIcon basicOneIcon;

	private JButton basicTwoBtn;
	private ImageIcon basicTwoIcon;

	public MenuPanel() {
		setLayout(new GridLayout(2, 1));
		AppManager.createAppManager().setNorthMenuPanel(new NorthMenuPanel());
		AppManager.createAppManager().setSouthMenuPanel(new SouthMenuPanel());

		wallBtn = new JButton(GlobalNum.WALL);
		doorBtn = new JButton(GlobalNum.DOOR);
		windowBtn = new JButton(GlobalNum.WINDOW);
		colorBtn = new JButton(GlobalNum.COLOR);
		clearBtn = new JButton(GlobalNum.CLEAR);
		plusBtn = new JButton(GlobalNum.PLUS);

		basicOneIcon = new ImageIcon("./image/washer.png");
		basicTwoIcon = new ImageIcon("./image/refrigerator.png");

		basicOneBtn = new JButton(basicOneIcon);
		basicTwoBtn = new JButton(basicTwoIcon);

		basicOneBtn.setBorderPainted(false);
		basicOneBtn.setContentAreaFilled(false);

		basicTwoBtn.setBorderPainted(false);
		basicTwoBtn.setContentAreaFilled(false);

		add(AppManager.createAppManager().getNorthMenuPanel());
		add(AppManager.createAppManager().getSouthMenuPanel());

		AppManager.createAppManager().getNorthMenuPanel().addBtn(wallBtn);
		AppManager.createAppManager().getNorthMenuPanel().addBtn(doorBtn);
		AppManager.createAppManager().getNorthMenuPanel().addBtn(windowBtn);
		AppManager.createAppManager().getNorthMenuPanel().addBtn(colorBtn);
		AppManager.createAppManager().getNorthMenuPanel().addBtn(clearBtn);

		AppManager.createAppManager().getSouthMenuPanel().addBtn(basicOneBtn);
		AppManager.createAppManager().getSouthMenuPanel().addBtn(basicTwoBtn);
		AppManager.createAppManager().getSouthMenuPanel().addBtn(plusBtn);
	}
	
	public JButton getPlusBtn() {
		return plusBtn;
	}

	public void setPlusBtn(JButton plusBtn) {
		this.plusBtn = plusBtn;
	}

	public JButton getBasicOneBtn() {
		return basicOneBtn;
	}

	public void setBasicOneBtn(JButton basicOneBtn) {
		this.basicOneBtn = basicOneBtn;
	}

	public ImageIcon getBasicOneIcon() {
		return basicOneIcon;
	}

	public void setBasicOneIcon(ImageIcon basicOneIcon) {
		this.basicOneIcon = basicOneIcon;
	}

	public JButton getBasicTwoBtn() {
		return basicTwoBtn;
	}

	public void setBasicTwoBtn(JButton basicTwoBtn) {
		this.basicTwoBtn = basicTwoBtn;
	}

	public ImageIcon getBasicTwoIcon() {
		return basicTwoIcon;
	}

	public void setBasicTwoIcon(ImageIcon basicTwoIcon) {
		this.basicTwoIcon = basicTwoIcon;
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

	public void setBtnListener(ActionListener listener) {
		wallBtn.addActionListener(listener);
		doorBtn.addActionListener(listener);
		windowBtn.addActionListener(listener);
		colorBtn.addActionListener(listener);
		clearBtn.addActionListener(listener);
		basicOneBtn.addActionListener(listener);
		basicTwoBtn.addActionListener(listener);
		plusBtn.addActionListener(listener);
	}
}
