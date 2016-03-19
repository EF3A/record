package java;


//如果声明成public 就要在自己的文件夹
interface Comparable
{
	int compareTo(Object other);
}

class Employee implements Comparable
{
	private int salary;
	//报错 : Duplicate local variable other
	//duplicate 重复 
	@Override
	public int compareTo(Object otherEmployee) {
		// TODO Auto-generated method stub
		Employee other = (Employee) otherEmployee;
		
		//同一个类 在方法里面访问 另一个实例的private?可以.私有成员只有在声明它们的类和结构体中才是可访问的
		//other.salary = 5;这样也是可以的,作用域
		return Double.compare(salary, other.salary);
	}
}


//接口的改进
interface Comparable2<T>
{
	int compareTo(T other);
}
//接口中的方法是public,所以 无需声明为 public
//接口中可以包含多个方法
//接口中还可以定义常量

//接口中不能含有实例域
//不能再接口中实现方法


//之前接口中的类名错,实现中的类名错,所以The field Employee.salary is not visible
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
