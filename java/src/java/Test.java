package java.src.java;


import java.util.Arrays;

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
        /*
         * 2016/3/20
         * 相减不适合double, 会有四舍五入 ..... 去看看 如何实现---------------------------------------------
         */
        return Double.compare(salary, other.salary);
        /*
         * 2016/3/20
         * sort方法里面有
         * if(a[i].compareTo(a[j]) > 0)
         * {
         *  rearrange a[i] and a[j]
         * }
         * 所以要compareTo
         * 
         * 
         * 
         * sort 方法定义接受一个 comparable array, 但是 并不会报错, 因为, sort 可以接受 object[],同时转换.....
         * 
         * 系统做的事情不是报错,而是强转
         * if(((Comparable)a[i]).compareTo(a[j]) > 0)
         * {
         *      rearrange a[i] and a[j]
         *      ...
         * }
         */
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
    private int salary;
    private String name;
    public Employee2(int salary, String name) {
        // TODO Auto-generated constructor stub
        this.salary = salary;
        this.name = name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name+"has"+salary;
    }
    
    @Override
    public int compareTo(Employee2 other) {
        // TODO Auto-generated method stub
        return Double.compare(salary, other.salary);
    }

    
}

class Employee2Test
{
    public void init()
    {
        /*
         *      写错的
         *      Employee2 line[] = new Employee();
         */
        Employee2 line[] = new Employee2[3];
        line[0]= new Employee2(100, "e1");
        line[1]= new Employee2(300, "e2");
        line[2]= new Employee2(200, "e3");
        
        
        /*
         *  数组排序 在 arrays 里面
         */     Arrays.sort(line);
        for(int i=0;i<line.length;i++)
        {
            System.out.println(line[i]);
        }
    }
}
/*
 * 写完程序点击那个绿色的运行按钮，直接报错："Selection cannot be launched and there are no recent launches”，
 * 网上搜了下，发现第一次运行不能直接点这个，必须先设置一下run配置文件，即：Run-> Run Configurations...，
 * 可以参考：http://stackoverflow.com/questions/9240333/selection-cannot-be-launched-and-there-are-no-recent-launches-when-eclipse-for
 * 这样继续运行，还是报错：“错误: 找不到或无法加载主类”，再加上以前模糊的记忆，java文件名必须和类名一致，于是修改文件名。继续还是报错，这个时候出现错误：“
 * editor does not contain a main type”，继续搜索，对于这个问题：原来这个class所在包没有被添加到build path中。
 * 解决方法：在左侧的package explorer中右击这个class所在包的上一级目录--build path--use as source folder。这样就解决问题了。
 * 重新打开class，再run一下，ok了。

  */



/*
 * Selection cannot be launched and there are no recent launches
 * shift+ alt+ x ....
 */
public class Test {
    public static void main(String[] args)
    {
        Employee2Test t = new Employee2Test();
        t.init();
    }
}
