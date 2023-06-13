package model;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String contactPphone;
    private String dateOdDelivery;
    private String rentalTime;
    private String[] color;
    private String comment;

    public Order(String firstName, String lastName, String address, String metroStation, String contactPphone, String dateOdDelivery, String rentalTime, String[] color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.contactPphone = contactPphone;
        this.dateOdDelivery = dateOdDelivery;
        this.rentalTime = rentalTime;
        this.color = color;
        this.comment = comment;
    }

    public Order() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getContactPphone() {
        return contactPphone;
    }

    public void setContactPphone(String contactPphone) {
        this.contactPphone = contactPphone;
    }

    public String getDateOdDelivery() {
        return dateOdDelivery;
    }

    public void setDateOdDelivery(String dateOdDelivery) {
        this.dateOdDelivery = dateOdDelivery;
    }

    public String getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(String rentalTime) {
        this.rentalTime = rentalTime;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
