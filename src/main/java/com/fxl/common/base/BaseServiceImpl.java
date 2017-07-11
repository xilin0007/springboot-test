package com.fxl.common.base;

import java.util.List;


public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {


	protected abstract BaseMapper<T> getDao();
	
	@Override
	public T findById(Integer id) {
		return getDao().findById(id);
	}
	
	@Override
	public boolean insert(T paramT) {
		try {
			return (getDao().insert(paramT)>0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean insertBatch(List<T> list) {
		try {
			return (getDao().insertBatch(list)>0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			return (getDao().delete(id)>0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(T Po) {
		try {
			return (getDao().update(Po)>0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean updateBatch(List<T> paramList) {
		try {
			return (getDao().updateBatch(paramList)>0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}