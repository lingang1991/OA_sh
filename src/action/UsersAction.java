package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
//struts2接受表单数据的方式有三种：普通属性、领域对象、模型驱动；
//三者详细的比较参考：http://blog.csdn.net/li_tengfei/article/details/6098145
//当jsp提交的表单数据量比较大的时候，模型驱动有绝对的优势！

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 为了在反序列化时,确保类版本的兼容性,最好在每个要序列化的类中加入private static final long
	 * serialVersionUID这个属性,具体数值自己定义
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// 用户登录动作
	public String login() {
		System.out.println("action.UsersAction.login()方法被调用了");
		UsersDAO udao = new UsersDAOImpl();

		if (udao.usersLogin(user)) {

			// 在session中保存登陆成功的用户名,以便在前台显示。
			session.setAttribute("loginUserName", user.getUsername());

			return "login_success";
		} else {
			return "login_failure";
		}

	}

	@SkipValidation
	// 用户注销登录方法，首先判断session是否保存了用户名
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}

		return "logout_success";

	}

	@Override
	public void validate() {

		// 用户名不能为空,trim()函数去除字符串前缀和后缀空格
		// 用户名或者密码为空，也就是Action中的属性值为空的时候，Struts2的默认拦截器会报错，但是又找不到input的Result，不能够把错误返回，会报错：No
		// result defined for action and result input。在Struts2.xml中加上 <result
		// name="input">/users/Users_login.jsp</result>这句出错的时候就可以跳转到指定页面。

		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空！");

		}

		if ("".equals(user.getPassword().trim())) {
			this.addFieldError("passwordError", "密码不能为空！");

		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "密码长度不能小于6位！");

		}

		System.out.print("validate()表单验证方法被执行了！");

	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
