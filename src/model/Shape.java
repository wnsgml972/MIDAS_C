package model;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;

public class Shape {

	private String shape;
	private int x, y;
	private int width, height;
	private int red;
	private int green;
	private int blue;
	private Color color;
	private boolean empty;
	
	private int type; //0 paint, 1 label
	
	// 1 label
	private Image img;
	private String imgPath;
	private String name;
	
	private Boolean state; //selected state
	
	public Shape() {	}
	
	//일반
	public Shape(String shape, int x, int y, int width, int height){ 
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		type = 0;
		color = Color.BLACK;
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		empty = true;
		state = false;
	}
	
	//일반
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
		type = 0;
		color = new Color(red, green, blue);
		state = false;
	}
	
	//이미지
	public Shape(String shape, int x, int y, int width, int height, int red, int green, int blue ,boolean empty, int type, String imgPath, String name){
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.empty = empty;
		this.type = type;
		this.imgPath = imgPath;
		color = new Color(red, green, blue);
		state = false;
		this.name = name;
	}
	
	//이미지
	public Shape(Image img, String imgPath, int x, int y, int width, int height, String name){
		this.img = img;
		this.imgPath = imgPath;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.red = 0;
		this.green = 0;
		this.blue = 0;
		shape = "img";
		empty = false;
		type = 1;
		state = false;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	//-------------------------------------------------------
	
}
