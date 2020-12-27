package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginGUI extends Application {
	
	Scene login;
	Scene mainScene;
	Stage window;
	
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
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> {
			window.setScene(mainScene);
		});
		grid.add(loginButton, 0, 2);
		
		Button registerButton = new Button("Register");
		grid.add(registerButton, 1, 2);
		
		login = new Scene(grid,500,300);
		
	}
	
	public void mainScene() {
		
		BorderPane border = new BorderPane();
		HBox header = new HBox(50);
		header.setAlignment(Pos.CENTER);
		
		Button add = new Button("Add Entry");
		Button logout = new Button("Logout");
		Button edit = new Button ("Edit");
		
		header.getChildren().addAll(add,logout,edit);
		border.setTop(header);
		
	    
		
		ScrollPane content = new ScrollPane();
		VBox vbox = new VBox(15);
		
		for (int i = 0; i < 3; i++) {
			HBox hbox = new HBox(25);
			
			Label label1 = new Label("Test1");
			Label label2 = new Label("Test2");
			
			hbox.getChildren().addAll(label1, label2);
			vbox.getChildren().add(hbox);
			
			
		}
		
		content.setContent(vbox);
		
		border.setCenter(content);
		
		mainScene = new Scene(border, 500, 300);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		loginScene();
		mainScene();
		
		window.setScene(login);
		window.show();
		
	}
	
}