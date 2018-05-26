package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controller.MenuPanelController;
import controller.MyMouseListener;
import main.AppManager;
import model.Shape;
import values.GlobalNum;

public class CanvasPanel extends JPanel{

	private MainPanel mainPanel;
	private MenuPanelController menuController;
	int x, y, width, height;
		
	public CanvasPanel()
	{
		this.setLayout(null);
		this.setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int size = mainPanel.shapeVec.size();

		for (int i = 0; i < size; i++) 
		{
			Shape shape = MainPanel.shapeVec.get(i);
			int width = shape.getWidth();
			int height = shape.getHeight();
			int x = shape.getX();
			int y = shape.getY();

			if (width < 0) {
				int tmp = x;
				x += width;
				width = tmp - x;
			}

			if (height < 0) {
				int tmp = y;
				y += height;
				height = tmp - y;
			}
			
			g.setColor(shape.getColor()); //set Color
						
			switch (shape.getShape()) 
			{
				case GlobalNum.WALL:
					if(shape.isEmpty()){
						g.drawRect(x, y, width, height);
					}else{
						g.fillRect(x, y, width, height);
					}
					break;
				case GlobalNum.DOOR:
					g.drawLine(shape.getX(), shape.getY(), shape.getWidth(),shape.getHeight());
	
					break;
				case GlobalNum.WINDOW:
					if(shape.isEmpty()){
						g.drawArc(x, y, width, height, 0, 360);
					}else{
						g.fillArc(x, y, width, height, 0, 360);
					}
					break;
			}
		}
	}


	public void myMouseEvent(MyMouseListener listener)
	{
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
}
