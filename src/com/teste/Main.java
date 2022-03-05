package com.teste;

import com.teste.actionModel.ActionA;
import com.teste.actionModel.ActionB;
import com.teste.actionModel.ActionCalculate;
import com.teste.actionModel.ActionDefault;
import com.teste.controller.ProcessThreads;
import com.teste.observableModels.MyObserverModel;
import com.teste.threadModels.MyThreadModel;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando o processamento!");
        List<ActionDefault> actions = Arrays.asList(
                new ActionA(),
                new ActionB(),
                new ActionCalculate(2.3, 14)
        );
        Observable myObservable = new MyObserverModel(false);
        ProcessThreads processThreads = new ProcessThreads(actions, myObservable);
        processThreads.start();
    }
}
