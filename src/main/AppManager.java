package main;

import view.*;
import controller.*;

public class AppManager {

	private static AppManager appManager;
	
	private CanvasPanel canvasPanel;
	private MainFrame mainFrame;
	private MainPanel mainPanel;
	private MenuPanel menuPanel;
	private PanelManager panelManager;
	
	private CanvasPanelController canvasPanelController;
	private MainFrameController mainFrameController;
	private MainPanelController mainPanelController;
	private MenuPanelController menuPanelController;
	
	private JsonParser jsonParser;
	
	private AppManager(){}
	
	public static AppManager createAppManager()
	{
		if(appManager == null)
			appManager = new AppManager();
		
		return appManager;
	}

	//getter setter
	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}

	public void setCanvasPanel(CanvasPanel canvasPanel) {
		this.canvasPanel = canvasPanel;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public CanvasPanelController getCanvasPanelController() {
		return canvasPanelController;
	}

	public void setCanvasPanelController(CanvasPanelController canvasPanelController) {
		this.canvasPanelController = canvasPanelController;
	}

	public MainFrameController getMainFrameController() {
		return mainFrameController;
	}

	public void setMainFrameController(MainFrameController mainFrameController) {
		this.mainFrameController = mainFrameController;
	}

	public MainPanelController getMainPanelController() {
		return mainPanelController;
	}

	public void setMainPanelController(MainPanelController mainPanelController) {
		this.mainPanelController = mainPanelController;
	}

	public MenuPanelController getMenuPanelController() {
		return menuPanelController;
	}

	public void setMenuPanelController(MenuPanelController menuPanelController) {
		this.menuPanelController = menuPanelController;
	}

	public JsonParser getJsonParser() {
		return jsonParser;
	}

	public void setJsonParser(JsonParser jsonParser) {
		this.jsonParser = jsonParser;
	}

	public PanelManager getPanelManager() {
		return panelManager;
	}

	public void setPanelManager(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	
	//---------------------------------------------------------------------------//

}
