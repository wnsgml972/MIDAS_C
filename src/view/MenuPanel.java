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
	
	private JButton colorBtn;
	private JButton clearBtn;
	
	public MenuPanel()
	{
		rectBtn = new JButton("wall");
		
		lineBtn = new JButton("line");
		circleBtn = new JButton("circle");
		
		colorBtn = new JButton("color");
		clearBtn = new JButton("clear");
		
		
		add(rectBtn);
		add(lineBtn);
		add(circleBtn);
		add(colorBtn);
		add(clearBtn);
				
	}
	
	public void setBtnListener(ActionListener listener){
		
		rectBtn.addActionListener(listener);
		lineBtn.addActionListener(listener);
		circleBtn.addActionListener(listener);
		colorBtn.addActionListener(listener);
		clearBtn.addActionListener(listener);
	}
		

}
