package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.AppManager;
import model.Shape;

public class MainPanel extends JPanel {

	public static Vector<Shape> shapeVec = new Vector<Shape>();

	private JPanel boardPanel;
	private JLabel widthLabel;
	private JLabel columnLabel;

	public MainPanel() {
		this.setLayout(new BorderLayout());

		AppManager.createAppManager().setCanvasPanel(new CanvasPanel());
		AppManager.createAppManager().setMenuPanel(new MenuPanel());

		widthLabel = new JLabel("test");
		columnLabel = new JLabel("test");

		boardPanel = new JPanel();
		boardPanel.setLayout(null);
		boardPanel.setBackground(Color.pink);
		boardPanel.add(widthLabel);
		boardPanel.add(columnLabel);
		widthLabel.setLocation(10, 10);

		boardPanel.add(AppManager.createAppManager().getCanvasPanel());

		AppManager.createAppManager().getCanvasPanel().setLocation(30, 30);

		this.add(AppManager.createAppManager().getMenuPanel(), BorderLayout.EAST);
		this.add(boardPanel, BorderLayout.CENTER);
	}

	public static Vector<Shape> getShapeVec() {
		return shapeVec;
	}

	public static void setShapeVec(Vector<Shape> shapeVec) {
		MainPanel.shapeVec = shapeVec;
	}

	public JPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(JPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public JLabel getWidthLabel() {
		return widthLabel;
	}

	public void setWidthLabel(JLabel widthLabel) {
		this.widthLabel = widthLabel;
	}

	public JLabel getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(JLabel columnLabel) {
		this.columnLabel = columnLabel;
	}
	
	
}