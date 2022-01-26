import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserRepo implements DataSourceCRUD<UserModel> {
    private final Connection connection;

    public UserRepo(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public UserModel create(UserModel model) throws SQLException{
        //JDBC logic
        //Sql statement that adds data to a table
        try{
            String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getFirstName());
            pstmt.setString(2, model.getLastName());
            pstmt.setString(3, model.getEmail());
            pstmt.setString(4, model.getPassword());

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return model;
    }
    //Overloaded read method, so that read method works when given email instead of account id
    public UserModel read(String s) {
        //reads/returns values for given email.
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, s);

            ResultSet rs = pstmt.executeQuery();

            UserModel model = new UserModel();
            while (rs.next()) {
                model.setId(rs.getInt("user_id"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));
            }
            return model;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel read(Integer id) {
        //reads/returns values for given account id.
        try {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            UserModel model = new UserModel();
            while (rs.next()) {
                model.setId(rs.getInt("user_id"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));
            }
            return model;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel update(UserModel model){
        //Updates/Changes firstname, lastname, and password for a given account id
        try{
            String sql = "UPDATE users SET first_name = ?, last_name = ?, password = ? WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getFirstName());
            pstmt.setString(2, model.getLastName());
            pstmt.setString(3, model.getPassword());
            pstmt.setInt(4, model.getId());

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return model;
    }
    @Override
    public void delete(Integer id){
        //deletes row in table at id
        try{
            String sql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
