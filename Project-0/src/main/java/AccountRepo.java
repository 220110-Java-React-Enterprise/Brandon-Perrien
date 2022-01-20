
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//CRUD interface implementation
public class AccountRepo implements DataSourceCRUD<AccountModel> {
    private final Connection connection;

    public AccountRepo(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public AccountModel create(AccountModel model){
        //JDBC logic
        //Sql statement that adds data to a table

        try{
            String sql = "INSERT INTO accounts (first_name, last_name, email, password) VALUES (?,?,?,?)";
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

    @Override
    public AccountModel read(Integer id) {
        //reads/returns values for given account id.
        try {
            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            AccountModel model = new AccountModel();
            while (rs.next()) {
                model.setId(rs.getInt("account_id"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setEmail(rs.getString("email"));
            }
            return model;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccountModel update(AccountModel model){
        //Updates/Changes table data member
        try{
            String sql = "UPDATE accounts SET first_name = ?, last_name = ?, email = ?, password = ? WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getFirstName());
            pstmt.setString(2, model.getLastName());
            pstmt.setString(3, model.getEmail());
            pstmt.setString(4, model.getPassword());
            pstmt.setInt(5, model.getId());

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
        String sql = "DELETE FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }catch(SQLException e){
        e.printStackTrace();
    }
}
}
