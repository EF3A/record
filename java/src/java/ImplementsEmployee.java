package java.src.java;

//֮ǰ�ı���, Ӧ������Ϊ����array.sort ,����������Ҫʵ��implement comparable ,
//��Ҫʵ�ֵ�, ����ʵ�ֵĲ���һ��


//interface Comparable3<T>
//{
//	//����Ҫָ���޶���
//	int compareTo(T t);
//}

//�ӿ�Ҳ�Ḳ�ǵ�....
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
//	//û���ڷ�����,дforѭ����Ȼ����
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

//�ļ�����,��ʵ���ǰ���������java,javax֮���,�����޸���Щ��.

//Exception in thread "main" java.lang.SecurityException: Prohibited package name
//Change your package name. java as a package name is prohibited.
//
//Edit: Move your Main.java file in a (source) directory that doesn't 
//start with java or javax and use the directory structure names to 
//change your package name in the code.

