package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.models.Room;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class SearchWindow
{
    public void searchWindow(Stage primaryStage, Customer customer)
    {
        REST rest = new REST();
        AccountWindow accountWindow = new AccountWindow();
        BookingWindow bookingWindow = new BookingWindow();

        primaryStage.setTitle("SpringBurne");
        AnchorPane searchWindow = new AnchorPane();
        Scene searchScene = new Scene(searchWindow, 650, 450);
        searchWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        TextField tfSearch = new TextField();
        TextField tfStartDate = new TextField();
        TextField tfEndDate = new TextField();
        TextField tfBeachDistance = new TextField();
        TextField tfCenterDistance = new TextField();
        Button btnSearch = new Button("Search");
        CheckBox cbPool = new CheckBox("Pool");
        CheckBox cbRestaurant = new CheckBox("Restaurant");
        CheckBox cbChildrensClub = new CheckBox("Children's club");
        CheckBox cbSeaView = new CheckBox("Sea View");
        CheckBox cbNightLife = new CheckBox("Night Life");
        Label labelAdult = new Label("Adults: ");
        Label labelKids = new Label("Kids: ");
        Label labelName = new Label(customer.getFirstName() + " " + customer.getLastName());
        Hyperlink hlAccount = new Hyperlink("Account");
        Button btnContinue = new Button("Continue");
        TableView roomTable = new TableView();

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

        TableColumn<Room, Long> roomId = new TableColumn<>("Room ID");
        TableColumn<Room, String> roomName = new TableColumn<>("Name");
        TableColumn<Room, Integer> rating = new TableColumn<>("Rating");
        TableColumn<Room, Room.priceRange> priceRange = new TableColumn<>("Price Range");
        TableColumn<Room, String> city = new TableColumn<>("City");
        TableColumn<Room, String> description = new TableColumn<>("Description");
        TableColumn<Room, Integer> beds = new TableColumn<>("beds");
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

        tfSearch.setPromptText("Location");
        tfStartDate.setPromptText("YYYY-MM-DD START");
        tfEndDate.setPromptText("YYYY-MM-DD END");
        tfBeachDistance.setPromptText("Distance to beach (m)");
        tfCenterDistance.setPromptText("Distance to center (m)");
        tfSearch.setPrefWidth(230);
        btnSearch.setPrefWidth(75.0);




        AnchorPane.setBottomAnchor(btnSearch, 35.0);
        AnchorPane.setLeftAnchor(btnSearch, 10.0);

        AnchorPane.setTopAnchor(tfSearch, 35.0);
        AnchorPane.setLeftAnchor(tfSearch, 5.0);

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

        AnchorPane.setTopAnchor(roomTable, 5.0);
        AnchorPane.setLeftAnchor(roomTable, 250.0);
        AnchorPane.setBottomAnchor(roomTable, 50.0);
        AnchorPane.setRightAnchor(roomTable, 5.0);

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
                labelAdult,
                cboxChildren,
                labelKids,
                labelName,
                hlAccount,
                btnContinue,
                tfBeachDistance,
                tfCenterDistance,
                roomTable);
        primaryStage.setScene(searchScene);
        primaryStage.show();

        hlAccount.setOnAction(e -> accountWindow.accountWindow(primaryStage, customer));
        btnContinue.setOnAction(event -> bookingWindow.bookingWindow(primaryStage, customer));
        btnSearch.setOnAction((e -> {
            List<Room> rooms = rest.getRooms();
            for (Room room : rooms) {
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
                        new PropertyValueFactory<Room, Integer>("DistanceToCenter"));
                roomTable.getItems().add(room);
            }
        }));
    }
}
