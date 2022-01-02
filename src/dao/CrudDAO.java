package dao;

import java.util.List;

public interface CrudDAO<T>  extends SuperDAO{
    boolean add(T t);
    boolean update(T t);
    boolean delete(String id);
    T get(String id);
    List<T> getAll();
    String getId();
    List<String> getAllIds();
}
