package cc.hansam.java.compare.compareble;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年8月25日下午6:37:08
 */
public class Student implements Comparable<Student> {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}


}
