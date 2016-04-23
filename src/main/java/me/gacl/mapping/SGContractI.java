package me.gacl.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import me.gacl.domain.SGContract;

public interface SGContractI {
	
	@Insert("insert into contract(content, updated_at, updated_by) values(#{content},#{updated_at},#{updated_by})")
	public int insert(SGContract sgContract);
	
	@Update("update contract set content=#{content}, updated_at=#{updated_at}, updated_by=#{updated_by} where id=#{id}")
	public int update(SGContract sgContract);
	
	@Select("select content from contract order by updated_at desc limit 1")
	public SGContract selectLatestOne();

	@Select("select * from contract")
	public List<SGContract> selectAll();
	
	@Delete("delete from contract where id=#{id}")
	public int deleteById(int id);

}
