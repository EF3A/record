package java.src.java;


import java.util.Arrays;

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
        /*
         * 2016/3/20
         * ������ʺ�double, ������������ ..... ȥ���� ���ʵ��---------------------------------------------
         */
        return Double.compare(salary, other.salary);
        /*
         * 2016/3/20
         * sort����������
         * if(a[i].compareTo(a[j]) > 0)
         * {
         *  rearrange a[i] and a[j]
         * }
         * ����ҪcompareTo
         * 
         * 
         * 
         * sort �����������һ�� comparable array, ���� �����ᱨ��, ��Ϊ, sort ���Խ��� object[],ͬʱת��.....
         * 
         * ϵͳ�������鲻�Ǳ���,����ǿת
         * if(((Comparable)a[i]).compareTo(a[j]) > 0)
         * {
         *      rearrange a[i] and a[j]
         *      ...
         * }
         */
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
         *      д���
         *      Employee2 line[] = new Employee();
         */
        Employee2 line[] = new Employee2[3];
        line[0]= new Employee2(100, "e1");
        line[1]= new Employee2(300, "e2");
        line[2]= new Employee2(200, "e3");
        
        
        /*
         *  �������� �� arrays ����
         */     Arrays.sort(line);
        for(int i=0;i<line.length;i++)
        {
            System.out.println(line[i]);
        }
    }
}
/*
 * д��������Ǹ���ɫ�����а�ť��ֱ�ӱ���"Selection cannot be launched and there are no recent launches����
 * ���������£����ֵ�һ�����в���ֱ�ӵ����������������һ��run�����ļ�������Run-> Run Configurations...��
 * ���Բο���http://stackoverflow.com/questions/9240333/selection-cannot-be-launched-and-there-are-no-recent-launches-when-eclipse-for
 * �����������У����Ǳ���������: �Ҳ������޷��������ࡱ���ټ�����ǰģ���ļ��䣬java�ļ������������һ�£������޸��ļ������������Ǳ������ʱ����ִ��󣺡�
 * editor does not contain a main type������������������������⣺ԭ�����class���ڰ�û�б���ӵ�build path�С�
 * ���������������package explorer���һ����class���ڰ�����һ��Ŀ¼--build path--use as source folder�������ͽ�������ˡ�
 * ���´�class����runһ�£�ok�ˡ�

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
