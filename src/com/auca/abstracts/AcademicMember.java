package com.auca.abstracts;

import com.auca.department.Department;
import com.auca.exceptions.ValidationException;

import java.time.LocalDate;

public abstract class AcademicMember extends Person {

    // Six attributes required by the assignment
    private String memberNumber;
    private Department department;
    private LocalDate joinDate;
    private String academicStatus;
    private String institutionalEmail;
    private String advisorName;

    // Constructor
    public AcademicMember(
            String personId,
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            LocalDate dateOfBirth,
            String memberNumber,
            Department department,
            LocalDate joinDate,
            String academicStatus,
            String institutionalEmail,
            String advisorName) {

        // Initialize Person attributes
        super(personId, firstName, lastName, email, phoneNumber, dateOfBirth);

        // Initialize AcademicMember attributes
        this.memberNumber = memberNumber;
        this.department = department;
        this.joinDate = joinDate;
        this.academicStatus = academicStatus;
        this.institutionalEmail = institutionalEmail;
        this.advisorName = advisorName;
    }

    // Getters and Setters

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    // Validate AcademicMember information

    @Override
    public void validate() throws ValidationException {

        // Validate inherited Person attributes first
        super.validate();

        if (memberNumber == null ||
                memberNumber.trim().length() < 4 ||
                memberNumber.trim().length() > 30) {

            throw new ValidationException(
                    "Member number must contain 4 to 30 characters."
            );
        }

        if (department == null) {
            throw new ValidationException(
                    "Department must be selected."
            );
        }

        if (joinDate == null ||
                joinDate.isAfter(LocalDate.now())) {

            throw new ValidationException(
                    "Join date cannot be in the future."
            );
        }

        if (academicStatus == null ||
                !(academicStatus.equals("ACTIVE") ||
                        academicStatus.equals("INACTIVE"))) {

            throw new ValidationException(
                    "Academic status must be ACTIVE or INACTIVE."
            );
        }

        if (institutionalEmail == null ||
                institutionalEmail.length() > 120 ||
                !institutionalEmail.matches(
                        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            throw new ValidationException(
                    "Invalid institutional email."
            );
        }

        if (advisorName == null ||
                advisorName.trim().length() < 2 ||
                advisorName.trim().length() > 120) {

            throw new ValidationException(
                    "Advisor name must contain 2 to 120 characters."
            );
        }
    }

    // Abstract method
    public abstract String getAcademicCategory();

    // Display AcademicMember information

    @Override
    public String toString() {

        return super.toString() +
                "\nMember Number: " + memberNumber +
                "\nDepartment: " + department +
                "\nJoin Date: " + joinDate +
                "\nAcademic Status: " + academicStatus +
                "\nInstitutional Email: " + institutionalEmail +
                "\nAdvisor Name: " + advisorName;
    }
}