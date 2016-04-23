package me.gacl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import me.gacl.domain.SGContract;
import me.gacl.mapping.SGContractI;
import me.gacl.util.SGMyBatisUtil;

public class SGTestCRUDByAnnotationMapper {
	private static SqlSession sqlSession = SGMyBatisUtil.getSqlSession(true);
	private static SGContractI sgContractI = sqlSession.getMapper(SGContractI.class); 

	public static void selectAll() {
		List<SGContract> allContract = sgContractI.selectAll();
		System.out.println(allContract);
	}
	
	public static void updateById(SGContract sgContract) {
		int result = sgContractI.update(sgContract);
		System.out.println(result);
	}
	
	public static void insert(SGContract sgContract) {
		int result = sgContractI.insert(sgContract);
		System.out.println(result);
	}
	
	public static void delete(int id) {
		int result = sgContractI.deleteById(id);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
//		selectAll();
		
//		SGContract sgContract = new SGContract();
//		sgContract.setContent("i love lmy~");
//		sgContract.setUpdated_at(new Date());
//		sgContract.setUpdated_by(1);
//		sgContract.setId(1);
//		updateById(sgContract);
		
//		SGContract sgContract = new SGContract();
//		sgContract.setContent("new added record for test");
//		sgContract.setUpdated_at(new Date());
//		sgContract.setUpdated_by(2);
//		insert(sgContract);
		
//		delete(2);
		
		sqlSession.close();
	}
    
}