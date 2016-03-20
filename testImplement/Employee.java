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
	 * ��������double , ���� Double.compare()����
	 * double �Ƚ�����-----------------------------------------
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
 * �̳б���Ҫʵ�ֹ��캯�� 			-----------------------------------
 * 
 */
class MyManage extends MyEmployee
{
	public MyManage(String name,int salary) {
		// TODO Auto-generated constructor stub
		super(name,salary);
	}
	/*
	 * ����̳е�comparable ��������
	 * Employee ʵ�ֵ��� comparable<Employee> ������ comparable<manage>
	 * 
	 * public int compareTo(Employee other)
	 * {
	 * 	Manage m = (Manage) other;
	 * }
	 * 
	 * ���������� "���Գ�" �Ĺ���.
	 * x.compareTo(y);
	 * y.compareTo(x);
	 * ClassCastException �쳣
	 * 
	 * 
	 * 
	 * �������???????????????????????:
	 * �ڿ�ͷ��
	 * if(getClass() != other.getClass()) throw new ClassCastException();
	 * 
	 * �������ͨ���㷨, �͸���super class �е�compareTo() ���� final
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
			//Ҳ����֮ǰ��new ,��ʵ����ָ��ռ�,
			//��������ռ�������?
			// ...........  δ��� ----------------------------------
			lines[i] = new MyEmployee("employee"+i,1000-i*200);
		}
		Arrays.sort(lines);
		for(int i=0;i<N;i++)
		{
			System.out.println(lines[i]);
		}
	}
}
