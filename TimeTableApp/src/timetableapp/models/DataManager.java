package timetableapp.models;

import lombok.Getter;
import lombok.Setter;

public class DataManager {

    private static DataManager instance = new DataManager();

    public static DataManager getInstance() {
        return instance;
    }

    private DataManager() {
    }

    @Getter
    @Setter
    private TableModel tm;

}