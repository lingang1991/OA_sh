package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;
import entity.Students;

//学生Action类
public class StudentsAction extends SuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询所有学生的方法
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//将查询到的资料放进session中
		if (list.size()>0 && list != null ) {
			session.setAttribute("students_list",list);
			System.out.println("类StudentsAction中query()查询成功!");
		}
		
		return "query_success";
		
	}
	
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		System.out.println("类StudentsAction中delete()删除成功！");
		return "delete_success";
		
	}
	
	
	public String add() throws Exception{
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = new Students();
		s.setGender(request.getParameter("gender"));
		System.out.println(s.getGender());
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		System.out.println(s.getBirthday());
		
		s.setSname(request.getParameter("sname"));
		System.out.println(s.getSname());
		
		s.setAddress(request.getParameter("address"));
		System.out.println(s.getAddress());
		
		sdao.addStudents(s);
		System.out.println("类StudentsAction中add()执行成功！,返回了'add_success'");
		return "add_success";
		
	}
	
	//修改学生资料的动作
	public String modify(){
		//获取传递过来的学生sid
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存学生资料的动作
	public String save() throws Exception{
		
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = new Students();
		s.setGender(request.getParameter("gender"));
		System.out.println(s.getGender());
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		System.out.println(s.getBirthday());
		
		s.setSname(request.getParameter("sname"));
		System.out.println(s.getSname());
		
		s.setAddress(request.getParameter("address"));
		System.out.println(s.getAddress());
		
		s.setSid(request.getParameter("sid"));
		System.out.println(s.getSid());
		
		sdao.updateStudents(s);
		System.out.println("类StudentsAction中save()执行成功！,返回了'saves_success'");

		return "save_success";
		
		
	}
	
	
}
