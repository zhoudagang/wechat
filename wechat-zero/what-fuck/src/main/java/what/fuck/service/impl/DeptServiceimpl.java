package what.fuck.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.fuck.dao.IDeptDao;
import what.fuck.entity.vo.Dept;
import what.fuck.service.IDeptService;

@Service
public class DeptServiceimpl implements IDeptService {

	@Resource
	private IDeptDao deptdao;

	
	@Override
	public List<Dept> findAll() {
		return this.deptdao.findAll();
	}

	@Override
	public boolean doCreate(Dept vo) {
		return deptdao.doCreate(vo);
	}

	@Override
	public List<Dept> findAll2() {
		return deptdao.findAll2();
	}

}
