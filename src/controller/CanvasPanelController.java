package controller;

import main.AppManager;
import view.CanvasPanel;

public class CanvasPanelController{

	private CanvasPanel canvasPanel;
		
	public CanvasPanelController()
	{
		canvasPanel = AppManager.createAppManager().getCanvasPanel();
		canvasPanel.myMouseEvent(new MyMouseListener());
	}	
}