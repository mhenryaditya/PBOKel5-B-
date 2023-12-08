package com.raven.swing.table;

import com.raven.model.ModelBuyer;

public interface EventAction {

    public void delete(ModelBuyer buyer);

    public void update(ModelBuyer buyer);
}
