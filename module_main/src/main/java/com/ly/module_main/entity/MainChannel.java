package com.ly.module_main.entity;

/**
 * Description: <主频道类型><br>
 * Author:      alex<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public enum MainChannel {
    HOME(0,"HOME"), SQUARE(1,"SQUARE"),MESSAGE(2,"MESSAGE"),MINE(3,"MINE");
    public int id;
    public String name;
    MainChannel(int id, String name){
        this.id = id;
        this.name = name;
    }
}
