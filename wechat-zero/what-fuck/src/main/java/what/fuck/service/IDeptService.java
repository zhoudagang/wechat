package what.fuck.service;

import java.util.List;

import what.fuck.entity.vo.Dept;

public interface IDeptService {
	public List<Dept> findAll();
	
	public boolean doCreate(Dept vo);
	
	public List<Dept> findAll2();
	
}
