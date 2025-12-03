package com.Test;

public class Test06 {
    public static void main(String[] args) {
        Color.RED.show();

        Color c = Color.BLUE;
        switch (c){
            case RED:
                System.out.println("wqeq");
                break;
            case BLACK:
                System.out.println("Wqeq");
                break;
            case BLUE:
                System.out.println("Wqeq");
                break;
            default:
                System.out.println("Weqeqewq");
        }
    }
}

interface AA {
    void show();
}

enum Color implements AA {

    RED("1","2","3"),
    BLACK("1","2","3"),
    BLUE("1","2","3");

    private String redValue;
    private String greenValue;
    private String blueValue;

    Color(String redValue, String greenValue, String blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(this.redValue + this.blueValue + this.greenValue);
    }
}
