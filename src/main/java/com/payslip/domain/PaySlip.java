package com.payslip.domain;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.nthdimenzion.crud.ICrudEntity;
import org.nthdimenzion.ddd.domain.IdGeneratingArcheType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 12/4/13
 * Time: 12:29 PM
 */
@Entity
public class PaySlip extends IdGeneratingArcheType implements ICrudEntity{

    private Set<Income> incomes;
    private Set<Deduction> deductions;
    private Money netSalary;

    PaySlip() {
    }

    public PaySlip(PaySlipTemplate paySlipTemplate) {
        this.setIncomes(paySlipTemplate.getIncomes());
        this.setDeductions(paySlipTemplate.getDeductions());
        this.setNetSalary(paySlipTemplate.getNetSalary());
    }


    @ManyToMany
    public Set<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<Income> incomes) {
        this.incomes = incomes;
    }

    @ManyToMany
    public Set<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(Set<Deduction> deductions) {
        this.deductions = deductions;
    }

    @Columns(columns = {@Column(name = "AMOUNT", precision = 64, scale = 2), @Column(name = "CURRENCY_CODE")})
    @Type(type = "org.nthdimenzion.ddd.domain.sharedkernel.MoneyType")
    public Money getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Money netSalary) {
        this.netSalary = netSalary;
    }

    public Money calculateNetSalary(){
        netSalary =  Money.zero(CurrencyUnit.USD);
        return netSalary;
    }
}
