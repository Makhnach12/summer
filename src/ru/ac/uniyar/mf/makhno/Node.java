package ru.ac.uniyar.mf.makhno;

import java.util.ArrayList;
import java.util.UUID;

public class Node {
    private String id;
    private String name;
    private ArrayList<Node> children;

    public Node(){
        this.id = "";
        this.name = "/";
        this.children = new ArrayList<>();
    }

    public Node(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}