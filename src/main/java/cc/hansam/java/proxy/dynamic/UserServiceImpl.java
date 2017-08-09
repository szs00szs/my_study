package cc.hansam.java.proxy.dynamic;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午10:44:19
 */
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("add user");
	}

	@Override
	public void removeUser() {
		System.out.println("remove user");
	}

	@Override
	public void searchUser() {
		System.out.println("search user");
	}

}
