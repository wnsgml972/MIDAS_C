package main;

import view.CanvasPanel;
import view.MainFrame;
import view.MainPanel;
import view.MenuPanel;
import view.PanelManager;

import controller.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppManager.createAppManager().setPanelManager(new PanelManager());
		//AppManager.createAppManager().setMainFrame(new MainFrame());
		AppManager.createAppManager().setJsonParser(new JsonParser());
		AppManager.createAppManager().setMainFrameController(new MainFrameController());
		AppManager.createAppManager().setMainPanelController(new MainPanelController());
		
		AppManager.createAppManager().setMenuPanelController(new MenuPanelController());
		AppManager.createAppManager().setCanvasPanelController(new CanvasPanelController());
		
		
	}

}
