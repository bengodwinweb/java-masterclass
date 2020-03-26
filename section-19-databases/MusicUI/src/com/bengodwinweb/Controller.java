package com.bengodwinweb;

import com.bengodwinweb.model.Album;
import com.bengodwinweb.model.Artist;
import com.bengodwinweb.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView artistTable;
    @FXML
    private ProgressBar progressBar;


    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }

    public void listAlbumsForArtist() {
        Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null) {
            System.out.println("No artist selected");
            return;
        }

        Task<ObservableList<Album>> task = new GetAlbumsByArtistTask(artist.getId());
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    public void updateArtist() {
//        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        final Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return Datasource.getInstance().updateArtistName(artist.getId(), "AC/DC");
            }
        };

        task.setOnSucceeded(e -> {
            if(task.valueProperty().get()) {
                artist.setName("AC/DC");
                artistTable.refresh();
            }
        });

        new Thread(task).start();
    }

}

class GetAllArtistsTask extends Task<ObservableList<Artist>> {

    @Override
    public ObservableList<Artist> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().queryArtists());
    }
}

class GetAlbumsByArtistTask extends Task<ObservableList<Album>> {
    int artistId;

    public GetAlbumsByArtistTask(int artistId) {
        this.artistId = artistId;
    }

    @Override
    protected ObservableList<Album> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().queryAlbumsForArtist(artistId));
    }
}
