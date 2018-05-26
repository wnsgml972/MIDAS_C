package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.AppManager;
import model.Shape;

public class MenuPanel extends JPanel{
	
	private PanelManager panelManager;
	private CanvasPanel canvasPanel;
	private Shape drawingShape = null;
	private Shape eraseShape = null;

	private JButton rectBtn;
	private JButton lineBtn;
	private JButton circleBtn;
	private JButton eraseBtn;
	private JButton colorBtn;
	private JButton clearBtn;
	
	public MenuPanel()
	{
		rectBtn = new JButton("rectangle");
		lineBtn = new JButton("line");
		circleBtn = new JButton("circle");
		eraseBtn = new JButton("erase");
		colorBtn = new JButton("color");
		clearBtn = new JButton("clear");
		
		
		add(rectBtn);
		add(lineBtn);
		add(circleBtn);
		add(eraseBtn);
		add(colorBtn);
		add(clearBtn);
				
	}
	
	public void setBtnListener(ActionListener listener){
		
		rectBtn.addActionListener(listener);
		lineBtn.addActionListener(listener);
		circleBtn.addActionListener(listener);
		eraseBtn.addActionListener(listener);
		colorBtn.addActionListener(listener);
		clearBtn.addActionListener(listener);
	}
	

	// getter setter
	public Shape getDrawingShape() {
		return drawingShape;
	}

	public void setDrawingShape(Shape drawingShape) {
		this.drawingShape = drawingShape;
	}

	public Shape getEraseShape() {
		return eraseShape;
	}

	public void setEraseShape(Shape eraseShape) {
		this.eraseShape = eraseShape;
	}

	public JButton getRectBtn() {
		return rectBtn;
	}

	public void setRectBtn(JButton rectBtn) {
		this.rectBtn = rectBtn;
	}

	public JButton getLineBtn() {
		return lineBtn;
	}

	public void setLineBtn(JButton lineBtn) {
		this.lineBtn = lineBtn;
	}

	public JButton getCircleBtn() {
		return circleBtn;
	}

	public void setCircleBtn(JButton circleBtn) {
		this.circleBtn = circleBtn;
	}

	public JButton getEraseBtn() {
		return eraseBtn;
	}

	public void setEraseBtn(JButton eraseBtn) {
		this.eraseBtn = eraseBtn;
	}

	public JButton getColorBtn() {
		return colorBtn;
	}

	public void setColorBtn(JButton colorBtn) {
		this.colorBtn = colorBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public void setClearBtn(JButton clearBtn) {
		this.clearBtn = clearBtn;
	}
	//------------------------------------------------------
	

}
