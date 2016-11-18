package action;

import java.text.SimpleDateFormat;
import java.util.List;

import service.EmployeeOutDAO;
import service.StudentsDAO;
import service.impl.EmployeeOutDAOImpl;
import service.impl.StudentsDAOImpl;
import entity.EmployeeOut;
import entity.Students;

//ѧ��Action��
public class EmployeeOutAction extends SuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//��ѯ���жԳ��������ķ���
	public String query(){
		EmployeeOutDAO edao = new EmployeeOutDAOImpl();
		List<EmployeeOut> list = edao.queryAllEmployeeOut();
		//����ѯ�������ϷŽ�session��
		if (list.size()>0 && list != null ) {
			session.setAttribute("employeeOut_list",list);
			System.out.println("��EmployeeOutAction��query()��ѯ�ɹ�!");
		}
		System.out.println("query_success���سɹ�!");
		return "query_success";
		
	}
	
	public String delete(){
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeOut(eid);
		System.out.println("��EmployeeOutAction��delete()ɾ���ɹ���");
		return "delete_success";
		
	}
	
	
	public String add() throws Exception{
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		EmployeeOut s = new EmployeeOut();
		
		//eid�Զ�����
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
		System.out.println("��EmployeeOutAction��add()ִ�гɹ���,������'add_success'");
		return "add_success";
		
	}
	
	//�޸�ѧ�����ϵĶ���
	public String modify(){
		//��ȡ���ݹ�����ѧ��sid
		String eid = request.getParameter("eid");
		EmployeeOutDAO sdao = new EmployeeOutDAOImpl();
		EmployeeOut s = sdao.queryEmployeeOutByEid(eid);
		//�����ڻỰ��
		session.setAttribute("modify_EmployeeOut", s);
		return "modify_success";
	}
	
	//����ѧ�����ϵĶ���
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
		System.out.println("��EmployeeOutAction��save()ִ�гɹ���,������'saves_success'");
		return "save_success";
	}	
}
