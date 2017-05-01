package com.fatec.medicine.model.dao;

import java.sql.Connection;

public class MedicineDAO extends ConnectionDAO {
    
    public MedicineDAO(Connection connection) {
        super(connection);
    }
    
}