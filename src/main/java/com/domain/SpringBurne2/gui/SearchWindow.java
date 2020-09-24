package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.models.Room;
import javafx.application.Application;
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
        Label labelName = new Label(customer.getFirstName() + " " + customer.getLastName()); //TODO: kod för namn behvövs
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

        //ObservableList<String> listLocations =
        //        FXCollections.observableArrayList();
        //ListView<String> lvListLocations = new ListView<String>(listLocations);
        //SelectionModel<String> lvSelModel =
        //        lvListLocations.getSelectionModel();

        TableView roomTable = new TableView();

        TableColumn<Room, Long> roomId = new TableColumn<>("Room ID");
        TableColumn<Room, String> roomName = new TableColumn<>("Name");
        TableColumn<Room, Integer> rating = new TableColumn<>("Rating");
        TableColumn<Room, Room.priceRange> priceRange = new TableColumn<>("Price Range");
        TableColumn<Room, String> city = new TableColumn<>("City");
        TableColumn<Room, String> description = new TableColumn<>("Description");
        TableColumn<Room, Integer> beds = new TableColumn<>("beds");
        //TableColumn<Boolean, Room> bool1 = new TableColumn<>("bool1");
        //TableColumn<Boolean, Room> bool2 = new TableColumn<>("bool1");
        //TableColumn<Boolean, Room> bool3 = new TableColumn<>("bool1");
        //TableColumn<Boolean, Room> bool4 = new TableColumn<>("bool1");
        //TableColumn<Boolean, Room> bool5 = new TableColumn<>("bool1");


        roomTable.getColumns().addAll(
                roomId,
                roomName,
                rating,
                priceRange,
                city,
                description,
                beds
                // bool1,
                // bool2,
                // bool3,
                // bool4,
                // bool5
        );
        roomId.setCellValueFactory(new PropertyValueFactory<Room, Long>("roomId"));
        roomName.setCellValueFactory(new PropertyValueFactory<Room, String>("Name"));
        rating.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Rating"));
        priceRange.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room, Room.priceRange>, ObservableValue<Room.priceRange>>()
                                       {
                                           @Override
                                           public ObservableValue<Room.priceRange> call(TableColumn.CellDataFeatures<Room, Room.priceRange> param)
                                           {
                                               return null;
                                           }
                                       });
                city.setCellValueFactory(new PropertyValueFactory<Room, String>("City"));
        description.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
        beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Beds"));
        //List<Room> rooms = rest.getRooms();
        roomTable.getItems().add(new Room(1L, "test", 5, Room.priceRange.HIGH, "Stad", "tlkadklaslk", 2, true, false, true, false, true, 99, 1));
        roomTable.getItems().add(new Room(2L, "En liten båt", 1, Room.priceRange.HIGH, "Öresund", "vi vet alla vad som pågår här", 1, true, false, true, false, true, 99, 1));

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
                //lvListLocations,
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
        //    btnSearch.setOnAction((e -> {
        //        List<Room> rooms = rest.getRooms();
        //        for (Room r : rooms)
        //            listLocations.add(r.toString());
        //    }));
    }
}
