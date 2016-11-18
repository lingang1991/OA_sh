package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import action.SuperAction;
import service.EmployeeSupplyDAO;
import service.EmployeeWorkDAO;
import service.impl.EmployeeSupplyDAOImpl;
import service.impl.EmployeeWorkDAOImpl;
import entity.EmployeeWork;

//Action类
public class TestEmployeeSupplyDAOImpl extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	// 查询所有对出差表操作的方法
	public void query() {
		// 查询所有的加班记录
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao1.queryAllEmployeeWork();
		StringBuilder senumbs = new StringBuilder();
		int m = 0,n=0;
		StringBuilder senames = new StringBuilder();
		String[] a = new String[list.size()];//a数组存储list里面的工号
		String[] b = new String[list.size()];//b数组存储list里面的姓名 
		Date[] c = new Date[list.size()];//c数组存储list的日期
		Date[] day = new Date[list.size()];//day存储不重复的日期
		String[] d = new String[list.size()];//d存储同一天加班的人员工号
		String[] name = new String[list.size()];//name存储同一天加班的人员姓名
		// 将查询到资料的名字和工号放进两个StringBuilder中，便于拼接
		if (list.size() > 0 && list != null) {
			EmployeeWork e = null;

			for (int i = 0; i < list.size(); i++) {
				e = list.get(i);
				a[i] = e.getEnumb();
				b[i] = e.getEname();
				c[i] = e.getEworkday();
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
			senumbs.append(a[i]);
			senames.append(b[i]);
			System.out.println("a[i]的值："+a[i]);
			System.out.println("b[i]的值："+b[i]);
			m=0;
				for (int j = 1 + i; j < c.length; j++) {
					if (c[i].compareTo(c[j]) == 0) {
						
						senumbs.append("、");
						senumbs.append(a[j]);
						senames.append("、");
						senames.append(b[j]);
						m++;	
					}
				}
				System.out.println("senmbs的值是： " + senumbs);
				System.out.println("senames的值是： " + senames);
				d[n]=senumbs.toString();
				name[n]=senames.toString();
				day[n] = c[i];
				senumbs.delete(0,senumbs.length());
				senames.delete(0,senames.length());
				System.out.println("d[n]的值是： " + d[n]);
				System.out.println("name[n]的值是： " + name[n]);
				n++;		
		}
		System.out.println();
		for (int i = 0; i < d.length; i++) {
			
			System.out.println("d[n]的遍历值是："+d[i]);
			System.out.println("name[n]的遍历值是："+name[i]);
			System.out.println("day[n]的遍历值是："+day[i]);
		}
		System.out.println("类EmployeeSupplyAction中query()查询成功!");
		System.out.println("query_success返回成功!");
	}

	public String midify() {
		StringBuilder senumbs = new StringBuilder();
		StringBuilder senames = new StringBuilder();
		EmployeeWork list_filter = null;
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list1 = edao1.queryAllEmployeeWork();

		// 将查询到资料的名字和工号放进两个StringBuilder中，便于拼接

		if (list1.size() > 0 && list1 != null) {

			/*
			 * for(EmployeeWork e : list){ }的重写
			 */
			EmployeeWork e = null;
			for (int i = 0; i < list1.size() - 1; i++) {
				e = list1.get(i);
				list_filter = e;
				senumbs.append(list_filter.getEnumb());
				senumbs.append("、");
				senames.append(list_filter.getEname());
				senames.append("、");
			}

			// 设计最后一个字段
			e = list1.get(list1.size() - 1);
			list_filter = e;
			senumbs.append(list_filter.getEnumb());
			senames.append(list_filter.getEname());
		}

		System.out.println(senames);
		System.out.println(senumbs);
		List<StringBuilder> list_s = new ArrayList<StringBuilder>();
		System.out.println(senames);
		System.out.println(senumbs);
		list_s.add(senames);
		list_s.add(senumbs);
		session.setAttribute("EmployeeSupply_list", list_s);
		System.out.println(session);
		System.out.println("类EmployeeSupplyAction中query()查询成功!");
		System.out.println("query_success返回成功!");
		return "query_success";
	}

	public String delete() {
		EmployeeSupplyDAO sdao = new EmployeeSupplyDAOImpl();
		String eid = request.getParameter("sid");
		sdao.deleteEmployeeSupply(eid);
		System.out.println("类EmployeeSupplyAction中delete()删除成功！");
		return "delete_success";
	}

}
