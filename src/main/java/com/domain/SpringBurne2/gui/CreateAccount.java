package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccount
{
    public void createAccountWindow(Stage primaryStage)
    {
        REST rest = new REST();
        App login = new App();

        primaryStage.setTitle("SpringBurne");
        AnchorPane createAccountWindow = new AnchorPane();
        Scene createScene = new Scene(createAccountWindow, 300, 225);
        createAccountWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        TextField tfFirstName = new TextField();
        TextField tfLastName = new TextField();
        TextField tfEmail = new TextField();
        TextField tfPassword = new TextField();
        Label labelFName = new Label("First name: ");
        Label labelLName = new Label("Last name: ");
        Label labelEmail = new Label("Email: ");
        Label labelPassword = new Label("Password: ");
        Label labelGender = new Label("Gender:");
        Button btnBack = new Button("Back");
        Button btnCreate = new Button("Create");

        ObservableList<String> gender = FXCollections.observableArrayList(
                "M",
                "F",
                "O"
        );
        ComboBox cboxGender = new ComboBox(gender);

        tfFirstName.setPromptText("First name");
        tfLastName.setPromptText("Last name");
        tfEmail.setPromptText("E-mail");
        tfPassword.setPromptText("Password");

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
        AnchorPane.setLeftAnchor(labelPassword, 5.0);
        AnchorPane.setTopAnchor(tfPassword, 100.0);
        AnchorPane.setLeftAnchor(tfPassword, 75.0);

        AnchorPane.setBottomAnchor(btnBack, 5.0);
        AnchorPane.setLeftAnchor(btnBack, 5.0);

        AnchorPane.setBottomAnchor(btnCreate, 5.0);
        AnchorPane.setRightAnchor(btnCreate, 5.0);

        AnchorPane.setLeftAnchor(cboxGender, 75.0);
        AnchorPane.setTopAnchor(cboxGender, 130.0);
        AnchorPane.setTopAnchor(labelGender, 133.0);
        AnchorPane.setLeftAnchor(labelGender, 5.0);

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
                btnCreate,
                cboxGender,
                labelGender);
        primaryStage.setScene(createScene);
        primaryStage.show();

        btnBack.setOnAction(e -> {
            try {
                login.start(primaryStage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        btnCreate.setOnAction(e -> {
            String value = (String) cboxGender.getValue();
            Customer c = new Customer(
                    0L,
                    tfFirstName.getText(),
                    tfLastName.getText(),
                    Customer.Gender.valueOf(value),
                    tfEmail.getText(),
                    tfPassword.getText());
            rest.postUser(c);
            confirmAccountWindow(primaryStage);
        });
    }

    public void confirmAccountWindow(Stage primaryStage)
    {
        App login = new App();

        primaryStage.setTitle("SpringBurne");
        BorderPane createAccountWindow = new BorderPane();
        Scene createScene = new Scene(createAccountWindow, 300, 225);
        createAccountWindow.setPadding(new Insets(10, 10, 10, 10));

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Label labelCreated = new Label("Account Created");
        Button btnOk = new Button("Ok");

        vbox.setAlignment(Pos.CENTER);
        createAccountWindow.setCenter(vbox);
        vbox.getChildren().addAll(labelCreated, btnOk);
        primaryStage.setScene(createScene);
        primaryStage.show();

        btnOk.setOnAction(e -> {
            try {
                login.start(primaryStage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

    }
}