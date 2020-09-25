package com.domain.SpringBurne2.gui;

import com.domain.SpringBurne2.gui.utility.REST;
import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.models.Reservation;
import com.domain.SpringBurne2.models.Room;
import com.domain.SpringBurne2.repositories.ReservationRepositoryImpl;
import com.domain.SpringBurne2.gui.utility.Search;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchWindow
{
    public void searchWindow(Stage primaryStage, Customer customer)
    {
        REST rest = new REST();
        AccountWindow accountWindow = new AccountWindow();
        BookingWindow bookingWindow = new BookingWindow();

        primaryStage.setTitle("SpringBurne");
        AnchorPane searchWindow = new AnchorPane();
        Scene searchScene = new Scene(searchWindow, 1000, 450);
        searchWindow.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.centerOnScreen();

        TextField tfSearch = new TextField();
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
        Label labelLocation = new Label("Location: ");
        Hyperlink hlAccount = new Hyperlink("Account");
        Button btnContinue = new Button("Continue");
        DatePicker checkInDate = new DatePicker();
        DatePicker checkOutDate = new DatePicker();
        Label labelFilter = new Label("Optional search filters: ");
        Label labelBeach = new Label("Distance to beach:");
        Label labelCenter = new Label("Distance to center: ");
        TableView roomTable = new TableView();

        ObservableList<Integer> adults = FXCollections.observableArrayList( // TODO for loop för antal ? annars lägg till fler
                1,
                2,
                3,
                4
        );
        final ComboBox cboxAdults = new ComboBox(adults);

        ObservableList<Integer> children = FXCollections.observableArrayList( //TODO samma som den ovanför
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
        tfBeachDistance.setPromptText("Distance to beach (m)");
        tfCenterDistance.setPromptText("Distance to center (m)");
        checkInDate.setPromptText("Check-in Date");
        checkOutDate.setPromptText("Check-out date");
        tfSearch.setPrefWidth(322);
        checkInDate.setPrefWidth(155);
        checkOutDate.setPrefWidth(155);
        btnSearch.setPrefWidth(75.0);

        AnchorPane.setBottomAnchor(btnSearch, 50.0);
        AnchorPane.setLeftAnchor(btnSearch, 250.0);

        AnchorPane.setTopAnchor(tfSearch, 35.0);
        AnchorPane.setLeftAnchor(tfSearch, 5.0);

        AnchorPane.setTopAnchor(checkInDate, 65.0);
        AnchorPane.setLeftAnchor(checkInDate, 5.0);

        AnchorPane.setTopAnchor(checkOutDate, 65.0);
        AnchorPane.setLeftAnchor(checkOutDate, 170.0);

        AnchorPane.setTopAnchor(labelFilter, 180.0);
        AnchorPane.setLeftAnchor(labelFilter, 5.0);

        AnchorPane.setTopAnchor(cbPool, 200.0);
        AnchorPane.setLeftAnchor(cbPool, 5.0);
        AnchorPane.setTopAnchor(cbRestaurant, 220.0);
        AnchorPane.setLeftAnchor(cbRestaurant, 80.0);
        AnchorPane.setTopAnchor(cbChildrensClub, 200.0);
        AnchorPane.setLeftAnchor(cbChildrensClub, 55.0);
        AnchorPane.setTopAnchor(cbSeaView, 220.0);
        AnchorPane.setLeftAnchor(cbSeaView, 5.0);
        AnchorPane.setTopAnchor(cbNightLife, 240.0);
        AnchorPane.setLeftAnchor(cbNightLife, 5.0);

        AnchorPane.setTopAnchor(labelBeach,200.0);
        AnchorPane.setLeftAnchor(labelBeach, 170.0);
        AnchorPane.setTopAnchor(tfBeachDistance, 220.0);
        AnchorPane.setLeftAnchor(tfBeachDistance, 170.0);

        AnchorPane.setTopAnchor(labelCenter, 250.0);
        AnchorPane.setLeftAnchor(labelCenter,170.0);
        AnchorPane.setTopAnchor(tfCenterDistance, 270.0);
        AnchorPane.setLeftAnchor(tfCenterDistance, 170.0);

        AnchorPane.setTopAnchor(labelAdult, 95.0);
        AnchorPane.setLeftAnchor(labelAdult, 5.0);
        AnchorPane.setTopAnchor(cboxAdults, 115.0);
        AnchorPane.setLeftAnchor(cboxAdults, 5.0);

        AnchorPane.setTopAnchor(labelKids, 95.0);
        AnchorPane.setLeftAnchor(labelKids, 75.0);
        AnchorPane.setTopAnchor(cboxChildren, 115.0);
        AnchorPane.setLeftAnchor(cboxChildren, 75.0);

        AnchorPane.setTopAnchor(roomTable, 5.0);
        AnchorPane.setLeftAnchor(roomTable, 335.0);
        AnchorPane.setBottomAnchor(roomTable, 50.0);
        AnchorPane.setRightAnchor(roomTable, 5.0);

        AnchorPane.setTopAnchor(labelName, 5.0);
        //AnchorPane.setLeftAnchor(labelName, 230.0);
        AnchorPane.setRightAnchor(labelName, 652.0); //TODO testa med ett långt namn

        AnchorPane.setTopAnchor(hlAccount, 12.0);
        AnchorPane.setLeftAnchor(hlAccount, 280.0);

        AnchorPane.setBottomAnchor(btnContinue, 5.0);
        AnchorPane.setRightAnchor(btnContinue, 5.0);

        AnchorPane.setTopAnchor(labelLocation, 15.0);
        AnchorPane.setLeftAnchor(labelLocation, 5.0);

        searchWindow.getChildren().addAll(
                btnSearch,
                tfSearch,
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
                roomTable,
                labelLocation,
                checkInDate,
                checkOutDate,
                labelFilter,
                labelBeach,
                labelCenter);
        primaryStage.setScene(searchScene);
        primaryStage.show();

        hlAccount.setOnAction(e -> accountWindow.accountWindow(primaryStage, customer));
        btnContinue.setOnAction(event -> bookingWindow.bookingWindow(primaryStage, customer));
        btnSearch.setOnAction((e -> {
            roomTable.getItems().clear();
            List<Room> rooms = rest.getRooms();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String checkInStr = dateTimeFormatter.format(checkInDate.getValue());
            String checkOutStr = dateTimeFormatter.format(checkOutDate.getValue());
            try {
                Search search = new Search(
                        checkInStr,
                        checkOutStr,
                        Integer.parseInt(tfBeachDistance.getText()),
                        Integer.parseInt(tfCenterDistance.getText()),
                        cbPool.isSelected(),
                        cbRestaurant.isSelected(),
                        cbChildrensClub.isSelected(),
                        cbNightLife.isSelected(),
                        cbSeaView.isSelected());
                rooms = filterSearch(rooms, search);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (NumberFormatException numberFormatException) {
                try {
                    Search search = new Search(
                            checkInStr,
                            checkOutStr,
                            0,
                            0,
                            cbPool.isSelected(),
                            cbRestaurant.isSelected(),
                            cbChildrensClub.isSelected(),
                            cbNightLife.isSelected(),
                            cbSeaView.isSelected());
                    rooms = filterSearch(rooms, search);
                } catch (ParseException pEx) {
                    pEx.printStackTrace();
                }
            }
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
                distanceToCenter.setCellValueFactory(
                        new PropertyValueFactory<Room, Integer>("distanceToCenter"));
                roomTable.getItems().add(room);
            }
        }));
    }
    
    public List<Room> filterSearch(
            List<Room> rooms, Search s) throws ParseException
    {
        REST rest = new REST();
        return availableBetween(
                rest.getReservations(),
                rooms,
                s.getStartDate(),
                s.getEndDate())
                .stream()
                .filter(r -> r.getDistanceToBeach() < s.getDistanceToBeach())
                .filter(r -> r.getDistanceToCenter() < s.getDistanceToCenter())
                .filter(r -> r.isPool() || !s.isPool())
                .filter(r -> r.isRestaurant() || !s.isRestaurant())
                .filter(r -> r.isChildClub() || !s.isChildClub())
                .filter(r -> r.isCentralLocation() || !s.isCentralLocation())
                .filter(r -> r.isSeaView() || !s.isSeaView())
                .collect(Collectors.toList());
    }
    
    private static boolean overlap(
            Date start1, Date end1, Date start2, Date end2)
    {
        return
                start1.getTime() <= end2.getTime() &&
                        start2.getTime() <= end1.getTime();
    }
    
    public List<Room> availableBetween(
            List<Reservation> reservations,
            List<Room> rooms,
            String start,
            String end) throws ParseException
    {
        for (Reservation reservation : reservations)
        {
            for (Iterator<Room> it = rooms.listIterator(); it.hasNext();)
            {
                Room room = it.next();
                if (
                        reservation.getRoomId().equals(room.getRoomId())
                                && overlap(
                                new SimpleDateFormat("yyyy-MM-dd").parse(start),
                                new SimpleDateFormat("yyyy-MM-dd").parse(end),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(reservation.getStartDate()),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(reservation.getEndDate())))
                    it.remove();
            }
        }
        return rooms;
    }
}
