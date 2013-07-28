package com.github.springrest.base;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author badqiu
 */
@Transactional
public abstract class BaseManager<E extends BaseEntity, PK extends Serializable> {
	
	protected Log log = LogFactory.getLog(getClass());

	protected abstract EntityDao getEntityDao();

	@Transactional(readOnly=true)
	public E getById(Context context, PK id) throws DataAccessException {
		return (E)getEntityDao().getById(id);
	}
	
	@Transactional(readOnly=true)
	public List<E> findAll() throws DataAccessException{
		return getEntityDao().findAll();
	}
	
	/** 根据id检查是否插入或是更新数据 */
	public void saveOrUpdate(Context context, E entity) throws DataAccessException {
		getEntityDao().saveOrUpdate(entity);
	}
	
	/** 插入数据 */
	public void save(Context context, E entity) throws DataAccessException {
		 getEntityDao().save(entity);
	}
	
	public void removeById(Context context, PK id) throws DataAccessException {
		getEntityDao().deleteById(id);
	}
	
	public void update(Context context, E entity) throws DataAccessException {
		getEntityDao().update(entity);
	}
	
	@Transactional(readOnly=true)
	public boolean isUnique(Context context, E entity, String uniquePropertyNames) throws DataAccessException {
		return getEntityDao().isUnique(entity, uniquePropertyNames);
	}
	
}
