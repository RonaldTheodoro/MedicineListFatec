package com.fatec.medicine.model.dao;

import com.fatec.medicine.model.bean.Doctor;
import java.sql.Connection;
import java.sql.SQLException;

public class DoctorDAO extends ConnectionDAO {
    
    public DoctorDAO(Connection connection) {
        super(connection);
    }
    
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctor" +
            "(name, crm, specializations) VALUES (?, ?, ?)";
        
        try {
            prepareStatement(sql);
            populateInsertStatement(doctor);
            executeStatement();
        } catch (SQLException error) {
            throwRuntimeException(error);
        }
    }
    
    private void populateInsertStatement(Doctor doctor) throws SQLException {
        setString(1, doctor.getName());
        setString(2, doctor.getCrm());
        setString(3, doctor.getSpecializations());
    }   
}
