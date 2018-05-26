package model;

import java.awt.Color;


public class Shape {

	private String shape;
	private int x, y,z;
	private int width, height;
	private int red;
	private int green;
	private int blue;
	private Color color;
	private boolean empty;
	
	public Shape(){	}
	
	public Shape(String shape, int x, int y, int width, int height){
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = Color.BLACK;
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		empty = true;
	}
	
	public Shape(String shape, int x, int y, int width, int height, int red, int green, int blue ,boolean empty){
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.empty = empty;
		color = new Color(red, green, blue);
	}
	
	public Boolean checkSelect(int selX, int selY){
		
		int widthTemp = width;
		int heightTemp = height;
		if(widthTemp < 0)
			widthTemp *= -1;
		if(heightTemp < 0)
			heightTemp *= -1;
		
		if(selX >= x && selX <= x+widthTemp &&
				selY >= y && selY <= y+heightTemp){
			return true;
		}
		else return false;
	}

	// getter setter 
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
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

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	//-------------------------------------------------------
	
}
