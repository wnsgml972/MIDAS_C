package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import main.AppManager;
import model.Shape;
import values.GlobalNum;
import view.CanvasPanel;
import view.MainPanel;
import view.ObjectPopUpMenu;

public class MyMouseListener implements MouseListener, MouseMotionListener {

	private CanvasPanel canvasPanel;
	private CanvasPanelController canvasController;
	private MenuPanelController menuController;
	private int x, y, x1, y1, x2, y2, width, height;
	private Shape shape;
	private String clicked;
	private int position;

	private int clickRange = 20;
	private int minusNum = 5;

	public MyMouseListener() {
		canvasController = AppManager.createAppManager().getCanvasPanelController();
		canvasPanel = AppManager.createAppManager().getCanvasPanel();
		menuController = AppManager.createAppManager().getMenuPanelController();
	}

	private void initSelect() {
		for (int i = 0; i < MainPanel.shapeVec.size(); i++) {
			shape = MainPanel.shapeVec.get(i);
			if (shape.getState() == true) {
				if (shape.getColorSelected() == false) {
					if (shape.isCloseSpace()) {
						shape.setRed(255);
					} else {
						shape.setRed(0);
					}
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

		if (clicked == null)
			return;

		// 선택 해제
		initSelect();

		if (clicked.equals(GlobalNum.WALL)) { // add wall
			shape = new Shape(clicked, x1, y1, 0, 0, AppManager.createAppManager().getCanvasPanel().getWidth(),
					AppManager.createAppManager().getCanvasPanel().getHeight());
			MainPanel.shapeVec.addElement(shape);
		} else if (clicked.equals(GlobalNum.DOOR) || clicked.equals(GlobalNum.WINDOW)) {
			shape = new Shape(clicked, x1, y1, 0, 0, AppManager.createAppManager().getCanvasPanel().getWidth(),
					AppManager.createAppManager().getCanvasPanel().getHeight());
			MainPanel.shapeVec.addElement(shape);
		} else if (clicked.equals("line")) {
			shape = new Shape(clicked, x1, y1, x1, y1, AppManager.createAppManager().getCanvasPanel().getWidth(),
					AppManager.createAppManager().getCanvasPanel().getHeight());
			MainPanel.shapeVec.addElement(shape);
		} else if (clicked.equals("select")) { // select Shape!

			for (int i = MainPanel.shapeVec.size() - 1; i >= 0; i--) {
				shape = MainPanel.shapeVec.get(i);
				position = i;

				int xTmp1 = shape.getX();
				int xTmp2 = shape.getX() + shape.getWidth();
				int yTmp1 = shape.getY();
				int yTmp2 = shape.getY() + shape.getHeight();

				if (shape.getShape().equals("line")) { // Line clicked
					if (x1 >= shape.getX() && x2 <= shape.getWidth() && y1 >= shape.getY() && y1 <= shape.getHeight()) {
						clicked = "clicked";
						width = x1 - shape.getX();
						height = y1 - shape.getY();
						break;
					}
				} else { // Wall clicked
							// if (x1 >= shape.getX() && x2 <= shape.getWidth()
							// + shape.getX() && y1 >= shape.getY()
							// && y1 <= shape.getHeight() + shape.getY())
							// 위 -> 오른쪽 -> 아래 -> 왼쪽 순서로 검사
					if (shape.getType() == 0) {
						if ((xTmp1 <= x1 && x1 <= xTmp2 && yTmp1 - clickRange <= y1 && y1 <= yTmp1 + clickRange)
								|| (yTmp1 <= y1 && y1 <= yTmp2 && xTmp2 - clickRange <= x1 && x1 <= xTmp2 + clickRange)
								|| (xTmp1 <= x1 && x1 <= xTmp2 && yTmp2 - clickRange <= y1 && y1 <= yTmp2 + clickRange)
								|| (yTmp1 <= y1 && y1 <= yTmp2 && xTmp1 - clickRange <= x1
										&& x1 <= xTmp1 + clickRange)) {
							if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
								ObjectPopUpMenu test = new ObjectPopUpMenu(position, 2);
								test.show(e.getComponent(), x1, y1);
								return;
							}
							clicked = "clicked";
							width = x1 - shape.getX();
							height = y1 - shape.getY();
							if (shape.getColorSelected() == true) { // color
								// select
								shape.setColor(new Color(0, 0, 255));
								shape.setState(true);
								break;
							}
							// color select
							shape.setRed(0);
							shape.setGreen(0);
							shape.setBlue(255);
							shape.setColor(new Color(0, 0, 255));
							shape.setState(true);
							break;
						}
					} else if (shape.getType() == 1) {
						if (x1 >= shape.getX() && x2 <= shape.getWidth() + shape.getX() && y1 >= shape.getY()
								&& y1 <= shape.getHeight() + shape.getY()) {
							// 마우스 우클릭
							if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
								ObjectPopUpMenu test = new ObjectPopUpMenu(position, 1);
								test.show(e.getComponent(), x1, y1);
								return;
							}
							clicked = "clicked";
							width = x1 - shape.getX();
							height = y1 - shape.getY();
							if (!(shape.getRed() == 0 && shape.getGreen() == 0 && shape.getBlue() == 0)) {
								shape.setState(true);
								break;
							}
							shape.setRed(255);
							shape.setGreen(0);
							shape.setBlue(0);
							shape.setColor(new Color(255, 0, 0));
							shape.setState(true);
							break;
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		if (clicked == null)
			return;
		
		if (x2 > canvasPanel.getWidth() - minusNum || x2 < minusNum)
			return;
		if (y2 > canvasPanel.getHeight() - minusNum || y2 < minusNum)
			return;

		if (clicked.equals(GlobalNum.WALL)) {
			drawWall();
		} else if (clicked.equals(GlobalNum.DOOR)) {
			drawDoor();
		} else if (clicked.equals(GlobalNum.WINDOW)) {
			drawWindow();
		} else if (clicked.equals("line")) {
			drawLine();
		} else if (clicked.equals("clicked")) // selected object
		{
			move();
			if (shape.getType() == 1) // when selectd object is furniture
				locatedInside(); // check that located wall;
		}

		menuController.setClicked("select"); // select로 바꿔서 그 안에서 컨트롤해 안에서 선택된
		// 애를 찾음
		clicked = "select";
		canvasPanel.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		if (clicked == null)
			return;

		if (x2 > canvasPanel.getWidth() - minusNum || x2 < minusNum)
			return;
		if (y2 > canvasPanel.getHeight() - minusNum || y2 < minusNum)
			return;

		if (clicked.equals(GlobalNum.WALL)) {
			drawWall();
		} else if (clicked.equals(GlobalNum.DOOR)) {
			drawDoor();
		} else if (clicked.equals(GlobalNum.WINDOW)) {
			drawWindow();
		} else if (clicked.equals("line")) {
			drawLine();
		} else if (clicked.equals("clicked")) // selected object
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

	public void move() {
		shape = MainPanel.shapeVec.get(position);
		int minX, minY, maxX, maxY; // section of canvas
		int startX, startY, endX, endY;

		minX = canvasPanel.getLocation().x;
		minY = canvasPanel.getLocation().y;
		maxX = (int) canvasPanel.getSize().getWidth() + minX;
		maxY = (int) canvasPanel.getSize().getHeight() + minY;

		startX = x2 - width;
		startY = y2 - height;
		endX = startX + shape.getWidth();
		endY = startY + shape.getHeight();

		// set X
		if (startX >= minX - (AppManager.createAppManager().getCanvasPanel().getX() - 3)
				&& endX <= maxX - (AppManager.createAppManager().getCanvasPanel().getX() + 3)) {
			shape.setX(x2 - width);
		}
		// set y
		if (shape.getType() == 0) {
			if (startY >= minY - (AppManager.createAppManager().getCanvasPanel().getY() - 3)
					&& endY <= maxY - (AppManager.createAppManager().getCanvasPanel().getY() + 3)) {
				shape.setY(y2 - height);
			}
		} else if (shape.getType() == 1) {
			if (startY >= minY - (AppManager.createAppManager().getCanvasPanel().getY() - 3)
					&& endY <= maxY - (AppManager.createAppManager().getCanvasPanel().getY() + 23)) {
				shape.setY(y2 - height);
			}
		}
	}

	public void locatedInside() {
		int objX1 = shape.getX();
		int objY1 = shape.getY();
		int objX2 = shape.getWidth() + objX1;
		int objY2 = shape.getHeight() + objY1;

		for (int i = 0; i < MainPanel.shapeVec.size(); i++) {
			Shape tempShape = MainPanel.shapeVec.get(i);
			if (tempShape.getType() == 0) // 벽일 경우
			{
				int wallX1 = tempShape.getX();
				int wallY1 = tempShape.getY();
				int wallX2 = tempShape.getWidth() + wallX1;
				int wallY2 = tempShape.getHeight() + wallY1;

				if (wallY1 > objY1 && wallY1 < objY2) // up
				{
					shape.setY(wallY1);
				}
				if (wallX2 > objX1 && wallX2 < objX2) // right
				{
					shape.setX(wallX2 - shape.getWidth());
				}
				if (wallY2 > objY1 && wallY2 < objY2) // down
				{
					shape.setY(wallY2 - shape.getHeight());
				}
				if (wallX1 > objX1 && wallX1 < objX2)// left
				{
					shape.setX(wallX1);
				}

				if (wallY1 >= objY1 && wallY2 <= objY2) // 방보다 객채의 높이가 긴경우
				{
					// 경고
					errorDialog();
					MainPanel.shapeVec.remove(shape);
					// 삭제
				} else if (wallX1 >= objX1 && wallX2 <= objX2) // 방보다 객채의 넓이가
																// 긴경우
				{
					// 경고
					errorDialog();
					MainPanel.shapeVec.remove(shape);
					// 삭제
				}
			}
		}
	}

	private void errorDialog() {
		JOptionPane.showMessageDialog(canvasPanel, "객체의 크기 너무 큽니다.", "size error", JOptionPane.ERROR_MESSAGE);
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