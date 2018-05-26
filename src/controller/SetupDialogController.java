package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.AppManager;
import values.GlobalNum;
import view.CanvasPanel;
import view.MainPanel;
import view.SetupDialog;

public class SetupDialogController {

	private int width = 0, column = 0;
	private SetupDialog setupDialog;
	private CanvasPanel canvasPanel;
	private MainPanel mainPanel;

	public SetupDialogController() {
		setupDialog = AppManager.createAppManager().getSetupDialog();
		canvasPanel = AppManager.createAppManager().getCanvasPanel();
		mainPanel = AppManager.createAppManager().getMainPanel();

		setupDialog.callActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == setupDialog.getMakeBtn()) {
					try {
						width = Integer.parseInt(setupDialog.getWidthField().getText());
						column = Integer.parseInt(setupDialog.getColumnField().getText());
					} catch (Exception exception) {
						setupDialog.getAskSentence().setText("정확하세 입력해주세요!!");
					}

					if (width != 0 && column != 0) {
						int stand = 700;
						int tempW, tempC;
						if (width >= column) {
							double temp = (double)stand / width;
							tempC = (int) (column * temp);
							tempW = stand;
						} else {
							double temp = (double)stand / column;
							tempW = (int) (width * temp);
							tempC = stand;
						}

						canvasPanel.setSize(tempW, tempC);
						mainPanel.getWidthLabel().setText(width + "");
						mainPanel.getColumnLabel().setText(column + "");
						mainPanel.getWidthLabel().setSize(30, 30);
						mainPanel.getColumnLabel().setSize(30, 30);
						mainPanel.getWidthLabel().setLocation(tempW / 2 + 10, 5);
						mainPanel.getColumnLabel().setLocation(5, tempC / 2 + 10);

						AppManager.createAppManager().getPanelManager().setContentPane(GlobalNum.MAIN);
						setupDialog.dispose();

					} else {
						setupDialog.getAskSentence().setText("정확하세 입력해주세요!!");
					}

				}

			}

		});
	}

	// getter setter

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	// -------------------------------

}