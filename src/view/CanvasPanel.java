package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.MenuPanelController;
import controller.MyMouseListener;
import main.AppManager;
import model.Shape;
import values.GlobalNum;

public class CanvasPanel extends JPanel {

	private MenuPanelController menuController;

	public CanvasPanel() {
		this.setLayout(null);
		this.setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = MainPanel.shapeVec.size();

		for (int i = 0; i < size; i++) {
			Shape shape = MainPanel.shapeVec.get(i);
			
			int width = shape.getWidth();
			int height = shape.getHeight();
			int x = shape.getX();
			int y = shape.getY();

			if (shape.getType() == 0) {  //type == paint

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
					if (shape.isEmpty()) {
						g.drawRect(x, y, width, height);
					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				case GlobalNum.DOOR:
					if (shape.isEmpty()) {
						g.drawRect(x, y, width, height);
					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				case GlobalNum.WINDOW:
					if (shape.isEmpty()) {
						g.drawRect(x, y, width, height);
					} else {
						g.fillRect(x, y, width, height);
					}
					break;
				}
			}
			else{ //type == label
				Image img = new ImageIcon(shape.getImgPath()).getImage();
				g.setColor(Color.black);
				g.drawImage(img, x, y, width, height, this);
				g.drawString(shape.getName(), x, y+shape.getHeight() + 15);				
			}
		}
	}

	public void myMouseEvent(MyMouseListener listener) {
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}

}
