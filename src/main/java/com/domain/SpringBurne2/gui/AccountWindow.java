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
        TableView roomTable = new TableView();

        TableColumn<Room, Long> roomId = new TableColumn<>("Room ID");
        TableColumn<Room, String> roomName = new TableColumn<>("Name");
        TableColumn<Room, Integer> rating = new TableColumn<>("Rating");
        TableColumn<Room, Room.priceRange> priceRange = new TableColumn<>("Price Range");
        TableColumn<Room, String> city = new TableColumn<>("City");
        TableColumn<Room, String> description = new TableColumn<>("Description");
        TableColumn<Room, Integer> beds = new TableColumn<>("Beds");
        TableColumn<Room, Boolean> pool = new TableColumn<>("Pool");
        TableColumn<Room, Boolean> restaurant = new TableColumn<>("Restaurant");
        TableColumn<Room, Boolean> childrensClub = new TableColumn<>("Children's Club");
        TableColumn<Room, Boolean> centralLocation = new TableColumn<>("Central Location");
        TableColumn<Room, Boolean> seaView = new TableColumn<>("Sea View");
        TableColumn<Room, Integer> distanceToBeach = new TableColumn<>("Distance to beach");
        TableColumn<Room, Integer> distanceToCenter = new TableColumn<>("Distance to center");

        roomTable.getColumns().addAll(
                roomId,
                roomName,
                rating,
                priceRange,
                city,
                description,
                beds,
                pool,
                restaurant,
                childrensClub,
                centralLocation,
                seaView,
                distanceToBeach,
                distanceToCenter
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

        AnchorPane.setTopAnchor(roomTable, 5.0);
        AnchorPane.setLeftAnchor(roomTable, 335.0);
        AnchorPane.setBottomAnchor(roomTable, 50.0);
        AnchorPane.setRightAnchor(roomTable, 5.0);

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
                roomTable,
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

        List<Room> rooms = rest.getRooms();
        List<Reservation> reservations = rest.getReservations();
        roomId.setCellValueFactory(
                new PropertyValueFactory<Room, Long>("roomId"));
        roomName.setCellValueFactory(
                new PropertyValueFactory<Room, String>("Name"));
        rating.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("Rating"));
        priceRange.setCellValueFactory(
                param -> {
                    Room r = param.getValue();
                    String s = Room.priceRange.valueOf(
                            r.getRange().toString())
                            .toString();
                    Room.priceRange pr = Room.priceRange.valueOf(s);
                    return new SimpleObjectProperty<>(pr);
                });
        city.setCellValueFactory(
                new PropertyValueFactory<Room, String>("City"));
        description.setCellValueFactory(
                new PropertyValueFactory<Room, String>("Description"));
        beds.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("Beds"));
        pool.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("Pool"));
        restaurant.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("Restaurant"));
        childrensClub.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("ChildClub"));
        centralLocation.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("CentralLocation"));
        seaView.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("SeaView"));
        distanceToBeach.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("DistanceToBeach"));
        distanceToBeach.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("DistanceToCenter")); //TODO Skriver inte ut
        Long r = 0L;
        Long c = 0L;
        for (int j = 0; j < reservations.size(); ++j) {
            r = reservations.get(j).getCustomerId();
            c = customer.getCustomerId();
            if (r.equals(c))
                roomTable.getItems().add(rooms.get(j));
        }

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
    }
}
