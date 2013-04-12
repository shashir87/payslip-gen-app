package com.payslip.domain;

import org.hibernate.annotations.Immutable;
import org.nthdimenzion.crud.ICrudEntity;
import org.nthdimenzion.ddd.domain.IdGeneratingArcheType;
import org.nthdimenzion.ddd.domain.annotations.ValueObject;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 12/4/13
 * Time: 11:53 AM
 */

@ValueObject
@Entity
public class IncomeHead extends IdGeneratingArcheType  {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
