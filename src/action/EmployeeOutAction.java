package action;

import java.text.SimpleDateFormat;
import java.util.List;

import service.EmployeeOutDAO;
import service.StudentsDAO;
import service.impl.EmployeeOutDAOImpl;
import service.impl.StudentsDAOImpl;
import entity.EmployeeOut;
import entity.Students;

//学生Action类
public class EmployeeOutAction extends SuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询所有对出差表操作的方法
	public String query(){
		EmployeeOutDAO edao = new EmployeeOutDAOImpl();
		List<EmployeeOut> list = edao.queryAllEmployeeOut();
		//将查询到的资料放进session中
		if (list.size()>0 && list != null ) {
			session.setAttribute("employeeOut_list",list);
			System.out.println("类EmployeeOutAction中query()查询成功!");
		}
		System.out.println("query_success返回成功!");
		return "query_success";
		
	}
	
	public String delete(){
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeOut(eid);
		System.out.println("类EmployeeOutAction中delete()删除成功！");
		return "delete_success";
		
	}
	
	
	public String add() throws Exception{
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		EmployeeOut s = new EmployeeOut();
		
		//eid自动生成
		//s.setEid(request.getParameter("eid"));
		//System.out.println(s.getEid());
		
		s.setEnumb(request.getParameter("enumb"));;
		System.out.println(s.getEnumb());
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
		s.setEoutbt(sdf.parse(request.getParameter("eoutbt")));
		System.out.println(s.getEoutbt());
		
		s.setEoutot(sdf.parse(request.getParameter("eoutot")));
		System.out.println(s.getEoutot());
		
		s.setEname(request.getParameter("ename"));
		System.out.println(s.getEname());
		
		s.setEchecked(request.getParameter("echecked"));  
		System.out.println(s.getEchecked());
		
		s.setEoutcity(request.getParameter("eoutcity"));
		System.out.println(s.getEoutcity());
		
		s.setEoutcontent(request.getParameter("eoutcontent"));
		System.out.println(s.getEoutcontent());
		
		s.setEoutdays(request.getParameter("eoutdays"));
		System.out.println(s.getEoutdays());
		
		sdao.addEmployeeOut(s);
		System.out.println("类EmployeeOutAction中add()执行成功！,返回了'add_success'");
		return "add_success";
		
	}
	
	//修改学生资料的动作
	public String modify(){
		//获取传递过来的学生sid
		String eid = request.getParameter("eid");
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		EmployeeOut s = sdao.queryEmployeeOutByEid(eid);
		//保存在会话中
		session.setAttribute("modify_EmployeeOut", s);
		return "modify_success";
	}
	
	//保存学生资料的动作
	public String save() throws Exception{
		
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		EmployeeOut s = new EmployeeOut();
		s.setEid(request.getParameter("eid"));
		System.out.println(s.getEid());
		
		s.setEnumb(request.getParameter("enumb"));;
		System.out.println(s.getEnumb());
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
		s.setEoutbt(sdf.parse(request.getParameter("eoutbt")));
		System.out.println(s.getEoutbt());
		
		
		s.setEoutot(sdf.parse(request.getParameter("eoutot")));
		System.out.println(s.getEoutot());
		
		s.setEname(request.getParameter("ename"));
		System.out.println(s.getEname());
		
		s.setEchecked(request.getParameter("echecked"));  
		System.out.println(s.getEchecked());
		
		s.setEoutcity(request.getParameter("eoutcity"));
		System.out.println(s.getEoutcity());
		
		s.setEoutcontent(request.getParameter("eoutcontent"));
		System.out.println(s.getEoutcontent());
		
		s.setEoutdays(request.getParameter("eoutdays"));
		System.out.println(s.getEoutdays());

		sdao.updateEmployeeOut(s);
		System.out.println("类EmployeeOutAction中save()执行成功！,返回了'saves_success'");
		return "save_success";
	}	
}
