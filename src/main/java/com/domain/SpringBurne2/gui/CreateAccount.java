package com.domain.SpringBurne2.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccount
{
    public void createAccountWindow (Stage primaryStage)
    {
        App login = new App();

        primaryStage.setTitle("SpringBurne");
        AnchorPane createAccountWindow = new AnchorPane();
        Scene loginScene = new Scene(createAccountWindow, 300,200);

        TextField tfFirstName = new TextField();
        tfFirstName.setPromptText("First name");
        TextField tfLastName = new TextField();
        tfLastName.setPromptText("Last name");
        TextField tfEmail = new TextField();
        tfEmail.setPromptText("E-mail");
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");
        Label labelFName = new Label("First name: ");
        Label labelLName = new Label("Last name: ");
        Label labelEmail = new Label("Email: ");
        Label labelPassword = new Label("Password: ");
        Button btnBack = new Button("Back");
        Button btnCreate = new Button("Create");


        AnchorPane.setTopAnchor(labelFName, 7.0);
        AnchorPane.setLeftAnchor(labelFName, 5.0);
        AnchorPane.setTopAnchor(tfFirstName, 5.0);
        AnchorPane.setLeftAnchor(tfFirstName, 75.0);

        AnchorPane.setTopAnchor(labelLName, 42.0);
        AnchorPane.setLeftAnchor(labelLName, 5.0);
        AnchorPane.setTopAnchor(tfLastName, 40.0);
        AnchorPane.setLeftAnchor(tfLastName, 75.0);

        AnchorPane.setTopAnchor(labelEmail, 70.0);
        AnchorPane.setLeftAnchor(labelEmail, 5.0);
        AnchorPane.setTopAnchor(tfEmail, 70.0);
        AnchorPane.setLeftAnchor(tfEmail, 75.0);

        AnchorPane.setTopAnchor(labelPassword, 100.0);
        AnchorPane.setLeftAnchor(labelPassword,5.0);
        AnchorPane.setTopAnchor(tfPassword, 100.0);
        AnchorPane.setLeftAnchor(tfPassword, 75.0);

        AnchorPane.setTopAnchor(btnBack, 150.0);
        AnchorPane.setLeftAnchor(btnBack,5.0);

        AnchorPane.setTopAnchor(btnCreate, 150.0);
        AnchorPane.setLeftAnchor(btnCreate, 55.0);


        createAccountWindow.getChildren().addAll(
                labelFName,
                tfFirstName,
                labelLName,
                tfLastName,
                labelEmail,
                tfEmail,
                labelPassword,
                tfPassword,
                btnBack,
                btnCreate);
        primaryStage.setScene(loginScene);
        primaryStage.show();

        btnBack.setOnAction(e -> {
            try {
                login.start(primaryStage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
