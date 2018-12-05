package what.fuck.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import what.fuck.entity.vo.Dept;

@Mapper
public interface IDeptDao {

	public List<Dept> findAll();

	public boolean doCreate(Dept vo);

	@Select("select * from dept")
	public List<Dept> findAll2();

}
