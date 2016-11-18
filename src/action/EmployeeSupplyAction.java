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

//Action��
public class EmployeeSupplyAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ��ѯ���жԳ��������ķ���
	public String query() {
		// ��ѯ���еļӰ��¼
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao1.queryAllEmployeeWork();
		//��list�������ڴ�С��ð������       
        for (int i = 0; i < list.size(); i++){  //�����n-1������
            for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
         	   //�Ե�ǰ��������score[0......length-i-1]��������(j�ķ�Χ�ܹؼ��������Χ��������С��)
         	  
                if( list.get(j1).getEworkday().compareTo(list.get(j1+1).getEworkday())>0){    //��С��ֵ����������
             	   EmployeeWork r=list.get(j1); 
             	   list.set(j1, list.get(j1+1));
             	   list.set(j1+1, r);	   
               }
           }            
       System.out.print("��" + (i + 1) + "����������");
           for(int a = 0; a < list.size(); a++){
               System.out.println(list.get(a) + "\t");
           }
           System.out.println("");
       }
           System.out.println("������������");
           for(int a = 0; a < list.size(); a++){
               System.out.println(list.get(a) + "\t");
      
       }
   
		StringBuilder senumbs = new StringBuilder();
		int m = 0,n=0;
		StringBuilder senames = new StringBuilder();
		String[] a = new String[list.size()];//a����洢list����Ĺ���
		String[] b = new String[list.size()];//b����洢list��������� 
		Date[] c = new Date[list.size()];//c����洢list������
		Date[] day = new Date[list.size()];//day�洢���ظ�������
		String[] d = new String[list.size()];//d�洢ͬһ��Ӱ����Ա����
		String[] name = new String[list.size()];//name�洢ͬһ��Ӱ����Ա����
		// ����ѯ�����ϵ����ֺ͹��ŷŽ�����StringBuilder�У�����ƴ��
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
			System.out.println("i��ֵ��"+i);
			senumbs.append(a[i]);
			senames.append(b[i]);
			System.out.println("a[i]��ֵ��"+a[i]);
			System.out.println("b[i]��ֵ��"+b[i]);
			m=0;
				for (int j = 1 + i; j < c.length; j++) {
					if (c[i].compareTo(c[j]) == 0) {
						
						senumbs.append("��");
						senumbs.append(a[j]);
						senames.append("��");
						senames.append(b[j]);
						m++;	
					}
				}
				System.out.println("senmbs��ֵ�ǣ� " + senumbs);
				System.out.println("senames��ֵ�ǣ� " + senames);
				d[n]=senumbs.toString();
				name[n]=senames.toString();
				day[n] = c[i];
				senumbs.delete(0,senumbs.length());
				senames.delete(0,senames.length());
				System.out.println("d[n]��ֵ�ǣ� " + d[n]);
				System.out.println("name[n]��ֵ�ǣ� " + name[n]);
				n++;		
		}
		System.out.println();
		for (int i = 0; i < n; i++) {		
			System.out.println("d[n]�ı���ֵ�ǣ�"+d[i]);//��Ӧ�Ź���
			System.out.println("name[n]�ı���ֵ�ǣ�"+name[i]);//��Ӧ������
			System.out.println("day[n]�ı���ֵ�ǣ�"+day[i]);//��Ӧ������
		}
		
		List<EmployeeSupply> list3 = new ArrayList<EmployeeSupply>();
		
			for (int i = 0; i < n; i++) {
				EmployeeSupply e2 = new EmployeeSupply();
				e2.setSid(String.valueOf(i+1));
				e2.setSenum(d[i]);
				e2.setSename(name[i]);
				e2.setSday(day[i]);
				//�ж�һ�μӰ���ж�����
				String str =d[i];
				String str1 = "��";
				int count = 0;
				int start = 0;
				while (str.indexOf(str1, start) >= 0 && start < str.length()) {
					count++;
					start = str.indexOf(str1, start) + str1.length();
				}
				e2.setSnumbs(count+1);
				e2.setScooperate("��");
				e2.setStimes(1);
				e2.setSreimburse((count+1)*30);
				e2.setSholiday("��");
				e2.setSreason("��Ʒ�з��Ӱ�");
				list3.add(e2);
			}
			
			
			System.out.println("list3:"+list3.toString());
			session.setAttribute("EmployeeSupply_list",list3);
		System.out.println("��EmployeeSupplyAction��query()��ѯ�ɹ�!");
		System.out.println("query_success���سɹ�!");
		return "query_success";
	}

	public String filter() throws Exception {
		EmployeeSupply list_filter=null;
			
		String[] title = {"���","�������","�ò�����","�òʹ���","�Ƿ����ⲿЭ����λ","�ò���ԱԱ�����","�ò���Ա����","����","�Ƿ����","��������"};
			
		String eworkbeginday = request.getParameter("eworkbeginday");
		String eworkendday = request.getParameter("eworkendday");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File("C:/Ա������/Ա���Ӱ�/Ա���Ͳ�.xls");
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

			// ��ѯ���еļӰ��¼
			EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
			List<EmployeeWork> list = edao1.queryAllEmployeeWork();
		
			//��list�������ڴ�С��ð������       
				           for (int i = 0; i < list.size(); i++){  //�����n-1������
				               for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
				            	   //�Ե�ǰ��������score[0......length-i-1]��������(j�ķ�Χ�ܹؼ��������Χ��������С��)
				            	  
				                   if( list.get(j1).getEworkday().compareTo(list.get(j1+1).getEworkday())>0){    //��С��ֵ����������
				                	   EmployeeWork r=list.get(j1); 
				                	   list.set(j1, list.get(j1+1));
				                	   list.set(j1+1, r);	   
				                  }
				              }            
			              System.out.print("��" + (i + 1) + "����������");
				              for(int a = 0; a < list.size(); a++){
				                  System.out.println(list.get(a) + "\t");
				              }
				              System.out.println("");
				          }
				              System.out.println("������������");
				              for(int a = 0; a < list.size(); a++){
				                  System.out.println(list.get(a) + "\t");
				         
				          }
				      
			      
		
		
			
			
			StringBuilder senumbs = new StringBuilder();
			int m = 0,n=0;
			StringBuilder senames = new StringBuilder();
			String[] a = new String[list.size()];//a����洢list����Ĺ���
			String[] b = new String[list.size()];//b����洢list��������� 
			Date[] c = new Date[list.size()];//c����洢list������
			Date[] day = new Date[list.size()];//day�洢���ظ�������
			String[] d = new String[list.size()];//d�洢ͬһ��Ӱ����Ա����
			String[] name = new String[list.size()];//name�洢ͬһ��Ӱ����Ա����
			// ����ѯ�����ϵ����ֺ͹��ŷŽ�����StringBuilder�У�����ƴ��
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
				System.out.println("i��ֵ��"+i);
				senumbs.append(a[i]);
				senames.append(b[i]);
				System.out.println("a[i]��ֵ��"+a[i]);
				System.out.println("b[i]��ֵ��"+b[i]);
				m=0;
					for (int j1 = 1 + i; j1 < c.length; j1++) {
						if (c[i].compareTo(c[j1]) == 0) {
							
							senumbs.append("��");
							senumbs.append(a[j1]);
							senames.append("��");
							senames.append(b[j1]);
							m++;	
						}
					}
					System.out.println("senmbs��ֵ�ǣ� " + senumbs);
					System.out.println("senames��ֵ�ǣ� " + senames);
					d[n]=senumbs.toString();
					name[n]=senames.toString();
					day[n] = c[i];
					senumbs.delete(0,senumbs.length());
					senames.delete(0,senames.length());
					System.out.println("d[n]��ֵ�ǣ� " + d[n]);
					System.out.println("name[n]��ֵ�ǣ� " + name[n]);
					n++;		
			}
			System.out.println();
			for (int i = 0; i < d.length; i++) {		
				System.out.println("d[n]�ı���ֵ�ǣ�"+d[i]);//��Ӧ�Ź���
				System.out.println("name[n]�ı���ֵ�ǣ�"+name[i]);//��Ӧ������
				System.out.println("day[n]�ı���ֵ�ǣ�"+day[i]);//��Ӧ������
			}
			
			List<EmployeeSupply> list3 = new ArrayList<EmployeeSupply>();
			
			
			for (int i = 0; i < n; i++) {
				EmployeeSupply e2 = new EmployeeSupply();
					e2.setSid(String.valueOf(i+1));
					e2.setSenum(d[i]);
					e2.setSename(name[i]);
					e2.setSday(day[i]);
					String str =d[i];
					String str1 = "��";
					int count = 0;
					int start = 0;
					while (str.indexOf(str1, start) >= 0 && start < str.length()) {
						count++;
						start = str.indexOf(str1, start) + str1.length();
					}
					e2.setSnumbs(count+1);
					e2.setScooperate("��");
					e2.setStimes(1);
					e2.setSreimburse((count+1)*30);
					e2.setSholiday("��");
					e2.setSreason("��Ʒ�з��Ӱ�");
					list3.add(e2);
				}
			
			
			// ����ѯ�������ϷŽ�session��
			if (list3.size() > 0 && list3 != null) {
				for (EmployeeSupply e : list3) {
					if (e.getSday().compareTo(dt1) >= 0
							&& e.getSday().compareTo(dt2) <= 0) {
						list_filter = e;
						System.out.println("list_filter��for���ˣ�"+list_filter.toString());					
						 //׷������
						
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
						
						System.out.println("��EmployeeSupplyAction��filter()��ѯ�ɹ�!");
					}
				}
				
			}

			System.out.println("��EmployeeSupplyAction��filter()���˳ɹ�!");

		} catch (Exception e) {
			System.out.println("WorkAction��ɾѡ�����У�����ת������");
			e.printStackTrace();
		}	
		//����д����
	    workbook.write();
	    //�ر���
	    workbook.close();
		System.out.println("filter_success���سɹ�!");
		return "filter_success";

	}


	public String delete() {
		EmployeeSupplyDAO sdao = new EmployeeSupplyDAOImpl();
		String eid = request.getParameter("sid");
		sdao.deleteEmployeeSupply(eid);
		System.out.println("��EmployeeSupplyAction��delete()ɾ���ɹ���");
		return "delete_success";
	}

	
}
