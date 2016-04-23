package com.zzy.contract.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zzy.contract.dao.ContractDao;
import com.zzy.contract.entity.SGContract;
import com.zzy.contract.mapping.SGContractI;
import com.zzy.utils.SGMyBatisUtil;

@Service
public class ContractDaoImpl implements ContractDao{
	private SqlSession sqlSession = SGMyBatisUtil.getSqlSession(true);
	private SGContractI sgContractI = sqlSession.getMapper(SGContractI.class); 
	
	public ContractDaoImpl() {
	}

	@Override
	public SGContract selectLatestOne() {
		SGContract sgContract = sgContractI.selectLatestOne();
		System.out.println(sgContract);
		return sgContract;
	}

	@Override
	public boolean insert(SGContract sgContract) {
		int result = sgContractI.insert(sgContract);
		System.out.println(result);
		
		return result>0;
	}

	@Override
	public boolean update(SGContract sgContract) {
		int result = sgContractI.update(sgContract);
		System.out.println(result);;
		
		return result>0;
	}

	@Override
	public boolean deleteById(int id) {
		int result = sgContractI.deleteById(id);
		System.out.println(result);
		
		return result>0;
	}

	@Override
	public SGContract selectById(int id) {
		SGContract sgContract = sgContractI.selectById(id);
		System.out.println(sgContract);
		
		return sgContract;
	}

	@Override
	public List<SGContract> selectAll() {
		List<SGContract> contractHistory = sgContractI.selectAll();
		System.out.println(contractHistory);
		
		return contractHistory;
	}

}
