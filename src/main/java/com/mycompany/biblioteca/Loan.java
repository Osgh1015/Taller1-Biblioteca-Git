
package com.mycompany.biblioteca;

import java.time.LocalDate;
 

public class Loan {
    private String loanId;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status;
 
    public Loan(String loanId, Client client, Book book, LocalDate date) {
        this.loanId = loanId;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = "ACTIVE"; 
    }
 
    // ---- Getters and Setters ----
    public String getLoanId() {
        return loanId;
    }
 
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
 
    public Client getClient() {
        return client;
    }
 
    public void setClient(Client client) {
        this.client = client;
    }
 
    public Book getBook() {
        return book;
    }
 
    public void setBook(Book book) {
        this.book = book;
    }
 
    public LocalDate getDate() {
        return date;
    }
 
    public void setDate(LocalDate date) {
        this.date = date;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    @Override
    public String toString() {
        return "Loan [id=" + loanId
                + ", client=" + client.getName()
                + ", book=" + book.getTitle()
                + ", date=" + date
                + ", status=" + status + "]";
    }
}