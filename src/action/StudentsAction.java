package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;
import entity.Students;

//ѧ��Action��
public class StudentsAction extends SuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//��ѯ����ѧ���ķ���
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//����ѯ�������ϷŽ�session��
		if (list.size()>0 && list != null ) {
			session.setAttribute("students_list",list);
			System.out.println("��StudentsAction��query()��ѯ�ɹ�!");
		}
		
		return "query_success";
		
	}
	
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		System.out.println("��StudentsAction��delete()ɾ���ɹ���");
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
		System.out.println("��StudentsAction��add()ִ�гɹ���,������'add_success'");
		return "add_success";
		
	}
	
	//�޸�ѧ�����ϵĶ���
	public String modify(){
		//��ȡ���ݹ�����ѧ��sid
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//�����ڻỰ��
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//����ѧ�����ϵĶ���
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
		System.out.println("��StudentsAction��save()ִ�гɹ���,������'saves_success'");

		return "save_success";
		
		
	}
	
	
}
