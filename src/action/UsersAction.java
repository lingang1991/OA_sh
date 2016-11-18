package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
//struts2���ܱ����ݵķ�ʽ�����֣���ͨ���ԡ��������ģ��������
//������ϸ�ıȽϲο���http://blog.csdn.net/li_tengfei/article/details/6098145
//��jsp�ύ�ı��������Ƚϴ��ʱ��ģ�������о��Ե����ƣ�

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * Ϊ���ڷ����л�ʱ,ȷ����汾�ļ�����,�����ÿ��Ҫ���л������м���private static final long
	 * serialVersionUID�������,������ֵ�Լ�����
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// �û���¼����
	public String login() {
		System.out.println("action.UsersAction.login()������������");
		UsersDAO udao = new UsersDAOImpl();

		if (udao.usersLogin(user)) {

			// ��session�б����½�ɹ����û���,�Ա���ǰ̨��ʾ��
			session.setAttribute("loginUserName", user.getUsername());

			return "login_success";
		} else {
			return "login_failure";
		}

	}

	@SkipValidation
	// �û�ע����¼�����������ж�session�Ƿ񱣴����û���
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}

		return "logout_success";

	}

	@Override
	public void validate() {

		// �û�������Ϊ��,trim()����ȥ���ַ���ǰ׺�ͺ�׺�ո�
		// �û�����������Ϊ�գ�Ҳ����Action�е�����ֵΪ�յ�ʱ��Struts2��Ĭ���������ᱨ���������Ҳ���input��Result�����ܹ��Ѵ��󷵻أ��ᱨ��No
		// result defined for action and result input����Struts2.xml�м��� <result
		// name="input">/users/Users_login.jsp</result>�������ʱ��Ϳ�����ת��ָ��ҳ�档

		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "�û�������Ϊ�գ�");

		}

		if ("".equals(user.getPassword().trim())) {
			this.addFieldError("passwordError", "���벻��Ϊ�գ�");

		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "���볤�Ȳ���С��6λ��");

		}

		System.out.print("validate()����֤������ִ���ˣ�");

	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
