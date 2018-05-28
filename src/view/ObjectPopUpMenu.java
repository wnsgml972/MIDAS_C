package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import controller.ObjectDialogController;
import main.AppManager;
import model.Shape;

public class ObjectPopUpMenu extends JPopupMenu implements ActionListener {
   private int position;
   private int mode;

   private JMenuItem update;
   private JMenuItem delete;

   //
   private JMenuItem copy;
   private JMenuItem description;
   private JFrame frame;
   private JPanel  descPanel;
   //

   public ObjectPopUpMenu(int position, int mode) {
      super();

      this.position = position;
      this.mode = mode;

      copy = new JMenuItem("복사");
      copy.addActionListener(this);

      update = new JMenuItem("수정");
      update.addActionListener(this);

      delete = new JMenuItem("삭제");
      delete.addActionListener(this);

      description = new JMenuItem("설명");
      description.addActionListener(this);

      this.add(copy);
      this.add(update);

      this.add(delete);
      this.add(description);
      
      frame = new JFrame("설명");
      frame.setSize(200, 300);
      frame.setLayout(null);
      
      
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == update) {
         Shape shape = MainPanel.shapeVec.get(position);
         AppManager.createAppManager().setObjectDialog(new ObjectDialog(shape, mode));
         AppManager.createAppManager().setObjectDialogController(new ObjectDialogController(shape, mode));
         ObjectDialog objectDialog = AppManager.createAppManager().getObjectDialog();
         objectDialog.setVisible(true);
      } else if (ae.getSource() == delete) {
         MainPanel.shapeVec.remove(position);
         AppManager.createAppManager().getCanvasPanel().repaint();
      } else if (ae.getSource() == copy) {

         Shape shape = new Shape(MainPanel.shapeVec.get(position));
         shape.setX(shape.getX() + 15);
         shape.setY(shape.getY() + 15);
         MainPanel.shapeVec.add(shape);
         AppManager.createAppManager().getCanvasPanel().repaint();
      } else if (ae.getSource() == description) {

         //  설명 
         System.out.println("hello");
         descPanel = new JPanel();
         descPanel.setSize(200, 300);
         descPanel.setLocation(20, 0);
         descPanel.setLayout(new GridLayout(4,2));
         descPanel.add(new JLabel("Name : "));
         descPanel.add(new JLabel(AppManager.createAppManager().getMainPanel().shapeVec.get(position).getName()+"\n"));
         descPanel.add(new JLabel("Width : "));
         descPanel.add(new JLabel((int)(AppManager.createAppManager().getMainPanel().shapeVec.get(position).getWidth()/AppManager.createAppManager().getMainPanel().rate)+"\n"));
         descPanel.add(new JLabel("Height : "));
         descPanel.add(new JLabel((int)(AppManager.createAppManager().getMainPanel().shapeVec.get(position).getHeight()/AppManager.createAppManager().getMainPanel().rate)+"\n"));
         frame.add(descPanel);
         frame.setVisible(true);
         AppManager.createAppManager().getCanvasPanel().repaint();
      } 
   }
}