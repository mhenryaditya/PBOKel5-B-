package com.raven.swing.table;

import model.ModelBuyer;

public interface EventAction {

    public void delete(ModelBuyer buyer);

    public void update(ModelBuyer buyer);
}
