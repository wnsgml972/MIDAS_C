package controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import main.AppManager;
import view.MainFrame;
import view.MainPanel;

public class MainFrameController {

	private MainFrame mainFrame;
	private JsonParser jsonParser;
	private FileDialog dialog;

	// image print
	private Boolean imgPrintState = true;
	private Image img = null;

	public MainFrameController() {
		mainFrame = AppManager.createAppManager().getMainFrame();
		jsonParser = AppManager.createAppManager().getJsonParser();

		mainFrame.callActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == mainFrame.getNewItem()) // 이전 저장 여부, clear
				{
					newFile();
				} else if (obj == mainFrame.getSaveItem()) {
					saveFile();
				} else if (obj == mainFrame.getLoadItem()) {
					loadFile();
				} else if (obj == mainFrame.getImgPrintItem()) {
					imgPrint();
				} else if (obj == mainFrame.getExitItem()) {
					System.exit(0);
				}

			}
		});

	}

	public void saveFile() {
		dialog = new FileDialog(mainFrame, "save", FileDialog.SAVE);
		dialog.setDirectory(".");
		dialog.setVisible(true);

		if (dialog.getFile() == null)
			return;

		jsonParser.setFileName(dialog.getFile());
		jsonParser.save();

	}

	public void newFile() {
		int result = 1;
		if (MainPanel.shapeVec.size() != 0) {
			result = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "save", JOptionPane.YES_NO_OPTION);
		}

		if (result == 0) // 저장
		{
			saveFile();
		}

		AppManager.createAppManager().getMainPanel().shapeVec.removeAllElements();
		AppManager.createAppManager().getCanvasPanel().repaint();

	}

	public void loadFile() {
		int result = 1;
		if (MainPanel.shapeVec.size() != 0) {
			result = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "save", JOptionPane.YES_NO_OPTION);
		}

		if (result == 0) // 저장
		{
			saveFile();
		}

		dialog = new FileDialog(mainFrame, "load", FileDialog.LOAD);

		dialog.setDirectory(".");
		dialog.setVisible(true);

		if (dialog.getFile() == null)
			return;
		else {
			jsonParser.setFileName(dialog.getFile());
			MainPanel.shapeVec = jsonParser.load();
			AppManager.createAppManager().getCanvasPanel().repaint();

		}
	}

	public void imgPrint() {
		if (imgPrintState) {
			capture();
			System.out.println("캡쳐!");

		} else {
			JOptionPane.showMessageDialog(null, "벽이 모두 막혀있습니다. 올바른 인테리어를 만들어주세요.");
		}
	}

	public void capture() {
		try {
			Robot robot = new Robot();
			// 내 모니터 화면의 크기를 가져오는 방법
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			// 모니터의 화면을 selectRect에 가로,세로 표현
			Rectangle selectRect = new Rectangle((int) screen.getWidth(), (int) screen.getHeight());
			for (int i = 0; i < 2; i++) {
				BufferedImage buffimg = robot.createScreenCapture(selectRect);
				File screenfile = new File("screen" + i + ".jpg");
				ImageIO.write(buffimg, "jpg", screenfile);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}