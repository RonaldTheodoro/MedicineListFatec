package com.fatec.medicine.filter;

import com.fatec.medicine.model.connection.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class ConnectionFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            request.setAttribute("connection", connection);
            chain.doFilter(request, response);
            connection.close();
        } catch (ClassNotFoundException | SQLException error) {
            Logger.getLogger(
                ConnectionFilter.class.getName()
            ).log(Level.SEVERE, null, error);
        }
    }

    @Override
    public void destroy() { }
}
