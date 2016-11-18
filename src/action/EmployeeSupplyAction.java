package action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.EmployeeSupplyDAO;
import service.EmployeeWorkDAO;
import service.impl.EmployeeSupplyDAOImpl;
import service.impl.EmployeeWorkDAOImpl;
import entity.EmployeeSupply;
import entity.EmployeeWork;

//Action类
public class EmployeeSupplyAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 查询所有对出差表操作的方法
	public String query() {
		// 查询所有的加班记录
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao1.queryAllEmployeeWork();
		//将list按照日期大小，冒泡排序       
        for (int i = 0; i < list.size(); i++){  //最多做n-1趟排序
            for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
         	   //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
         	  
                if( list.get(j1).getEworkday().compareTo(list.get(j1+1).getEworkday())>0){    //把小的值交换到后面
             	   EmployeeWork r=list.get(j1); 
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
		for (int i = 0; i < n; i++) {		
			System.out.println("d[n]的遍历值是："+d[i]);//对应着工号
			System.out.println("name[n]的遍历值是："+name[i]);//对应着姓名
			System.out.println("day[n]的遍历值是："+day[i]);//对应着日期
		}
		
		List<EmployeeSupply> list3 = new ArrayList<EmployeeSupply>();
		
			for (int i = 0; i < n; i++) {
				EmployeeSupply e2 = new EmployeeSupply();
				e2.setSid(String.valueOf(i+1));
				e2.setSenum(d[i]);
				e2.setSename(name[i]);
				e2.setSday(day[i]);
				//判断一次加班的有多少人
				String str =d[i];
				String str1 = "、";
				int count = 0;
				int start = 0;
				while (str.indexOf(str1, start) >= 0 && start < str.length()) {
					count++;
					start = str.indexOf(str1, start) + str1.length();
				}
				e2.setSnumbs(count+1);
				e2.setScooperate("否");
				e2.setStimes(1);
				e2.setSreimburse((count+1)*30);
				e2.setSholiday("否");
				e2.setSreason("产品研发加班");
				list3.add(e2);
			}
			
			
			System.out.println("list3:"+list3.toString());
			session.setAttribute("EmployeeSupply_list",list3);
		System.out.println("类EmployeeSupplyAction中query()查询成功!");
		System.out.println("query_success返回成功!");
		return "query_success";
	}

	public String filter() throws Exception {
		EmployeeSupply list_filter=null;
			
		String[] title = {"序号","报销金额","用餐人数","用餐次数","是否有外部协作单位","用餐人员员工编号","用餐人员姓名","日期","是否假期","工作事由"};
			
		String eworkbeginday = request.getParameter("eworkbeginday");
		String eworkendday = request.getParameter("eworkendday");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File("C:/员工管理/员工加班/员工餐补.xls");
		file.createNewFile();
		int j = 1;
	//创建工作簿
    WritableWorkbook workbook = Workbook.createWorkbook(file);
    //创建sheet1页
    WritableSheet sheet = workbook.createSheet("sheet1", 0);
	//往sheet1中添加数据
    //第一行设置列名，即表头
    Label label=null;
    for (int i = 0; i < title.length; i++) {
		label = new Label(i, 0,title[i]);//三个参数：第i列，第一行，名称
		sheet.addCell(label);
	}
		try {
			Date dt1 = df.parse(eworkbeginday);
			Date dt2 = df.parse(eworkendday);
			System.out.println(dt1);
			System.out.println(dt2);

			// 查询所有的加班记录
			EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
			List<EmployeeWork> list = edao1.queryAllEmployeeWork();
		
			//将list按照日期大小，冒泡排序       
				           for (int i = 0; i < list.size(); i++){  //最多做n-1趟排序
				               for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
				            	   //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
				            	  
				                   if( list.get(j1).getEworkday().compareTo(list.get(j1+1).getEworkday())>0){    //把小的值交换到后面
				                	   EmployeeWork r=list.get(j1); 
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
					for (int j1 = 1 + i; j1 < c.length; j1++) {
						if (c[i].compareTo(c[j1]) == 0) {
							
							senumbs.append("、");
							senumbs.append(a[j1]);
							senames.append("、");
							senames.append(b[j1]);
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
				System.out.println("d[n]的遍历值是："+d[i]);//对应着工号
				System.out.println("name[n]的遍历值是："+name[i]);//对应着姓名
				System.out.println("day[n]的遍历值是："+day[i]);//对应着日期
			}
			
			List<EmployeeSupply> list3 = new ArrayList<EmployeeSupply>();
			
			
			for (int i = 0; i < n; i++) {
				EmployeeSupply e2 = new EmployeeSupply();
					e2.setSid(String.valueOf(i+1));
					e2.setSenum(d[i]);
					e2.setSename(name[i]);
					e2.setSday(day[i]);
					String str =d[i];
					String str1 = "、";
					int count = 0;
					int start = 0;
					while (str.indexOf(str1, start) >= 0 && start < str.length()) {
						count++;
						start = str.indexOf(str1, start) + str1.length();
					}
					e2.setSnumbs(count+1);
					e2.setScooperate("否");
					e2.setStimes(1);
					e2.setSreimburse((count+1)*30);
					e2.setSholiday("否");
					e2.setSreason("产品研发加班");
					list3.add(e2);
				}
			
			
			// 将查询到的资料放进session中
			if (list3.size() > 0 && list3 != null) {
				for (EmployeeSupply e : list3) {
					if (e.getSday().compareTo(dt1) >= 0
							&& e.getSday().compareTo(dt2) <= 0) {
						list_filter = e;
						System.out.println("list_filter的for过滤："+list_filter.toString());					
						 //追加数据
						
							label = new Label(0, j, list_filter.getSid());
							sheet.addCell(label);
							
							
							label = new Label(1, j, String.valueOf(list_filter.getSreimburse()));
							sheet.addCell(label);
							
							label = new Label(2, j, String.valueOf(list_filter.getSnumbs()));
							sheet.addCell(label);
							
							label = new Label(3, j, String.valueOf(list_filter.getStimes()));
							sheet.addCell(label);
							
							label = new Label(4, j, list_filter.getScooperate());
							sheet.addCell(label);
							
							label = new Label(5, j, list_filter.getSenum());
							sheet.addCell(label);
							
							label = new Label(6, j, list_filter.getSename());
							sheet.addCell(label);
							
							java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
							String date = formatter.format(list_filter.getSday());
							label = new Label(7, j, date);
							sheet.addCell(label);
							
							label = new Label(8, j, list_filter.getSholiday());
							sheet.addCell(label);
							
							label = new Label(9, j, list_filter.getSreason());
							sheet.addCell(label);
							
							j++;
						
						System.out.println("类EmployeeSupplyAction中filter()查询成功!");
					}
				}
				
			}

			System.out.println("类EmployeeSupplyAction中filter()过滤成功!");

		} catch (Exception e) {
			System.out.println("WorkAction中删选方法中，日期转换出错！");
			e.printStackTrace();
		}	
		//进行写操作
	    workbook.write();
	    //关闭流
	    workbook.close();
		System.out.println("filter_success返回成功!");
		return "filter_success";

	}


	public String delete() {
		EmployeeSupplyDAO sdao = new EmployeeSupplyDAOImpl();
		String eid = request.getParameter("sid");
		sdao.deleteEmployeeSupply(eid);
		System.out.println("类EmployeeSupplyAction中delete()删除成功！");
		return "delete_success";
	}

	
}
