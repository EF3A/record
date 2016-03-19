package java;


//���������public ��Ҫ���Լ����ļ���
interface Comparable
{
	int compareTo(Object other);
}

class Employee implements Comparable
{
	private int salary;
	//���� : Duplicate local variable other
	//duplicate �ظ� 
	@Override
	public int compareTo(Object otherEmployee) {
		// TODO Auto-generated method stub
		Employee other = (Employee) otherEmployee;
		
		//ͬһ���� �ڷ���������� ��һ��ʵ����private?����.˽�г�Աֻ�����������ǵ���ͽṹ���в��ǿɷ��ʵ�
		//other.salary = 5;����Ҳ�ǿ��Ե�,������
		return Double.compare(salary, other.salary);
	}
}


//�ӿڵĸĽ�
interface Comparable2<T>
{
	int compareTo(T other);
}
//�ӿ��еķ�����public,���� ��������Ϊ public
//�ӿ��п��԰����������
//�ӿ��л����Զ��峣��

//�ӿ��в��ܺ���ʵ����
//�����ٽӿ���ʵ�ַ���


//֮ǰ�ӿ��е�������,ʵ���е�������,����The field Employee.salary is not visible
class Employee2 implements Comparable2<Employee2>
{
	public int salary = 5;

	@Override
	public int compareTo(Employee2 other) {
		// TODO Auto-generated method stub
		return Double.compare(salary, other.salary);
	}

	
}




public class Test {

}
