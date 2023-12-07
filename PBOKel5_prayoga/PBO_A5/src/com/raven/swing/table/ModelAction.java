package com.raven.swing.table;

import com.raven.model.ModelBuyer;

public class ModelAction {

    public ModelBuyer getBuyer() {
        return buyer;
    }

    public void setBuyer(ModelBuyer buyer) {
        this.buyer = buyer;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelBuyer buyer, EventAction event) {
        this.buyer = buyer;
        this.event = event;
    }

    private ModelBuyer buyer;
    private EventAction event;
}
