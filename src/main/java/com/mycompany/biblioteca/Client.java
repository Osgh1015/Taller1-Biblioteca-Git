
package com.mycompany.biblioteca;

public class Client extends  {
    private String email;
 
    public Client(String id, String name, String phone, String email) {
        super(id, name, phone); // reuses the parent's constructor
        this.email = email;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public String toString() {
        return "Client [" + super.toString() + ", email=" + email + "]";
    }
}