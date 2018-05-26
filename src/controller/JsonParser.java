package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Shape;
import view.MainPanel;

public class JsonParser {
   private JSONParser jsonParser;
   private Vector<Shape> shapeVec;
   
   private BufferedWriter bufferedWriter;
   private BufferedReader bufferedReader;
   private String tmp;
   private String fileName;
   

   public JsonParser() {
      jsonParser = new JSONParser();
      shapeVec = MainPanel.shapeVec;
   }

   public void openReader() {
      try {
         bufferedReader = new BufferedReader(new FileReader(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public void openWriter() {
      try {
         bufferedWriter = new BufferedWriter(new FileWriter(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void save() {
      openWriter();
      
      StringBuffer sb = new StringBuffer("");

      sb.append("{\"");
      sb.append("Shape"); // className
      sb.append("\":[");

      for (int i = 0; i < shapeVec.size(); i++) {
         sb.append("{\"");
         
         sb.append("shape"); //key
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getShape()); //val
         sb.append("\"");

         sb.append(",\"");
         sb.append("x");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getX());
         sb.append("\"");

         sb.append(",\"");
         sb.append("y");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getY());
         sb.append("\"");

         sb.append(",\"");
         sb.append("width");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getWidth());
         sb.append("\"");

         sb.append(",\"");
         sb.append("height");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getHeight());
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("red");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getRed());
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("green");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getGreen());
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("blue");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getBlue());
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("empty");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).isEmpty());
         sb.append("\"");

         sb.append(",\"");
         sb.append("type");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getType());
         sb.append("\"");

         sb.append(",\"");
         sb.append("imgPath");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getImgPath());
         sb.append("\"");

         sb.append(",\"");
         sb.append("name");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).getName());
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("canvasWidth");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append((int)(shapeVec.get(i).getCanvasWidth()/MainPanel.rate));
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("canvasHeight");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append((int)(shapeVec.get(i).getCanvasHeight()/MainPanel.rate));
         sb.append("\"");
         
         sb.append(",\"");
         sb.append("closeSpace");
         sb.append("\"");
         sb.append(":");
         sb.append("\"");
         sb.append(shapeVec.get(i).isCloseSpace());
         sb.append("\"");
         
         sb.append("}");
         if (!(i == shapeVec.size() - 1)) {
            sb.append(",");
         }
      }
      
      sb.append("]}");
      String result = sb.toString();
      System.out.println("save");
      System.out.println(result);

      try {
         bufferedWriter.write(result);
         bufferedWriter.newLine();
         bufferedWriter.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public Vector<Shape> load() {
      openReader();
      try {
         tmp = bufferedReader.readLine();
         System.out.println("load");
         System.out.println(tmp);
         bufferedReader.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      JSONObject jsonObject = null;
      JSONArray groupInfoArray = null;
      try {
         jsonObject = (JSONObject) jsonParser.parse(tmp);

         groupInfoArray = (JSONArray) jsonObject.get("Shape");
         shapeVec = new Vector<Shape>();
         for (int i = 0; i < groupInfoArray.size(); i++) {
            JSONObject groupObject = (JSONObject) groupInfoArray.get(i);            

            Shape shape = new Shape( groupObject.get("shape").toString(), Integer.parseInt(groupObject.get("x").toString())
                  , Integer.parseInt(groupObject.get("y").toString()), Integer.parseInt(groupObject.get("width").toString()), 
                  Integer.parseInt(groupObject.get("height").toString()), Integer.parseInt(groupObject.get("red").toString()),
                  Integer.parseInt(groupObject.get("green").toString()),Integer.parseInt(groupObject.get("blue").toString()),
                  Boolean.parseBoolean(groupObject.get("empty").toString()), Integer.parseInt(groupObject.get("type").toString())
                  ,groupObject.get("imgPath").toString() ,groupObject.get("name").toString(),
                  Integer.parseInt(groupObject.get("canvasWidth").toString()), Integer.parseInt(groupObject.get("canvasHeight").toString()),
                  Boolean.parseBoolean(groupObject.get("closeSpace").toString())
                  );
            shapeVec.add(shape);
         }

      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return shapeVec;
   }

   //getter setter
   public String getFileName() {
      return fileName;
   }

   public void setFileName(String fileName) {
      this.fileName = fileName;
   }
   //----------------------------
   

}