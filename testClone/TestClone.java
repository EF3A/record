package testClone;

import java.util.Date;

//clone ������object ���һ��protected ����,
//����ֱ�ӵ���, ֻ��employ����ܿ�¡employ����


/*
 * �ж�
 * 1.Ĭ��clone�Ƿ�����(ǳ����))
 * 2.Ĭ��clone�ܷ�ͨ�����ÿɱ�����clone�õ��޲�
 * 3.�Ƿ�õ���clone
 */


/*
 * ѡ��
 * 1. ʵ��cloneable�ӿ�
 * 2. ʹ��public �������η� ���¶���clone(ע��,������public)
 */

/*
 * �޷�ֱ�ӵ��� anobject.clone()
 * ...˼��,�����඼��objcet������,Ϊʲô����
 * key word: �ܱ�������
 */



/*
 * cloneable ��ǽӿ�, û����Ҫʵ�ֵķ���
 * tagging interface
 */


/*
 * Ŀ��: ������instanceof �������ͼ��
 * if(obj instanceof Cloneable)
 * 
 */

/*
 * ǳ��������
 */
class Employee implements Cloneable
{
	@Override
	public Employee clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub	
		//ע������������ת��	
		return (Employee)super.clone();
	}
}

/*
 * 
 * �������
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
	 * �÷����������쳣,��Ϊ��ʵ����clone,
	 * ���Ǳ�������֪��?????????????
	 * ��д
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
 *  ����д���ʺ�final��
 */



/*
 * ���鶼��clone, ͬʱ������Ϊ��public
 * 
 * int[] luckyNumbers = {2,3,4,5,6};
 * int[] cloned = luckyNumber.clone();
 * cloned[2] = 3;
 */

public class TestClone {

}
