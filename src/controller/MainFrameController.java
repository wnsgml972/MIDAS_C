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
import values.GlobalNum;
import view.MainFrame;
import view.MainPanel;
import view.SetupDialog;

public class MainFrameController {

	private MainFrame mainFrame;
	private JsonParser jsonParser;
	private FileDialog dialog;

	// image print
	private Boolean imgPrintState = true;
	private Image img = null;
	private int stand = 700;

	public MainFrameController() {
		mainFrame = AppManager.createAppManager().getMainFrame();
		jsonParser = AppManager.createAppManager().getJsonParser();

		mainFrame.callActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == mainFrame.getNewItem()) // 이전 저장 여부, clear
				{
					if(MainPanel.shapeVec.size() == 0){
						AppManager.createAppManager().setSetupDialog(new SetupDialog());
						AppManager.createAppManager().setSetupDialogController(new SetupDialogController());
					}else{
						newFile();						
					}
				} else if (obj == mainFrame.getSaveItem()) {
					saveFile();
				} else if (obj == mainFrame.getLoadItem()) {
					loadFile();

					AppManager.createAppManager().getPanelManager().setContentPane(GlobalNum.MAIN);
					AppManager.createAppManager().getMainFrame().enableItem();
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
			MainPanel mainPanel = AppManager.createAppManager().getMainPanel();
			int width = MainPanel.shapeVec.get(0).getCanvasWidth();
			int column = MainPanel.shapeVec.get(0).getCanvasHeight();			
			int tempW;
			int tempC;
			if (width >= column) {
				double temp = (double)stand / width;
				AppManager.createAppManager().getMainPanel().rate = temp;
				tempC = (int) (column * temp);
				tempW = stand;
			} else {
				double temp = (double)stand / column;
				AppManager.createAppManager().getMainPanel().rate = temp;
				tempW = (int) (width * temp);
				tempC = stand;
			}
			AppManager.createAppManager().getCanvasPanel().setSize(tempW, tempC);
			System.out.println(tempW + " " + tempC);
			mainPanel.getWidthLabel().setText(width + "");
			mainPanel.getColumnLabel().setText(column + "");
			mainPanel.getWidthLabel().setSize(30, 30);
			mainPanel.getColumnLabel().setSize(30, 30);
			mainPanel.getWidthLabel().setLocation(tempW / 2 + 10, 5);
			mainPanel.getColumnLabel().setLocation(5, tempC / 2 + 10);
			
			AppManager.createAppManager().getCanvasPanel().repaint();
		}
	}

	public void imgPrint() {
		if (imgPrintState) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					capture();
				}
			}).start();
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
			
			Rectangle clip = selectRect.intersection(new Rectangle(AppManager.createAppManager().getBoardPanel().getWidth()
					, AppManager.createAppManager().getBoardPanel().getHeight()));
			
			BufferedImage buffimg = robot.createScreenCapture(selectRect);
			
			//clipping 함
			BufferedImage clippedImg = null;
			try{
				clippedImg = buffimg.getSubimage((int)AppManager.createAppManager().getMainFrame().getLocationOnScreen().getX() + 5
					,(int)AppManager.createAppManager().getMainFrame().getLocationOnScreen().getY() + 60, 
					clip.width, clip.height);				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "캔버스가 화면에 올바르게 있지 않습니다. 다시 확인해주세요");
				return;
			}
			dialog = new FileDialog(mainFrame, "save", FileDialog.SAVE);
			dialog.setDirectory(".");
			dialog.setVisible(true);

			if (dialog.getFile() == null)
				return;
			
			File screenfile = new File(dialog.getFile());
			if(!(dialog.getFile().contains("jpg") || dialog.getFile().contains("jpeg") || dialog.getFile().contains("svc") || 
					dialog.getFile().contains("png"))){
				JOptionPane.showMessageDialog(null, "올바른 그림파일 형식이 아닙니다. 다시 확인해주세요");
				return;
			}
			if(dialog.getFile().contains("jpg")){
				ImageIO.write(clippedImg, "jpg", screenfile);
			}
			else if(dialog.getFile().contains("svc")){
				ImageIO.write(clippedImg, "svc", screenfile);
			}
			else if(dialog.getFile().contains("jpeg")){
				ImageIO.write(clippedImg, "jpeg", screenfile);
			}
			else if(dialog.getFile().contains("png")){
				ImageIO.write(clippedImg, "png", screenfile);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}