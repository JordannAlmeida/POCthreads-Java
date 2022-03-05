package com.teste.controller;
import com.teste.actionModel.ActionDefault;
import com.teste.observableModels.MyObserverModel;
import com.teste.threadModels.MyThreadModel;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class ProcessThreads implements Observer {
    private final List<Runnable> threads;

    public ProcessThreads(List<ActionDefault> actions, Observable myObserverModel) {
        this.threads = actions.stream().map(a -> new MyThreadModel(a, 10, (MyObserverModel) myObserverModel))
                .collect(Collectors.toList());
        myObserverModel.addObserver(this);
    }

    private boolean allCompleted() {
        return threads.stream().allMatch((Runnable t) -> {
            if(t instanceof MyThreadModel) {
                return ((MyThreadModel) t).isCompleteAction();
            }
            return false;
        });
    }
    
    public void start() {
        for (Runnable r : threads) {
            Thread t = new Thread(r);
            t.start();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MyObserverModel) {
            System.out.println("Action encerrada: " + ((MyObserverModel) o).getNameActionFinish());
            if (allCompleted()) {
                System.out.println("Finalizado todos os processamentos!");
            }
        }
    }
}
