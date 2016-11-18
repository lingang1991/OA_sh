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

//Action��
public class TestEmployeeSupplyDAOImpl extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	// ��ѯ���жԳ��������ķ���
	public void query() {
		// ��ѯ���еļӰ��¼
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = edao1.queryAllEmployeeWork();
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
		for (int i = 0; i < d.length; i++) {
			
			System.out.println("d[n]�ı���ֵ�ǣ�"+d[i]);
			System.out.println("name[n]�ı���ֵ�ǣ�"+name[i]);
			System.out.println("day[n]�ı���ֵ�ǣ�"+day[i]);
		}
		System.out.println("��EmployeeSupplyAction��query()��ѯ�ɹ�!");
		System.out.println("query_success���سɹ�!");
	}

	public String midify() {
		StringBuilder senumbs = new StringBuilder();
		StringBuilder senames = new StringBuilder();
		EmployeeWork list_filter = null;
		EmployeeWorkDAO edao1 = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list1 = edao1.queryAllEmployeeWork();

		// ����ѯ�����ϵ����ֺ͹��ŷŽ�����StringBuilder�У�����ƴ��

		if (list1.size() > 0 && list1 != null) {

			/*
			 * for(EmployeeWork e : list){ }����д
			 */
			EmployeeWork e = null;
			for (int i = 0; i < list1.size() - 1; i++) {
				e = list1.get(i);
				list_filter = e;
				senumbs.append(list_filter.getEnumb());
				senumbs.append("��");
				senames.append(list_filter.getEname());
				senames.append("��");
			}

			// ������һ���ֶ�
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
		System.out.println("��EmployeeSupplyAction��query()��ѯ�ɹ�!");
		System.out.println("query_success���سɹ�!");
		return "query_success";
	}

	public String delete() {
		EmployeeSupplyDAO sdao = new EmployeeSupplyDAOImpl();
		String eid = request.getParameter("sid");
		sdao.deleteEmployeeSupply(eid);
		System.out.println("��EmployeeSupplyAction��delete()ɾ���ɹ���");
		return "delete_success";
	}

}
