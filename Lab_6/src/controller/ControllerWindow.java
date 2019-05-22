package controller;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Text;
import model.Competitor;
import model.EmptyDateException;
import model.Event;
import model.Viewer;

public class ControllerWindow {

    @FXML
    private TextField tfExplorer;

    @FXML
    private Button btExplorer;

    @FXML
    private Text textLoadData;

    @FXML
    private TextField tfSearchViewer;

    @FXML
    private Text textTimeViewer;

    @FXML
    private Text textSearchViewer;

    @FXML
    private TextField tfSearchCompetitor;

    @FXML
    private Text textTimeCompetitor;

    @FXML
    private Text textSearchCompetitor;

    @FXML
    private ImageView imageV;
    
    @FXML
    private Text textTimeLoadData;

    @FXML
    private TextArea textData;
    /**
     * Relación con el evento.
     */
    private Event ev;
    /**
     * Ruta donde se encuentra el archivo.
     */
    private File theFile;
    
    @FXML
    private TextField tfSearchCountry;
    @FXML
    private Pane pane;


    @FXML
    void btExplore(ActionEvent event) {
    		JFileChooser chooser = new JFileChooser("data");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = chooser.showOpenDialog(chooser);
			if(result==JFileChooser.APPROVE_OPTION) {
				 theFile = chooser.getSelectedFile();
			}
			tfExplorer.setText(theFile.getAbsolutePath());

    	
    }

    @FXML
    void btLoad(ActionEvent event) {
    
    	try {
			ev.loadViewer(theFile);
			ev.addToListCompetitor();
			textTimeLoadData.setText(String.valueOf(ev.getTimeLoadViewer()));
			textLoadData.setText("Se carga satisfactoriamente los datos"); 
		} catch (Exception e) {
			textLoadData.setText("Debe seleccionar el arhivo que desea cargar");
		}
    }

    @FXML
    void btSearchCompetitor(ActionEvent event) {
    	long timeSearchCompetitor =  System.currentTimeMillis();
    	String id = tfSearchCompetitor.getText();
    	try {
    		textSearchCompetitor.setText("");
    		Competitor competitor = ev.searchCompetitor(id);
    		imageV.setImage(new Image(competitor.getPhoto()));
    		textData.setText(competitor.toString());
    	}catch (NullPointerException e) {
    		textSearchCompetitor.setText("No se encontro el participante.");
    	}
    	long time =  System.currentTimeMillis()-timeSearchCompetitor;
    	textTimeCompetitor.setText(String.valueOf(time));
    	tfSearchCompetitor.clear();
    }
    		
    		

    @FXML
    void btSearchViewer(ActionEvent event) {
    	long timeSearchViewer =  System.currentTimeMillis();
    	String id = tfSearchViewer.getText();
    	try {
    		textSearchViewer.setText("");
    		Viewer viewer =ev.searchViewer(id); 
    		imageV.setImage(new Image(viewer.getPhoto()));
    		textData.setText(viewer.toString());
    		
    	}catch(NullPointerException e) {
    		textSearchViewer.setText("No se encontro el espectador.");
    	}
    	
    	long time =  System.currentTimeMillis()-timeSearchViewer;
    	textTimeViewer.setText(String.valueOf(time));
    	tfSearchViewer.clear();
    }
    
    @FXML
    public void SearchCompetitorByCountry(ActionEvent event) {
    	int layouX = 0;
    	int layouY = 0;
    	String search= tfSearchCountry.getText();
 
    	try {
			ArrayList<Competitor> competitors = ev.searchCompetitorByCountry(search);
			System.out.println(competitors.size());
    	for (int i = 0; i < competitors.size(); i++) {
			
    		VBox vbox = new VBox();
    		vbox.setLayoutX(layouX);
    		vbox.setLayoutY(layouY);
    		vbox.setPrefWidth(258);
    		vbox.setPrefHeight(324);
    		vbox.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
    		vbox.setFillWidth(true);
    		ImageView image = new ImageView();
    		image.setImage(new Image(competitors.get(i).getPhoto()));
    		TextArea text = new TextArea();
    		text.setText(competitors.get(i).toString());
    		vbox.getChildren().add(image);
    		vbox.getChildren().add(text);
    		Line line = new Line();
    		Line line2 = new Line();
    		if(i < competitors.size()-1) {
    		line.setLayoutX(258+layouX);
    		line.setLayoutY(layouY+200);
    		line.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    		line.setEndX(42);
    		line.setFill(Color.BLUE);
    		line2.setLayoutX(258+layouX);
    		line2.setLayoutY(layouY+150);
    		line2.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    		line2.setEndX(42);
    		line2.setFill(Color.BLUE);
    		}
    		layouX += 300;
    		pane.getChildren().addAll(vbox,line,line2);
    		
		}
  	
    	} catch (EmptyDateException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
     void  SearchViewerByCountry(ActionEvent event) {
    	int layouX = 0;
    	int layouY = 0;
    	String search= tfSearchCountry.getText();
    	boolean found = false;
    	
    	try {
    		ArrayList<Viewer> viewer = ev.addViewerFromTheSameCountry(search);
		for (int i = 0; i < 10&& !found; i++) {
			
		
			VBox vbox = new VBox();
    		vbox.setLayoutX(layouX);
    		vbox.setLayoutY(layouY);
    		vbox.setPrefWidth(258);
    		vbox.setPrefHeight(324);
    		vbox.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
    		vbox.setFillWidth(true);
    		ImageView image = new ImageView();
    		image.setImage(new Image(viewer.get(i).getPhoto()));
    		TextArea text = new TextArea();
    		text.setText(viewer.get(i).toString());
    		vbox.getChildren().add(image);
    		vbox.getChildren().add(text);
    		
        	
//  		  /**
//  		   * Izquierda 
//  		   */
			VBox vbox2 = new VBox();
			vbox2.setLayoutX(layouX+=258);
  			vbox2.setLayoutY(layouY-=324);
  			vbox2.setPrefWidth(258);
  			vbox2.setPrefHeight(324);
  			vbox2.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
  			vbox2.setFillWidth(true);
  			ImageView image2 = new ImageView();
  			image2.setImage(new Image(viewer.get(i+1).getPhoto()));
  			TextArea text2 = new TextArea();
  			text2.setText(viewer.get(i+1).toString());
  			vbox2.getChildren().add(image2);
  			vbox2.getChildren().add(text2);
  		
  			VBox vbox3 = new VBox();
  			//Derecha
  			if(i+2 < viewer.size()) {
    		vbox3.setLayoutX(layouX+=258);
    		vbox3.setLayoutY(layouY+=324);
    		vbox3.setPrefWidth(258);
    		vbox3.setPrefHeight(324);
    		vbox3.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
    		vbox3.setFillWidth(true);
    		ImageView image3 = new ImageView();
    		image3.setImage(new Image(viewer.get(i+2).getPhoto()));
    		TextArea text3 = new TextArea();
    		text3.setText(viewer.get(i+2).toString());
    		vbox3.getChildren().add(image3);
    		vbox3.getChildren().add(text3);
  			}else {
  				found = true;
  			}
  			pane.getChildren().addAll(vbox,vbox2,vbox3);
		}
			

    		
    	} catch (Exception e) {
    		
    	}
    	System.out.println("termine");
    }
    @FXML
    public void initialize() {
    	ev = new Event("Voley Cup");
    }

}
