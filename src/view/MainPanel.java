package view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;

import main.AppManager;
import model.Shape;

public class MainPanel extends JPanel{
	
	public static Vector<Shape> shapeVec = new Vector<Shape>();

	
	public MainPanel()
	{
		this.setLayout(new BorderLayout());
		
		if(AppManager.createAppManager().getMenuPanel()== null)
		{
			AppManager.createAppManager().setCanvasPanel(new CanvasPanel());
			AppManager.createAppManager().setMenuPanel(new MenuPanel());
		}

		
		this.add(AppManager.createAppManager().getMenuPanel(), BorderLayout.EAST);
		this.add(AppManager.createAppManager().getCanvasPanel(), BorderLayout.CENTER);

	}
	

}
