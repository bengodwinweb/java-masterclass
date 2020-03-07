package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"
                };

                ObservableList<String> employees = FXCollections.observableArrayList();

                int progress = 0;
                int maxProgress = names.length;
                for (String name : names) {
                    employees.add(name);
                    updateProgress(++progress, maxProgress);
                    updateMessage(String.format("Added %s to the list", name));
                    Thread.sleep(200);
                }

                return employees;
            }
        };
    }
}
