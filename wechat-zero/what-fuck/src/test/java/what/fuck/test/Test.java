package what.fuck.test;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import what.fuck.StartSpringBootMain;
import what.fuck.controller.test;
import what.fuck.entity.vo.Dept;
import what.fuck.service.IDeptService;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class Test {

	@Resource
	private test testController;
	@Resource
	private DataSource dataSource;
	@Resource
	private IDeptService deptService;
	

	@org.junit.Test
	public void testIndex() {
		System.err.println(testController.index());
	}

	@org.junit.Test
	public void testSource() throws SQLException {
		System.out.println(this.dataSource.getConnection());
	}

	@org.junit.Test
	public void testDeptService() throws SQLException {
		System.out.println(this.deptService.findAll());
	}
	
	@org.junit.Test
	public void testDeptdoCreate() throws SQLException {
		Dept dept=new Dept();
		dept.setDname("測試部");
		System.out.println(this.deptService.doCreate(dept));
	}

}
