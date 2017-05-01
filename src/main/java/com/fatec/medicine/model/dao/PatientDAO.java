package com.fatec.medicine.model.dao;

import java.sql.Connection;

public class PatientDAO extends ConnectionDAO {

    public PatientDAO(Connection connection) {
        super(connection);
    }

}
