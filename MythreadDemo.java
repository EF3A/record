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
	//Cannot instantiate the type Ellipse2D 这个是abstract class
	public void move(Rectangle2D comp)
	{
		x += dx;
		y += dy;
		if(x < comp.getMinX())
		{
			x = comp.getMinX();
			dx =  -dx;
		}
		// y 错写 x 飞出
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
//extends component 才是 component 
class BallComponent extends JComponent
{
	private int height = 350;
	private int width = 450;
	private List<Ball> myList = new ArrayList<>();
//	repaint更像是一个事件，因为你调用它的时候，它并不是立即执行paint()进行重画的，GUI引擎只是记录了一个事件：哦，有请求说需要重画以下，有空我就调用下paint()函数。
//
//	“如果调用一个容器的repaint它是不是回去重画容器内所有的组件？如果是 它实现的时候是不是通过调用所有组件的repaint方法呢？”
//
//	是的。不是，前面已经说了repaint是个事件而已，并不实际执行重画。
//
//	最后：可以只调用一个组件的repaint()。
	
	//------------------------原来这个draw 不是随便取的, 是重写, repaint调用, 具体实现未看
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		//把每个ball 画出来, 
		//这个for循环,要指出类型
		for(Ball b:myList)
			g2.fill(b.getShape());
	}

	public void add(Ball b)
	{
		myList.add(b);
	}
	//component 的初始化 有点不一样 
	@Override
		public Dimension getPreferredSize() {
			// TODO Auto-generated method stub
			return new Dimension(width,height);
		}
	
}

//jframe 有 add()  和 pack() 方法
//指定frame 大小 ?  
// 为什么只指定了 component 大小,而且是prefersize ....



//repaint 也有点疑问, component  可是我没有重写

class BallFrame extends JFrame
{
	//frame 初始化, 就是要把大家装进去
	//component 肯定有
	private BallComponent comp;
	public BallFrame() 
	{
		// TODO Auto-generated constructor stub
		comp = new BallComponent();
		//放置的位置
		add(comp,BorderLayout.CENTER);
		//把两个button放进panel
		JPanel jpanel = new JPanel();

		addButton(jpanel,"start",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		
		
		//这里的退出和frame的退出不一样
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
		//listener 要自己加上
	public void addButton(Container c, String title, ActionListener listener)
	{
		//jbutton 没有title 大小变了很多
		JButton jb = new JButton(title);
		c.add(jb);
		jb.addActionListener(listener);
	}
	public void addBall()
	{
		Ball b = new Ball();
		comp.add(b);
		//add之后要动, 也就是线程
		Runnable r = new BallRunnable(b, comp);
		Thread t = new Thread(r);
		t.start();
	}
	
}

//class BallRunnable 把ball 和 ballrunnable 分开来 可以.
class BallRunnable implements Runnable
{
	private Ball b;
	private Component comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
	//这里之所以写构造函数,为了传入 component ,为了重画??
	//--------------------------------------------这里没有自己写repaint,应该可以写球的repaint...???
	//---------------------------------------------这样repaint 好像会调用很多次.
	public BallRunnable(Ball b,Component comp) 
	{
		// TODO Auto-generated constructor stub
		this.b = b;
		this.comp = comp;
		
	}
	//线程要sleep
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















