package testClone;

import java.util.Date;

//clone 方法是object 类的一个protected 方法,
//不能直接调用, 只有employ类才能克隆employ对象


/*
 * 判断
 * 1.默认clone是否满足(浅拷贝))
 * 2.默认clone能否通过调用可变对象的clone得到修补
 * 3.是否该调用clone
 */


/*
 * 选择
 * 1. 实现cloneable接口
 * 2. 使用public 访问修饰符 重新定义clone(注意,这里是public)
 */

/*
 * 无法直接调用 anobject.clone()
 * ...思考,所有类都是objcet的子类,为什么不行
 * key word: 受保护规则
 */



/*
 * cloneable 标记接口, 没有需要实现的方法
 * tagging interface
 */


/*
 * 目的: 可以用instanceof 进行类型检查
 * if(obj instanceof Cloneable)
 * 
 */

/*
 * 浅拷贝举例
 */
class Employee implements Cloneable
{
	@Override
	public Employee clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub	
		//注意这里有类型转换	
		return (Employee)super.clone();
	}
}

/*
 * 
 * 深拷贝举例
 * 
 */
class Employ2 implements Cloneable
{
	Date hireDay;
	@Override
	public Employ2 clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employ2 cloned = (Employ2)super.clone();
		cloned.hireDay = (Date) hireDay.clone();
		return cloned;
	}
	/*
	 * 该方法不会抛异常,因为都实现了clone,
	 * 但是编译器不知道?????????????
	 * 改写
	 */
}


/*
 * public Employ2 clone()
 * {
 * 		try
 * 		{
 * 			return (Employ2) super.clone();
 * 		}
 * 		catch(CloneNoSupportedException e){ return null;}
 *  }
 *  这种写法适合final类
 */



/*
 * 数组都有clone, 同时被声明为了public
 * 
 * int[] luckyNumbers = {2,3,4,5,6};
 * int[] cloned = luckyNumber.clone();
 * cloned[2] = 3;
 */

public class TestClone {

}
