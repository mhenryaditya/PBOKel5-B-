package com.raven.model2;

import javax.swing.Icon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model_Card(Icon icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public Model_Card() {
    }

    private Icon icon;
    private String title;
    private String description;

    public void addActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
