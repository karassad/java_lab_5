package interfaces;

import model.Organization;

import java.util.LinkedHashSet;

public interface Command {
    void execute(LinkedHashSet<Organization> organizations, String[] args);
}
