package com.payslip.domain;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.nthdimenzion.crud.ICrudEntity;
import org.nthdimenzion.ddd.domain.IdGeneratingArcheType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 12/4/13
 * Time: 12:07 PM
 */
@Entity
public class Deduction extends IdGeneratingArcheType implements ICrudEntity {

    private String title;
    private Money amount;

    Deduction() {
    }

    public Deduction(String title) {
        this.title = title;
        this.amount = Money.zero(CurrencyUnit.USD);
    }

    public Deduction(DeductionHead deductionHead) {
        this.title = deductionHead.getTitle();
        this.amount = Money.zero(CurrencyUnit.USD);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Columns(columns = {@Column(name = "AMOUNT", precision = 64, scale = 2), @Column(name = "CURRENCY_CODE")})
    @Type(type = "org.nthdimenzion.ddd.domain.sharedkernel.MoneyType")
    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
