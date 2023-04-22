package com.guy.common;

public class DataTable {

    private int id;
    private String expenseName;
    private String amount;
    private String date;
    private String description;

    public DataTable() {
    }

    public DataTable(String expenseName, String amount, String date, String description, int id) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}