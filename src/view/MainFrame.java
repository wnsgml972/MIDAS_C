package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import main.AppManager;


public class MainFrame extends JFrame{
	
	private JMenuBar mb;
	private JMenu fileMenu;
	private JMenuItem saveItem;
	private JMenuItem loadItem;
	private JMenuItem exitItem;
	
	public MainFrame()
	{
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createMenu();
		if(AppManager.createAppManager().getMainPanel() == null)
		{
			AppManager.createAppManager().setMainPanel(new MainPanel());
		}

		this.add(AppManager.createAppManager().getMainPanel());
		this.setVisible(true);
	}
	
	private void createMenu() {
		mb = new JMenuBar();
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		loadItem = new JMenuItem("Load");
		exitItem = new JMenuItem("Exit");
		
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	public void callActionListener(ActionListener listener)
	{
		saveItem.addActionListener(listener); //jsonParser.save();
		loadItem.addActionListener(listener); //MainPanel.shapeVec = jsonParser.load();	panelManager.getCanvasPanel().repaint();
		exitItem.addActionListener(listener); //System.exit(0);
	}

	
	// getter setter
	public JMenuItem getSaveItem() {
		return saveItem;
	}

	public void setSaveItem(JMenuItem saveItem) {
		this.saveItem = saveItem;
	}

	public JMenuItem getLoadItem() {
		return loadItem;
	}

	public void setLoadItem(JMenuItem loadItem) {
		this.loadItem = loadItem;
	}

	public JMenuItem getExitItem() {
		return exitItem;
	}

	public void setExitItem(JMenuItem exitItem) {
		this.exitItem = exitItem;
	}
	//---------------------------------------------------------------------

}
