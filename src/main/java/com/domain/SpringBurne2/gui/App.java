package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.repositories.CustomerRepositoryImpl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application
{

    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        SearchWindow searchWindow = new SearchWindow();
        CreateAccount createAccount = new CreateAccount();

        primaryStage.setTitle("SpringBurne");
        AnchorPane loginWindow = new AnchorPane();
        Scene loginScene = new Scene(loginWindow, 300, 175);
        loginWindow.setPadding(new Insets(10, 10, 10, 10));

        TextField tfEmail = new TextField();
        tfEmail.setPromptText("Email");
        tfEmail.setPrefWidth(200);
        Label labelEmail = new Label("Email: ");
        TextField tfPassword = new TextField();
        tfPassword.setPrefWidth(200);
        tfPassword.setPromptText("Password");
        Label labelPassword = new Label("Password: ");
        
        Button btnLogin = new Button("login");
        Button btnNewUser = new Button("New user");
        Button btnContinue = new Button("Continue without logging in");

        AnchorPane.setTopAnchor(btnLogin, 80.0);
        AnchorPane.setLeftAnchor(btnLogin, 125.0);

        AnchorPane.setBottomAnchor(btnContinue, 5.0);
        AnchorPane.setRightAnchor(btnContinue, 5.0);

        AnchorPane.setBottomAnchor(btnNewUser, 5.0);
        AnchorPane.setLeftAnchor(btnNewUser, 5.0);

        AnchorPane.setTopAnchor(tfEmail, 20.0);
        AnchorPane.setLeftAnchor(tfEmail, 65.0);
        AnchorPane.setLeftAnchor(labelEmail, 5.0);
        AnchorPane.setTopAnchor(labelEmail, 23.0);

        AnchorPane.setTopAnchor(tfPassword, 50.0);
        AnchorPane.setLeftAnchor(tfPassword, 65.0);
        AnchorPane.setTopAnchor(labelPassword, 53.0);
        AnchorPane.setLeftAnchor(labelPassword, 5.0);

        loginWindow.getChildren().addAll(btnLogin,
                btnNewUser,
                btnContinue,
                tfEmail,
                tfPassword,
                labelEmail,
                labelPassword);
        primaryStage.setScene(loginScene);
        primaryStage.show();

        btnContinue.setOnAction(e -> searchWindow.searchWindow(primaryStage, CustomerRepositoryImpl.getByID(1L)));
        btnNewUser.setOnAction(e -> createAccount.createAccountWindow(primaryStage));
        btnLogin.setOnAction(e -> {
            REST rest = new REST();
            Customer c = rest.getCustomerByEmail(tfEmail.getText());
            if (c != null && c.getPassword().equals(tfPassword.getText()))
            {
                searchWindow.searchWindow(primaryStage, c);
            }
        });
    }
}