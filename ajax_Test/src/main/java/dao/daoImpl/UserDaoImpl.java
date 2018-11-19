package dao.daoImpl;

import Entity.User;
import dao.ConnectionPool;
import dao.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {
    private final String CREATE = "INSERT INTO users (firstName, lastName, username, password, status,role,email) VALUES (?, ?, ?, ?, ?,?,?)";
    private final String READ = "SELECT * FROM users WHERE userId = ?";
    private final String READ_ALL = "SELECT * FROM users";
    private final String UPDATE = "UPDATE users SET firstName = ?, lastName = ?, userName = ?, password = ?, status = ?, role = ? , email= ? WHERE  userId = ? ";
    private final String DELETE = "DELETE FROM users WHERE userId= ?";
    private final String READ_BY_NAME = "SELECT * FROM users WHERE username = ?";
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public User getUserByName(String name) {
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); PreparedStatement ps = connection.prepareStatement(READ_BY_NAME)) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt("userId"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            User.Role.valueOf(resultSet.getString("role")),
                            User.UserStatus.valueOf(resultSet.getString("status")));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(User element) {
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); PreparedStatement ps = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, element.getFirstName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getUserName());
            ps.setString(4, element.getPassword());
            ps.setString(5, String.valueOf(element.getUserStatus()));
            ps.setString(6, String.valueOf(element.getUserRole()));
            ps.setString(7, element.getEmail());
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    element.setUserId(generatedKeys.getInt(1));
                }
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User read(int id) {
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt("userId"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            User.Role.valueOf(resultSet.getString("role")),
                            User.UserStatus.valueOf(resultSet.getString("status")));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> read() {
        List<User> userList = new ArrayList<>();
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(READ_ALL)) {
                while (resultSet.next()) {
                    userList.add(new User(resultSet.getInt("userId"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            User.Role.valueOf(resultSet.getString("role")),
                            User.UserStatus.valueOf(resultSet.getString("status"))));
                }
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(User element) {
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, element.getFirstName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getUserName());
            ps.setString(4, element.getPassword());
            ps.setString(5, String.valueOf(element.getUserStatus()));
            ps.setString(6, String.valueOf(element.getUserRole()));
            ps.setString(7, element.getEmail());
            ps.setInt(8, element.getUserId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (connectionPool == null) connectionPool = ConnectionPool.getInstance();
        try (Connection connection = connectionPool.getConnection(); PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
