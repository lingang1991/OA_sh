package action;

import java.text.SimpleDateFormat;
import java.util.List;

import service.EmployeeOutDAO;
import service.EmployeeRestDAO;
import service.EmployeeWorkDAO;
import service.impl.EmployeeOutDAOImpl;
import service.impl.EmployeeRestDAOImpl;
import service.impl.EmployeeWorkDAOImpl;
import entity.EmployeeOut;
import entity.EmployeeRest;
import entity.EmployeeWork;

//Action类
public class EmployeeRestAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查询所有对出差表操作的方法
	public String query() {
		EmployeeRestDAO edao = new EmployeeRestDAOImpl();
		List<EmployeeRest> list = edao.queryAllEmployeeRest();
		// 将查询到的资料放进session中
		if (list.size() > 0 && list != null) {
			session.setAttribute("EmployeeRest_list", list);
			System.out.println("类EmployeeRestAction中query()查询成功!");
		}
		System.out.println("query_success返回成功!");
		return "query_success";

	}

	public String delete() {
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeRest(eid);
		System.out.println("类EmployeeRestAction中delete()删除成功！");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		EmployeeRest s = new EmployeeRest();

		// eid自动生成
		// s.setEid(request.getParameter("eid"));
		// System.out.println(s.getEid());

		s.setEnumb(request.getParameter("enumb"));

		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setErestday(sdf.parse(request.getParameter("erestday")));

		s.setEresttime(request.getParameter("eresttime"));

		s.setEresthours(request.getParameter("eresthours"));

		s.setErestreason(request.getParameter("erestreason"));

		s.setErestremained(request.getParameter("erestremained"));

		sdao.addEmployeeRest(s);

		System.out.println("类EmployeeRestAction中add()执行成功！,返回了'add_success'");
		return "add_success";

	}

	// 修改学生资料的动作
	public String modify() {
		// 获取传递过来的学生sid
		String eid = request.getParameter("eid");
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		EmployeeRest s = sdao.queryEmployeeRestByEid(eid);
		// 保存在会话中
		session.setAttribute("modify_EmployeeRest", s);
		System.out.println("返回modify_success成功！");
		return "modify_success";
	}

	// 保存学生资料的动作
	public String save() throws Exception {

		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		EmployeeRest s = new EmployeeRest();


		s.setEid(request.getParameter("eid"));
		
		s.setEnumb(request.getParameter("enumb"));

		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setErestday(sdf.parse(request.getParameter("erestday")));

		s.setEresttime(request.getParameter("eresttime"));

		s.setEresthours(request.getParameter("eresthours"));

		s.setErestreason(request.getParameter("erestreason"));

		s.setErestremained(request.getParameter("erestremained"));

		sdao.updateEmployeeRest(s);
		
		System.out.println("类EmployeeRestAction中save()执行成功！,返回了'saves_success'");

		return "save_success";

	}

}
