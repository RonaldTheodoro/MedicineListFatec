package com.fatec.medicine.servlet.logic;

import com.fatec.medicine.model.bean.Doctor;
import com.fatec.medicine.model.dao.DoctorDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListDoctors")
public class ListDoctors implements Logic {

    @Override
    public String execute(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Connection connection = (Connection) request.getAttribute("connection");
        List<Doctor> doctors = new DoctorDAO(connection).getListDoctors();
        
        request.setAttribute("doctors", doctors);
        return "list-doctors.jsp";
    }   
}
