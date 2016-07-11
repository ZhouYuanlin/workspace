import javax.swing.JButton;
import javax.swing.JFrame;


public class Swing {
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		//JFrame 是一个顶层容器（可以添加其他Swing组件）
		JFrame jf = new JFrame();
		//按钮
		JButton jb = new JButton();
		jb.setText("I am a button");
		//设置标题
		jf.setTitle("Hello Swing");
		//设置大小
		jf.setSize(200, 200);
		//添加组件
		jf.add(jb);
		//设置初始位置（默认在右上角）
		jf.setLocation(100, 200);
		//设置退出时就关闭
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//现实窗口
		jf.setVisible(true);
		
		
	}
}
