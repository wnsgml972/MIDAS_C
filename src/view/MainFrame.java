package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private JMenuBar mb;
	private JMenu fileMenu;
	private JMenuItem newItem;
	private JMenuItem saveItem;
	private JMenuItem loadItem;
	private JMenuItem imgPrintItem;
	private JMenuItem exitItem;

	public MainFrame() {
		this.setSize(1200, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		setTitle("MIDAS CHALLENGE 2018 화이팅");
		createMenu();
		this.setVisible(true);
	}

	private void createMenu() {
		mb = new JMenuBar();
		fileMenu = new JMenu("File");
		newItem = new JMenuItem("New");
		saveItem = new JMenuItem("Save");
		loadItem = new JMenuItem("Load");
		imgPrintItem = new JMenuItem("Image Print");
		exitItem = new JMenuItem("Exit");

		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(imgPrintItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		mb.add(fileMenu);
		disableItem();
		setJMenuBar(mb);
	}
	public void disableItem(){
		saveItem.setEnabled(false);
		imgPrintItem.setEnabled(false);
	}
	public void enableItem(){
		saveItem.setEnabled(true);
		imgPrintItem.setEnabled(true);
	}
	
	public void callActionListener(ActionListener listener) {
		newItem.addActionListener(listener);
		saveItem.addActionListener(listener);
		loadItem.addActionListener(listener);
		imgPrintItem.addActionListener(listener);
		exitItem.addActionListener(listener); 
	}
	
	// getter setter	
	public JMenuItem getSaveItem() {
		return saveItem;
	}

	public JMenuItem getImgPrintItem() {
		return imgPrintItem;
	}

	public void setImgPrintItem(JMenuItem imgPrintItem) {
		this.imgPrintItem = imgPrintItem;
	}

	public JMenuItem getNewItem() {
		return newItem;
	}

	public void setNewItem(JMenuItem newItem) {
		this.newItem = newItem;
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
	// ---------------------------------------------------------------------

}