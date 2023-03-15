package com.example.project.user.model.dataccess.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.example.project.user.model.datatypes.enums.Role;
import com.example.project.user.model.entity.UserProfile;
import com.rabbitmq.client.Channel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserProfilePersistence {
    @PersistenceContext
    private EntityManager entityManager;

    final static String sql = "{CALL get_users_by_role(?)}";
    final static String cosmetologist = String.valueOf(Role.COSMETOLOGIST);

    public UserProfile getExistingUser(Long id) {

        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/database_spring_boot_project",
            "root", "password123!");
        UserProfile userProfile=new UserProfile();
        try (Connection connection = dataSource.getConnection();
                CallableStatement statement = connection.prepareCall(sql)) {

            statement.setString(1, "1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ids = String.valueOf(resultSet.getInt("id"));
                userProfile.setName(resultSet.getString("name"));
                String email = resultSet.getString("email");
                // process user data...
            }
            return userProfile;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        //        id=2l;
        //        String query = "FROM UserProfile u WHERE u.id = :id";
        //        UserProfile userProfile = (UserProfile) entityManager.createQuery(query)
        //                .setParameter("id", id)
        //                .getSingleResult();
        //        return  userProfile;
        //        LocalDateTime expirationTime = LocalDateTime.now().minusHours(24); // Set expiration time to 24 hours ago
        //        entityManager.createQuery("DELETE FROM MyEntity WHERE createdAt < :expirationTime")
        //                .setParameter("expirationTime", expirationTime)
        //                .executeUpdate();
    }
}
