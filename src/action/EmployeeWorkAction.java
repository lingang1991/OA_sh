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

//Action��
public class EmployeeWorkAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��ѯ���жԳ��������ķ���
	public String query() {
		EmployeeWorkDAO edao = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao.queryAllEmployeeWork();
		// ����ѯ�������ϷŽ�session��
		if (list.size() > 0 && list != null) {
			session.setAttribute("employeeWork_list", list);
			System.out.println("��EmployeeWorkAction��query()��ѯ�ɹ�!");
		}
		System.out.println("query_success���سɹ�!");
		return "query_success";
	}

	public String delete() {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		String eid = request.getParameter("eid");
		sdao.deleteEmployeeWork(eid);
		System.out.println("��EmployeeWorkAction��delete()ɾ���ɹ���");
		return "delete_success";

	}

	public String add() throws Exception {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		EmployeeWork s = new EmployeeWork();

		// eid�Զ�����
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

		System.out.println("��EmployeeOutAction��add()ִ�гɹ���,������'add_success'");
		return "add_success";

	}

	// �޸�ѧ�����ϵĶ���
	public String modify() {
		// ��ȡ���ݹ�����ѧ��sid
		String eid = request.getParameter("eid");
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		EmployeeWork s = sdao.queryEmployeeWorkByEid(eid);
		// �����ڻỰ��
		session.setAttribute("modify_EmployeeWork", s);
		return "modify_success";
	}

	// ����ѧ�����ϵĶ���
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
				.println("��EmployeeWorkAction��save()ִ�гɹ���,������'saves_success'");

		return "save_success";

	}

	public String filter() throws Exception {
		EmployeeWork list_filter=null;
		String[] title = {"����","����","�Ӱ�����","�Ӱ�ʱ���","�Ӱ�ʱ��","�Ӱ����","�Ӱ�ص�","�Ӱ�ɹ�"};
			
		String eworkbeginday = request.getParameter("eworkbeginday");
		String eworkendday = request.getParameter("eworkendday");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File("C:/Ա������/Ա���Ӱ�/Ա���Ӱ༰������ٱ�.xls");
		file.createNewFile();
		int j = 1;
	//����������
    WritableWorkbook workbook = Workbook.createWorkbook(file);
    //����sheet1ҳ
    WritableSheet sheet = workbook.createSheet("sheet1", 0);
	//��sheet1���������
    //��һ����������������ͷ
    Label label=null;
    for (int i = 0; i < title.length; i++) {
		label = new Label(i, 0,title[i]);//������������i�У���һ�У�����
		sheet.addCell(label);
	}
		try {
			Date dt1 = df.parse(eworkbeginday);
			Date dt2 = df.parse(eworkendday);
			System.out.println(dt1);
			System.out.println(dt2);

			EmployeeWorkDAO edao = new EmployeeWorkDAOImpl();
			List<EmployeeWork> list = edao.queryAllEmployeeWork();
			
			// ����ѯ�������ϷŽ�session��
			if (list.size() > 0 && list != null) {
				for (EmployeeWork e : list) {
					if (e.getEworkday().compareTo(dt1) >= 0
							&& e.getEworkday().compareTo(dt2) <= 0) {
						list_filter = e;
						System.out.println("list_filter��for���ˣ�"+list_filter.toString());					
						 //׷������
						
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
						
						System.out.println("��EmployeeWorkAction��filter()��ѯ�ɹ�!");
					}
				}
				
			}

			System.out.println("��EmployeeWorkAction��filter()���˳ɹ�!");

		} catch (Exception e) {
			System.out.println("WorkAction��ɾѡ�����У�����ת������");
			e.printStackTrace();
		}	
		//����д����
	    workbook.write();
	    //�ر���
	    workbook.close();
		System.out.println("query_success���سɹ�!");
		return "filter_success";

	}
	
	public String importModel() throws Exception {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		

		 try{   	  
	            Workbook book  =  Workbook.getWorkbook( new  File( "C:/Ա������/Ա���Ӱ�/Ա���Ӱ༰������ٱ�.xls" ));   
	            //  ��õ�һ�����������    
	            Sheet sheet  =  book.getSheet(0);   
	           
	            //  �õ���j�е�i�еĵ�Ԫ�� 
	            for (int i = 1; i < sheet.getRows(); i++) { 
	            	
	        		System.out.println("ִ���ˣ�");
	        		EmployeeWork s = new EmployeeWork();
	        		
	            		    Cell cell_0  =  sheet.getCell( 0 ,  i );//��һ��������ʾ�У��ڶ���������ʾ��
	            		    s.setEid(cell_0.getContents());
	            		    System.out.println(cell_0.getContents()+"�Ѿ����룡");
	            		    
	            		    Cell cell_1  =  sheet.getCell( 1 ,  i );
	            		    s.setEnumb(cell_1.getContents());
	            		    System.out.println(cell_1.getContents()+"�Ѿ����룡");

	            		    Cell cell_2  =  sheet.getCell( 2 ,  i );
	            			s.setEname(cell_2.getContents());
	            			System.out.println(cell_2.getContents()+"�Ѿ����룡");
	            			
	            			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	            			Cell cell_3  =  sheet.getCell( 3 ,  i );
	            			s.setEworkday(sdf.parse(cell_3.getContents()));
	            			System.out.println(cell_3.getContents()+"�Ѿ����룡");
	            			
	            			Cell cell_4  =  sheet.getCell( 4 ,  i );
	            			s.setEworktime(cell_4.getContents());
	            			System.out.println(cell_4.getContents()+"�Ѿ����룡");
 
	            			Cell cell_5  =  sheet.getCell( 5 ,  i );
	            			s.setEworkhours(cell_5.getContents());
	            			System.out.println(cell_5.getContents()+"�Ѿ����룡");

	            			Cell cell_6 =  sheet.getCell( 6 ,  i );
	            			s.setEworkcity(cell_6.getContents());
	            			System.out.println(cell_6.getContents()+"�Ѿ����룡");

	            			Cell cell_7  =  sheet.getCell( 7,  i );
	            			s.setEworklocation(cell_7.getContents());
	            			System.out.println(cell_7.getContents()+"�Ѿ����룡");

	            			Cell cell_8  =  sheet.getCell( 8 ,  i );
	            			s.setEworkcontent(cell_8.getContents());
	            			System.out.println(cell_8.getContents()+"�Ѿ����룡");

	            			sdao.addEmployeeWork(s);
	            			System.out.println("��EmployeeWorkAction��importModel() ִ�гɹ���,������'add_success'");
	            	   }   
	           book.close();   
	       }catch  (Exception e){   
	           System.out.println("��EmployeeWorkAction��importModel() ִ��ʧ�ܣ�");
	       }    
		return "import_prepare";
	}

}
