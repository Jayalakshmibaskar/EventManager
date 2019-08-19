package com.example.revathy.events;

public class EventModel {
    String name;
    String desc;
    String id;



    public EventModel(String name, String desc,String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }






}
