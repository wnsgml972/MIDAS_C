package model;

import java.awt.Color;

public class Window {
	private int x;
	private int y;
	private int width;
	private int height;

	private int moveWidth;
	private int moveHeight;

	private int dir;

	private int x1, y1;
	private int x2, y2;

	private Color color;

	public Window(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = Color.ORANGE;
		dir = 0;
	}
	public Window(int x, int y, int width, int height, int dir, int x1, int y1, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = Color.BLACK;
		this.dir = dir;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void setRange(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

		// change x and y
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getDir() {
		return dir;
	}

	public void setMove(int moveWidth, int moveHeight) {
		this.moveWidth = moveWidth;
		this.moveHeight = moveHeight;
	}

	public void move(int x, int y) {
		this.x = x - moveWidth;
		this.y = y - moveHeight;
	}
	
	public void moveX(int x) {
		this.x = x - moveWidth;
	}
	
	public void moveY(int y) {
		this.y = y - moveHeight;
	}

	public Boolean xRangeCheck(int xTemp) {
		if (x2 < xTemp || xTemp < x1)
			return false;
		return true;
	}

	public Boolean yRangeCheck(int yTemp) {
		if (y2 < yTemp || yTemp < y1)
			return false;
		return true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMoveWidth() {
		return moveWidth;
	}

	public void setMoveWidth(int moveWidth) {
		this.moveWidth = moveWidth;
	}

	public int getMoveHeight() {
		return moveHeight;
	}

	public void setMoveHeight(int moveHeight) {
		this.moveHeight = moveHeight;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
}