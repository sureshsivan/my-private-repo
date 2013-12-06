package in.v8delta.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO Class For All the DAO Operations
 * 
 * @author v8-suresh
 *
 */
public interface GenericDao<T, ID extends Serializable> {
	List<T> getAll();
	T getById(ID id);
	
}
