package com.alejandro.dao;

import com.alejandro.model.entity.EmployeeEntity;

public class EmployeeDao extends AbstractCrudDao<EmployeeEntity, Long>{

    public EmployeeDao() {
        super(EmployeeEntity.class);
    }
}
