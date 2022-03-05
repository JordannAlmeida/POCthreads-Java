package com.teste.observableModels;

import java.util.Observable;

public class MyObserverModel extends Observable {
    public boolean finish;
    public String nameActionFinish;

    public MyObserverModel(boolean finish) {
        this.finish = finish;
    }

    public String getNameActionFinish() {
        return nameActionFinish;
    }

    public void setFinishAction(boolean finish, String nameActionFinish) {
        this.finish = finish;
        this.nameActionFinish = nameActionFinish;
        setChanged();
        notifyObservers();
    }
}
