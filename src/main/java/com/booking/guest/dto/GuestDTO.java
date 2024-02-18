package com.booking.guest.dto;
public class GuestDTO {
    private String name;
    private String Surname;
    private String emailAddress;
    private String country;
    private boolean booked;

    public GuestDTO() {
    }

    public GuestDTO(String name, String surname, String emailAddress, String country, boolean booked) {
        this.name = name;
        Surname = surname;
        this.emailAddress = emailAddress;
        this.country = country;
        this.booked = booked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "GuestDTO{" +
                "name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", country='" + country + '\'' +
                ", booked=" + booked +
                '}';
    }
}
