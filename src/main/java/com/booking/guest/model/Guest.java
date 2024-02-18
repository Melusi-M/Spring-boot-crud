package com.booking.guest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "Surname")
    private String Surname;
    @Column(name = "emailAddress")
    private String emailAddress;
    @Column(name = "country")
    private String country;
    @Column(name = "booked")
    private boolean booked;

    public Guest() {
    }

    public Guest(String name, String surname, String emailAddress, String country, boolean booked) {
        this.name = name;
        Surname = surname;
        this.emailAddress = emailAddress;
        this.country = country;
        this.booked = booked;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
       this.id = Id;
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
        country = country;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", country='" + country + '\'' +
                ", booked=" + booked +
                '}';
    }
}
