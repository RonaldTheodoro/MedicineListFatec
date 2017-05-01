package com.fatec.medicine.model.dao;

import com.fatec.medicine.model.bean.Doctor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        } finally {
            dispose();
        }
    }
    
    public List<Doctor> getListDoctors() {
        String sql = "SELECT * FROM Doctor";
        List<Doctor> doctors = new ArrayList<>();
        
        try {
            prepareStatement(sql);
            query();
            doctors = getPopulatedList();
        } catch (SQLException error) {
            throwRuntimeException(error);
        } finally {
            dispose();
        }
        return doctors;
    }
    
    private void populateInsertStatement(Doctor doctor) throws SQLException {
        setString(1, doctor.getName());
        setString(2, doctor.getCrm());
        setString(3, doctor.getSpecializations());
    }
    
    private Doctor getPopulatedObject() throws SQLException {
        Doctor doctor = new Doctor();
        
        doctor.setId(getLong("id"));
        doctor.setName(getString("name"));
        doctor.setCrm(getString("crm"));
        doctor.setSpecializations(getString("specializations"));
        
        return doctor;
    }
    
    private List<Doctor> getPopulatedList() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        
        while (resultSetNext())
            doctors.add(getPopulatedObject());
        
        return doctors;
    }
}
