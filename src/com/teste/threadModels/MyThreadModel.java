package com.teste.threadModels;

import com.teste.actionModel.ActionDefault;
import com.teste.observableModels.MyObserverModel;

public class MyThreadModel implements Runnable{
    private final ActionDefault action;
    private boolean completeAction;
    private final int numberInteractions;
    private final MyObserverModel myObserverModel;

    public MyThreadModel(ActionDefault action, int numberInteractions, MyObserverModel myObserverModel) {
        this.action = action;
        completeAction = false;
        this.numberInteractions = numberInteractions;
        this.myObserverModel = myObserverModel;
    }

    @Override
    public void run() {
        System.out.println("Chamando metodo run para executar a ação: " + action.getClass().getCanonicalName() +
                " com numero de interações igual a : " + numberInteractions);
        for (int i = 0; i<numberInteractions; i++) {
            try {
                action.doAction();
                long timeSleep = Math.round(Math.random()*3000);
                Thread.sleep(timeSleep);
            } catch (Exception e) {
                System.out.println("Erro ao processar action " + action.getClass().getCanonicalName());
            }
        }
        completeAction = true;
        myObserverModel.setFinishAction(true, action.getClass().getCanonicalName());
    }

    public boolean isCompleteAction() {
        return completeAction;
    }
}
