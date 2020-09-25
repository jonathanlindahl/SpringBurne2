package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.models.Reservation;
import com.domain.SpringBurne2.models.Room;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

public class AccountWindow
{
    public void accountWindow(Stage primaryStage, Customer customer)
    {
        REST rest = new REST();

        primaryStage.setTitle("SpringBurne");
        SearchWindow searchWindow = new SearchWindow();
        AnchorPane accountWindow = new AnchorPane();
        Scene accountScene = new Scene(accountWindow, 1000, 450);
        accountWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        Label labelDetails = new Label("Details");
        Label labelFName = new Label("First name:");
        TextField tfFName = new TextField();
        Label labelFNameInfo = new Label(customer.getFirstName());
        tfFName.setDisable(true);
        tfFName.setVisible(false);
        labelFNameInfo.setVisible(true);

        Label labelLName = new Label("Last name:");
        TextField tfLName = new TextField();
        Label labelLNameInfo = new Label(customer.getLastName());
        tfLName.setDisable(true);
        tfLName.setVisible(false);
        labelLNameInfo.setVisible(true);

        Label labelEmail = new Label("Email:");
        TextField tfEmail = new TextField();
        Label labelEmailInfo = new Label(customer.getEmail());
        tfEmail.setDisable(true);
        tfEmail.setVisible(false);
        labelEmailInfo.setVisible(true);

        Label labelPassword = new Label("Password:");
        TextField tfPassword = new TextField();
        Label labelPasswordInfo = new Label(customer.getPassword()); // TODO gör om till *** om vi har tid
        tfPassword.setDisable(true);
        tfPassword.setVisible(false);
        labelPasswordInfo.setVisible(true);

        Hyperlink hlChangeFName = new Hyperlink("change");
        Hyperlink hlChangeLName = new Hyperlink("change");
        Hyperlink hlChangeEmail = new Hyperlink("change");
        Hyperlink hlChangePassword = new Hyperlink("change");

        Button btnSave = new Button("Save");
        Button btnCancelReservation = new Button("Cancel Reservation");
        Button btnChangeReservation = new Button("Change Reservation");
        Button btnBack = new Button("Back to booking");
        TableView reservationTable = new TableView();
        
        TableColumn<Reservation, Long> bookingId = new TableColumn<>("Booking ID");
        TableColumn<Reservation, Long> customerId = new TableColumn<>("Customer ID");
        TableColumn<Reservation, Long> roomId = new TableColumn<>("Room ID");
        TableColumn<Reservation, String> checkInDate = new TableColumn<>("Check in Date");
        TableColumn<Reservation, String> checkoutDate = new TableColumn<>("Check out Date");
        TableColumn<Reservation, Boolean> halfBoard = new TableColumn<>("Half board");
        TableColumn<Reservation, Boolean> fullBoard = new TableColumn<>("Full board");
        TableColumn<Reservation, Boolean> allInclusive = new TableColumn<>("All inclusive");
        TableColumn<Reservation, Integer> extraBeds = new TableColumn<>("Extra beds");
        TableColumn<Reservation, Integer> extraCribs = new TableColumn<>("Extra cribs");

        reservationTable.getColumns().addAll(
                bookingId,
                customerId,
                roomId,
                checkInDate,
                checkoutDate,
                halfBoard,
                fullBoard,
                allInclusive,
                extraBeds,
                extraCribs
        );

        AnchorPane.setTopAnchor(labelDetails, 5.0);
        AnchorPane.setLeftAnchor(labelDetails, 5.0);

        AnchorPane.setTopAnchor(labelFName, 40.0);
        AnchorPane.setLeftAnchor(labelFName, 5.0);
        AnchorPane.setTopAnchor(labelFNameInfo, 40.0);
        AnchorPane.setLeftAnchor(labelFNameInfo, 75.0);
        AnchorPane.setTopAnchor(tfFName, 40.0);
        AnchorPane.setLeftAnchor(tfFName, 75.0);
        AnchorPane.setTopAnchor(hlChangeFName, 40.0);
        AnchorPane.setLeftAnchor(hlChangeFName, 280.0);

        AnchorPane.setTopAnchor(labelLName, 80.0);
        AnchorPane.setLeftAnchor(labelLName, 5.0);
        AnchorPane.setTopAnchor(labelLNameInfo, 80.0);
        AnchorPane.setLeftAnchor(labelLNameInfo, 75.0);
        AnchorPane.setTopAnchor(tfLName, 80.0);
        AnchorPane.setLeftAnchor(tfLName, 75.0);
        AnchorPane.setTopAnchor(hlChangeLName, 80.0);
        AnchorPane.setLeftAnchor(hlChangeLName, 280.0);

        AnchorPane.setTopAnchor(labelEmail, 120.0);
        AnchorPane.setLeftAnchor(labelEmail, 5.0);
        AnchorPane.setTopAnchor(labelEmailInfo, 120.0);
        AnchorPane.setLeftAnchor(labelEmailInfo, 75.0);
        AnchorPane.setTopAnchor(tfEmail, 120.0);
        AnchorPane.setLeftAnchor(tfEmail, 75.0);
        AnchorPane.setTopAnchor(hlChangeEmail, 120.0);
        AnchorPane.setLeftAnchor(hlChangeEmail, 280.0);

        AnchorPane.setTopAnchor(labelPassword, 160.0);
        AnchorPane.setLeftAnchor(labelPassword, 5.0);
        AnchorPane.setTopAnchor(labelPasswordInfo, 160.0);
        AnchorPane.setLeftAnchor(labelPasswordInfo, 75.0);
        AnchorPane.setTopAnchor(tfPassword, 160.0);
        AnchorPane.setLeftAnchor(tfPassword, 75.0);
        AnchorPane.setTopAnchor(hlChangePassword, 160.0);
        AnchorPane.setLeftAnchor(hlChangePassword, 280.0);

        AnchorPane.setTopAnchor(btnSave, 200.0);
        AnchorPane.setLeftAnchor(btnSave, 285.0);

        AnchorPane.setTopAnchor(reservationTable, 5.0);
        AnchorPane.setLeftAnchor(reservationTable, 335.0);
        AnchorPane.setBottomAnchor(reservationTable, 50.0);
        AnchorPane.setRightAnchor(reservationTable, 5.0);

        AnchorPane.setBottomAnchor(btnChangeReservation, 5.0);
        AnchorPane.setRightAnchor(btnChangeReservation, 5.0);

        AnchorPane.setBottomAnchor(btnCancelReservation, 5.0);
        AnchorPane.setRightAnchor(btnCancelReservation, 165.0);

        AnchorPane.setBottomAnchor(btnBack, 5.0);
        AnchorPane.setLeftAnchor(btnBack, 5.0);


        accountWindow.getChildren().addAll(
                tfFName,
                labelFNameInfo,
                hlChangeFName,
                tfLName,
                labelLNameInfo,
                hlChangeLName,
                tfEmail,
                labelEmailInfo,
                hlChangeEmail,
                tfPassword,
                labelPasswordInfo,
                hlChangePassword,
                btnSave,
                reservationTable,
                btnChangeReservation,
                btnCancelReservation,
                btnBack,
                labelDetails,
                labelEmail,
                labelFName,
                labelLName,
                labelPassword);
        primaryStage.setScene(accountScene);
        primaryStage.show();

        List<Reservation> reservations = rest.getReservations();
        bookingId.setCellValueFactory(
                new PropertyValueFactory<Reservation, Long>("reservationId"));
        customerId.setCellValueFactory(
                new PropertyValueFactory<Reservation, Long>("customerId"));
        roomId.setCellValueFactory(
                new PropertyValueFactory<Reservation, Long>("roomId"));
        checkInDate.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("StartDate"));
        checkoutDate.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("EndDate"));
        halfBoard.setCellValueFactory(
                new PropertyValueFactory<Reservation, Boolean>("HalfBoard"));
        fullBoard.setCellValueFactory(
                new PropertyValueFactory<Reservation, Boolean>("FullBoard"));
        allInclusive.setCellValueFactory(
                new PropertyValueFactory<Reservation, Boolean>("AllInclusive"));
        extraBeds.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("ExtraBeds"));
        extraCribs.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("ExtraCribs"));
        
        for (Reservation r : reservations)
            if (r.getCustomerId().equals(customer.getCustomerId()))
                reservationTable.getItems().add(r);

        hlChangeFName.setOnAction(e ->
        {
            tfFName.setDisable(false);
            tfFName.setVisible(true);
            labelFNameInfo.setVisible(false);
        });

        hlChangeLName.setOnAction(e ->
        {
            tfLName.setDisable(false);
            tfLName.setVisible(true);
            labelLNameInfo.setVisible(false);
        });

        hlChangeEmail.setOnAction(e ->
        {
            tfEmail.setDisable(false);
            tfEmail.setVisible(true);
            labelEmailInfo.setVisible(false);
        });

        hlChangePassword.setOnAction(e ->
        {
            tfPassword.setDisable(false);
            tfPassword.setVisible(true);
            labelPasswordInfo.setVisible(false);
        });

        btnSave.setOnAction(event -> {
            if (!tfFName.getText().trim().isEmpty()) {
                customer.setFirstName(tfFName.getText());
                labelFNameInfo.setText(customer.getFirstName());
            }
            if (!tfLName.getText().trim().isEmpty()) {
                customer.setLastName(tfLName.getText());
                labelLNameInfo.setText(customer.getLastName());
            }
            if (!tfEmail.getText().trim().isEmpty()) {
                customer.setEmail(tfEmail.getText());
                labelEmailInfo.setText(customer.getEmail());
            }
            if (!tfPassword.getText().trim().isEmpty()) {
                customer.setPassword(tfPassword.getText());
                labelPasswordInfo.setText(customer.getPassword());
            }
            rest.updateUser(customer);
            tfFName.setDisable(true);
            tfFName.setVisible(false);
            labelFNameInfo.setVisible(true);
            tfLName.setDisable(true);
            tfLName.setVisible(false);
            labelLNameInfo.setVisible(true);
            tfEmail.setDisable(true);
            tfEmail.setVisible(false);
            labelEmailInfo.setVisible(true);
            tfPassword.setDisable(true);
            tfPassword.setVisible(false);
            labelPasswordInfo.setVisible(true);
        });

        btnBack.setOnAction(event -> searchWindow.searchWindow(primaryStage, customer));
        btnCancelReservation.setOnAction(e -> {
            int i = reservationTable.getSelectionModel().getSelectedIndex();
            Reservation r = (Reservation) reservationTable.getItems().get(i);
            rest.deleteReservation(r);
            reservationTable.getItems().remove(i);
        });
    }
}
