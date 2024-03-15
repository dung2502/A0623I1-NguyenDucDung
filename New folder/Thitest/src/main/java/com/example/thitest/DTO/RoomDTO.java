package com.example.thitest.DTO;

import java.sql.Date;

public class RoomDTO {
    private int id;
    private String room_id;
    private String person_name;
    private String phone_number;
    private Date rental_start_date;
    private String payments;
    private String note;

    public RoomDTO() {
    }

    public RoomDTO(int id, String room_id, String person_name, String phone_number, Date rental_start_date, String payments, String note) {
        this.id = id;
        this.room_id = room_id;
        this.person_name = person_name;
        this.phone_number = phone_number;
        this.rental_start_date = rental_start_date;
        this.payments = payments;
        this.note = note;
    }

    public RoomDTO(String room_id, String person_name, String phone_number, Date rental_start_date, String payments, String note) {
        this.room_id = room_id;
        this.person_name = person_name;
        this.phone_number = phone_number;
        this.rental_start_date = rental_start_date;
        this.payments = payments;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getRental_start_date() {
        return rental_start_date;
    }

    public void setRental_start_date(Date rental_start_date) {
        this.rental_start_date = rental_start_date;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
