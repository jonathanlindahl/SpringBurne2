package com.domain.SpringBurne2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class BookingWindow
{
    public void bookingWindow(Stage primaryStage)
    {
        SearchWindow searchWindow = new SearchWindow();
        AccountWindow accountWindow = new AccountWindow();

        Image image = new Image("https://i.imgur.com/XaVrpqJ.jpg");


        primaryStage.setTitle("SpringBurne");

        AnchorPane bookingWindow = new AnchorPane();
        Scene bookingScene = new Scene(bookingWindow, 650, 450);
        bookingWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        Label labelExtra = new Label("Extras: ");
        Label labelInfo = new Label("\"Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"");
        labelInfo.setWrapText(true);
        Label labelName = new Label("NAME OF HOTEL"); // kod för namn
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);

        Button btnConfirm = new Button("Confirm booking");
        Button btnCancel = new Button("Cancel and return");

        Label labelBeds = new Label("Extra beds:");
        ObservableList<Integer> beds = FXCollections.observableArrayList(
                1,
                2,
                3,
                4
        );
        final ComboBox cboxBeds = new ComboBox(beds);

        Label labelCrib = new Label("Extra cribs:");
        ObservableList<Integer> cribs = FXCollections.observableArrayList(
                1,
                2,
                3,
                4
        );
        final ComboBox cboxCrib = new ComboBox(cribs);

        CheckBox cbHalfBoard = new CheckBox("Half board");
        CheckBox cbFullBoard = new CheckBox("Full board");
        CheckBox cbAllInclusive = new CheckBox("All inclusive");

        AnchorPane.setBottomAnchor(btnConfirm, 5.0);
        AnchorPane.setRightAnchor(btnConfirm, 5.0);

        AnchorPane.setBottomAnchor(btnCancel, 5.0);
        AnchorPane.setLeftAnchor(btnCancel, 5.0);

        AnchorPane.setTopAnchor(labelInfo, 270.0);
        AnchorPane.setLeftAnchor(labelInfo, 250.0);
        AnchorPane.setRightAnchor(labelInfo, 5.0);

        AnchorPane.setLeftAnchor(labelExtra, 5.0);
        AnchorPane.setTopAnchor(labelExtra,5.0);

        AnchorPane.setTopAnchor(labelBeds, 40.0);
        AnchorPane.setLeftAnchor(labelBeds, 5.0);
        AnchorPane.setTopAnchor(cboxBeds, 40.0 );
        AnchorPane.setLeftAnchor(cboxBeds, 70.0);

        AnchorPane.setTopAnchor(labelCrib, 75.0);
        AnchorPane.setLeftAnchor(labelCrib, 5.0);
        AnchorPane.setTopAnchor(cboxCrib, 75.0);
        AnchorPane.setLeftAnchor(cboxCrib, 70.0);

        AnchorPane.setTopAnchor(cbHalfBoard, 110.0);
        AnchorPane.setLeftAnchor(cbHalfBoard, 5.0);

        AnchorPane.setTopAnchor(cbFullBoard, 140.0);
        AnchorPane.setLeftAnchor(cbFullBoard, 5.0);

        AnchorPane.setTopAnchor(cbAllInclusive, 170.0);
        AnchorPane.setLeftAnchor(cbAllInclusive, 5.0);

        AnchorPane.setTopAnchor(labelName,5.0);
        AnchorPane.setLeftAnchor(labelName, 250.0);

        AnchorPane.setTopAnchor(imageView, 25.0);
        AnchorPane.setLeftAnchor(imageView, 270.0);
        AnchorPane.setRightAnchor(imageView, 5.0);

        bookingWindow.getChildren().addAll(
                btnConfirm,
                btnCancel,
                labelInfo,
                labelExtra,
                labelName,
                labelBeds,
                cboxBeds,
                labelCrib,
                cboxCrib,
                cbHalfBoard,
                cbFullBoard,
                cbAllInclusive,
                imageView);
        primaryStage.setScene(bookingScene);
        primaryStage.show();

        btnCancel.setOnAction(e -> searchWindow.searchWindow(primaryStage));
        btnConfirm.setOnAction(e -> accountWindow.accountWindow(primaryStage));
    }
}
