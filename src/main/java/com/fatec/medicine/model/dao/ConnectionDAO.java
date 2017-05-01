package com.fatec.medicine.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class ConnectionDAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public ConnectionDAO(Connection connection) {
        this.connection = connection;
    }
    
    protected void populateGetByIdQueryStatement(Long id) throws SQLException {
        statement.setLong(1, id);
    }
    
    protected void prepareStatement(String sql) throws SQLException {
        statement = connection.prepareStatement(sql);
    }
    
    protected void query() throws SQLException {
        resultSet = statement.executeQuery();
    }

    protected void dispose() {
        try {
            closeResultSet();
            closeStatement();
            closeConnection();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    private void closeResultSet() throws SQLException {
        if (resultSet != null)
            resultSet.close();
    }
    
    private void closeStatement() throws SQLException {
        if (statement != null)
            statement.close();
    }
    
    private void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }
}
