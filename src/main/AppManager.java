package main;

import view.*;
import controller.*;

public class AppManager {

	private static AppManager appManager;

	private CanvasPanel canvasPanel;
	private MainFrame mainFrame;
	private MainPanel mainPanel;
	private BoardPanel boardPanel;
	private MenuPanel menuPanel;
	private SouthMenuPanel southMenuPanel;
	private NorthMenuPanel northMenuPanel;
	private ObjectDialog objectDialog;

	private IntroPanel introPanel;
	private PanelManager panelManager;

	private CanvasPanelController canvasPanelController;
	private MainFrameController mainFrameController;
	private MainPanelController mainPanelController;
	private MenuPanelController menuPanelController;
	private ObjectDialogController objectDialogController;

	private JsonParser jsonParser;

	private SetupDialog setupDialog;
	private IntroPanelController introPanelController;
	private SetupDialogController setupDialogController;

	private AppManager() {
	}

	public static AppManager createAppManager() {
		if (appManager == null)
			appManager = new AppManager();

		return appManager;
	}

	// getter setter	
	public SouthMenuPanel getSouthMenuPanel() {
		return southMenuPanel;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public ObjectDialog getObjectDialog() {
		return objectDialog;
	}

	public void setObjectDialog(ObjectDialog objectDialog) {
		this.objectDialog = objectDialog;
	}

	public ObjectDialogController getObjectDialogController() {
		return objectDialogController;
	}

	public void setObjectDialogController(ObjectDialogController objectDialogController) {
		this.objectDialogController = objectDialogController;
	}

	public void setSouthMenuPanel(SouthMenuPanel southMenuPanel) {
		this.southMenuPanel = southMenuPanel;
	}

	public NorthMenuPanel getNorthMenuPanel() {
		return northMenuPanel;
	}

	public void setNorthMenuPanel(NorthMenuPanel northMenuPanel) {
		this.northMenuPanel = northMenuPanel;
	}

	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}

	public void setCanvasPanel(CanvasPanel canvasPanel) {
		this.canvasPanel = canvasPanel;
	}

	public void setIntroPanel(IntroPanel introPanel) {
		this.introPanel = introPanel;
	}

	public IntroPanel getIntroPanel() {
		return introPanel;
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

	public SetupDialog getSetupDialog() {
		return setupDialog;
	}

	public void setSetupDialog(SetupDialog setupDialog) {
		this.setupDialog = setupDialog;
	}

	public IntroPanelController getIntroPanelController() {
		return introPanelController;
	}

	public void setIntroPanelController(IntroPanelController introPanelController) {
		this.introPanelController = introPanelController;
	}

	public SetupDialogController getSetupDialogController() {
		return setupDialogController;
	}

	public void setSetupDialogController(SetupDialogController setupDialogController) {
		this.setupDialogController = setupDialogController;
	}

	// ---------------------------------------------------------------------------//

}
