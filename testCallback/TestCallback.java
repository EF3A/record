package testCallback;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
/*
 * 	回调 指定某个时间发生时,应该采取的动作,
 * 	
 *  用户接口的实现 ??????
 *  
 */

/*
 * java.swing.timer : 在到达给定时间时,发出通告.
 * 			例子: 每秒获得通知, 以便更新时钟.
 * 
 * 构造定时器 :
 * 		设置时间间隔
 * 		告知定时器, 到达时间间隔做什么
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
