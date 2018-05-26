package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.AppManager;
import view.CanvasPanel;
import view.IntroPanel;
import view.SetupDialog;

public class IntroPanelController {

	private IntroPanel introPanel;
	private CanvasPanel canvasPanel;

	public IntroPanelController() {
		introPanel = AppManager.createAppManager().getIntroPanel();
		canvasPanel = AppManager.createAppManager().getCanvasPanel();

		introPanel.callActionListenter(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == introPanel.getStartBtn()) {
					AppManager.createAppManager().setSetupDialog(new SetupDialog());
					AppManager.createAppManager().setSetupDialogController(new SetupDialogController());
				}
			}

		});
	}

}