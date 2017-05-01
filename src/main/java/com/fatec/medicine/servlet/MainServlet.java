package com.fatec.medicine.servlet;

import com.fatec.medicine.servlet.logic.Logic;
import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void service(
            HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String parameter = request.getParameter("logic");
        String className = "com.fatec.medicine.servlet.logic." + parameter;
        
        try {
            Class<?> classObject = Class.forName(className);
            Logic logic = (Logic) classObject.newInstance();
            String page = logic.execute(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (Exception error) {
            throw new ServerException(
                "The business logic caused an exception", error);
        }
    }
}
