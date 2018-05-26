package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.ObjectDialogController;
import main.AppManager;
import model.Shape;

public class ObjectPopUpMenu extends JPopupMenu implements ActionListener {
	private int position;
	
	private JMenuItem update;
	private JMenuItem delete;
	
	
	public ObjectPopUpMenu (int position) {
		super();
		
		this.position = position;
		
		update = new JMenuItem("수정");
		update.addActionListener(this);
		
		delete = new JMenuItem("삭제");
		delete.addActionListener(this);
		
		this.add(update);
		this.add(delete);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			Shape shape = MainPanel.shapeVec.get(position);
			AppManager.createAppManager().setObjectDialog(new ObjectDialog(shape, 1));
			AppManager.createAppManager().setObjectDialogController(new ObjectDialogController(shape, 1));
			ObjectDialog objectDialog = AppManager.createAppManager().getObjectDialog();
			objectDialog.setVisible(true);
		}
		else if(ae.getSource() == delete) {
			MainPanel.shapeVec.remove(position);
			AppManager.createAppManager().getCanvasPanel().repaint();
		}
	}
}
