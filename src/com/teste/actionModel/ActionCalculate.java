package com.teste.actionModel;

public class ActionCalculate implements ActionDefault{
    private double number1;
    private double number2;

    public ActionCalculate(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void doAction() {
        double result = Math.pow(number1, number2) * Math.random();
        System.out.println("Action Calculated return: " + result);
    }
}
