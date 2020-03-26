package com.bengodwinweb;

import com.bengodwinweb.model.Artist;
import com.bengodwinweb.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView<Artist> artistTable;

    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
    }
}

class GetAllArtistsTask extends Task {

    @Override
    public ObservableList<Artist> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().queryArtists());
    }


}
