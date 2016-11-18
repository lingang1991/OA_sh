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

//Action��
public class TestEmployeeTaxiSupplyDAOImpl extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	public void filter() throws Exception {
		// ���ȸ������ڴ�employeetaxi��ɸѡ�����ִ򳵼�¼����ɸѡ�����ļ�¼�������½���list��
		
		int k = 0;
		EmployeeTaxiDAO edao1 = new EmployeeTaxiDAOImpl();
		List<EmployeeTaxi> list= edao1.queryAllEmployeeTaxi();
		
		EmployeeTaxiSupplyDAO edao = new EmployeeTaxiSupplyDAOImpl();
		List<EmployeeTaxiSupply> list1 = edao.queryAllEmployeeTaxiSupply();
		
		System.out.println("��taxi�л�ȡ����list1��");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// ��list����ȡÿһ���¼�Ĺ��š������ͳ���
		int m = 0, n = 0;
		String[] a = new String[list.size()];// a����洢list����Ĺ���
		String[] b = new String[list.size()];// b����洢list���������
		String[] c = new String[list.size()];// c����洢list�ĳ���
		String[] d = new String[list.size()];// d�洢ͬһ��Ӱ����Ա����
		String[] name = new String[list.size()];// name�Ӱ����Ա����
		Double[] cost = new Double[list.size()];// cost��Ϊ�ۼ����洢ͬһ�˴򳵷���
		Double[] allcost = new Double[list.size()];// allcost�洢ͬһ�˴��ܷ���

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

		for (int i = 0; i < d.length; i++) {
			System.out.println("d[n]�ı���ֵ�ǣ�" + d[i]);// ��Ӧ�Ź���
			System.out.println("name[n]�ı���ֵ�ǣ�" + name[i]);// ��Ӧ������
			System.out.println("allcost[n]�ı���ֵ�ǣ�" + allcost[i]);// ��Ӧ���ܴ򳵷���
		}

		// �����ܺ�ļ�¼������list1��
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
			System.out.println("��list�и��ݹ��˳������ܷ���list1��");
			session.setAttribute("EmployeeTaxiSupply_list", list1);
		} else {
			System.out.println("TaxiAction�в�ѯ����listΪ��ֵ");
		}
		System.out.println("��EmployeeTaxiSupplyAction��filter()���˳ɹ�!");
		System.out.println("filter_success���سɹ�!");
		System.out.println("��EmployeeTaxiSupplyAction��filter()���˳ɹ�!");

		//return "filter_success";

	}

}
	
	
