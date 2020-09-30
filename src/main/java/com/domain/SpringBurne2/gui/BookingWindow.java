package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.models.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.List;

public class BookingWindow
{
    public void bookingWindow(
            Stage primaryStage, Customer customer, Reservation reservation)
    {
        REST rest = new REST();
        SearchWindow searchWindow = new SearchWindow();
        AccountWindow accountWindow = new AccountWindow();

        primaryStage.setTitle("SpringBurne");
        AnchorPane bookingWindow = new AnchorPane();
        Scene bookingScene = new Scene(bookingWindow, 650, 450);
        bookingWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        Label labelExtra = new Label("Extras: ");
        Label labelName = new Label("NAME OF HOTEL"); // kod för namn
        Label labelRoomName = new Label("Room name"); // TODO kod för rumsnamn
        Label labelCity = new Label("City"); // TODO kod för stad
        Label labelDescription = new Label("Room description "); // TODO kod för beskrivning
        Label labelRoomBeds = new Label("number of beds"); // TODO number of beds
        Label labelBeds = new Label("Extra beds:");
        Label labelCrib = new Label("Extra cribs:");
        Button btnConfirm = new Button("Confirm booking");
        Button btnCancel = new Button("Cancel and return");
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbHalfBoard = new RadioButton("Half board");
        RadioButton rbFullBoard = new RadioButton("Full board");
        RadioButton rbAllInclusive = new RadioButton("All inclusive");
        rbHalfBoard.setToggleGroup(tg);
        rbFullBoard.setToggleGroup(tg);
        rbAllInclusive.setToggleGroup(tg);

        ObservableList<Integer> beds = FXCollections.observableArrayList();
        for (int i = 1; i < 51; ++i)
            beds.add(i);
        final ComboBox cboxBeds = new ComboBox(beds);

        ObservableList<Integer> cribs = FXCollections.observableArrayList();
        for (int i = 1; i < 51; ++i)
            cribs.add(i);
        final ComboBox cboxCrib = new ComboBox(cribs);

        AnchorPane.setBottomAnchor(btnConfirm, 5.0);
        AnchorPane.setRightAnchor(btnConfirm, 5.0);

        AnchorPane.setBottomAnchor(btnCancel, 5.0);
        AnchorPane.setLeftAnchor(btnCancel, 5.0);

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

        AnchorPane.setTopAnchor(rbHalfBoard, 110.0);
        AnchorPane.setLeftAnchor(rbHalfBoard, 5.0);

        AnchorPane.setTopAnchor(rbFullBoard, 140.0);
        AnchorPane.setLeftAnchor(rbFullBoard, 5.0);

        AnchorPane.setTopAnchor(rbAllInclusive, 170.0);
        AnchorPane.setLeftAnchor(rbAllInclusive, 5.0);

        AnchorPane.setTopAnchor(labelName,5.0);
        AnchorPane.setLeftAnchor(labelName, 270.0);

        AnchorPane.setTopAnchor(labelRoomName, 25.0);
        AnchorPane.setLeftAnchor(labelRoomName, 270.0);

        AnchorPane.setTopAnchor(labelCity, 55.0);
        AnchorPane.setLeftAnchor(labelCity, 270.0);

        AnchorPane.setTopAnchor(labelDescription, 75.0);
        AnchorPane.setTopAnchor(labelDescription, 270.0);

        AnchorPane.setTopAnchor(labelBeds, 95.0);
        AnchorPane.setLeftAnchor(labelBeds, 270.0);

        bookingWindow.getChildren().addAll(
                btnConfirm,
                btnCancel,
                labelExtra,
                labelName,
                labelBeds,
                cboxBeds,
                labelCrib,
                cboxCrib,
                rbHalfBoard,
                rbFullBoard,
                rbAllInclusive,
                labelRoomName,
                labelDescription,
                labelCity,
                labelRoomBeds);
        primaryStage.setScene(bookingScene);
        primaryStage.show();

        btnCancel.setOnAction(e -> searchWindow.searchWindow(primaryStage, customer));
        btnConfirm.setOnAction(e -> {
            List<Reservation> reservations = rest.getReservations();
            if (reservations.contains(reservation))
                rest.updateReservation(reservation);
            else
                rest.postReservation(reservation);
            accountWindow.accountWindow(primaryStage, customer);
        });
    }
}
