package testCallback;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
/*
 * 	�ص� ָ��ĳ��ʱ�䷢��ʱ,Ӧ�ò�ȡ�Ķ���,
 * 	
 *  �û��ӿڵ�ʵ�� ??????
 *  
 */

/*
 * java.swing.timer : �ڵ������ʱ��ʱ,����ͨ��.
 * 			����: ÿ����֪ͨ, �Ա����ʱ��.
 * 
 * ���춨ʱ�� :
 * 		����ʱ����
 * 		��֪��ʱ��, ����ʱ������ʲô
 */

//interface ActionListener
//{
//	void actionPerformed(ActionEvent event);
//}

class TimerPrinter implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		Date now = new Date();
		System.out.println("at the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();
	}
}















public class TestCallback {
	public static void main(String[] args)
	{
		ActionListener listener = new TimerPrinter();
		Timer t = new Timer(1000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "quit?");
		System.exit(0);
	}
}
