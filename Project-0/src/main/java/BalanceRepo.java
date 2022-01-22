import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceRepo implements DataSourceCRUD<BalanceModel>{
    private final Connection connection;

    public BalanceRepo(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public BalanceModel create(BalanceModel model){
        //JDBC logic
        //Sql statement that adds data to a table

        try{
            String sql = "INSERT INTO bank_accounts (account_id, email, account_name, balance) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.setString(2, model.getEmail());
            pstmt.setString(3, model.getAccountName());
            pstmt.setDouble(4, model.getBalance());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public BalanceModel read(String s) {
        //reads/returns values for given email.
        try {
            String sql = "SELECT * FROM bank_accounts WHERE account_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, s);

            ResultSet rs = pstmt.executeQuery();

            BalanceModel model = new BalanceModel();
            while (rs.next()) {
                model.setEmail(rs.getString("email"));
                model.setAccountName(rs.getString("account_name"));
                model.setBalance(rs.getDouble("balance"));
                model.setId(rs.getInt("id"));
            }
            return model;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BalanceModel update(BalanceModel model){
        //Updates/Changes table data member
        try{
            String sql = "UPDATE bank_accounts SET balance = ? WHERE account_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, model.getBalance());
            pstmt.setString(2, model.getAccountName());

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
            String sql = "DELETE FROM bank_accounts WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
