package controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

import main.AppManager;
import view.MainFrame;
import view.MainPanel;

public class MainFrameController {

   private MainFrame mainFrame;
   private JsonParser jsonParser;
   private FileDialog dialog;
   
   
   public MainFrameController() {
      mainFrame = AppManager.createAppManager().getMainFrame();
      jsonParser = AppManager.createAppManager().getJsonParser();
      
      mainFrame.callActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            
            if(obj == mainFrame.getNewItem()) // 이전 저장 여부, clear
            {
               newFile();
            }
            else if(obj == mainFrame.getSaveItem())
            {
               saveFile();
               
            }
            else if(obj == mainFrame.getLoadItem())
            {
               loadFile();
            }
            else if(obj == mainFrame.getExitItem())
            {
               System.exit(0);
            }
            
            
         }
      });
   }
   
   
   public void saveFile()
   {
      dialog = new FileDialog(mainFrame, "save",FileDialog.SAVE);
      dialog.setDirectory(".");
      dialog.setVisible(true);
            
      if(dialog.getFile() == null) return;

      jsonParser.setFileName(dialog.getFile());
      jsonParser.save();
      
   }

   public void newFile()
   {
      int result = 1;
      if(MainPanel.shapeVec.size() != 0)
      {
         result  = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "save",JOptionPane.YES_NO_OPTION);
      }
      
      if(result == 0)  // 저장
      {
         saveFile();
      }
      
      AppManager.createAppManager().getMainPanel().shapeVec.removeAllElements();
      AppManager.createAppManager().getCanvasPanel().repaint();
      
   }

   public void loadFile()
   {
      int result = 1;
      if(MainPanel.shapeVec.size() != 0)
      {
         result  = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "save",JOptionPane.YES_NO_OPTION);
      }
      
      if(result == 0)  // 저장
      {
         saveFile();
      }
      
      dialog = new FileDialog(mainFrame, "load",FileDialog.LOAD);
      
      dialog.setDirectory(".");
      dialog.setVisible(true);
      
      if(dialog.getFile() == null) return;
      else
      {
         jsonParser.setFileName(dialog.getFile());
         MainPanel.shapeVec = jsonParser.load();   
         AppManager.createAppManager().getCanvasPanel().repaint();
         
      }
   }
}