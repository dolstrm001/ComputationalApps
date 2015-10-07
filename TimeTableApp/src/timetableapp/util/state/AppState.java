package timetableapp.util.state;

import controlP5.ControlP5;
import java.awt.Font;
import java.io.File;
import lombok.Getter;
import lombok.Setter;
import processing.core.PApplet;
import processing.core.PFont;
import timetableapp.gui.Dialog;
import timetableapp.util.Properties;
import timetableapp.util.observer.ObservableValue;

public class AppState {

    private static AppState instance = new AppState();

    @Getter
    @Setter
    private File selectedFile;

    @Getter
    private PApplet app;

    @Getter
    @Setter
    private ControlP5 cp5;

    @Getter
    private int displayPanelWidth;
    @Getter
    private int displayPanelHeight;

    @Getter
    private ObservableValue<Integer> newFileSelectedStateObserver = new ObservableValue(0);
    @Getter
    private ObservableValue<Integer> loadingFileStateObserver = new ObservableValue(0);
    @Getter
    private ObservableValue<Integer> fileLoadedStateObserver = new ObservableValue(0);
    @Getter
    private ObservableValue<Integer> selectedViewStateObserver = new ObservableValue(ViewStates.MainView);

    public void setApp(PApplet app) {
        this.app = app;
        displayPanelWidth = app.width - (Properties.displayPanelXOffset * 2);
        displayPanelHeight = app.height - (Properties.displayPanelYOffset * 2) - 80;
        displayPanelHeight = displayPanelHeight - (displayPanelHeight % 24);
    }

    public static AppState getInstance() {
        return instance;
    }

    private PFont txtfont, iconFont;

    private Font iFont;

    private AppState() {
        Font f;
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResource("ttf/OpenSans-Regular.ttf").openStream());
            txtfont = new PFont(f, true);
            f = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResource("ttf/fontawesome-webfont.ttf").openStream());
            f = f.deriveFont(Font.PLAIN, 16F);
            iconFont = new PFont(f, true);
        } catch (Exception e) {
            new Dialog().fatalErrorDialog("error occured app closes now");
        }
    }

    public PFont getIconFont() {
        return iconFont;
    }

    public void setFontSize() {
        AppState.this.setFontSize(14);
    }

    public void setFontSize(int size) {
        app.textFont(txtfont, size);
    }

    public void setNewFileSelectedState(int value) {
        newFileSelectedStateObserver.setValue(value);
    }

    public void setLoadingFileState(int value) {
        loadingFileStateObserver.setValue(value);
    }

    public void setFileLoadedState(int value) {
        fileLoadedStateObserver.setValue(value);
    }

    public void setSelectedViewState(int value) {
        selectedViewStateObserver.setValue(value);
    }

    public int getNewFileSelectedState() {
        return newFileSelectedStateObserver.getValue();
    }

    public int getLoadingFileState() {
        return loadingFileStateObserver.getValue();
    }

    public int getFileLoadedState() {
        return fileLoadedStateObserver.getValue();
    }

    public int getSelectedViewState() {
        return selectedViewStateObserver.getValue();
    }
}
