package application;

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
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void loginScene() {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text formTitle = new Text ("Enter a password below!");
		formTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(formTitle, 0, 0, 2, 1);
		
		TextField passwordTF = new TextField();
		grid.add(passwordTF, 0, 1, 2, 1);
		
		Button loginButton = new Button("Login");
		grid.add(loginButton, 0, 2);
		
		Button registerButton = new Button("Register");
		grid.add(registerButton, 1, 2);
		
		login = new Scene(grid,400,300);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		loginScene();
		
		primaryStage.setScene(login);
		primaryStage.show();
		
	}
	
}
