package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetupDialog extends JFrame{
   
   private JLabel askSentence;
   private JLabel widthLabel;
   private JLabel columnLabel;
   private JTextField widthField;
   private JTextField columnField;
   private JButton makeBtn;
   
   
   public SetupDialog()
   {
      this.setLayout(new FlowLayout());
      this.setSize(300, 200);
      
      askSentence = new JLabel("가로 세로 길이를 입력해주세요");
      widthLabel = new JLabel("가로");
      columnLabel = new JLabel("세로");
      widthField = new JTextField(10);
      columnField = new JTextField(10);
      makeBtn = new JButton("만들기");      
      
      
      this.add(askSentence);
      this.add(widthLabel);
      this.add(widthField);
      this.add(columnLabel);
      this.add(columnField);
      this.add(makeBtn);
      
      this.setVisible(true);
      
   }
   
   public void callActionListener(ActionListener listener)
   {
      makeBtn.addActionListener(listener);
   }

      
   /// getter setter
   
   public JButton getMakeBtn() {
      return makeBtn;
   }

   public void setMakeBtn(JButton makeBtn) {
      this.makeBtn = makeBtn;
   }

   public JTextField getWidthField() {
      return widthField;
   }

   public void setWidthField(JTextField widthField) {
      this.widthField = widthField;
   }

   public JTextField getColumnField() {
      return columnField;
   }

   public void setColumnField(JTextField columnField) {
      this.columnField = columnField;
   }

   public JLabel getAskSentence() {
      return askSentence;
   }

   public void setAskSentence(JLabel askSentence) {
      this.askSentence = askSentence;
   }
   
   
   

}