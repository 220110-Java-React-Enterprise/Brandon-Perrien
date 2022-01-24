import java.sql.SQLException;

public interface DataSourceCRUD<T> {
    //create,read,update,delete for sql
    public T create(T t) throws SQLException;
    public T read(Integer id);
    public T update(T t);
    public void delete(Integer id);
}
