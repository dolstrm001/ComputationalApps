package timetableapp;

import timetableapp.Gui.GuiHelper;
import controlP5.ControlEvent;
import processing.core.PApplet;
import timetableapp.util.AppState;

public class BaseApplication extends PApplet {

    GuiHelper guiHelper;

    @Override
    public void settings() {
        height = displayHeight - 200;
        width = displayWidth - 500;
        size(width, height);
    }

    @Override
    public void setup() {
        AppState.getInstance().setApp(this);
        frameRate(60);
        guiHelper = new GuiHelper();
        guiHelper.setup();
    }

    @Override
    public void draw() {

    }

    public void controlEvent(ControlEvent evt) {
        guiHelper.controlEvent(evt);
    }
}
