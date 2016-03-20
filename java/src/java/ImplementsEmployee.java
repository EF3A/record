package java.src.java;

//之前的报错, 应该是因为用了array.sort ,但是其中需要实现implement comparable ,
//需要实现的, 和我实现的不是一个


//interface Comparable3<T>
//{
//	//不需要指定限定符
//	int compareTo(T t);
//}

//接口也会覆盖的....
class Employee3 implements Comparable<Employee3>
{
	private int salary;
	private String name;
	
	public Employee3(String name,int salary) {
		// TODO Auto-generated constructor stub
		this.salary = salary;
		this.name = name;
	}
	
	@Override
	public int compareTo(Employee3 other) {
		// TODO Auto-generated method stub
		return salary-other.salary;
	}
	
}

public class ImplementsEmployee {
//	int N = 3;
//	//没有在方法里,写for循环当然报错
//	Employee3 lines[] = new Employee3[N];
//	for(int i=0;i<N;i++)
//	{
//		
//	}
	public static void main(String[] args)
	{
		int N = 3;
		Employee3 lines[] = new Employee3[N];
		System.out.println(lines.length);
	}
}

//文件报错,其实就是包名中有了java,javax之类的,不能修改这些包.

//Exception in thread "main" java.lang.SecurityException: Prohibited package name
//Change your package name. java as a package name is prohibited.
//
//Edit: Move your Main.java file in a (source) directory that doesn't 
//start with java or javax and use the directory structure names to 
//change your package name in the code.

