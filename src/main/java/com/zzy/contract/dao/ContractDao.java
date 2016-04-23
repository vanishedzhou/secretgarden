package com.zzy.contract.dao;

import java.util.List;

import com.zzy.contract.entity.SGContract;

public interface ContractDao {
	public SGContract selectLatestOne();
	
	public SGContract selectById(int id);
	
	public List<SGContract> selectAll();
	
	public boolean insert(SGContract sgContract);
	
	public boolean update(SGContract sgContract);
	
	public boolean deleteById(int id);

}
