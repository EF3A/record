package testImplement;

import java.util.Arrays;

class MyEmployee implements Comparable<MyEmployee>
{
	private int salary;
	private String name;
	public MyEmployee(String name,int salary) {
		// TODO Auto-generated constructor stub
		this.salary = salary;
		this.name = name;
	}
	
	/*
	 * 书上用了double , 用了 Double.compare()方法
	 * double 比较问题-----------------------------------------
	 * 
	 */
	@Override
	public int compareTo(MyEmployee o) {
		// TODO Auto-generated method stub
		return salary - o.salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"has"+salary;
	}
}

/*
 * 继承必须要实现构造函数 			-----------------------------------
 * 
 */
class MyManage extends MyEmployee
{
	public MyManage(String name,int salary) {
		// TODO Auto-generated constructor stub
		super(name,salary);
	}
	/*
	 * 这里继承的comparable 会有问题
	 * Employee 实现的是 comparable<Employee> 而不是 comparable<manage>
	 * 
	 * public int compareTo(Employee other)
	 * {
	 * 	Manage m = (Manage) other;
	 * }
	 * 
	 * 这样不符合 "反对称" 的规则.
	 * x.compareTo(y);
	 * y.compareTo(x);
	 * ClassCastException 异常
	 * 
	 * 
	 * 
	 * 解决方案???????????????????????:
	 * 在开头加
	 * if(getClass() != other.getClass()) throw new ClassCastException();
	 * 
	 * 如果存在通用算法, 就该在super class 中的compareTo() 加入 final
	 * 
	 * 
	 */
	
}



public class Employee 
{
	public static void main(String args[])
	{
		int N = 3;
		MyEmployee lines[] = new MyEmployee[N];
		for(int i=0;i<N;i++)
		{
			//也就是之前的new ,其实还是指针空间,
			//真正分配空间在这里?
			// ...........  未解决 ----------------------------------
			lines[i] = new MyEmployee("employee"+i,1000-i*200);
		}
		Arrays.sort(lines);
		for(int i=0;i<N;i++)
		{
			System.out.println(lines[i]);
		}
	}
}
