package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @NotBlank(message = "You must enter a description")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "must enter an email")
    @Email(message = "Invalid Email. Try Again.")
    private String contactEmail;

    @NotBlank(message = "you must enter a date")
    private String date;

    @NotBlank(message = "you must enter a location")
    private String location;

    @NotBlank(message = "you must enter a price")
    private String price;


    public EventDetails(@NotBlank(message = "You must enter a description") @Size(max = 500, message = "Description too long!") String description, @NotBlank(message = "must enter an email") @Email(message = "Invalid Email. Try Again.") String contactEmail, @NotBlank(message = "you must enter a date") String date, @NotBlank(message = "you must enter a location") String location, @NotBlank(message = "you must enter a price") String price) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.date = date;
        this.location = location;
        this.price = price;
    }

    public EventDetails(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
