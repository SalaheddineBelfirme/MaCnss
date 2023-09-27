package com.macnss.Model.DAO;

import java.sql.SQLException;
import java.util.List;

// O stand for (object)
public interface DAO<O> {
    List<O> getAll() throws SQLException;
    Boolean save(O o) throws SQLException;
    Boolean update(O o) throws SQLException;
    Boolean delete(int id) throws SQLException;
}
