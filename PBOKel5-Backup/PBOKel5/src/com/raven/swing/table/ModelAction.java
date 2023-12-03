package com.raven.swing.table;

import com.raven.model.ModelBuyer;

public class ModelAction {

    public ModelBuyer getStudent() {
        return student;
    }

    public void setStudent(ModelBuyer student) {
        this.student = student;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelBuyer student, EventAction event) {
        this.student = student;
        this.event = event;
    }

    private ModelBuyer student;
    private EventAction event;
}
