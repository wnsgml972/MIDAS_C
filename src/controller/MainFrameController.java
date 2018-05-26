package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.AppManager;
import view.MainFrame;
import view.MainPanel;

public class MainFrameController {

	private MainFrame mainFrame;
	private JsonParser jsonParser;
	
	public MainFrameController() {
		mainFrame = AppManager.createAppManager().getMainFrame();
		jsonParser = AppManager.createAppManager().getJsonParser();
		
		mainFrame.callActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if(obj == mainFrame.getSaveItem())
				{
					jsonParser.save();
				}
				else if(obj == mainFrame.getLoadItem())
				{
					MainPanel.shapeVec = jsonParser.load();	
					AppManager.createAppManager().getCanvasPanel().repaint();
					
				}
				else if(obj == mainFrame.getExitItem())
				{
					System.exit(0);
				}
				
			}
		});
	}

}
