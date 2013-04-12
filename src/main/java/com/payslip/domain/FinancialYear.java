package com.payslip.domain;

import org.nthdimenzion.crud.ICrudEntity;
import org.nthdimenzion.ddd.domain.IdGeneratingArcheType;
import org.nthdimenzion.ddd.domain.Interval;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 12/4/13
 * Time: 11:56 AM
 */
@Entity
public class FinancialYear extends IdGeneratingArcheType implements ICrudEntity{

    private String title;

    private Interval yearPeriod;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    @Embedded
    public Interval getYearPeriod() {
        return yearPeriod;
    }

    public void setYearPeriod(Interval yearPeriod) {
        this.yearPeriod = yearPeriod;
    }
}
