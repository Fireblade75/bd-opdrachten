package com.example.office.actions.di;

import com.example.office.actions.core.ExitAction;
import com.example.office.actions.employee.AddEmployeeAction;
import com.example.office.actions.core.MenuAction;
import com.example.office.actions.employee.ShowEmployeesAction;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ActionModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<MenuAction> actionBinder = Multibinder.newSetBinder(binder(), MenuAction.class);
        actionBinder.addBinding().to(ExitAction.class);
        actionBinder.addBinding().to(AddEmployeeAction.class);
        actionBinder.addBinding().to(ShowEmployeesAction.class);
    }
}
