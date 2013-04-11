package org.nthdimenzion.ddd.infrastructure.hibernate;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.joda.time.DateTime;
import org.nthdimenzion.ddd.domain.LifeCycle;
import org.nthdimenzion.security.domain.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Arrays;

public class AutoColumnsPopulator extends EmptyInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private SystemUser systemUser;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] currentState, String[] propertyNames, Type[] types) {
        setValue(currentState, propertyNames, "lifeCycle");
        return true;
    }

    private void setValue(Object[] currentState, String[] propertyNames, String propertyToSet) {
        int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
        if (index >= 0) {
            LifeCycle lifeCycle = (LifeCycle) currentState[index];
            lifeCycle.setCreatedBy(getUserName());
            lifeCycle.setCreatedTxTimestamp(DateTime.now());
            setValueForUpdate(currentState,propertyNames,propertyToSet);
        }
    }



    private void setValueForUpdate(Object[] currentState, String[] propertyNames, String propertyToSet) {
        int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
        if (index >= 0) {
            LifeCycle lifeCycle = (LifeCycle) currentState[index];
            lifeCycle.setUpdatedBy(getUserName());
            lifeCycle.setUpdatedTxTimestamp(DateTime.now());
        }
    }

    private String getUserName() {
        return org.nthdimenzion.object.utils.StringUtils.nullSafeCopy(systemUser.getUsername());
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) {
        setValueForUpdate(currentState, propertyNames, "lifeCycle");
        return true;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public String onPrepareStatement(String sql) {
        return super.onPrepareStatement(sql);
    }
}