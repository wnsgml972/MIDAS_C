package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Door;
import model.Shape;
import model.Window;
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

			sb.append("shape"); // key
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(shapeVec.get(i).getShape()); // val
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
			sb.append((int) (shapeVec.get(i).getCanvasWidth() / MainPanel.rate));
			sb.append("\"");

			sb.append(",\"");
			sb.append("canvasHeight");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append((int) (shapeVec.get(i).getCanvasHeight() / MainPanel.rate));
			sb.append("\"");

			sb.append(",\"");
			sb.append("closeSpace");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(shapeVec.get(i).isCloseSpace());
			sb.append("\"");
			
			sb.append(",\"");
			sb.append("doorSize");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(shapeVec.get(i).getDoors().size());
			sb.append("\"");
			
			// door start
			for (int j = 0; j < shapeVec.get(i).getDoors().size(); j++) {

				sb.append(",\"");
				sb.append("d"+j+"x");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getX());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"y");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getY());
				sb.append("\"");

				sb.append(",\"");
				sb.append("d"+j+"width");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getWidth());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"height");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getHeight());
				sb.append("\"");

				sb.append(",\"");
				sb.append("d"+j+"moveWidth");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getMoveWidth());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"moveHeight");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getMoveHeight());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"dir");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getDir());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"x1");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getX1());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"y1");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getY1());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"x2");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getX2());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("d"+j+"y2");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getDoors().get(j).getY2());
				sb.append("\"");
			}
			// door end
			
			sb.append(",\"");
			sb.append("windowSize");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(shapeVec.get(i).getWindows().size());
			sb.append("\"");
			
			// window start
			for (int j = 0; j < shapeVec.get(i).getWindows().size(); j++) {

				sb.append(",\"");
				sb.append("w"+j+"x");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getX());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"y");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getY());
				sb.append("\"");

				sb.append(",\"");
				sb.append("w"+j+"width");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getWidth());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"height");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getHeight());
				sb.append("\"");

				sb.append(",\"");
				sb.append("w"+j+"moveWidth");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getMoveWidth());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"moveHeight");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getMoveHeight());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"dir");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getDir());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"x1");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getX1());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"y1");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getY1());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"x2");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getX2());
				sb.append("\"");
				
				sb.append(",\"");
				sb.append("w"+j+"y2");
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(shapeVec.get(i).getWindows().get(j).getY2());
				sb.append("\"");
			}
			// window end
			
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
				ArrayList<Door> doorList = new ArrayList<Door>();
				ArrayList<Window> windowList = new ArrayList<Window>();
				//door
				for(int j=0; j<Integer.parseInt(groupObject.get("doorSize").toString()); j++){

					//dir, x1, y1, x2, y2  수정
					
					Door door = new Door(Integer.parseInt(groupObject.get("d" +j+"x").toString()),
							Integer.parseInt(groupObject.get("d" +j+"y").toString()), 
							Integer.parseInt(groupObject.get("d" +j+"width").toString()), 
							Integer.parseInt(groupObject.get("d" +j+"height").toString()),
							Integer.parseInt(groupObject.get("d" +j+"dir").toString()),
							Integer.parseInt(groupObject.get("d" +j+"x1").toString()),
							Integer.parseInt(groupObject.get("d" +j+"y1").toString()),
							Integer.parseInt(groupObject.get("d" +j+"x2").toString()),
							Integer.parseInt(groupObject.get("d" +j+"y2").toString())
							);
					doorList.add(door);
				}
				//window
				for(int j=0; j<Integer.parseInt(groupObject.get("windowSize").toString()); j++){

					Window window = new Window(Integer.parseInt(groupObject.get("w" +j+"x").toString()),
							Integer.parseInt(groupObject.get("w" +j+"y").toString()), 
							Integer.parseInt(groupObject.get("w" +j+"width").toString()), 
							Integer.parseInt(groupObject.get("w" +j+"height").toString()),
							Integer.parseInt(groupObject.get("w" +j+"dir").toString()),
							Integer.parseInt(groupObject.get("w" +j+"x1").toString()),
							Integer.parseInt(groupObject.get("w" +j+"y1").toString()),
							Integer.parseInt(groupObject.get("w" +j+"x2").toString()),
							Integer.parseInt(groupObject.get("w" +j+"y2").toString())
							);
					windowList.add(window);
				}
				
				Shape shape = new Shape(groupObject.get("shape").toString(),
						Integer.parseInt(groupObject.get("x").toString()),
						Integer.parseInt(groupObject.get("y").toString()),
						Integer.parseInt(groupObject.get("width").toString()),
						Integer.parseInt(groupObject.get("height").toString()),
						Integer.parseInt("0"),
						Integer.parseInt(groupObject.get("green").toString()),
						Integer.parseInt(groupObject.get("blue").toString()),
						Boolean.parseBoolean(groupObject.get("empty").toString()),
						Integer.parseInt(groupObject.get("type").toString()), groupObject.get("imgPath").toString(),
						groupObject.get("name").toString(), Integer.parseInt(groupObject.get("canvasWidth").toString()),
						Integer.parseInt(groupObject.get("canvasHeight").toString()),
						Boolean.parseBoolean(groupObject.get("closeSpace").toString()),
						doorList, windowList
						);
				shapeVec.add(shape);
				
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shapeVec;
	}

	// getter setter
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	// ----------------------------

}