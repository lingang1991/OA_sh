package action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.EmployeeOutDAO;
import service.EmployeeRestDAO;
import service.EmployeeSupplyDAO;
import service.EmployeeTaxiDAO;
import service.EmployeeWorkDAO;
import service.impl.EmployeeOutDAOImpl;
import service.impl.EmployeeRestDAOImpl;
import service.impl.EmployeeSupplyDAOImpl;
import service.impl.EmployeeTaxiDAOImpl;
import service.impl.EmployeeWorkDAOImpl;
import entity.EmployeeOut;
import entity.EmployeeRest;
import entity.EmployeeSupply;
import entity.EmployeeTaxi;
import entity.EmployeeWork;

//Action��
public class EmployeeTaxiAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��ѯ���жԴ򳵱�����ķ���
	public String query() {
		// ��ѯ���еĴ򳵼�¼
		EmployeeTaxiDAO edao = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list = edao.queryAllEmployeeTaxi();
		// ����ѯ�������ϷŽ�session��
		if (list.size() > 0 && list != null) {
			session.setAttribute("EmployeeTaxi_list", list);
			System.out.println("��EmployeeRestAction��query()��ѯ�ɹ�!");
		}
		System.out.println("query_success���سɹ�!");
		return "query_success";

	}

	public String delete() {
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeTaxi(eid);
		System.out.println("��EmployeeTaxiAction��delete()ɾ���ɹ���");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		EmployeeTaxi s = new EmployeeTaxi();

		// eid�Զ�����
		// s.setEid(request.getParameter("eid"));
		// System.out.println(s.getEid());

		s.setEnumb(request.getParameter("enumb"));
	
		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setEtaxiday(sdf.parse(request.getParameter("etaxiday")));
		
		s.setEtaxigo(request.getParameter("etaxigo"));
		
		s.setEtaxicost(request.getParameter("etaxicost"));

	

		sdao.addEmployeeTaxi(s);

		System.out.println("��EmployeeTaxiAction��add()ִ�гɹ���,������'add_success'");
		return "add_success";

	}

	// �޸�ѧ�����ϵĶ���
	public String modify() {
		// ��ȡ���ݹ�����ѧ��sid
		String eid = request.getParameter("eid");
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		EmployeeTaxi s = sdao.queryEmployeeTaxiByEid(eid);
		// �����ڻỰ��
		session.setAttribute("modify_EmployeeTaxi", s);
		return "modify_success";
	}

	// ����ѧ�����ϵĶ���
	public String save() throws Exception {

		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		EmployeeTaxi s = new EmployeeTaxi();
		
	    s.setEid(request.getParameter("eid"));

		s.setEnumb(request.getParameter("enumb"));

		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
s.setEtaxiday(sdf.parse(request.getParameter("etaxiday")));
		
		s.setEtaxigo(request.getParameter("etaxigo"));
		
		s.setEtaxicost(request.getParameter("etaxicost"));

		sdao.updateEmployeeTaxi(s);
		System.out.println("��EmployeeTaxiAction��save()ִ�гɹ���,������'saves_success'");

		return "save_success";

	}
	
	public String filter() throws Exception {
		
		// ��ѯ���еĴ򳵼�¼
		EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list = edao1.queryAllEmployeeTaxi();
		int m = 0,n=0;//m��������������n�������������ݴ洢ά��
		String[] a = new String[list.size()];//a����洢list����Ĺ���
		String[] b = new String[list.size()];//b����洢list��������� 
		String[] c = new String[list.size()];//c����洢list�ĳ���
		String[] d = new String[list.size()];//d�洢ͬһ��Ӱ����Ա����
		String[] name = new String[list.size()];//name�Ӱ����Ա����
		Double[] cost = new Double[list.size()];//cost��Ϊ�ۼ����洢ͬһ�˴򳵷���
		Double[] allcost = new Double[list.size()];//allcost�洢ͬһ�˴��ܷ���
	
		if (list.size() > 0 && list != null) {
			EmployeeTaxi e = null;
			for (int i = 0; i < list.size(); i++) {
				e = list.get(i);
				a[i] = e.getEnumb();
				b[i] = e.getEname();
				c[i] = e.getEtaxicost();
			}
		}

		for (int i = 0; i < c.length; i++) {
			System.out.println(a[i]);
		}
		for (int i = 0; i < c.length; i++) {
			System.out.println(b[i]);
		}

		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		for (int i = 0; i < c.length - 1; i=i+m+1) {
			System.out.println("i��ֵ��"+i);
			System.out.println("a[i]��ֵ��"+a[i]);
			System.out.println("b[i]��ֵ��"+b[i]);
			cost[i]=Double.parseDouble(c[i]);
			m=0;
				for (int j = 1 + i; j < c.length; j++) {
					if (a[i].compareTo(a[j]) == 0) {
						cost[i]+=Double.parseDouble(c[j]);
						m++;	
					}
				}
				allcost[n]=cost[i];
				cost[i]=(double) 0;
				d[n]=a[i];
				name[n]=b[i];
				System.out.println("���ţ�"+d[n]+" ������"+b[i]+" �򳵵��ܷ����ǣ� " + allcost[n]);
				n++;		
		}
		System.out.println();
		
		for (int i = 0; i < d.length; i++) {		
			System.out.println("d[n]�ı���ֵ�ǣ�"+d[i]);//��Ӧ�Ź���
			System.out.println("name[n]�ı���ֵ�ǣ�"+name[i]);//��Ӧ������
			System.out.println("allcost[n]�ı���ֵ�ǣ�"+allcost[i]);//��Ӧ���ܴ򳵷���
		}
	
		EmployeeTaxi e2 = null;
		if (list.size() > 0 && list != null) {
			for (int i = 0; i < list.size(); i++) {
				e2 = list.get(i);
				e2.setEid(String.valueOf(i));;
				e2.setEnumb(d[i]);
				e2.setEname(name[i]);
				e2.setEtaxicost(String.valueOf(allcost[i]));
				list.set(i, e2);
			}
			session.setAttribute("EmployeeSupply_list",list);
		}else {
			System.out.println("TaxiAction�в�ѯ����listΪ��ֵ");
		}
		System.out.println("��EmployeeTaxiAction��filter()���˳ɹ�!");
		System.out.println("filter_success���سɹ�!");
		return "filter_success";
		
		
		
	}
	
	
	

}
