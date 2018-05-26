package view;

import java.awt.Container;

import main.AppManager;
import values.GlobalNum;

public class PanelManager {
	
	public MainFrame main;
	
	public PanelManager()
	{
		AppManager.createAppManager().setMainFrame(new MainFrame());
		AppManager.createAppManager().setIntroPanel(new IntroPanel());
		AppManager.createAppManager().setMainPanel(new MainPanel());
		main = AppManager.createAppManager().getMainFrame();
		startPanel();
	}
	
	// 화면을 전환
	public void setContentPane(Container panel) {
		main.setContentPane(panel);
		// 코드의 유연성 증가
	}

	// 정수를 이용 전환
	public void setContentPane(int panel) {
		// 기존코드 가독성 증가
		main.getContentPane().revalidate();
		switch (panel) {
		case GlobalNum.MAIN:
			main.setContentPane(AppManager.createAppManager().getMainPanel());
			break;
		case GlobalNum.INTRO:
			main.setContentPane(AppManager.createAppManager().getIntroPanel());
			break;
		}
	}
	
	public void startPanel(){
		this.setContentPane(GlobalNum.INTRO);
		main.setVisible(true);
	}
}
