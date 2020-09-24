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
        Scene accountScene = new Scene(accountWindow, 550, 350);
        accountWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        TextField tfFName = new TextField();
        Label labelFName = new Label(customer.getFirstName()); // kod för namn
        tfFName.setDisable(true);
        tfFName.setVisible(false);
        labelFName.setVisible(true);

        TextField tfLName = new TextField();
        Label labelLName = new Label(customer.getLastName()); // kod för efternamn
        tfLName.setDisable(true);
        tfLName.setVisible(false);
        labelLName.setVisible(true);

        TextField tfEmail = new TextField();
        Label labelEmail = new Label(customer.getEmail()); // kod för email
        tfEmail.setDisable(true);
        tfEmail.setVisible(false);
        labelEmail.setVisible(true);

        TextField tfPassword = new TextField();
        Label labelPassword = new Label(customer.getPassword()); // kod för lösenord
        tfPassword.setDisable(true);
        tfPassword.setVisible(false);
        labelPassword.setVisible(true);

        Hyperlink hlChangeFName = new Hyperlink("change");
        Hyperlink hlChangeLName = new Hyperlink("change");
        Hyperlink hlChangeEmail = new Hyperlink("change");
        Hyperlink hlChangePassword = new Hyperlink("change");

        Button btnSave = new Button("Save");

//        ObservableList<String> listLocations
//                = FXCollections.observableArrayList();
//        ListView<String> lvListLocations = new ListView<String>(listLocations);
//        SelectionModel<String> lvSelModel
//                = lvListLocations.getSelectionModel();

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
        TableColumn<Room, Integer> beds = new TableColumn<>("beds");
    
        roomTable.getColumns().addAll(
                roomId,
                roomName,
                rating,
                priceRange,
                city,
                description,
                beds
        );

        AnchorPane.setTopAnchor(labelFName, 5.0);
        AnchorPane.setLeftAnchor(labelFName, 5.0);
        AnchorPane.setTopAnchor(tfFName, 5.0);
        AnchorPane.setLeftAnchor(tfFName, 5.0);
        AnchorPane.setTopAnchor(hlChangeFName, 5.0);
        AnchorPane.setLeftAnchor(hlChangeFName, 70.0);

        AnchorPane.setTopAnchor(labelLName, 40.0);
        AnchorPane.setLeftAnchor(labelLName, 5.0);
        AnchorPane.setTopAnchor(tfLName, 40.0);
        AnchorPane.setLeftAnchor(tfLName, 5.0);
        AnchorPane.setTopAnchor(hlChangeLName, 40.0);
        AnchorPane.setLeftAnchor(hlChangeLName, 70.0);

        AnchorPane.setTopAnchor(labelEmail, 75.0);
        AnchorPane.setLeftAnchor(labelEmail, 5.0);
        AnchorPane.setTopAnchor(tfEmail, 75.0);
        AnchorPane.setLeftAnchor(tfEmail, 5.0);
        AnchorPane.setTopAnchor(hlChangeEmail, 75.0);
        AnchorPane.setLeftAnchor(hlChangeEmail, 105.0);

        AnchorPane.setTopAnchor(labelPassword, 110.0);
        AnchorPane.setLeftAnchor(labelPassword, 5.0);
        AnchorPane.setTopAnchor(tfPassword, 110.0);
        AnchorPane.setLeftAnchor(tfPassword, 5.0);
        AnchorPane.setTopAnchor(hlChangePassword, 110.0);
        AnchorPane.setLeftAnchor(hlChangePassword, 70.0);

        AnchorPane.setTopAnchor(btnSave, 140.0);
        AnchorPane.setLeftAnchor(btnSave, 5.0);

        AnchorPane.setTopAnchor(roomTable, 5.0);
        AnchorPane.setLeftAnchor(roomTable, 250.0);
        AnchorPane.setBottomAnchor(roomTable, 50.0);
        AnchorPane.setRightAnchor(roomTable, 5.0);

        AnchorPane.setBottomAnchor(btnChangeReservation, 5.0);
        AnchorPane.setRightAnchor(btnChangeReservation,5.0);

        AnchorPane.setBottomAnchor(btnCancelReservation, 5.0);
        AnchorPane.setRightAnchor(btnCancelReservation, 165.0);

        AnchorPane.setBottomAnchor(btnBack,5.0);
        AnchorPane.setLeftAnchor(btnBack,5.0);
        
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
        Long r = 0L;
        Long c = 0L;
        for (int j = 0; j < reservations.size(); ++j)
        {
            r = reservations.get(j).getCustomerId();
            c = customer.getCustomerId();
            if (r.equals(c))
                roomTable.getItems().add(rooms.get(j));
        }
        accountWindow.getChildren().addAll(
                tfFName,
                labelFName,
                hlChangeFName,
                tfLName,
                labelLName,
                hlChangeLName,
                tfEmail,
                labelEmail,
                hlChangeEmail,
                tfPassword,
                labelPassword,
                hlChangePassword,
                btnSave,
                roomTable,
                btnChangeReservation,
                btnCancelReservation,
                btnBack);
        primaryStage.setScene(accountScene);
        primaryStage.show();


        hlChangeFName.setOnAction(e ->
        {
            tfFName.setDisable(false);
            tfFName.setVisible(true);
            labelFName.setVisible(false);
        });

        hlChangeLName.setOnAction(e ->
        {
            tfLName.setDisable(false);
            tfLName.setVisible(true);
            labelLName.setVisible(false);
        });

        hlChangeEmail.setOnAction(e ->
        {
            tfEmail.setDisable(false);
            tfEmail.setVisible(true);
            labelEmail.setVisible(false);
        });

        hlChangePassword.setOnAction(e ->
        {
            tfPassword.setDisable(false);
            tfPassword.setVisible(true);
            labelPassword.setVisible(false);
        });

        btnSave.setOnAction(event -> {
            if (!tfFName.getText().trim().isEmpty())
            {
                customer.setFirstName(tfFName.getText());
                labelFName.setText(customer.getFirstName());
            }
            if (!tfLName.getText().trim().isEmpty())
            {
                customer.setLastName(tfLName.getText());
                labelLName.setText(customer.getLastName());
            }
            if (!tfEmail.getText().trim().isEmpty())
            {
                customer.setEmail(tfEmail.getText());
                labelEmail.setText(customer.getEmail());
            }
            if (!tfPassword.getText().trim().isEmpty())
            {
                customer.setPassword(tfPassword.getText());
                labelPassword.setText(customer.getPassword());
            }
            rest.updateUser(customer);
            tfFName.setDisable(true);
            tfFName.setVisible(false);
            labelFName.setVisible(true);
            tfLName.setDisable(true);
            tfLName.setVisible(false);
            labelLName.setVisible(true);
            tfEmail.setDisable(true);
            tfEmail.setVisible(false);
            labelEmail.setVisible(true);
            tfPassword.setDisable(true);
            tfPassword.setVisible(false);
            labelPassword.setVisible(true);
        });

        btnBack.setOnAction(event -> searchWindow.searchWindow(primaryStage, customer));
    }
}
