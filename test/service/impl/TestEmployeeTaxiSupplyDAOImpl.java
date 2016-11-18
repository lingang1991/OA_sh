package service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import action.SuperAction;
import service.EmployeeTaxiDAO;
import service.EmployeeTaxiSupplyDAO;
import entity.EmployeeTaxi;
import entity.EmployeeTaxiSupply;

//Action类
public class TestEmployeeTaxiSupplyDAOImpl extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	public void filter() throws Exception {
		// 首先根据日期从employeetaxi中筛选出部分打车记录，将筛选出来的记录保存在新建的list中
		
		int k = 0;
		EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list= edao1.queryAllEmployeeTaxi();
		
		EmployeeTaxiSupplyDAO edao = new EmployeeTaxiSupplyDAOImpl();
		List<EmployeeTaxiSupply> list1 = edao.queryAllEmployeeTaxiSupply();
		
		System.out.println("从taxi中获取到了list1！");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// 从list中提取每一项记录的工号、姓名和车费
		int m = 0, n = 0;
		String[] a = new String[list.size()];// a数组存储list里面的工号
		String[] b = new String[list.size()];// b数组存储list里面的姓名
		String[] c = new String[list.size()];// c数组存储list的车费
		String[] d = new String[list.size()];// d存储同一天加班的人员工号
		String[] name = new String[list.size()];// name加班的人员姓名
		Double[] cost = new Double[list.size()];// cost作为累加器存储同一人打车费用
		Double[] allcost = new Double[list.size()];// allcost存储同一人打车总费用

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

		// 将提取出来的工号、姓名和车费，按工号和姓名进行费用汇总
		for (int i = 0; i < c.length - 1; i = i + m + 1) {
			System.out.println("i的值：" + i);
			System.out.println("a[i]的值：" + a[i]);
			System.out.println("b[i]的值：" + b[i]);
			cost[i] = Double.parseDouble(c[i]);
			m = 0;
			for (int j = 1 + i; j < c.length; j++) {
				if (a[i].compareTo(a[j]) == 0 && b[i].compareTo(b[j]) == 0) {
					cost[i] += Double.parseDouble(c[j]);
					m++;
				}
			}
			allcost[n] = cost[i];
			cost[i] = (double) 0;
			d[n] = a[i];
			name[n] = b[i];
			System.out.println("工号：" + d[n] + " 姓名：" + b[i] + " 打车的总费用是： "
					+ allcost[n]);
			n++;
		}
		System.out.println();

		for (int i = 0; i < d.length; i++) {
			System.out.println("d[n]的遍历值是：" + d[i]);// 对应着工号
			System.out.println("name[n]的遍历值是：" + name[i]);// 对应着姓名
			System.out.println("allcost[n]的遍历值是：" + allcost[i]);// 对应着总打车费用
		}

		// 将汇总后的记录保存在list1中
		EmployeeTaxiSupply e2 = null;
		if (list1.size() > 0 && list1 != null) {
			for (int i = 0; i < list1.size(); i++) {
				e2 = list1.get(i);
				e2.setEid(String.valueOf(i+1));
				e2.setEnumb(d[i]);
				e2.setEname(name[i]);
				e2.setEallcost(String.valueOf(allcost[i]));
				list1.set(i, e2);
			}
			System.out.println("从list中根据过滤出来了总费用list1！");
			session.setAttribute("EmployeeTaxiSupply_list", list1);
		} else {
			System.out.println("TaxiAction中查询到的list为空值");
		}
		System.out.println("类EmployeeTaxiSupplyAction中filter()过滤成功!");
		System.out.println("filter_success返回成功!");
		System.out.println("类EmployeeTaxiSupplyAction中filter()过滤成功!");

		//return "filter_success";

	}

}
	
	
