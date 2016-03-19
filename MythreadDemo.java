package thread2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;





class Ball
{
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	private int width = 15;
	private int height = 15;
	//rectangle2D ---  component 
	//Cannot instantiate the type Ellipse2D �����abstract class
	public void move(Rectangle2D comp)
	{
		x += dx;
		y += dy;
		if(x < comp.getMinX())
		{
			x = comp.getMinX();
			dx =  -dx;
		}
		// y ��д x �ɳ�
		if(y < comp.getMinY())
		{
			y = comp.getMinY();
			dy = -dy;
		}
		if(x + width > comp.getMaxX())
		{
			x = comp.getMaxX() - width;
			dx = -dx;
		}
		if(y+height > comp.getMaxY())
		{
			y = comp.getMaxY() - height;
			dy = -dy;
		}
	}
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x,y,width,height);
	}
}
//extends component ���� component 
class BallComponent extends JComponent
{
	private int height = 350;
	private int width = 450;
	private List<Ball> myList = new ArrayList<>();
//	repaint������һ���¼�����Ϊ���������ʱ��������������ִ��paint()�����ػ��ģ�GUI����ֻ�Ǽ�¼��һ���¼���Ŷ��������˵��Ҫ�ػ����£��п��Ҿ͵�����paint()������
//
//	���������һ��������repaint���ǲ��ǻ�ȥ�ػ����������е����������� ��ʵ�ֵ�ʱ���ǲ���ͨ���������������repaint�����أ���
//
//	�ǵġ����ǣ�ǰ���Ѿ�˵��repaint�Ǹ��¼����ѣ�����ʵ��ִ���ػ���
//
//	��󣺿���ֻ����һ�������repaint()��
	
	//------------------------ԭ�����draw �������ȡ��, ����д, repaint����, ����ʵ��δ��
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		//��ÿ��ball ������, 
		//���forѭ��,Ҫָ������
		for(Ball b:myList)
			g2.fill(b.getShape());
	}

	public void add(Ball b)
	{
		myList.add(b);
	}
	//component �ĳ�ʼ�� �е㲻һ�� 
	@Override
		public Dimension getPreferredSize() {
			// TODO Auto-generated method stub
			return new Dimension(width,height);
		}
	
}

//jframe �� add()  �� pack() ����
//ָ��frame ��С ?  
// Ϊʲôָֻ���� component ��С,������prefersize ....



//repaint Ҳ�е�����, component  ������û����д

class BallFrame extends JFrame
{
	//frame ��ʼ��, ����Ҫ�Ѵ��װ��ȥ
	//component �϶���
	private BallComponent comp;
	public BallFrame() 
	{
		// TODO Auto-generated constructor stub
		comp = new BallComponent();
		//���õ�λ��
		add(comp,BorderLayout.CENTER);
		//������button�Ž�panel
		JPanel jpanel = new JPanel();

		addButton(jpanel,"start",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		
		
		//������˳���frame���˳���һ��
		addButton(jpanel,"exit",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	    add(jpanel, BorderLayout.SOUTH);
	    pack();
	}
		//listener Ҫ�Լ�����
	public void addButton(Container c, String title, ActionListener listener)
	{
		//jbutton û��title ��С���˺ܶ�
		JButton jb = new JButton(title);
		c.add(jb);
		jb.addActionListener(listener);
	}
	public void addBall()
	{
		Ball b = new Ball();
		comp.add(b);
		//add֮��Ҫ��, Ҳ�����߳�
		Runnable r = new BallRunnable(b, comp);
		Thread t = new Thread(r);
		t.start();
	}
	
}

//class BallRunnable ��ball �� ballrunnable �ֿ��� ����.
class BallRunnable implements Runnable
{
	private Ball b;
	private Component comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
	//����֮����д���캯��,Ϊ�˴��� component ,Ϊ���ػ�??
	//--------------------------------------------����û���Լ�дrepaint,Ӧ�ÿ���д���repaint...???
	//---------------------------------------------����repaint �������úܶ��.
	public BallRunnable(Ball b,Component comp) 
	{
		// TODO Auto-generated constructor stub
		this.b = b;
		this.comp = comp;
		
	}
	//�߳�Ҫsleep
	public void run()
	{
		for(int i=0;i<STEPS;i++)
		{
		try {
			b.move(comp.getBounds());
			comp.repaint();
			Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class MythreadDemo
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
	               JFrame frame = new BallFrame();
	               frame.setTitle("BallThread");
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
			}
		});
	}
}















