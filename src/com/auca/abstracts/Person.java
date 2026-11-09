package com.auca.abstracts;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;

import java.time.LocalDate;

public abstract class Person implements Identifiable, Registrable {

    // Six attributes required by the assignment
    private String personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    // Constructor
    public Person(String personId, String firstName, String lastName,
                  String email, String phoneNumber, LocalDate dateOfBirth) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Implementing Identifiable methods

    @Override
    public String getId() {
        return personId;
    }

    @Override
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    // Common validation for all people

    @Override
    public void validate() throws ValidationException {

        if (personId == null ||
                personId.trim().length() < 4 ||
                personId.trim().length() > 30) {

            throw new ValidationException(
                    "Person ID must contain 4 to 30 characters."
            );
        }

        if (firstName == null ||
                firstName.trim().length() < 2 ||
                firstName.trim().length() > 60) {

            throw new ValidationException(
                    "First name must contain 2 to 60 characters."
            );
        }

        if (lastName == null ||
                lastName.trim().length() < 2 ||
                lastName.trim().length() > 60) {

            throw new ValidationException(
                    "Last name must contain 2 to 60 characters."
            );
        }

        if (email == null ||
                email.length() > 120 ||
                !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            throw new ValidationException("Invalid email address.");
        }

        if (phoneNumber == null ||
                !phoneNumber.matches("\\+?[0-9]{10,15}")) {

            throw new ValidationException(
                    "Phone number must contain 10 to 15 digits."
            );
        }

        if (dateOfBirth == null ||
                !dateOfBirth.isBefore(LocalDate.now())) {

            throw new ValidationException(
                    "Date of birth must be a valid date in the past."
            );
        }
    }

    // Abstract method
    public abstract String getRoleDescription();

    // Display person information

    @Override
    public String toString() {

        return "Person ID: " + personId +
                "\nName: " + firstName + " " + lastName +
                "\nEmail: " + email +
                "\nPhone: " + phoneNumber +
                "\nDate of Birth: " + dateOfBirth;
    }
}