package action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.EmployeeWorkDAO;
import service.impl.EmployeeWorkDAOImpl;
import entity.EmployeeWork;

//Action类
public class EmployeeWorkAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查询所有对出差表操作的方法
	public String query() {
		EmployeeWorkDAO edao = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao.queryAllEmployeeWork();
		// 将查询到的资料放进session中
		if (list.size() > 0 && list != null) {
			session.setAttribute("employeeWork_list", list);
			System.out.println("类EmployeeWorkAction中query()查询成功!");
		}
		System.out.println("query_success返回成功!");
		return "query_success";
	}

	public String delete() {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeWork(eid);
		System.out.println("类EmployeeWorkAction中delete()删除成功！");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		EmployeeWork s = new EmployeeWork();

		// eid自动生成
		// s.setEid(request.getParameter("eid"));
		// System.out.println(s.getEid());

		s.setEnumb(request.getParameter("enumb"));
		;

		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setEworkday(sdf.parse(request.getParameter("eworkday")));

		s.setEworktime(request.getParameter("eworktime"));

		s.setEworkhours(request.getParameter("eworkhours"));

		s.setEworkcity(request.getParameter("eworkcity"));

		s.setEworklocation(request.getParameter("eworklocation"));

		s.setEworkcontent(request.getParameter("eworkcontent"));

		sdao.addEmployeeWork(s);

		System.out.println("类EmployeeOutAction中add()执行成功！,返回了'add_success'");
		return "add_success";

	}

	// 修改学生资料的动作
	public String modify() {
		// 获取传递过来的学生sid
		String eid = request.getParameter("eid");
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		EmployeeWork s = sdao.queryEmployeeWorkByEid(eid);
		// 保存在会话中
		session.setAttribute("modify_EmployeeWork", s);
		return "modify_success";
	}

	// 保存学生资料的动作
	public String save() throws IOException, ParseException {

		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		EmployeeWork s = new EmployeeWork();

		s.setEid(request.getParameter("eid"));

		s.setEnumb(request.getParameter("enumb"));

		s.setEname(request.getParameter("ename"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setEworkday(sdf.parse(request.getParameter("eworkday")));

		s.setEworktime(request.getParameter("eworktime"));

		s.setEworkhours(request.getParameter("eworkhours"));

		s.setEworkcity(request.getParameter("eworkcity"));

		s.setEworklocation(request.getParameter("eworklocation"));

		s.setEworkcontent(request.getParameter("eworkcontent"));

		sdao.updateEmployeeWork(s);
		System.out
				.println("类EmployeeWorkAction中save()执行成功！,返回了'saves_success'");

		return "save_success";

	}

	public String filter() throws Exception {
		EmployeeWork list_filter=null;
		String[] title = {"工号","姓名","加班日期","加班时间段","加班时长","加班城市","加班地点","加班成果"};
			
		String eworkbeginday = request.getParameter("eworkbeginday");
		String eworkendday = request.getParameter("eworkendday");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File("C:/员工管理/员工加班/员工加班及出差跟踪表.xls");
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

			EmployeeWorkDAO edao = new EmployeeWorkDAOImpl();
			List<EmployeeWork> list = edao.queryAllEmployeeWork();
			
			// 将查询到的资料放进session中
			if (list.size() > 0 && list != null) {
				for (EmployeeWork e : list) {
					if (e.getEworkday().compareTo(dt1) >= 0
							&& e.getEworkday().compareTo(dt2) <= 0) {
						list_filter = e;
						System.out.println("list_filter的for过滤："+list_filter.toString());					
						 //追加数据
						
							label = new Label(0, j, list_filter.getEnumb());
							sheet.addCell(label);
							
							label = new Label(1, j, list_filter.getEname());
							sheet.addCell(label);
							
							java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
							String date = formatter.format(list_filter.getEworkday());
							label = new Label(2, j, date);
							sheet.addCell(label);
							
							label = new Label(3, j, list_filter.getEworktime());
							sheet.addCell(label);
							
							label = new Label(4, j, list_filter.getEworkhours());
							sheet.addCell(label);
							
							label = new Label(5, j, list_filter.getEworkcity());
							sheet.addCell(label);
							
							label = new Label(6, j, list_filter.getEworklocation());
							sheet.addCell(label);
							
							label = new Label(7, j, list_filter.getEworkcontent());
							sheet.addCell(label);
							j++;
						
						System.out.println("类EmployeeWorkAction中filter()查询成功!");
					}
				}
				
			}

			System.out.println("类EmployeeWorkAction中filter()过滤成功!");

		} catch (Exception e) {
			System.out.println("WorkAction中删选方法中，日期转换出错！");
			e.printStackTrace();
		}	
		//进行写操作
	    workbook.write();
	    //关闭流
	    workbook.close();
		System.out.println("query_success返回成功!");
		return "filter_success";

	}
	
	public String importModel() throws Exception {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		

		 try{   	  
	            Workbook book  =  Workbook.getWorkbook( new  File( "C:/员工管理/员工加班/员工加班及出差跟踪表.xls" ));   
	            //  获得第一个工作表对象    
	            Sheet sheet  =  book.getSheet(0);   
	           
	            //  得到第j列第i行的单元格 
	            for (int i = 1; i < sheet.getRows(); i++) { 
	            	
	        		System.out.println("执行了！");
	        		EmployeeWork s = new EmployeeWork();
	        		
	            		    Cell cell_0  =  sheet.getCell( 0 ,  i );//第一个参数表示列，第二个参数表示行
	            		    s.setEid(cell_0.getContents());
	            		    System.out.println(cell_0.getContents()+"已经插入！");
	            		    
	            		    Cell cell_1  =  sheet.getCell( 1 ,  i );
	            		    s.setEnumb(cell_1.getContents());
	            		    System.out.println(cell_1.getContents()+"已经插入！");

	            		    Cell cell_2  =  sheet.getCell( 2 ,  i );
	            			s.setEname(cell_2.getContents());
	            			System.out.println(cell_2.getContents()+"已经插入！");
	            			
	            			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	            			Cell cell_3  =  sheet.getCell( 3 ,  i );
	            			s.setEworkday(sdf.parse(cell_3.getContents()));
	            			System.out.println(cell_3.getContents()+"已经插入！");
	            			
	            			Cell cell_4  =  sheet.getCell( 4 ,  i );
	            			s.setEworktime(cell_4.getContents());
	            			System.out.println(cell_4.getContents()+"已经插入！");
 
	            			Cell cell_5  =  sheet.getCell( 5 ,  i );
	            			s.setEworkhours(cell_5.getContents());
	            			System.out.println(cell_5.getContents()+"已经插入！");

	            			Cell cell_6 =  sheet.getCell( 6 ,  i );
	            			s.setEworkcity(cell_6.getContents());
	            			System.out.println(cell_6.getContents()+"已经插入！");

	            			Cell cell_7  =  sheet.getCell( 7,  i );
	            			s.setEworklocation(cell_7.getContents());
	            			System.out.println(cell_7.getContents()+"已经插入！");

	            			Cell cell_8  =  sheet.getCell( 8 ,  i );
	            			s.setEworkcontent(cell_8.getContents());
	            			System.out.println(cell_8.getContents()+"已经插入！");

	            			sdao.addEmployeeWork(s);
	            			System.out.println("类EmployeeWorkAction中importModel() 执行成功！,返回了'add_success'");
	            	   }   
	           book.close();   
	       }catch  (Exception e){   
	           System.out.println("类EmployeeWorkAction中importModel() 执行失败！");
	       }    
		return "import_prepare";
	}

}
