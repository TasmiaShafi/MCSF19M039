package com.example.recyclerviewapp;

public class ModelClass {
    private int imageview;
    private String name,date,msg,separator;
    ModelClass(int imageview,String name,String date, String msg,String separator){
        this.imageview=imageview;
        this.name=name;
        this.date=date;
        this.msg=msg;
        this.separator=separator;
    }
    public int getImageview() {
        return imageview;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }
    public String getSeparator() {
        return separator;
    }
}
