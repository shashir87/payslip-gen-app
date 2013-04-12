package com.payslip.domain;

import org.joda.time.DateTime;
import org.nthdimenzion.crud.ICrudEntity;
import org.nthdimenzion.ddd.domain.IdGeneratingArcheType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 12/4/13
 * Time: 11:59 AM
 */
@Entity
public class Employee extends IdGeneratingArcheType implements ICrudEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private DateTime dateOfBirth;
    private String employeeNumber;
    private DateTime dateOfJoining;
    private String pfAccountNumber;
    private String panNumber;
    private String bankAccountNumber;
    private String bankName;
    private int leavesTaken;

    private PaySlipTemplate paySlipTemplate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public DateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(DateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getPfAccountNumber() {
        return pfAccountNumber;
    }

    public void setPfAccountNumber(String pfAccountNumber) {
        this.pfAccountNumber = pfAccountNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }

    @OneToOne
    public PaySlipTemplate getPaySlipTemplate() {
        return paySlipTemplate;
    }

    public void setPaySlipTemplate(PaySlipTemplate paySlipTemplate) {
        this.paySlipTemplate = paySlipTemplate;
    }
}
