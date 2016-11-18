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

//Action类
public class EmployeeTaxiAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查询所有对打车表操作的方法
	public String query() {
		// 查询所有的打车记录
		EmployeeTaxiDAO edao = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list = edao.queryAllEmployeeTaxi();
		// 将查询到的资料放进session中
		if (list.size() > 0 && list != null) {
			session.setAttribute("EmployeeTaxi_list", list);
			System.out.println("类EmployeeRestAction中query()查询成功!");
		}
		System.out.println("query_success返回成功!");
		return "query_success";

	}

	public String delete() {
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeTaxi(eid);
		System.out.println("类EmployeeTaxiAction中delete()删除成功！");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		EmployeeTaxi s = new EmployeeTaxi();

		// eid自动生成
		// s.setEid(request.getParameter("eid"));
		// System.out.println(s.getEid());

		s.setEnumb(request.getParameter("enumb"));
	
		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setEtaxiday(sdf.parse(request.getParameter("etaxiday")));
		
		s.setEtaxigo(request.getParameter("etaxigo"));
		
		s.setEtaxicost(request.getParameter("etaxicost"));

	

		sdao.addEmployeeTaxi(s);

		System.out.println("类EmployeeTaxiAction中add()执行成功！,返回了'add_success'");
		return "add_success";

	}

	// 修改学生资料的动作
	public String modify() {
		// 获取传递过来的学生sid
		String eid = request.getParameter("eid");
		EmployeeTaxiDAO sdao = new EmployeeTaxiDAOImpl();
		EmployeeTaxi s = sdao.queryEmployeeTaxiByEid(eid);
		// 保存在会话中
		session.setAttribute("modify_EmployeeTaxi", s);
		return "modify_success";
	}

	// 保存学生资料的动作
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
		System.out.println("类EmployeeTaxiAction中save()执行成功！,返回了'saves_success'");

		return "save_success";

	}
	
	public String filter() throws Exception {
		
		// 查询所有的打车记录
		EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list = edao1.queryAllEmployeeTaxi();
		int m = 0,n=0;//m用作迭代步长，n用作处理后的数据存储维度
		String[] a = new String[list.size()];//a数组存储list里面的工号
		String[] b = new String[list.size()];//b数组存储list里面的姓名 
		String[] c = new String[list.size()];//c数组存储list的车费
		String[] d = new String[list.size()];//d存储同一天加班的人员工号
		String[] name = new String[list.size()];//name加班的人员姓名
		Double[] cost = new Double[list.size()];//cost作为累加器存储同一人打车费用
		Double[] allcost = new Double[list.size()];//allcost存储同一人打车总费用
	
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
			System.out.println("i的值："+i);
			System.out.println("a[i]的值："+a[i]);
			System.out.println("b[i]的值："+b[i]);
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
				System.out.println("工号："+d[n]+" 姓名："+b[i]+" 打车的总费用是： " + allcost[n]);
				n++;		
		}
		System.out.println();
		
		for (int i = 0; i < d.length; i++) {		
			System.out.println("d[n]的遍历值是："+d[i]);//对应着工号
			System.out.println("name[n]的遍历值是："+name[i]);//对应着姓名
			System.out.println("allcost[n]的遍历值是："+allcost[i]);//对应着总打车费用
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
			System.out.println("TaxiAction中查询到的list为空值");
		}
		System.out.println("类EmployeeTaxiAction中filter()过滤成功!");
		System.out.println("filter_success返回成功!");
		return "filter_success";
		
		
		
	}
	
	
	

}
