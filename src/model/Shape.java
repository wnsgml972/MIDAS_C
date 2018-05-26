package model;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class Shape {

	private String shape;
	private int x, y;
	private int width, height;
	private int red;
	private int green;
	private int blue;
	private Color color;
	private Boolean colorSelected;
	private boolean empty;
	private boolean closeSpace = true;

	private int canvasWidth;
	private int canvasHeight;

	private int type; // 0 paint, 1 label

	// 1 label
	private Image img;
	private String imgPath;
	private String name;

	private Boolean state; // selected state
	private ArrayList<Door> doorList = new ArrayList<Door>();
	private ArrayList<Window> windowList = new ArrayList<Window>();

	public Shape() {
	}

	public Shape(Shape shape) {
		this.shape = shape.shape;
		x = shape.x;
		y = shape.y;
		width = shape.width;
		height = shape.height;
		if (shape.closeSpace) {
			red = 255;
			green = 0;
			blue = 0;
			color = new Color(255, 0, 0);
		} else {
			red = shape.red;
			green = shape.green;
			blue = shape.blue;
			color = shape.color;
		}
		colorSelected = shape.colorSelected;
		empty = shape.empty;
		closeSpace = shape.closeSpace;

		canvasWidth = shape.canvasWidth;
		canvasHeight = shape.canvasHeight;

		type = shape.type; // 0 paint, 1 label

		// 1 label
		img = shape.img;
		imgPath = shape.imgPath;
		name = shape.name;

		state = false; // selected state
	}

	// 일반
	public Shape(String shape, int x, int y, int width, int height, int canvasWidth, int canvasHeight) {
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		type = 0;
		color = Color.red;
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		empty = true;
		state = false;
		colorSelected = false;
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
	}

	// 일반
	public Shape(String shape, int x, int y, int width, int height, int red, int green, int blue, boolean empty,
			int canvasWidth, int canvasHeight) {
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
		colorSelected = false;
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
	}

	// 이미지
	public Shape(String shape, int x, int y, int width, int height, int red, int green, int blue, boolean empty,
			int type, String imgPath, String name, int canvasWidth, int canvasHeight, Boolean closeSpace, ArrayList<Door> doorList,  ArrayList<Window> windowList) {
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
		colorSelected = false;
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
		this.closeSpace = closeSpace;
		this.doorList = doorList;
		this.windowList = windowList;
	}

	// 이미지
	public Shape(Image img, String imgPath, int x, int y, int width, int height, String name, int canvasWidth,
			int canvasHeight) {
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
		colorSelected = false;
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
	}

	public Boolean checkSelect(int selX, int selY) {

		int widthTemp = width;
		int heightTemp = height;
		if (widthTemp < 0)
			widthTemp *= -1;
		if (heightTemp < 0)
			heightTemp *= -1;

		if (selX >= x && selX <= x + widthTemp && selY >= y && selY <= y + heightTemp) {
			return true;
		} else
			return false;
	}

	// getter setter
	public ArrayList<Door> getDoors() {
		return doorList;
	}
	public ArrayList<Window> getWindows() {
		return windowList;
	}

	public void addDoor(Door door) {
		doorList.add(door);
	}
	public void addWindow(Window window) {
		windowList.add(window);
	}

	public String getShape() {
		return shape;
	}

	public boolean isCloseSpace() {
		return closeSpace;
	}

	public void setCloseSpace(boolean closeSpace) {
		this.closeSpace = closeSpace;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	public Boolean getColorSelected() {
		return colorSelected;
	}

	public void setColorSelected(Boolean colorSelected) {
		this.colorSelected = colorSelected;
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
	
	// -------------------------------------------------------

}
