package com.codegym.model.dao;
import com.codegym.model.dto.GlassesDTO;
import com.codegym.model.entity.Glasses;
import com.codegym.connection.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GlassesDAO {
    public List<Glasses> glassesList = null;

    public List<Glasses> getAll() {
        glassesList = new LinkedList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT * FROM glasses;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Glasses glasses = new Glasses();
                glasses.setId(resultSet.getInt("id"));
                glasses.setName(resultSet.getString("name"));
                glasses.setPrice(resultSet.getDouble("price"));
                glasses.setQuantity(resultSet.getInt("quantity"));
                glasses.setBrand(resultSet.getString("brand"));
                glassesList.add(glasses);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return glassesList;
    }

    public GlassesDTO get(int id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT * FROM glasses WHERE id = ?;";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GlassesDTO glasses = new GlassesDTO();
                glasses.setId(resultSet.getInt("id"));
                glasses.setName(resultSet.getString("name"));
                glasses.setPrice(resultSet.getDouble("price"));
                glasses.setQuantity(resultSet.getInt("quantity"));
                glasses.setBrand(resultSet.getString("brand"));
                return glasses;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GlassesDTO();
    }

        public void insert(Glasses glasses){
            try{
                Connection connection = JdbcConnection.getConnection();
                String sql = "INSERT INTO glasses(name, price, quantity, brand) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, glasses.getName());
                preparedStatement.setDouble(2, glasses.getPrice());
                preparedStatement.setInt(3, glasses.getQuantity());
                preparedStatement.setString(4, glasses.getBrand());
                preparedStatement.executeUpdate();
//                if(preparedStatement.executeUpdate() > 0){
//                    System.out.println("Add glasses success !");
//                } else {
//                    System.out.println("Failed to insert glasses !");
//                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public void update(int id, Glasses glasses) throws SQLException {
            try {
                Connection connection = JdbcConnection.getConnection();
                String sql = "UPDATE glasses SET name = ?, price = ?, quantity = ?, brand = ? WHERE id = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, glasses.getName());
                preparedStatement.setDouble(2, glasses.getPrice());
                preparedStatement.setInt(3, glasses.getQuantity());
                preparedStatement.setString(4, glasses.getBrand());
                preparedStatement.setInt(5, id);
                preparedStatement.executeUpdate();
//                if (preparedStatement.executeUpdate() > 0) {
//                    System.out.println("Edited glasses success !");
//                } else {
//                    System.out.println("Failed to edit glasses !");
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void delete(int id) {
            try{
                Connection connection = JdbcConnection.getConnection();
                String sql = "DELETE FROM glasses WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id );
                preparedStatement.executeUpdate();
//                if(preparedStatement.executeUpdate() > 0) {
//                    System.out.println("Remove glasses success !");
//                } else {
//                    System.out.println("Failed to remove glasses !");
//                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
}
