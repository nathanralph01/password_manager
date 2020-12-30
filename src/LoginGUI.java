package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class LoginGUI extends Application {
	
	Scene login;
	Scene mainScene;
	Stage window;
	//ArrayList<String> array;
	LoginMain file;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void loginScene() {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text formTitle = new Text ("Enter a username below");
		formTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(formTitle, 0, 0, 2, 1);
		
		TextField passwordTF = new TextField();
		grid.add(passwordTF, 0, 1, 2, 1);
		
		Label errorLabel = new Label();
		errorLabel.setTextFill(Color.RED);
		grid.add(errorLabel, 0, 3, 2, 1);
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> {
			if(!passwordTF.getText().isEmpty()) {
				file = new LoginMain(passwordTF.getText());
				String fileResult = file.getFile();
				if(fileResult.equals("good_file")) {
					mainScene();
					window.setScene(mainScene);
				} else if (fileResult.equals("no_file")) {
					errorLabel.setText("Username does not exist");
				} else if (fileResult.equals("bad_file")) {
					errorLabel.setText("File is of incorrect format");
				}
				//array = file.getArray();
			} else {
				errorLabel.setText("Username cannot be empty");
			}
			
		});
		grid.add(loginButton, 0, 2);
		
		Button registerButton = new Button("Register");
		registerButton.setOnAction(e -> {
			if(!passwordTF.getText().isEmpty()) {
				file = new LoginMain(passwordTF.getText());
				file.setFile();
				System.out.println("username created");
			} else {
				errorLabel.setText("Username cannot be empty");
			}
			
		});
		grid.add(registerButton, 1, 2);
		
		login = new Scene(grid,500,300);
		
	}
	
	public void mainScene() {
		
		BorderPane border = new BorderPane();
		
		ScrollPane content = new ScrollPane();
		VBox vbox = new VBox(15);
		
		ArrayList<String> array = file.getArray();
		
		for (int i = 0; i < array.size(); i++) {
			String[] entry = array.get(i).split(" ");
			HBox hbox = new HBox(20);
			
			TextField tf1 = new TextField(entry[0]);
			TextField tf2 = new TextField(entry[1]);
			TextField tf3 = new TextField(entry[2]);
			
			hbox.getChildren().addAll(tf1, tf2, tf3);
			vbox.getChildren().add(hbox);
			
		}
		
		content.setContent(vbox);
		
		border.setCenter(content);
		
		HBox header = new HBox(50);
		header.setAlignment(Pos.CENTER);
		
		Button add = new Button("Add Entry");
		add.setOnAction(e -> {
			HBox hbox = new HBox(20);
			TextField tf1 = new TextField();
			TextField tf2 = new TextField();
			TextField tf3 = new TextField();
			
			hbox.getChildren().addAll(tf1, tf2, tf3);
			vbox.getChildren().add(hbox);
		});
		
		Button logout = new Button("Logout");
		logout.setOnAction(e -> {
			window.setScene(login);
		});
		
		Button save = new Button ("save");
		save.setOnAction(e -> {
			ArrayList <String> arraytemp = new ArrayList();
			int entryNumber = vbox.getChildren().size();
			
			for (int i = 0; i < entryNumber; i++) {
				String entry = "";
				/*Node nodeOut = vbox.getChildren().get(i);
				nodeOut = ((HBox)nodeOut).getChildren().get(0); 
				entry = ((TextField)nodeOut).getText();
				
				nodeOut = vbox.getChildren().get(i);
				nodeOut = ((HBox)nodeOut).getChildren().get(1); 
				entry = entry + " " +  ((TextField)nodeOut).getText();
				
				nodeOut = vbox.getChildren().get(i);
				nodeOut = ((HBox)nodeOut).getChildren().get(2);
				entry = entry + " " +  ((TextField)nodeOut).getText();*/
				
				for (int k = 0; k < 3; k++) {
					entry = entry + getTextField(i,k,vbox) + " ";
				}
				arraytemp.add(entry.substring(0,entry.length() - 1));
			}
			
			file.setArray(arraytemp);
			file.editFile();
			
		});
		
		header.getChildren().addAll(add,logout,save);
		border.setTop(header);
		
		mainScene = new Scene(border, 500, 300);
		
	}
	
	public String getTextField(int row, int column, VBox vbox) {
		String entry;
		Node node = vbox.getChildren().get(row);
		node = ((HBox)node).getChildren().get(column); 
		entry = ((TextField)node).getText();
		return entry;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		loginScene();
		
		window.setTitle("Password Manager");
		window.setScene(login);
		window.show();
		
	}
	
}
