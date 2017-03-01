package edu.eci.cosw.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 2091412 on 3/1/17.
 */
@Embeddable
public class PersonDetails {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int phoneNumber;

    protected PersonDetails(){}

    public PersonDetails(String firstName, String lastName, Date dateOfBirth, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    //Implementar tal vez foto de perfil bien chevere (sugoi desu ne!)

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "dateofbirth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "phonenumber")
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
