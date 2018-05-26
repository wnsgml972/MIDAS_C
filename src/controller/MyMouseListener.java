package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.AppManager;
import model.Shape;
import view.CanvasPanel;
import view.MainPanel;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private CanvasPanel canvasPanel;
	private CanvasPanelController canvasController;
	private MainPanel mainPanel;
	private MenuPanelController menuController;
	private Shape shapeObj;
	private Color color;
	private boolean empty;
	private int x,y,x1, y1, x2, y2, width, height, red, green, blue, tempx;
	private Shape shape;
	private String clicked;
	private int position;
	
	public MyMouseListener()
	{
		canvasController = AppManager.createAppManager().getCanvasPanelController();
		canvasPanel = AppManager.createAppManager().getCanvasPanel();
		menuController = AppManager.createAppManager().getMenuPanelController();
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		x2 = x1 = e.getX();
		y2 = y1 = e.getY();
		clicked = menuController.getClicked();
		if(clicked.equals("rectangle")|| clicked.equals("circle"))
		{
			shape = new Shape(clicked,x1,y1,0,0);
			mainPanel.shapeVec.addElement(shape);
		}
		else if(clicked.equals("line"))
		{
			shape = new Shape(clicked,x1,y1,x1,y1);
			mainPanel.shapeVec.addElement(shape);
		}
		else if(clicked.equals("select"))
		{
			
			for(int i=mainPanel.shapeVec.size()-1;i>=0;i++)
			{
				shape = mainPanel.shapeVec.get(i);
				position =i;
				if(shape.getShape().equals("line"))
				{
					if(x1>=shape.getX() && x2<=shape.getWidth() && y1>=shape.getY() && y1<=shape.getHeight())
					{
						clicked = "clicked";
						width = x1- shape.getX();
						height = y1 - shape.getY();
						break;
					}
				}
				else {
					if(x1>=shape.getX() && x2<=shape.getWidth()+shape.getX()&& y1>=shape.getY() && y1<=shape.getHeight()+shape.getY())
					{
						clicked = "clicked";
						width = x1- shape.getX();
						height = y1 - shape.getY();
						break;
					}
				}
			}
		}
		else if(clicked.equals("erase"))
		{
			for(int i=mainPanel.shapeVec.size()-1;i>=0;i++)
			{
				shape = mainPanel.shapeVec.get(i);
				if(shape.getShape().equals("line"))
				{
					if(x1>=shape.getX() && x2<=shape.getWidth() && y1>=shape.getY() && y1<=shape.getHeight())
					{
						mainPanel.shapeVec.remove(i);
						break;
					}
				}
				else {
					if(x1>=shape.getX() && x2<=shape.getWidth()+shape.getX()&& y1>=shape.getY() && y1<=shape.getHeight()+shape.getY())
					{
						mainPanel.shapeVec.remove(i);
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
		
		if(clicked.equals("rectangle")|| clicked.equals("circle"))
		{
			drawRectangleCircle();
		}
		else if(clicked.equals("line"))
		{
			drawLine();
		}
		else if(clicked.equals("clicked")) // selected object
		{
			move();
		}
		
		menuController.setClicked("select");
		clicked = "select";
		canvasPanel.repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		if(clicked.equals("rectangle")|| clicked.equals("circle"))
		{
			drawRectangleCircle();
		}
		else if(clicked.equals("line"))
		{
			drawLine();
		}
		else if(clicked.equals("clicked")) // selected object
		{
			move();
		}		
		canvasPanel.repaint();

		
	}

	public void drawRectangleCircle()
	{
		if(x2>x1)
		{
			width = x2- x1;
			x = x1;
		}
		else
		{
			width = x1- x2;
			x = x2;
		}
		
		if(y2>y1)
		{
			height = y2 - y1;
			y = y1;
		}
		else
		{
			height = y1 - y2;
			y = y2;
		}
		shape = mainPanel.shapeVec.lastElement();
		shape.setX(x);
		shape.setY(y);
		shape.setWidth(width);
		shape.setHeight(height);
	}
	
	public void drawLine()
	{
		shape = mainPanel.shapeVec.lastElement();
		
		shape.setX(x1);
		shape.setWidth(x2);
		shape.setY(y1);
		shape.setHeight(y2);		
		
	}

	public void move()
	{
		shape = mainPanel.shapeVec.get(position);		
		shape.setX(x2-x1+width);
		shape.setY(y2-y1+height);
	
	}
	
	
	
	
	
	
	
	//---------------------------------------------------------------------
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
