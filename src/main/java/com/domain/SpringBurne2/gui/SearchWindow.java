package com.domain.SpringBurne2.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchWindow
{
    public void searchWindow(Stage primaryStage)
    {
        AccountWindow accountWindow = new AccountWindow();
        BookingWindow bookingWindow = new BookingWindow();

        primaryStage.setTitle("SpringBurne");

        AnchorPane searchWindow = new AnchorPane();
        Scene searchScene = new Scene(searchWindow, 650, 450);
        searchWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Location");
        tfSearch.setPrefWidth(230);
        TextField tfStartDate = new TextField();
        tfStartDate.setPromptText("YYYY-MM-DD START");
        TextField tfEndDate = new TextField();
        tfEndDate.setPromptText("YYYY-MM-DD END");
        TextField tfBeachDistance = new TextField();
        tfBeachDistance.setPromptText("Distance to beach (m)");
        TextField tfCenterDistance = new TextField();
        tfCenterDistance.setPromptText("Distance to center (m)");
        Button btnSearch = new Button("Search");
        btnSearch.setPrefWidth(75.0);
        CheckBox cbPool = new CheckBox("Pool");
        CheckBox cbRestaurant = new CheckBox("Restaurant");
        CheckBox cbChildrensClub = new CheckBox("Children's club");
        CheckBox cbSeaView = new CheckBox("Sea View");
        CheckBox cbNightLife = new CheckBox("Night Life");
        Label labelAdult = new Label("Adults: ");
        Label labelKids = new Label("Kids: ");
        Label labelName = new Label("Namn Efternamn"); // kod för namn behvövs
        Hyperlink hlAccount = new Hyperlink("Account");
        Button btnContinue = new Button("Continue");

        ObservableList<Integer> adults = FXCollections.observableArrayList(
                1,
                2,
                3,
                4
        );
        final ComboBox cboxAdults = new ComboBox(adults);

        ObservableList<Integer> children = FXCollections.observableArrayList(
                1,
                2,
                3,
                4
        );
        final ComboBox cboxChildren = new ComboBox(children);



        ObservableList<String> listLocations
                = FXCollections.observableArrayList();
        ListView<String> lvListLocations = new ListView<String>(listLocations);
        SelectionModel<String> lvSelModel
                = lvListLocations.getSelectionModel();


        AnchorPane.setBottomAnchor(btnSearch, 35.0);
        AnchorPane.setLeftAnchor(btnSearch, 10.0);

        AnchorPane.setTopAnchor(tfSearch, 35.0);
        AnchorPane.setLeftAnchor(tfSearch, 5.0);
        // AnchorPane.setRightAnchor(tfSearch, 290.0);

        AnchorPane.setTopAnchor(tfStartDate, 65.0);
        AnchorPane.setLeftAnchor(tfStartDate, 5.0);

        AnchorPane.setTopAnchor(tfEndDate, 95.0);
        AnchorPane.setLeftAnchor(tfEndDate, 5.0);

        AnchorPane.setTopAnchor(tfBeachDistance, 300.0);
        AnchorPane.setLeftAnchor(tfBeachDistance, 5.0);

        AnchorPane.setTopAnchor(tfCenterDistance, 270.0);
        AnchorPane.setLeftAnchor(tfCenterDistance, 5.0);

        AnchorPane.setTopAnchor(cbPool, 180.0);
        AnchorPane.setLeftAnchor(cbPool, 5.0);

        AnchorPane.setTopAnchor(cbRestaurant, 180.0);
        AnchorPane.setLeftAnchor(cbRestaurant, 55.0);

        AnchorPane.setTopAnchor(cbChildrensClub, 205.0);
        AnchorPane.setLeftAnchor(cbChildrensClub, 5.0);

        AnchorPane.setTopAnchor(cbSeaView, 205.0);
        AnchorPane.setLeftAnchor(cbSeaView, 110.0);

        AnchorPane.setTopAnchor(cbNightLife, 235.0);
        AnchorPane.setLeftAnchor(cbNightLife, 5.0);
        AnchorPane.setTopAnchor(cboxAdults, 150.0);
        AnchorPane.setLeftAnchor(cboxAdults, 5.0);

        AnchorPane.setTopAnchor(cboxChildren, 150.0);
        AnchorPane.setLeftAnchor(cboxChildren, 75.0);

        AnchorPane.setTopAnchor(lvListLocations, 5.0);
        AnchorPane.setLeftAnchor(lvListLocations, 250.0);
        AnchorPane.setBottomAnchor(lvListLocations, 50.0);
        AnchorPane.setRightAnchor(lvListLocations, 5.0);

        AnchorPane.setTopAnchor(labelAdult, 130.0);
        AnchorPane.setLeftAnchor(labelAdult, 5.0);

        AnchorPane.setTopAnchor(labelKids, 130.0);
        AnchorPane.setLeftAnchor(labelKids, 75.0);

        AnchorPane.setTopAnchor(labelName, 5.0);
        AnchorPane.setLeftAnchor(labelName, 5.0);

        AnchorPane.setTopAnchor(hlAccount, 14.0);
        AnchorPane.setLeftAnchor(hlAccount, 2.0);

        AnchorPane.setBottomAnchor(btnContinue, 5.0);
        AnchorPane.setRightAnchor(btnContinue, 5.0);

        searchWindow.getChildren().addAll(
                btnSearch,
                tfSearch,
                tfStartDate,
                tfEndDate,
                cbPool,
                cbRestaurant,
                cbChildrensClub,
                cbNightLife,
                cbSeaView,
                cboxAdults,
                lvListLocations,
                labelAdult,
                cboxChildren,
                labelKids,
                labelName,
                hlAccount,
                btnContinue,
                tfBeachDistance,
                tfCenterDistance);
        primaryStage.setScene(searchScene);
        primaryStage.show();

        hlAccount.setOnAction(e -> accountWindow.accountWindow(primaryStage));
        btnContinue.setOnAction(event -> bookingWindow.bookingWindow(primaryStage));
    }
}
