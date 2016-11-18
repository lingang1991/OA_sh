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

	// ��ѯ���жԳ��������ķ���
	public String query() {
		EmployeeOutDAO edao = new EmployeeOutDAOImpl();
		List<EmployeeOut> list = edao.queryAllEmployeeOut();
		// ����ѯ�������ϷŽ�session��
		if (list.size() > 0 && list != null) {
			session.setAttribute("employeeOut_list", list);
			System.out.println("��EmployeeOutAction��query()��ѯ�ɹ�!");
		}
		System.out.println("query_success���سɹ�!");
		return "query_success";

	}

	public String filter() throws Exception {
		// ���ȸ������ڴ�employeetaxi��ɸѡ�����ִ򳵼�¼����ɸѡ�����ļ�¼�������½���list��
		
				int k = 0;
				EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
				List<EmployeeTaxi> list= edao1.queryAllEmployeeTaxi();//�����ݿ��ȡ����Դ����list�����������ڵĴ�С����ð������
				
				List<EmployeeTaxi> list3= new ArrayList<EmployeeTaxi>();//����һ������list3�����ڱ����list����ָ������������˺������
				
				List<EmployeeTaxiSupply> list2= new ArrayList<EmployeeTaxiSupply>();//���弯��list2�����ڱ���list3�еĹ��š��������ܴ򳵷���
				
				
				
				EmployeeTaxiSupplyDAO edao = new EmployeeTaxiSupplyDAOImpl();
				List<EmployeeTaxiSupply> list1 = edao.queryAllEmployeeTaxiSupply();
			
				String etaxibeginday = request.getParameter("etaxibeginday");
				String etaxiworkendday = request.getParameter("etaxiendday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dt1 = df.parse(etaxibeginday);
				Date dt2 = df.parse(etaxiworkendday);
				System.out.println(dt1);
				System.out.println(dt2);
				
				System.out.println("��taxi�л�ȡ����list1��");
				
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				
				for (int i = 0; i < list1.size(); i++) {
					System.out.println(list1.get(i));
				}
				
				//��list�������ڴ�С��ð������    
		        for (int i = 0; i < list.size(); i++){  //�����n-1������
		            for(int j1 = 0 ;j1 < list.size()-i-1; j1++){ 
		         	   //�Ե�ǰ���������������(j�ķ�Χ�ܹؼ��������Χ��������С��)
		                if( list.get(j1).getEtaxiday().compareTo(list.get(j1+1).getEtaxiday())>0){    //��С��ֵ����������
		                	EmployeeTaxi r=list.get(j1); 
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
		   
				
				//��list�������ڹ��˼�¼,����֮��ļ��ϱ�����list3
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
					System.out.println("list����֮��õ���list3��");
					for (int i = 0; i < list3.size(); i++) {
						System.out.println(list3.get(i));
					}
					
				}
				
				
				
				
				
				// ��list3����ȡÿһ���¼�Ĺ��š������ͳ���
				int m = 0, n = 0;
				String[] a = new String[list3.size()];// a����洢list����Ĺ���
				String[] b = new String[list3.size()];// b����洢list���������
				String[] c = new String[list3.size()];// c����洢list�ĳ���
				String[] d = new String[list3.size()];// d�洢ͬһ��Ӱ����Ա����
				String[] name = new String[list3.size()];// name�Ӱ����Ա����
				Double[] cost = new Double[list3.size()];// cost��Ϊ�ۼ����洢ͬһ�˴򳵷���
				Double[] allcost = new Double[list3.size()];// allcost�洢ͬһ�˴��ܷ���

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

				// ����ȡ�����Ĺ��š������ͳ��ѣ������ź��������з��û���
				for (int i = 0; i < c.length - 1; i = i + m + 1) {
					System.out.println("i��ֵ��" + i);
					System.out.println("a[i]��ֵ��" + a[i]);
					System.out.println("b[i]��ֵ��" + b[i]);
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
					System.out.println("���ţ�" + d[n] + " ������" + b[i] + " �򳵵��ܷ����ǣ� "
							+ allcost[n]);
					n++;
				}
				System.out.println();

				for (int i = 0; i < n-1; i++) {
					System.out.println("d[n]�ı���ֵ�ǣ�" + d[i]);// ��Ӧ�Ź���
					System.out.println("name[n]�ı���ֵ�ǣ�" + name[i]);// ��Ӧ������
					System.out.println("allcost[n]�ı���ֵ�ǣ�" + allcost[i]);// ��Ӧ���ܴ򳵷���
				}

				// �����ܺ�ļ�¼������list2��
				
				
					for (int i = 0; i < n; i++) {
						EmployeeTaxiSupply e2 = new EmployeeTaxiSupply();
						e2.setEid(String.valueOf(i+1));
						e2.setEnumb(d[i]);
						e2.setEname(name[i]);
						e2.setEallcost(String.valueOf(allcost[i]));
						list2.add(e2);
					}
					System.out.println("��list�и��ݹ��˳������ܷ���list2��");
					session.setAttribute("EmployeeTaxiSupply_list", list2);
				
				System.out.println("��EmployeeTaxiSupplyAction��filter()���˳ɹ�!");
				System.out.println("filter_success���سɹ�!");
				System.out.println("��EmployeeTaxiSupplyAction��filter()���˳ɹ�!");

				return "filter_success";
			}
}
