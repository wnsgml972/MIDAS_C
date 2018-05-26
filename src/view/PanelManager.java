package view;

import main.AppManager;

public class PanelManager {
	
	
	public PanelManager()
	{
		AppManager.createAppManager().setMainFrame(new MainFrame());
		AppManager.createAppManager().setMainPanel(new MainPanel());
		AppManager.createAppManager().setCanvasPanel(new CanvasPanel());
		AppManager.createAppManager().setMenuPanel(new MenuPanel());
	}

}
