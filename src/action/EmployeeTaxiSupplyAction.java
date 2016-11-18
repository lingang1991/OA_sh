package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.EmployeeOutDAO;
import service.EmployeeTaxiDAO;
import service.EmployeeTaxiSupplyDAO;
import service.impl.EmployeeOutDAOImpl;
import service.impl.EmployeeTaxiDAOImpl;
import service.impl.EmployeeTaxiSupplyDAOImpl;
import entity.EmployeeOut;
import entity.EmployeeTaxi;
import entity.EmployeeTaxiSupply;
import entity.EmployeeWork;


public class EmployeeTaxiSupplyAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查询所有对出差表操作的方法
	public String query() {
		EmployeeOutDAO edao = new EmployeeOutDAOImpl();
		List<EmployeeOut> list = edao.queryAllEmployeeOut();
		// 将查询到的资料放进session中
		if (list.size() > 0 && list != null) {
			session.setAttribute("employeeOut_list", list);
			System.out.println("类EmployeeOutAction中query()查询成功!");
		}
		System.out.println("query_success返回成功!");
		return "query_success";

	}

	public String filter() throws Exception {
		// 首先根据日期从employeetaxi中筛选出部分打车记录，将筛选出来的记录保存在新建的list中
		
				int k = 0;
				EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
				List<EmployeeTaxi> list= edao1.queryAllEmployeeTaxi();//从数据库获取数据源集合list，并按照日期的大小进行冒泡排序
				
				List<EmployeeTaxi> list3= new ArrayList<EmployeeTaxi>();//定义一个集合list3，用于保存对list进行指定日期区间过滤后的数据
				
				List<EmployeeTaxiSupply> list2= new ArrayList<EmployeeTaxiSupply>();//定义集合list2，用于保存list3中的工号、姓名和总打车费用
				
				
				
				EmployeeTaxiSupplyDAO edao = new EmployeeTaxiSupplyDAOImpl();
				List<EmployeeTaxiSupply> list1 = edao.queryAllEmployeeTaxiSupply();
			
				String etaxibeginday = request.getParameter("etaxibeginday");
				String etaxiworkendday = request.getParameter("etaxiendday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dt1 = df.parse(etaxibeginday);
				Date dt2 = df.parse(etaxiworkendday);
				System.out.println(dt1);
				System.out.println(dt2);
				
				System.out.println("从taxi中获取到了list1！");
				
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				
				for (int i = 0; i < list1.size(); i++) {
					System.out.println(list1.get(i));
				}
				
				//将list按照日期大小，冒泡排序    
		        for (int i = 0; i < list.size(); i++){  //最多做n-1趟排序
		            for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
		         	   //对当前无序区间进行排序(j的范围很关键，这个范围是在逐步缩小的)
		                if( list.get(j1).getEtaxiday().compareTo(list.get(j1+1).getEtaxiday())>0){    //把小的值交换到后面
		                	EmployeeTaxi r=list.get(j1); 
		             	   list.set(j1, list.get(j1+1));
		             	   list.set(j1+1, r);	   
		               }
		           }            
		       System.out.print("第" + (i + 1) + "次排序结果：");
		           for(int a = 0; a < list.size(); a++){
		               System.out.println(list.get(a) + "\t");
		           }
		           System.out.println("");
		       }
		           System.out.println("最终排序结果：");
		           for(int a = 0; a < list.size(); a++){
		               System.out.println(list.get(a) + "\t");
		      
		       }
		   
				
				//对list根据日期过滤记录,过滤之后的集合保存在list3
				if (list.size() > 0 && list != null) {
					EmployeeTaxi e = null;
					for (int i = 0; i < list.size(); i++) {
						e = list.get(i);
						System.out.println("list: "+e);
						if (e.getEtaxiday().compareTo(dt1) >= 0
								&& e.getEtaxiday().compareTo(dt2) <= 0) {
							e.setEid(String.valueOf(k+1));
							list3.add(e);
							System.out.println("list: "+list3.get(k));
							k++;

						}
					}
					System.out.println("list过滤之后得到的list3：");
					for (int i = 0; i < list3.size(); i++) {
						System.out.println(list3.get(i));
					}
					
				}
				
				
				
				
				
				// 从list3中提取每一项记录的工号、姓名和车费
				int m = 0, n = 0;
				String[] a = new String[list3.size()];// a数组存储list里面的工号
				String[] b = new String[list3.size()];// b数组存储list里面的姓名
				String[] c = new String[list3.size()];// c数组存储list的车费
				String[] d = new String[list3.size()];// d存储同一天加班的人员工号
				String[] name = new String[list3.size()];// name加班的人员姓名
				Double[] cost = new Double[list3.size()];// cost作为累加器存储同一人打车费用
				Double[] allcost = new Double[list3.size()];// allcost存储同一人打车总费用

				if (list3.size() > 0 && list3 != null) {
					EmployeeTaxi e = null;

					for (int i = 0; i < list3.size(); i++) {
						e = list3.get(i);
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

				for (int i = 0; i < n-1; i++) {
					System.out.println("d[n]的遍历值是：" + d[i]);// 对应着工号
					System.out.println("name[n]的遍历值是：" + name[i]);// 对应着姓名
					System.out.println("allcost[n]的遍历值是：" + allcost[i]);// 对应着总打车费用
				}

				// 将汇总后的记录保存在list2中
				
				
					for (int i = 0; i < n; i++) {
						EmployeeTaxiSupply e2 = new EmployeeTaxiSupply();
						e2.setEid(String.valueOf(i+1));
						e2.setEnumb(d[i]);
						e2.setEname(name[i]);
						e2.setEallcost(String.valueOf(allcost[i]));
						list2.add(e2);
					}
					System.out.println("从list中根据过滤出来了总费用list2！");
					session.setAttribute("EmployeeTaxiSupply_list", list2);
				
				System.out.println("类EmployeeTaxiSupplyAction中filter()过滤成功!");
				System.out.println("filter_success返回成功!");
				System.out.println("类EmployeeTaxiSupplyAction中filter()过滤成功!");

				return "filter_success";
			}
}
