package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.MenuPanelController;
import controller.MyMouseListener;
import model.Shape;
import values.GlobalNum;

public class CanvasPanel extends JPanel {

	private MenuPanelController menuController;

	private int minusNum = 5;

	public CanvasPanel() {
		this.setLayout(null);
		this.setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = MainPanel.shapeVec.size();

		Graphics2D g2 = (Graphics2D) g;
		BasicStroke thickStroke = new BasicStroke(5);
		BasicStroke thinStroke = new BasicStroke(3);

		for (int i = 0; i < size; i++) {
			Shape shape = MainPanel.shapeVec.get(i);

			int width = shape.getWidth();
			int height = shape.getHeight();
			int x = shape.getX();
			int y = shape.getY();

			if (shape.getType() == 0) { // type == paint

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

				g.setColor(shape.getColor()); // set Color

				switch (shape.getShape()) {
				case GlobalNum.WALL:
	                g2 = (Graphics2D) g;
	                AffineTransform current = g2.getTransform();
	                	                
					if (shape.isEmpty()) {
						if (shape.isCloseSpace()) {
							g2.setStroke(thickStroke);
						}
						g.drawRect(x, y, width, height);
						g2.setStroke(thinStroke);

					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				case GlobalNum.DOOR:
					if (shape.isEmpty()) {
						if (shape.isCloseSpace()) {
							g2.setStroke(thickStroke);
						}
						g.drawRect(x, y, width, height);
						g2.setStroke(thinStroke);
					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				case GlobalNum.WINDOW:
					if (shape.isEmpty()) {
						if (shape.isCloseSpace()) {
							g2.setStroke(thickStroke);
						}
						g.drawRect(x, y, width, height);
						g2.setStroke(thinStroke);
					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				}
			} else { // type == label
				Image img = new ImageIcon(shape.getImgPath()).getImage();
				if (shape.isCloseSpace()) {
					g.setColor(Color.RED);
				}
				g.drawImage(img, x, y, width, height, this);
				g.setColor(Color.black);
				g.drawString(shape.getName(), x, y + shape.getHeight() + 15);
			}
		}
	}

	public void myMouseEvent(MyMouseListener listener) {
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	/*
	 * g.drawRect(x, y, width, 15);


       // start == 90 // 회전을 클릭 하면 변경됨
       start = 90;
       g.drawArc(x, y-70/2, width*2, 70, start, 90);
       g.drawLine(x+width,  y-70/2, x+width,  y);
       
       
       //start == 0
       start = 0;
       g.drawArc(x-width, y-70/2, width*2, 70, start, 90);
       g.drawLine(x, y-70/2, x,  y);
       
       //start == 270
       start = 270;
       g.drawArc(x-width, y-70/2, width*2, 70+15, start, 90);
       g.drawLine(x, y+15, x,  y+15+70/2);
       
       //start == 180
       start = 180;
       g.drawArc(x, y-70/2, width*2, 70+15, start, 90);
       g.drawLine(x+width, y+15, x+width,  y+15+70/2);*/
}