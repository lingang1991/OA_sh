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

//Action��
public class EmployeeRestAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��ѯ���жԳ��������ķ���
	public String query() {
		EmployeeRestDAO edao = new EmployeeRestDAOImpl();
		List<EmployeeRest> list = edao.queryAllEmployeeRest();
		// ����ѯ�������ϷŽ�session��
		if (list.size() > 0 && list != null) {
			session.setAttribute("EmployeeRest_list", list);
			System.out.println("��EmployeeRestAction��query()��ѯ�ɹ�!");
		}
		System.out.println("query_success���سɹ�!");
		return "query_success";

	}

	public String delete() {
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeRest(eid);
		System.out.println("��EmployeeRestAction��delete()ɾ���ɹ���");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		EmployeeRest s = new EmployeeRest();

		// eid�Զ�����
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

		System.out.println("��EmployeeRestAction��add()ִ�гɹ���,������'add_success'");
		return "add_success";

	}

	// �޸�ѧ�����ϵĶ���
	public String modify() {
		// ��ȡ���ݹ�����ѧ��sid
		String eid = request.getParameter("eid");
		EmployeeRestDAO sdao = new EmployeeRestDAOImpl();
		EmployeeRest s = sdao.queryEmployeeRestByEid(eid);
		// �����ڻỰ��
		session.setAttribute("modify_EmployeeRest", s);
		System.out.println("����modify_success�ɹ���");
		return "modify_success";
	}

	// ����ѧ�����ϵĶ���
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
		
		System.out.println("��EmployeeRestAction��save()ִ�гɹ���,������'saves_success'");

		return "save_success";

	}

}
