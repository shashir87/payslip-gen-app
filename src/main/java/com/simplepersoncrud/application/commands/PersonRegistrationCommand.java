package com.simplepersoncrud.application.commands;

import com.google.common.base.Preconditions;
import org.nthdimenzion.cqrs.command.ICommand;
import org.nthdimenzion.cqrs.command.annotations.Command;

@Command
public class PersonRegistrationCommand implements ICommand{
    private String name;

    public PersonRegistrationCommand(){}

    public PersonRegistrationCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void validate() {
        Preconditions.checkNotNull(name);
    }
}
