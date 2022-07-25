package com.example.finalexam.repository;

import com.example.finalexam.model.Bike;
import com.example.finalexam.model.BikeType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class BikeRepository {
    JdbcTemplate jdbcTemplate;

    public BikeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Bike createBike(Bike bike){
        String query = " Insert into bikes values (null, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,bike.getBrand());
            preparedStatement.setString(2,bike.getModel());
            preparedStatement.setFloat(3,bike.getPrice());
            preparedStatement.setString(4,bike.getColor());
            preparedStatement.setString(5,bike.getType().toString());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        bike.setId(generatedKeyHolder.getKey().intValue());
        return bike;
    }

    public List<Bike> getBikesBy(String brand, BikeType type) {
        String query = new String();
        if (brand != null && type != null){
            query = "Select * from bikes where brand = ? and type = ?";
            List <Bike> result = jdbcTemplate.query(query,getBikeRowMapper(),brand,type);
            return result;


        }
        else if (brand != null){
            query = "Select * from bikes where brand =? ";
            List <Bike> result = jdbcTemplate.query(query,getBikeRowMapper(),brand);
            return result;

        }

        else if ( type != null){
            query = "Select * from bikes where type = ?";
            List <Bike> result = jdbcTemplate.query(query,getBikeRowMapper(),type);
            return result;

        }
        else{
            query = "Select * from bikes ";
            List <Bike> result = jdbcTemplate.query(query,getBikeRowMapper());
            return result;

        }

    }

    private RowMapper<Bike> getBikeRowMapper(){
        return (resultSet, rowNum) -> {
            Bike bike = new Bike();
            bike.setId(resultSet.getInt("id"));
            bike.setBrand(resultSet.getString("brand"));
            bike.setModel(resultSet.getString("brand"));
            bike.setPrice(resultSet.getFloat("brand"));
            bike.setColor(resultSet.getString("brand"));
            bike.setTypeString(resultSet.getString("type"));
            return bike;
        };
 }

}
