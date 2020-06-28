package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity{


    @Size(min=3, message = "Name must be at least 3 characters long")
    @NotBlank
    private String name;

//    private final List<Event> events = new ArrayList<>();

    public EventCategory( @Size(min=3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    public EventCategory(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
