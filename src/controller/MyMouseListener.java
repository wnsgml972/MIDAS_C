package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.AppManager;
import model.Shape;
import values.GlobalNum;
import view.CanvasPanel;
import view.MainPanel;

public class MyMouseListener implements MouseListener, MouseMotionListener {

	private CanvasPanel canvasPanel;
	private CanvasPanelController canvasController;
	private MenuPanelController menuController;
	private int x, y, x1, y1, x2, y2, width, height;
	private Shape shape;
	private String clicked;
	private int position;

	public MyMouseListener() {
		canvasController = AppManager.createAppManager().getCanvasPanelController();
		canvasPanel = AppManager.createAppManager().getCanvasPanel();
		menuController = AppManager.createAppManager().getMenuPanelController();

	}

	private void initSelect() {
		for (int i = 0; i < MainPanel.shapeVec.size(); i++) {
			shape = MainPanel.shapeVec.get(i);
			if(shape.getState() == true){
				
				if(shape.getRed() == 255 && shape.getGreen() == 13 && shape.getBlue() == 13 ){
					shape.setRed(0);
					shape.setGreen(0);
					shape.setBlue(0);
				}
				
				shape.setState(false);
				
				
				shape.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x2 = x1 = e.getX();
		y2 = y1 = e.getY();
		clicked = menuController.getClicked();

		// 선택 해제
		initSelect();

		if (clicked.equals(GlobalNum.WALL) ) { //add wall
			shape = new Shape(clicked, x1, y1, 0, 0);
			MainPanel.shapeVec.addElement(shape);
		}
		else if (clicked.equals(GlobalNum.DOOR) || clicked.equals(GlobalNum.WINDOW)){
			for (int i = 0; i < MainPanel.shapeVec.size(); i++) { //여기서부터
				
			}
			shape = new Shape(clicked, x1, y1, 0, 0);
			MainPanel.shapeVec.addElement(shape);
		}
		else if (clicked.equals("line")) {
			shape = new Shape(clicked, x1, y1, x1, y1);
			MainPanel.shapeVec.addElement(shape);
		} 
		else if (clicked.equals("select")) {  //select Shape!

			for (int i = MainPanel.shapeVec.size() - 1; i >= 0; i--) {
				shape = MainPanel.shapeVec.get(i);
				position = i;
				if (shape.getShape().equals("line")) { //Line clicked
					if (x1 >= shape.getX() && x2 <= shape.getWidth() && y1 >= shape.getY() && y1 <= shape.getHeight()) {
						clicked = "clicked";
						width = x1 - shape.getX();
						height = y1 - shape.getY();
						break;
					}
				} else { //Wall clicked					
					if (x1 >= shape.getX() && x2 <= shape.getWidth() + shape.getX() && y1 >= shape.getY()
							&& y1 <= shape.getHeight() + shape.getY()) {
						clicked = "clicked";
						width = x1 - shape.getX();
						height = y1 - shape.getY();
						if(!(shape.getRed() == 0 && shape.getGreen() == 0  && shape.getBlue() == 0 )){
							shape.setState(true);
							break;
						}
						shape.setRed(255);
						shape.setGreen(13);
						shape.setBlue(13);
						shape.setColor(new Color(255, 13,13));
						shape.setState(true);
						break;
					}
				}
			}
		}
}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		if (clicked.equals(GlobalNum.WALL)) {
			drawWall();
		} 
		else if (clicked.equals(GlobalNum.DOOR)) {
			drawDoor();
		} 
		else if (clicked.equals(GlobalNum.WINDOW)) {
			drawWindow();
		} 
		else if (clicked.equals("line")) {
			drawLine();
		} 
		else if (clicked.equals("clicked")) // selected object
		{
			move();
		}

		menuController.setClicked("select"); //select로 바꿔서 그 안에서 컨트롤해 안에서 선택된 애를 찾음
		clicked = "select";
		canvasPanel.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		if (clicked.equals(GlobalNum.WALL)) {
			drawWall();
		}
		else if (clicked.equals(GlobalNum.DOOR)) {
			drawDoor();
		} 
		else if (clicked.equals(GlobalNum.WINDOW)) {
			drawWindow();
		} 
		else if (clicked.equals("line")) {
			drawLine();
		} 
		else if (clicked.equals("clicked")) // selected object
		{
			move();
		}
		canvasPanel.repaint();

	}

	public void drawWall() {
		if (x2 > x1) {
			width = x2 - x1;
			x = x1;
		} else {
			width = x1 - x2;
			x = x2;
		}

		if (y2 > y1) {
			height = y2 - y1;
			y = y1;
		} else {
			height = y1 - y2;
			y = y2;
		}
		shape = MainPanel.shapeVec.lastElement();
		shape.setX(x);
		shape.setY(y);
		shape.setWidth(width);
		shape.setHeight(height);
	}
	public void drawDoor() {
		if (x2 > x1) {
			width = x2 - x1;
			x = x1;
		} else {
			width = x1 - x2;
			x = x2;
		}

		if (y2 > y1) {
			height = y2 - y1;
			y = y1;
		} else {
			height = y1 - y2;
			y = y2;
		}
		shape = MainPanel.shapeVec.lastElement();
		shape.setX(x);
		shape.setY(y);
		shape.setWidth(width);
		shape.setHeight(height);
	}
	public void drawWindow() {
		if (x2 > x1) {
			width = x2 - x1;
			x = x1;
		} else {
			width = x1 - x2;
			x = x2;
		}

		if (y2 > y1) {
			height = y2 - y1;
			y = y1;
		} else {
			height = y1 - y2;
			y = y2;
		}
		shape = MainPanel.shapeVec.lastElement();
		shape.setX(x);
		shape.setY(y);
		shape.setWidth(width);
		shape.setHeight(height);
	}
	
	public void drawLine() {
		shape = MainPanel.shapeVec.lastElement();
		shape.setX(x1);
		shape.setWidth(x2);
		shape.setY(y1);
		shape.setHeight(y2);
	}

	public void move() 
	{
		shape = MainPanel.shapeVec.get(position);
		shape.setX(x2 - width);
		shape.setY(y2 - height);

	}

	// ---------------------------------------------------------------------
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	//

}