package stockAnnotation.data;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;

import stockAnnotation.data.stockdata;;
public class draw 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 SimpleFrame frame=new SimpleFrame();
		 String filename=frame.choosefile();
		
		 frame.initFile(filename);
		
		
		 
		 Thread t=new Thread(frame);
		 t.start();
		 
		 
	}

}
class SimpleFrame extends JFrame implements KeyListener,MouseListener,ActionListener,MouseMotionListener,Runnable
{
    
	
	Vector<StockData> vec=new Vector<StockData>();//存取股票数据的容器
	
	Vector<Float> vec_weight=new Vector<Float>();//存取加权数据股票数据的容器
	Vector<Float> vec_equleFloats  = new Vector<Float>();//存取均线与加权相等的数据容器
	
	Vector<Point> sMALinesPoints = new Vector<Point>();//存取 SMA 曲线中的线段
	Vector<Point> wMALinesPoints = new Vector<Point>();//存取 WMA 曲线中的线段
	Vector<Line> interLines = new Vector<Line>();//存取 SMA 与 WMA 交点连接的线段
	Vector<iPoint> interPoints = new Vector<iPoint>();//存取 SMA 与 WMA 交点
	Vector<Point> highDistance = new Vector<Point>();//存取离交线最远的点
	float maxend;//最高的收盘价
	float minend;//最低的收盘价
	
	float maxprice;//所有中最高的最高价
	float minprice;//最低的最低价
	
	int maxvolum;//最大成交量
	int minvolum;//最小成交量
	
	float maxavg=0;//最大均线值
	float minavg=1000;//最小均线值
	
	Vector<Float> vec2=new Vector<Float>();//求均线时需要的数据容器
	Vector<Float> vecema=new Vector<Float>();//求ema时需要的数据容器
	Vector<Float> vecmacd1=new Vector<Float>();//求macd1时需要的数据容器
	Vector<Float> vecmacd2=new Vector<Float>();//求macd2时需要的数据容器
	Vector<Float> vecdif=new Vector<Float>();//求macd2时需要的数据容器
	Vector<Float> vecdea=new Vector<Float>();//求macd2时需要的数据容器
	
	Vector<Float> vecdeadif=new Vector<Float>();//求macd时需要的数据容器
	Vector<beili> vecstr1=new Vector<beili>();//求背离策略最大值时需要的数据容器
	Vector<beili> vecstr2=new Vector<beili>();//求背离策略最大值时需要的数据容器 
	boolean isfile=false;//判断程序是否初始化成功
	boolean isfocus=false;//设定焦点设定为false
	
	String fileName;//要读取的文件名
	
	int datacount;//读取文件的个数
	int showcount;//显示数据的个数
	int removecount;//偏移量
	
	int x;//鼠标的横坐标
	boolean isremove=false;//是否偏移
	
	float nowdata;//显示的数值
	
	stockdata f;//用于下载网上数据的类
	float emamax;
	float emamin;
	
	
	float difmax;
	float difmin;
	
	float deamax;
	float deamin;
	
    JMenuBar jmb;
    JMenu jm1,jm2,jm3;
    JMenuItem jm1_1,jm1_2,jm2_1,jm2_2,jm3_1;
    
    JTextField jt1;
    JLabel jl1;
    JButton jb1;

	private Point maxPoint;
	
	public SimpleFrame()
   {
	   Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
	   int width=screamsize.width;
//	   System.out.println("width "+width);
	   int height=screamsize.height;
//	   System.out.println("height "+height);
	   this.setSize(width,height);
	   this.setTitle("股票分析系统");
	   maxend=0;
	   minend=1000;
	   
	   maxvolum=0;
	   minvolum=2000000000;
	   
	   maxprice=0;
	   minprice=1000;
	   
	   datacount=1000;//初始化读取1000个数据
	   showcount=100;//初始化显示100个数据
	   removecount=0;//初始化偏移量为0
	   
	   x=0;
	   nowdata=0;
	   this.addKeyListener(this);//注册键盘的监听
	   this.addMouseListener(this);
	   this.addMouseMotionListener(this);
	  
	    f=new stockdata();
	    f.gettimedata();

		emamin=1000000;
		emamax=0;
		
		difmin=1000000;
		difmax=0;
		
		deamin=1000000;
		deamax=0; 
		
		//设置窗体布局
	    this.setLayout(null);
	    
	    //股票搜索接口
	    jl1=new JLabel("查找");
	    
	    jt1=new JTextField(100);
	  
	    jb1=new JButton("确定");
	    
	    //让编辑框失去焦点
	    jt1.setFocusable(isfocus);
	    jb1.setFocusable(isfocus);
	    jl1.setFocusable(isfocus);
	  //  jt1.addFocusListener((FocusListener) this);
	    
	   
	     
	    //注册监听
	    jb1.addActionListener(this);
	    jt1.addActionListener(this);
	    
	    jl1.setBounds(100, 10, 30, 20);
	    jt1.setBounds(140, 10, 120, 20);
	    jb1.setBounds(280, 10, 60, 20);
	     
	    //菜单的建立
	    //第一个菜单项
		jm1_1=new JMenuItem("打开");
		jm1_1.addActionListener(this);
		jm1_2=new JMenuItem("退出");
		jm1_2.addActionListener(this);
		jm1=new JMenu("文件");
		jm1.add(jm1_1);
		jm1.add(jm1_2);
		
		//第二个菜单项
		jm2_1=new JMenuItem("参数设置");
		jm2_1.addActionListener(this);
		jm2_2=new JMenuItem("策略设置");
		jm2_2.addActionListener(this);
		jm2=new JMenu("设置");
		jm2.add(jm2_1);
		jm2.add(jm2_2);
		
		//第三个菜单项
		jm3_1=new JMenuItem("数据更新");
		jm3_1.addActionListener(this);
		jm3=new JMenu("更新");
		jm3.add(jm3_1);
		
		//加入菜单
		jmb=new JMenuBar();
	    jmb.add(jm1);
	    jmb.add(jm2);
	    jmb.add(jm3);
	    
	    this.setJMenuBar(jmb);
		this.add(jl1);
		this.add(jt1);
		this.add(jb1);
	    
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	  
   }
	//画图操作
   public void paint(Graphics g)
   {
	    super.paint(g); 
	  
	    //组件的重绘
	    jmb.repaint();
	    jl1.repaint();
	    jt1.repaint();
	    jb1.repaint();
	   //jtp.setBounds(0, 100+(this.getHeight()-300), 100, 50);
		//this.add(jtp);
	// Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
	    
	
	   int imagewidth=this.getWidth()-300;//画图区域的宽度
//	   System.out.println("imagewidth " + imagewidth);
	   int imageheight=this.getHeight()-300;//画图区的高度
//	   System.out.println("imageheight " + imageheight);
	    //画屏幕
	   g.fillRect(0, 30, this.getWidth(), this.getHeight());
	   
	   g.setColor(Color.red);
       g.draw3DRect(100, 100, imagewidth, imageheight, true);
       
       int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
//       System.out.println(line);
       
//       g.drawLine(100, 100+line, 100+imagewidth, 100+line);
       
       g.draw3DRect(100+imagewidth+20, 100, 150, imageheight, true);
       g.drawLine(100+imagewidth+20, 100+line, 100+imagewidth+20+150, 100+line);   
       g.setColor(Color.white);
	  
	   
	   g.drawRect(10, 100, 80, 350);
	   g.drawString("时间", 40,120 );
	   g.drawString("数值",40,150);
	   g.drawString("开盘",40,180);
	   g.drawString("最高", 40,210);
	   g.drawString("最低", 40,240);
	   g.drawString("收盘", 40,270);
	   g.drawString("涨幅", 40,300);
	   g.drawString("振幅", 40,330);
	   g.drawString("总手", 40,360);
	   g.drawString("量比", 40,390);
	   g.drawString("换手", 40,420);
	   if(isfile )
	   {
    	   //画均线图
		   
		 //   5天的均线图
    	    drawline(g,10,Color.yellow);
    	    //10天的均线图
//    	    if(showcount>10)
//    	       drawline(g,10,Color.yellow);

    		   //测试
    	      drawWei_line(g, 10, Color.pink);
    	      drawendprice(g);
    	      
	        draw_interLine(g);
	        draw_PLR(g);
    	    //20天的均线图
//  	    if(showcount>20)
//           drawline(g,20,Color.pink);
	       
	       //画成交量图
//	        drawvolRect(g);
	       
	       
	       //画k线图
//	        drawkimg(g);
//	        g.drawString(this.fileName, 70+imagewidth/2, 80);//写标题
	       
	    	int num=Math.abs(showcount-x*showcount/imagewidth)-1;//得到数据的编号
	    	StockData data2=vec.get(num+removecount); //取出数据
	    	g.setColor(Color.yellow);
    		g.drawLine(x+100, 100, x+100, 100+line);
    	//	System.out.println("11");
    		
	        if(x!=0)
	        {
	        	String date="日期："+data2.date;
	    		String begin="开盘价："+data2.begin+"         元";
	    		String end="收盘价："+data2.end+"        元";
	    		String max="最高价："+data2.high+"        元";
	    		String min="最低价："+data2.low+"        元";
	    		String volumn="交易量："+data2.volumn+"   手";
	    		//System.out.println(num);
	    		g.drawString(date, x+100, 110);
	    		g.drawString(begin, x+100, 125);
	    		g.drawString(min, x+100, 140);
	    		g.drawString(max, x+100, 155);
	    		g.drawString(end, x+100, 170);
	    		g.drawString(volumn, x+100, 185);
	        }
	        g.drawString(data2.date, 20, 135);
	        g.drawString(data2.begin+"", 40, 195);
    		g.drawString(data2.high+"", 40, 225);
    		g.drawString(data2.low+"", 40, 255);
    		g.drawString(data2.end+"", 40, 285);
    		g.drawString(data2.volumn+"", 30, 375);
	        g.drawString(nowdata+"", 40, 165);
	       
	        //计算涨幅
	        if(num+removecount+1<vec.size())
	        {
		        StockData data3=vec.get(num+removecount+1);
		        
		        float extent=(data2.end-data3.end)/data3.end*100;
		        DecimalFormat df = new DecimalFormat("#.00");
		        extent=Float.parseFloat(df.format(extent));
		        g.drawString(extent+"%", 40, 315);
		        
		        
		        //计算振幅
		        float  Amplitude=(data2.high-data2.low)/data3.end*100;
		        
		        Amplitude=Float.parseFloat(df.format(Amplitude));
		        g.drawString(Amplitude+"%", 40, 345);
	        }
	        
	        //实时数据的绘图
	        this.draw_time(g);
	        
	        //时间轴
	        this.drawtime(g);
	        
	        //画指标
	        g.setColor(Color.red);;
	        g.drawRect(100, 100+imageheight+20, imagewidth, 170);
	        
	        g.setColor(Color.gray);
	        g.drawLine(100, 100+imageheight+100,imagewidth+100, 100+imageheight+100);
	        
	        g.setColor(Color.white);; 
	       
	       
//	       this.draw_ema(12,g,Color.yellow);
//	       this.draw_ema(26,g,Color.red); 
//	      
//	       if(showcount>26)
//	        this.draw_ema(26,g,Color.pink);
//	       
	   //  System.out.println("emamin="+emamin+" "+"emamax="+emamax);
	       
	      //画dif图
//	       this.draw_dif(g);
//	       if(showcount>26)
//	           this.draw_dea(g);
//	       
	        //macd柱状图
//	      this.DrawMacdRect(g);
	      
	     
        //  this.beistrmax();
        //  this.beistrmin();
	    /*  for(int i=0;i<vecstr.size();i++)
	      {
	    	
	    	 beili b=vecstr.get(i);
	    	
	    	 System.out.println("max="+b.max+" pos="+b.pos);
	    	  
	      }*/
         // this.comparemax(g);
         // this.comparemin(g);
	   }
     
       
   }
   
   //计算加权平均线=
   public void 	weightMa(int weightavgcount)
   {
	   float sum=0;
	   vec_weight.clear();
	   int tempcount = weightavgcount;
	   int sumcount = 0;
	   for(int i=0+removecount;i<datacount+removecount && i<vec.size()-weightavgcount;i++)
	   {
		   for(int j=i;j<i+weightavgcount && j<vec.size();j++)
			  {
			   	  sumcount+=tempcount;
				  sum+=(tempcount--)*vec.get(j).end;
//				  System.out.println("tempcount " + tempcount);
//				  System.out.println("sum "+sum); 
			  }
		   float a = (float)(Math.round(sum/sumcount * 100))/100;
//		   System.out.println("a "+a);
		   vec_weight.add(a);
		   
		   tempcount = weightavgcount;
		   sum = 0;
		   sumcount = 0;
		
	   }
   }
   
   
   
   //从文件中引入数据
   public void initFile(String filename)
	{
	   //每次切换时，清除数据后重新加载
	      vec.clear();
	 
	      FileReader fr=null;
		  BufferedReader br=null;
		
		try 
		{
			fr=new FileReader(filename);
			br=new BufferedReader(fr);
			String str="";
			
		    
			str=br.readLine();
//			System.out.println(str);
			int k=0;
			//读入数据，k表示读入数据的个数
			for( k=0;k<datacount && (str=br.readLine())!=null;k++)
			{
				String substr[]=str.split(",");
				StockData data=new StockData();
				data.addData(substr);
				if(k<showcount)
				{
					if(data.end>maxend)
					{
					  maxend=data.end;
					}
					if(data.end<minend)
					{
						minend=data.end;
					}
					if(data.volumn>maxvolum)
					{
						maxvolum=data.volumn;
					}
					if(data.volumn<minvolum)
					{
						minvolum=data.volumn;
					}
					if(data.high>maxprice)
					{
						maxprice=data.high;
					}
					if(data.low<minprice)
					{
						minprice=data.low;
					}
				}
				
				vec.add(data);
		    	
			}
			
		   datacount=k;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally
		{
		   try 
		   {
			 br.close();
			 fr.close();
			 
			 this.isfile=true;
			 
		   } catch (IOException e) 
		   {
			
			e.printStackTrace();
		   }
		  
		}
	
	   }
   //画均线图
   public void drawline(Graphics g,int count,Color color)
   {
	  
	   sMALinesPoints.clear();
	   int imagewidth=this.getWidth()-300;//画图区域的宽度
	   
	   int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
	  
	  
       this.dataminmax();
	   this.avgdata(count);
	 
     
	   int step=0;//增长步长
       float  extent =maxprice-minprice;
//       System.out.println(extent);
       float minprice2=10000;
       for(int i=0;i<showcount;i++)
       {
    	   		if(minprice2> vec2.get(i))
    	      {
    	   			minprice2=vec2.get(i);
    	      }
       }
//      System.out.println(minprice2);
       
       int nwidth=imagewidth/showcount;
       int count1=imagewidth%showcount;
//       System.out.println("nwidth"+nwidth);
//       System.out.println("count1 " + count1);
       
       int loc=(int)((vec2.get(0)-minprice2)*(line-50)/extent);

//       System.out.println("loc " + loc);
//       System.out.println("loc3 "+loc3);
       g.setColor(color);
       for(int i=1;i<showcount-1-count1;i++)
       {
         float nowavg=vec2.get(i);
//         System.out.println("nowavg " + nowavg);
        
         int loc2=(int)((nowavg-minprice2)/extent*(line-50));

//         System.out.println("loc2 " + loc2);
//         System.out.println("loc4 " + loc4);
         
//         g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth, 100+line-loc2-20);
         Point a = new Point(100+imagewidth-step, 100+line-loc-20);
         sMALinesPoints.add(a);

     
         loc=loc2;
         step+=nwidth;
         
       }
       for(int i=showcount-1-count1;i<showcount-1;i++)
       {
         float nowavg=vec2.get(i);
        
         int loc2=(int)((nowavg-minprice2)/extent*(line-50));
         
//         g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth-1, 100+line-loc2-20);         
         Point a = new Point(100+imagewidth-step, 100+line-loc-20);
         sMALinesPoints.add(a);  
         loc=loc2;
         step+=nwidth+1;
       }
       for (int i = showcount-1; i < vec2.size()-1; i++) 
       {
    	   
    	   		float nowavg=vec2.get(i);
           int loc2=(int)((nowavg-minprice2)/extent*(line-50)); 
           Point a = new Point(100+imagewidth-step, 100+line-loc-20);
           sMALinesPoints.add(a);  
           loc=loc2;
           step+=nwidth+1;
	}
   }
   //画加权平均曲线
   public void drawWei_line(Graphics g,int count,Color color)
   {
	 
	   wMALinesPoints.clear();
	   
	   int imagewidth=this.getWidth()-300;//画图区域的宽度
	   
	   int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
	  

	  
       this.dataminmax();
       this.weightMa(count);
	 
     
	   int step=0;//增长步长
       float  extent =maxprice-minprice;
//       System.out.println(extent);
       float minprice2=10000;
       for(int i=0;i<showcount;i++)
       {
    	   		if(minprice2> vec_weight.get(i))
    	      {
    	   			minprice2=vec_weight.get(i);
    	      }
       }
//      System.out.println(minprice2);
       
       int nwidth=imagewidth/showcount;
       int count1=imagewidth%showcount;
//       System.out.println("nwidth"+nwidth);
//       System.out.println("count1 " + count1);
       
       int loc=(int)((vec_weight.get(0)-minprice2)*(line-50)/extent);


       g.setColor(color);
       for(int i=1;i<showcount-1-count1;i++)
       {
         float nowavg=vec_weight.get(i);
//         System.out.println("nowavg " + nowavg);
        
         int loc2=(int)((nowavg-minprice2)/extent*(line-50));
//         System.out.println("loc2 " + loc2);
//         System.out.println("loc4 " + loc4);
         
//         g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth, 100+line-loc2-20);
         Point a = new Point(100+imagewidth-step, 100+line-loc-20);
         wMALinesPoints.add(a);
         
     
         loc=loc2;
         step+=nwidth;
         
       }
       for(int i=showcount-1-count1;i<showcount-1;i++)
       {
         float nowavg=vec_weight.get(i);
        
         int loc2=(int)((nowavg-minprice2)/extent*(line-50));
         
//         g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth-1, 100+line-loc2-20);
         Point a = new Point(100+imagewidth-step, 100+line-loc-20);
        wMALinesPoints.add(a);
         
         loc=loc2;
       
         step+=nwidth+1;
         
       }
       for (int i = showcount-1; i < vec_weight.size()-1; i++) {
    	   		float nowavg=vec_weight.get(i);
           int loc2=(int)((nowavg-minprice2)/extent*(line-50));
           Point a = new Point(100+imagewidth-step, 100+line-loc-20);
           wMALinesPoints.add(a);
            
            loc=loc2;
          
            step+=nwidth+1;
	}
//       System.out.println(wMALinesPoints.size());
   }
   //画成交量图
   public void drawvolRect(Graphics g)
   {
	   Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
	   int imagewidth=this.getWidth()-300;//画图区域的宽度
	   int imageheight=this.getHeight()-300;//画图区的高度
	   int line=(this.getHeight()-300)/5*3;//画图区的高度
	   
       int line2=(this.getHeight()-300)*2/5;//下面2/5的距离
       
       int downwidth=line2*3/5;//以下面的3/5来画柱状图
       
       this.dataminmax();
       
       int extent=maxvolum-minvolum;
//       System.out.println(extent);
       //标示成交量的最大最小值的线
       g.setColor(Color.white);
       int step2=0;
       for(int i=0;i<imagewidth/10;i++)
       {
          g.drawLine(100+step2, 100+line+20, 100+step2+5, 100+line+20);
          g.drawLine(100+step2, 100+line+downwidth+20, 100+step2+5, 100+line+downwidth+20);
          step2+=10;
       }
       //标示最大最小成交量
     //  g.drawString(maxvolum+" ", 50,100+line+20);
     //  g.drawString(minvolum+"", 50, 100+line+downwidth+20);
      
       String date=vec.get(0).date;
   
      
       int nwidth=imagewidth/showcount;
       int step=nwidth;
       int nwidth1=(int)(nwidth*0.9);
        int count=imagewidth%showcount;
       
       for(int i=0+removecount;i<showcount+removecount-count;i++)
       {
          int nowvolum=vec.get(i).volumn;
          int loc=10;
          if(minvolum>100000)
          {
            loc=((nowvolum-minvolum)/1000)*downwidth/(extent/1000);
          }
          else
          {
        	  loc=(nowvolum-minvolum)*downwidth/extent;  
          }
          if(vec.get(i).end>vec.get(i).begin)
          {
        	  g.setColor(Color.red);
        	
        	
            g.fillRect(100+imagewidth-step, 100+line+downwidth-loc+20, nwidth1,loc+10);
          
          }else
          {
        	 
        	  g.setColor(new Color(0,255,255 ));
        	  g.fillRect(100+imagewidth-step, 100+line+downwidth-loc+20, nwidth1,loc+10);
          
          }
          step+=nwidth;
       
       }
       
       for(int i=showcount+removecount-count;i<showcount+removecount;i++)
       {
          int nowvolum=vec.get(i).volumn;
          int loc=10;
          if(minvolum>100000)
          {
            loc=((nowvolum-minvolum)/1000)*downwidth/(extent/1000);
          }
          else
          {
        	  loc=(nowvolum-minvolum)*downwidth/extent;  
          }
          if(vec.get(i).end>vec.get(i).begin)
          {
        	g.setColor(new Color(0,255,255 ));
        	
            g.fillRect(100+imagewidth-step-1, 100+line+downwidth-loc+20, nwidth1,loc+10);
          
          }else
          {
        	 
        	  g.setColor(Color.red);
        	  g.fillRect(100+imagewidth-step-1, 100+line+downwidth-loc+20, nwidth1,loc+10);
          
          }
          step+=nwidth+1;
       
       }
     
	   
   }
   //画k线图
   public void drawkimg(Graphics g)
   {
	   Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
	   int imagewidth=this.getWidth()-300;//画图区域的宽度
	   int imageheight=this.getHeight()-300;//画图区的高度
	   int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
	   int step=0;
      
       this.dataminmax();
       
       float extent2=maxprice-minprice;
       int count=imagewidth%showcount;
//       System.out.println(showcount);
       int nwidth1=(int)((imagewidth/showcount)*0.9);
       for(int i=0+removecount;i<showcount+removecount-count;i++)
       {
    	  //画矩形
    	   int loc1=(int)((vec.get(i).begin-minprice)/extent2*(line-50));
    	   int loc2=(int)((vec.get(i).end-minprice)/extent2*(line-50));
    	   
    	   //画直线
    	   int loc3=(int)((vec.get(i).low-minprice)/extent2*(line-50));
    	   int loc4=(int)((vec.get(i).high-minprice)/extent2*(line-50));
    	   if(vec.get(i).end>vec.get(i).begin)
    	   {
    		   
    		   g.setColor(Color.red);
    	     
    	      g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2, 100+line-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2, 100+line-loc4-20);
    	      g.fillRect(100+imagewidth-step-imagewidth/showcount, 100+line-loc2-20, nwidth1, loc2-loc1+1);
    	   }
    	   else if(vec.get(i).end<vec.get(i).begin)
    	   {
    		 
    		 
    		  g.setColor(new Color(0,255,255 ));
     	      g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2, line+100-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2, 100+line-loc4-20);
     	      g.fillRect(100+imagewidth-step-imagewidth/showcount, 100+line-loc1-20, nwidth1, loc1-loc2+1);
    	   }
    	   else 
    	   {
    		   g.setColor(Color.green);
    		   g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2, line+100-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2, 100+line-loc4-20);
    		   g.fillRect(100+imagewidth-step-imagewidth/showcount, 100+line-loc1-20, nwidth1, loc1-loc2+1);
    	   }
    	   step+=imagewidth/showcount;
    	   
       }
       for(int i=showcount+removecount-count;i<showcount+removecount;i++)
       {
    	  //画矩形
    	   int loc1=(int)((vec.get(i).begin-minprice)/extent2*(line-50));
    	   int loc2=(int)((vec.get(i).end-minprice)/extent2*(line-50));
    	   
    	   //画直线
    	   int loc3=(int)((vec.get(i).low-minprice)/extent2*(line-50));
    	   int loc4=(int)((vec.get(i).high-minprice)/extent2*(line-50));
    	   if(vec.get(i).end>vec.get(i).begin)
    	   {
    		   
    		   g.setColor(Color.red);
    	     
    	      g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2-1, 100+line-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2-1, 100+line-loc4-20);
    	      g.fillRect(100+imagewidth-step-imagewidth/showcount-1, 100+line-loc2-20, nwidth1, loc2-loc1+1);
    	   }
    	   else if(vec.get(i).end<vec.get(i).begin)
    	   {
    		 
    		 
    		  g.setColor(new Color(0,255,255 ));
     	      g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2-1, line+100-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2-1, 100+line-loc4-20);
     	      g.fillRect(100+imagewidth-step-imagewidth/showcount-1, 100+line-loc1-20, nwidth1, loc1-loc2+1);
    	   }
    	   else 
    	   {
    		   g.setColor(Color.green);
    		   g.drawLine(100+imagewidth-step-(imagewidth/showcount+5)/2-1, line+100-loc3-20,100+imagewidth-step-(imagewidth/showcount+5)/2-1, 100+line-loc4-20);
    		   g.fillRect(100+imagewidth-step-imagewidth/showcount-1, 100+line-loc1-20, nwidth1, loc1-loc2+1);
    	   }
    	   step+=imagewidth/showcount+1;
    	   
       }
       
       
       
       
       g.setColor(Color.white);
      // g.drawString(maxprice+" ", 70, 130);
      // g.drawString(minprice+" ", 70, 100+line-20);
       int step2=0;
       for(int i=0;i<imagewidth/10;i++)
       {
         g.drawLine(100+step2, 130, 100+step2+5, 130);
         g.drawLine(100+step2, 100+line-20, 100+step2+5,100+line-20 );
         step2+=10;
       }
   }
   //画价格曲线
  public void drawendprice(Graphics g)
  {
  int imagewidth=this.getWidth()-300;//画图区域的宽度
  int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
 
  
  this.dataminmax();

  int step=0;//增长步长
  float  extent =maxprice-minprice;

  
  int count1=imagewidth%showcount;

  int nwidth=(int)(imagewidth/showcount);

  
  int loc=(int)((vec.get(0).end-minend)*(line-50)/extent);

  g.setColor(Color.white);
  for(int i=1;i<showcount-1-count1;i++)
  {
    float nowavg=vec.get(i).end;

   
    int loc2=(int)((nowavg-minend)/extent*(line-50));
    float lineWidth = 3.0f;
    ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
    g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth, 100+line-loc2-20);
    

    loc=loc2;
    step+=nwidth;
    
  }
  for(int i=showcount-1-count1;i<showcount-1;i++)
  {
    float nowavg=vec.get(i).end;
   
    int loc2=(int)((nowavg-minend)/extent*(line-50));
    
    g.drawLine(100+imagewidth-step, 100+line-loc-20, 100+imagewidth-step-nwidth-1, 100+line-loc2-20);
    
    
    loc=loc2;
    step+=nwidth+1;
    
  }
      
  }
   //进行画均线前的数值计算
   public void avgdata(int avgcount)//均线天数
   {
	      float sum=0;
		  vec2.clear();
		  for(int i=0+removecount;i<datacount+removecount && i<vec.size()-avgcount;i++)
		  {
			  for(int j=i;j<i+avgcount && j<vec.size();j++)
			  {
				  sum+=vec.get(j).end;
//				  System.out.println("sum "+sum);
				  
			  }
			  float a = (float)(Math.round(sum/avgcount * 100))/100;
//			  System.out.println("a "+ a);
			  vec2.add(a);
			  sum=0;
		  }
		   
   }
   public String choosefile()
   {
	   JFileChooser filechoose=new JFileChooser();
	   filechoose.showOpenDialog(null);
	   
	  
	   String filename=filechoose.getCurrentDirectory().getAbsolutePath();
//	   System.out.println(filename);
		  
	   filename+='/';
//	   System.out.println(filename);
	   filename+=filechoose.getSelectedFile().getName();
//	   System.out.println(filename);
	
	  String tempstr=filechoose.getSelectedFile().getName();//得到文件名
	  this.fileName= tempstr.substring(0, tempstr.length()-4);
	   
	 
	   
	  f.stockName=this.fileName.substring(this.fileName.length()-15, this.fileName.length()-11);
      
//     System.out.println(f.stockname);
//	 System.out.println(filename);
	   return filename;
	  
      
   }
   public void dataminmax()//求需要数据的最大最小值
   {
	   maxend=0;
	   minend=1000;
	   
	   maxvolum=0;
	   minvolum=100000000;
	   
	   maxprice=0;
	   minprice=1000;//重新置初值，求得最小最大值
	   
	   for(int k=0+removecount;k<showcount+removecount ;k++)
		{
		  
		   
		   StockData data=vec.get(k);
			if(k<showcount+removecount)
			{
				if(data.end>maxend)
				{
				  maxend=data.end;
//				  System.out.println("maxend " + maxend);
				}
				if(data.end<minend)
				{
					minend=data.end;
//					System.out.println("minend " + minend);
				}
				if(data.volumn>maxvolum)
				{
					maxvolum=data.volumn;
				}
				if(data.volumn<minvolum)
				{
					minvolum=data.volumn;
				}
				if(data.high>maxprice)
				{
					maxprice=data.high;
				}
				if(data.low<minprice)
				{
					minprice=data.low;
				}
			} 
		}
   }
   //计算 SMA 曲线与 WMA 曲线的交点
  public void interPoint()
  {
	  interPoints.clear();
	  for (int i = 0; i < sMALinesPoints.size()-1; i++) {
		if (sMALinesPoints.get(i).y == wMALinesPoints.get(i).y) {
			if (sMALinesPoints.get(i).x > 0) {
				iPoint newIPoint = new iPoint(sMALinesPoints.get(i),i);
				interPoints.add(newIPoint);
				System.out.println("ipoint ("+newIPoint.x+","+newIPoint.y+")"+" i " +i );
			}
			
		}
		if (sMALinesPoints.get(i).y < wMALinesPoints.get(i).y && sMALinesPoints.get(i+1).y > wMALinesPoints.get(i+1).y) {
			if (sMALinesPoints.get(i).x > 0) {
				iPoint newIPoint = new iPoint(sMALinesPoints.get(i),i);
				interPoints.add(newIPoint);
				System.out.println("ipoint ("+newIPoint.x+","+newIPoint.y+")"+" i " +i );
			}

		}
		if (sMALinesPoints.get(i).y > wMALinesPoints.get(i).y && sMALinesPoints.get(i+1).y < wMALinesPoints.get(i+1).y) {
			if (wMALinesPoints.get(i).x > 0) {
				iPoint newIPoint = new iPoint(wMALinesPoints.get(i),i);
				interPoints.add(newIPoint);
				System.out.println("ipoint ("+newIPoint.x+","+newIPoint.y+")"+" i " +i );
			}

		}
		
	}
  }
   //画交线
   public void draw_interLine(Graphics g)
   {
	   interPoint();
	   g.setColor(Color.blue);
	   for(int i = 0; i<interPoints.size()-1;i++)
	   {
		   
//		   g.drawLine(interPoints.get(i).x, interPoints.get(i).y, interPoints.get(i+1).x, interPoints.get(i+1).y);
	   }
   }
   //计算SMA 曲线与 WMA 曲线离每条交线最远距离的点
   public void calFarthest()
   {

	   highDistance.clear();
	   int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
	  
	   this.dataminmax();

	   float  extent =maxprice-minprice;

	   
	   double maxdis = 0;
	   Point maxPoint = new Point();
	   double mindis = 0;
	   Point minPoint = new Point();
	   int maxnum = 0;
	   int minnum = 0;
	   double dis1 = 0;
	   double dis2 = 0;
	   for (int i = 0; i < interPoints.size()-1; i++) {
		   System.out.println(interPoints.get(i).num+"——"+interPoints.get(i+1).num);
		   int a = interPoints.get(i).num;
		   int b = interPoints.get(i+1).num;
		for (int j = a; j < b; j++) {
			Point temp1 = sMALinesPoints.get(j);
			Point temp2 = wMALinesPoints.get(j);
			int x1 = interPoints.get(i).x;
			int y1 = interPoints.get(i).y;
			int x2 = interPoints.get(i+1).x;
			int y2 = interPoints.get(i+1).y;
			double k = (y1-y2)/(double)(x1-x2);//斜率
//			System.out.println("k " + k);
			double k0 = (temp1.y - y2)/(double)(temp1.x-x2);
//			System.out.println("k0 " + k0);
			double k1 = (temp2.y - y2)/(double)(temp2.x-x2);
//			System.out.println("k1 " + k1);
			 dis1 = pointToLine(x1, y1, x2, y2, temp1.x,temp1.y);
//			System.out.println("dis1 " + dis1);
			 dis2 = pointToLine(x1, y1, x2, y2, temp2.x,temp2.y);
//			System.out.println("dis2 " + dis2);
			if (k<0 && k0<=k && k1 <= k) {
				if (dis1 >= dis2 && dis1 > mindis) {
					mindis = dis1;
					minnum = j;
					minPoint = temp1;
//					System.out.println("hi1");
				}
				else if(dis2 > dis1 && dis2 > mindis){
					mindis = dis2;
					minnum = j;
					minPoint = temp2;
//					System.out.println("hi2");
				}
			}
			else if (k<0 && k0>=k && k1 >= k) {
				if (dis1 >= dis2 && dis1 > maxdis) {
					maxdis = dis1;
					maxnum = j;
					maxPoint = temp1;
//					System.out.println("hi3");
				}
				else if(dis2 > dis1 && dis2 > maxdis){
					maxdis = dis2;
					maxnum = j;
					maxPoint = temp2;
//					System.out.println("hi4");
				}
			}
			else if (k<0 && k0>=k && k1 <= k) {
				if (dis1 > maxdis) {
					maxdis = dis1;
					maxnum = j;
					maxPoint = temp1;
//					System.out.println("hi5");
				}
				else if(dis2 > mindis){
					mindis = dis2;
					minnum = j;
					minPoint = temp2;
//					System.out.println("hi6");
				}
			}
			else if (k<0 && k0<=k && k1 >= k) {
				if (dis1 > mindis) {
					mindis = dis1;
					minnum = j;
					minPoint = temp1;
//					System.out.println("hi7");
				}
				else if(dis2 > maxdis){
					maxdis = dis2;
					maxnum = j;
					maxPoint = temp2;
//					System.out.println("hi8");
				}
			}
			else if (k>0 && k0<=k && k1 <= k) {
				if (dis1 >= dis2 && dis1 > mindis) {
					mindis = dis1;
					minnum = j;
					minPoint = temp1;
//					System.out.println("hi9");
				}
				else if(dis2 > dis1 && dis2 > mindis){
					mindis = dis2;
					minnum = j;
					minPoint = temp2;
//					System.out.println("hi10");
				}
			}
			else if (k>0 && k0>=k && k1 >= k) {
				if (dis1 >= dis2 && dis1 > maxdis) {
					maxdis = dis1;
					maxnum = j;
					maxPoint = temp1;
//					System.out.println("hi11");
				}
				else if(dis2 > dis1 && dis2 > maxdis){
					maxdis = dis2;
					maxnum = j;
					maxPoint = temp2;
//					System.out.println("hi12");
				}
			}
			else if (k>0 && k0<=k && k1 >= k) {
				if (dis1 > mindis) {
					mindis = dis1;
					minnum = j;
					minPoint = temp1;
//					System.out.println("hi13");
				}
				else if(dis2 > maxdis){
					maxdis = dis2;
					maxnum = j;
					maxPoint = temp2;
//					System.out.println("hi14");
				}
			}
			else if (k>0 && k0>=k && k1 <= k) {
				if (dis1 > maxdis) {
					maxdis = dis1;
					maxnum = j;
					maxPoint = temp1;
//					System.out.println("hi15");
				}
				else if(dis2 > mindis){
					mindis = dis2;
					minnum = j;
					minPoint = temp2;
//					System.out.println("hi16");
				}
			}
			
		}
		if (dis1 == 0 && dis2 == 0) {
			continue;
		}
		int loc1=(int)((vec.get(minnum).end-minend)*(line-50)/extent);
		minPoint.y = 100+line-loc1-20;
		int loc2=(int)((vec.get(maxnum).end-minend)*(line-50)/extent);
		maxPoint.y = 100+line-loc2-20;
		System.out.println("maxnum "+maxnum);
		System.out.println("minnum " + minnum);
		System.out.println("max ("+maxPoint.x+","+maxPoint.y+")");
		System.out.println("min ("+minPoint.x+","+minPoint.y+")");
		if (maxPoint.x < minPoint.x) {
			if (minnum <= b && minnum >= a) {
				highDistance.add(minPoint);
			}
			if (maxnum <= b && maxnum >= a) {
				highDistance.add(maxPoint);
			}
		}
		else if(maxPoint.x > minPoint.x) {
			if (maxnum <= b && maxnum >= a) {
				highDistance.add(maxPoint);
			}
			if (minnum <= b && minnum >= a) {
				highDistance.add(minPoint);
			}
		}
		else if(maxPoint.x == minPoint.x) {
			if (maxnum <= b && maxnum >= a) {
				highDistance.add(maxPoint);
			}
		}
		System.out.println();
		maxdis = 0;
		mindis = 0;
	}
   }
   //计算点到直线的距离
   public double pointToLine(int x1,int y1,int x2,int y2,int x0,int y0)
   {
	   double space = 0;
	   double a,b,c; 
	   a = lineSpace(x1, y1, x2, y2);
	   b = lineSpace(x1, y1, x0, y0);
	   c = lineSpace(x2, y2, x0, y0);
	   if (c<=0.000001 || b<=0.000001) 
	   {
		space = 0;
		return space;
	   }
	   if (a<=0.000001)
	   {
		space = b;
		return space;
	   }
	   if (c*c>=a*a+b*b) {
		space = b;
		return space;
	}
	   if (b*b>=a*a+c*c) {
		space = c;
		return space;
	}
	   double p = (a+b+c)/2;
	   double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
	   space = 2*s/a;
	   return space;
   }
  //计算两点之间的距离
   public double lineSpace(int x1,int y1,int x2,int y2) {
	double lineLength = 0;
	lineLength = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	return lineLength;
}
   //画线性分段
   public void draw_PLR(Graphics g) {
	   System.out.println("hi");
	   calFarthest();
	g.setColor(Color.green);
	for (int i = 0; i < highDistance.size()-1; i++) {
		g.drawLine(highDistance.get(i).x, highDistance.get(i).y, highDistance.get(i+1).x, highDistance.get(i+1).y);
	}
}
   //实时数据的编写
  public void draw_time(Graphics g)
  {
	  Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
		 
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
	  int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
      
	  g.drawString("实时数据",100+imagewidth+20, 90);
      g.setColor(Color.red);
     
      g.drawLine(100+imagewidth+20, 120,100+imagewidth+170, 120);
      g.drawString("委    比", 100+imagewidth+25, 115);
      
      g.drawLine(100+imagewidth+20, 350,100+imagewidth+170, 350);
      g.drawLine(100+imagewidth+20, 100+100+30,100+imagewidth+170, 100+100+30);
      
      g.drawLine(100+imagewidth+40, 120,100+imagewidth+40, 350);
    
      g.drawString("卖", 100+imagewidth+25, 160);
      g.drawString("盘", 100+imagewidth+25, 200);
      g.drawString("买", 100+imagewidth+25, 280);
      g.drawString("盘", 100+imagewidth+25, 320);
      g.setColor(Color.white);
      g.drawString("5",100+imagewidth+45, 140);
      g.drawString("4",100+imagewidth+45, 160);
      g.drawString("3",100+imagewidth+45, 180);
      g.drawString("2",100+imagewidth+45, 200);
      g.drawString("1",100+imagewidth+45, 220);
      
      g.drawString("1",100+imagewidth+45, 255);
      g.drawString("2",100+imagewidth+45, 275);
      g.drawString("3",100+imagewidth+45, 295);
      g.drawString("4",100+imagewidth+45, 315);
      g.drawString("5",100+imagewidth+45, 335);
      
      g.setColor(Color.yellow);
      g.drawString(f.str[29]+"    "+Integer.parseInt(f.str[28])/100+"", 100+imagewidth+60, 140);
      g.drawString(f.str[27]+"    "+Integer.parseInt(f.str[26])/100+"", 100+imagewidth+60, 160);  
      g.drawString(f.str[25]+"    "+Integer.parseInt(f.str[24])/100+"", 100+imagewidth+60, 180);
      g.drawString(f.str[23]+"    "+Integer.parseInt(f.str[22])/100+"", 100+imagewidth+60, 200);
      g.drawString(f.str[21]+"    "+Integer.parseInt(f.str[20])/100+"", 100+imagewidth+60, 220);
      
      g.drawString(f.str[11]+"    "+Integer.parseInt(f.str[10])/100+"",100+imagewidth+60, 255);
      g.drawString(f.str[13]+"    "+Integer.parseInt(f.str[12])/100+"",100+imagewidth+60, 275);
      g.drawString(f.str[15]+"    "+Integer.parseInt(f.str[14])/100+"",100+imagewidth+60, 295);
      g.drawString(f.str[17]+"    "+Integer.parseInt(f.str[16])/100+"",100+imagewidth+60, 315);
      g.drawString(f.str[19]+"    "+Integer.parseInt(f.str[18])/100+"",100+imagewidth+60, 335);
      
      g.setColor(Color.red);
      g.drawLine(100+imagewidth+95, 350, 100+imagewidth+95, 570);
      g.setColor(Color.white);
      g.drawString("最新：", 100+imagewidth+25, 380);
      g.drawString("开盘：", 100+imagewidth+100, 380);
      g.drawString("涨跌：", 100+imagewidth+25, 410);
      g.drawString("最高：", 100+imagewidth+100, 410);
      g.drawString("涨幅：", 100+imagewidth+25, 440);
      g.drawString("均价：", 100+imagewidth+100, 440);
      g.drawString("总手：", 100+imagewidth+25, 470);
      g.drawString("量比：", 100+imagewidth+100, 470);
      g.drawString("金额：", 100+imagewidth+25, 500);
      g.drawString("换手：", 100+imagewidth+100, 500);
      g.drawString("股本：", 100+imagewidth+25, 530);
      g.drawString("流通：", 100+imagewidth+100, 530);
      g.drawString("振幅：", 100+imagewidth+25 ,560);
      g.drawString("最低：", 100+imagewidth+100 ,560);
      
      g.setColor(Color.green);
      g.drawString(f.str[6],100+imagewidth+55 ,380);
      g.drawString(f.str[1],100+imagewidth+130 ,380);
      g.drawString(f.str[4],100+imagewidth+130 ,410);
      g.drawString(f.str[5],100+imagewidth+130 ,560);
      g.drawString(f.str[3],100+imagewidth+55 ,380);
      
      //计算股本
      DecimalFormat decimalFormat=new DecimalFormat(".0");
      String stock=decimalFormat.format(Float.parseFloat(f.str[8])/1000000);
      g.drawString(stock+"万",100+imagewidth+55 ,470);
      
      //计算金额
      decimalFormat=new DecimalFormat(".0");
      stock=decimalFormat.format(Float.parseFloat(f.str[9])/100000000);
      g.drawString(stock+"亿",100+imagewidth+55 ,500);
      
      //加入图标
      Image im =Toolkit.getDefaultToolkit().getImage("./images/1.jpg");
      g.drawImage(im,100+imagewidth+25,635,null);
      
      
      
  }
  //加入时间轴
  public void drawtime(Graphics g)
  {
	
	  Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
		 
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
      g.setColor(Color.red);
      
      int width=imagewidth/showcount;
      int count=imagewidth%showcount;
      
      int count1=showcount/20;
      
      //表示点
      for(int i=0;i<showcount;i+=count1)
      {
       g.drawLine(100+imagewidth-i*width-width/2, 100+imageheight-5, 100+imagewidth-i*width-width/2, 100+imageheight+5);
      }
      
     
      
      g.setColor(Color.white);
      
      //表示时间
      for(int i=0+removecount;i<showcount+removecount;i+=count1)
      {
	        String time=vec.get(i).date;
	        String str[]=time.split("-");
	        String time2=str[1]+"-"+str[2];
	      //  System.out.println(str[1]+" "+str[2]);
	        g.drawString(time2, 100+imagewidth-(i-removecount)*width-width/2-8, 100+imageheight+15);
      }
      
	  
  }
  
  public void EMA(int daycount)
  {
	  vecema.clear();
	  float ema=vec.get(vec.size()-1).end;
	  this.vecema.add(ema);
	  float n=(float)(daycount+1);
	  float k=2/n;
	  for(int i=1;i<vec.size();i++)
	  {
		  ema=(1-k)*vecema.get(i-1)+k*vec.get(vec.size()-1-i).end;
		  vecema.add(ema);//从以前的数据开始存
	  }
	
 
  }
  //求ema的最值
  public void emaminmax()
  {
	  for(int i=datacount-showcount;i<datacount;i++)
      {
      	if(vecema.get(i)>emamax)
      	{
      	   emamax=vecema.get(i);
      
      	}
      	if(vecema.get(i)<emamin)
      	{
      		 emamin=vecema.get(i);
      	}
      }
	  
  }
  //画ema线
  public void draw_ema(int n,Graphics g,Color color)
  {
	 
	  this.EMA(n);
	  this.emaminmax();
	   
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
	  float extent=emamax-emamin;
      float ema=vecema.get(datacount-showcount-1);
  	
  	  int loc1=(int)((ema-emamin)/extent*100);

  	  int step=0;
  	  g.setColor(color);
  	  int nwidth=imagewidth/showcount;
  	  int count=imagewidth%showcount;
      for(int i=datacount-showcount;i<datacount-count;i++)
      {
      	float ema2=vecema.get(i);
       	
       	int loc2=(int)((ema2-emamin)/extent*100);
        g.drawLine(100+step, 100+imageheight+150-loc1-15, 100+step+nwidth, 100+imageheight+150-loc2-15);
        loc1=loc2;
        step+=nwidth;
     }
      for(int i=datacount-count;i<datacount;i++)
      {
      	float ema2=vecema.get(i);
       	
       	int loc2=(int)((ema2-emamin)/extent*100);
        g.drawLine(100+step, 100+imageheight+150-loc1-15, 100+step+nwidth, 100+imageheight+150-loc2-15);
        loc1=loc2;
        step+=nwidth+1;
     }
      
  }
  //求macd12数据
  public void MACD1()
  {
	 
	  vecmacd1.clear();
	  this.EMA(12);
	  for(int i=vecema.size()-1;i>=0;i--)
	  {
		  float ema=vecema.get(i);
		  vecmacd1.add(ema);//从最新的数据开始存
	  }
	  
  }
  //macd26的数据
  public void MACD2()
  {
	
	  vecmacd2.clear();
	  this.EMA(26);
	  for(int i=vecema.size()-1;i>=0;i--)
	  {
		  float ema=vecema.get(i);
		  vecmacd2.add(ema);//从最新的数据开始存
	  }
	  
  }
  //求dif(差离值)数据
  public void DIF()
  {
	  this.MACD1();
	  this.MACD2();
	  vecdif.clear();
	  for(int i=0;i<vecmacd1.size();i++)
	  {
		  float dif=(vecmacd1.get(i)-vecmacd2.get(i))*2;
		  vecdif.add(dif);//从最新数据开始存
	  }
	  
  }
  //求9日的dea
  public void DEA(int daycount)
  {
	 vecdea.clear();
	 float dea=vecdif.get(vecdif.size()-1);
	 vecdea.add(dea);
	 
	 float n=(float)(daycount+1);
	 float k=2/n;
	 for( int i=1;i<vecdif.size();i++)
	 {
		 dea=vecdea.get(i-1)*(1-k)+k*vecdif.get(vecdif.size()-1-i);
		 vecdea.add(dea);//从最后的数据开始存
	 }
	// System.out.println("vecdae="+vecdea.size()+"  showcount="+datacount);
  }
  //求dif的最值
  public void DeaDifRect()
  {
	  vecdeadif.clear();
	   this.DIF();
	   this.DEA(9);
      
	  for(int i=0;i<showcount;i++)
	  {
		float dif=vecdif.get(i);
		float dea=vecdea.get(vecdea.size()-1-i);
	    float temp=(dif-dea)*2;
		vecdeadif.add(temp);//从最新数据开始存的
	//	System.out.println("dif-temp="+temp);
	  }
  }

  public void maxmindif()
  {
	  this.DIF();
	  difmax=0;
	  difmin=1000;
	  for(int i=0;i<showcount;i++)
	  {
		  if(vecdif.get(i)>difmax)
		  {
			  difmax=vecdif.get(i);
		  }
		  if(vecdif.get(i)<difmin)
		  {
			  difmin=vecdif.get(i);
		  }
		  
	  }
 //	System.out.println(difmin+" "+difmax);
  }
  //求dea的最值
  public void maxmindea()
  {
	  this.DEA(9);
	  deamax=0;
	  deamin=1000;
	  for(int i=datacount-showcount;i<datacount;i++)
	  {
		  if(vecdea.get(i)>deamax)
		  {
			  deamax=vecdea.get(i);
		  }
		  if(vecdea.get(i)<deamin)
		  {
			  deamin=vecdea.get(i);
		  }
		  
	  }
  }
  //画dif图 //有问题
  public void draw_dif(Graphics g)
  {
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
	 
	  
	  this.maxmindif();
      this.maxmindea();
      
      float max,min;
      if(deamax>=difmax)
      {
    	  max=deamax;
      }
      else
      {
    	  max=difmax;
      }
      if(deamin<=difmin)
      {
    	  min=deamin;
      }
      else
      {
    	  min=difmin;
      }
      
      float extent=max-min;
      float dif=vecdif.get(0);
  	
  	  int loc1=(int)((dif-min)/extent*130);
      // System.out.println("extent="+extent);
      
  	  int step=0;
  	 
  	  int nwidth=imagewidth/showcount;
  	  int count=imagewidth%showcount;
      for(int i=1;i<showcount-count;i++)
      {
      	float dif2=vecdif.get(i);
       	
       	int loc2=(int)((dif2-min)/extent*130);
        g.drawLine(100+imagewidth-step, 100+imageheight+150-loc1, 100+imagewidth-step-nwidth, 100+imageheight+150-loc2);
       // System.out.println("dif="+dif2+" "+min+" "+extent+" loc1="+loc1+" loc2="+loc2);
        loc1=loc2;
        step+=nwidth;
     }
      for(int i=showcount-count;i<showcount;i++)
      {
      	float dif2=vecdif.get(i);
       	
       	int loc2=(int)((dif2-min)/extent*130);
        g.drawLine(100+imagewidth-step, 100+imageheight+150-loc1, 100+imagewidth-step-nwidth, 100+imageheight+150-loc2);
        loc1=loc2;
        step+=nwidth+1;
     }
        
  
  }
  //画dea图//有问题
  
  public void draw_dea(Graphics g)
  {
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
	  
	  this.maxmindif();
      this.maxmindea();
      
      g.setColor(Color.yellow);
      float max,min;
      if(deamax>=difmax)
      {
    	  max=deamax;
      }
      else
      {
    	  max=difmax;
      }
      if(deamin<=difmin)
      {
    	  min=deamin;
      }
      else
      {
    	  min=difmin;
      }
      float extent=max-min;
      float dea=vecdea.get(datacount-1);
  	
  	  int loc1=(int)((dea-min)/extent*130);

  	  int step=0;
  	 
  	  int nwidth=imagewidth/showcount;
  	  int count=imagewidth%showcount;
      for(int i=datacount-2;i>datacount-showcount+count;i--)
      {
      	float dea2=vecdea.get(i);
       	
       	int loc2=(int)((dea2-min)/extent*130);
        g.drawLine(100+imagewidth-step, 100+imageheight+150-loc1, 100+imagewidth-step-nwidth, 100+imageheight+150-loc2);
        
        loc1=loc2;
        step+=nwidth;
     }
      for(int i=datacount-showcount+count;i>datacount-showcount;i--)
      {
      	float dea2=vecdea.get(i);
       	
       	int loc2=(int)((dea2-min)/extent*130);
        g.drawLine(100+imagewidth-step, 100+imageheight+150-loc1, 100+imagewidth-step-nwidth, 100+imageheight+150-loc2);
        loc1=loc2;
        step+=nwidth+1;
     }
        
  
  }
  public void DrawMacdRect(Graphics g)
  {

	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度
	  this.DeaDifRect();
      
      
      int nwidth=(int)((imagewidth/showcount)*0.8);
      int step=0;
      int count=imagewidth%showcount;
  
     for(int i=0;i<showcount-count;i++)
     {
  	   float dif=vecdeadif.get(i);
  	
  	   int loc=(int)(Math.abs(dif*30));
  	   if(dif>0)
  	   {
  		   g.setColor(Color.red);
  		   g.fillRect(100+imagewidth-step-nwidth, 100+imageheight+100-loc, nwidth,loc);
  	   }
  	   if(dif<0)
  	   {
  		
  		  g.setColor(Color.green);
  		  g.fillRect(100+imagewidth-step-nwidth, 100+imageheight+100,nwidth,loc);
       	
  		   
  	  }
  	  
  	   step+=imagewidth/showcount;
     }
     for(int i=showcount-count;i<showcount;i++)
     {
  	   float dif=vecdeadif.get(i);
  	
  	   int loc=(int)(Math.abs(dif*30));
  	   if(dif>0)
  	   {
  		   g.setColor(Color.red);
  		   g.fillRect(100+imagewidth-step-nwidth, 100+imageheight+100-loc, nwidth,loc);
  	   }
  	   if(dif<0)
  	   {
  		
  		  g.setColor(Color.green);
  		  g.fillRect(100+imagewidth-step-nwidth, 100+imageheight+100,nwidth,loc);
       	
  		   
  	   }
  	  
  	   step+=imagewidth/showcount+1;
     }
	  
  }
  
  public void  beistrmax()//背离策略 ，上面的最大值
  {
	
	  vecstr1.clear();
	  float max=-10;
	  int index=0;
	  int num=0;
	  for(int i=0;i<showcount;i++)
	  {
		  
	    float dif=vecdeadif.get(i);
	//	System.out.println("dif="+dif+" i="+i);
		  
		 if(dif>0)
		  {
            if(dif>max)
			 {
				 max=dif;
				 index=i;
			 }
              
		  }
		 else
		 { 
			 if(max!=-10)
			 {
			    beili b=new  beili();
				b.max=max;
				b.pos=index;
			    vecstr1.add(b);
			    max=-10;
				index=0;
			 }
		 }
	  
	  }
	 
  }
  public void  beistrmin()//背离策略 ，下面的最大值
  {
	
	  vecstr2.clear();
	  float min=1000;
	  int index=0;
	
	  for(int i=0;i<showcount;i++)
	  {
		  
	    float dif=vecdeadif.get(i);
	//	System.out.println("dif="+dif+" i="+i);
		  
		 if(dif<0)
		  {
            if(dif<min)
			 {
				 min=dif;
				 index=i;
			 }
              
		  }
		 else
		 { 
			 if(min!=1000)
			 {
			    beili b=new  beili();
				b.min=min;
				b.pos=index;
			    vecstr2.add(b);
			    min=1000;
				index=0;
			 }
		 }
	  
	  }
	 
  }
  //比较上面的股价和
  public void comparemax(Graphics g)
  {
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度

    /*  float max,min;
      if(deamax>=difmax)
      {
    	  max=deamax;
      }
      else
      {
    	  max=difmax;
      }
      if(deamin<=difmin)
      {
    	  min=deamin;
      }
      else
      {
    	  min=difmin;
      }
      
      float extent=max-min;*/
      
	 for(int i=0;i<vecstr1.size()-1;i++)
	 {
		 beili b1=vecstr1.get(i);
		 beili b2=vecstr1.get(i+1);
		 StockData d1=vec.get(b1.pos);
		 StockData d2=vec.get(b2.pos);
		  
		// int count=imagewidth%showcount;
		 int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
		
		 float extent2=maxprice-minprice;
		 
		 if((b1.max>b2.max && d1.end<d2.end) || (b1.max<b2.max && d1.end>d2.end) )
		 {
			//System.out.println("max1="+b1.max+" max2="+b2.max+" d1.data="+d1.end+" d2.data="+d2.end);
		    int step1=(b1.pos-1)*(imagewidth/showcount);
		    int step2=(b2.pos-1)*(imagewidth/showcount);
		    
		    int loc1=(int)(Math.abs(b1.max*40));
		    int loc2=(int)(Math.abs(b2.max*40));
		    
		    int loc3=(int)((vec.get(b1.pos).begin-minprice)/extent2*(line-50));
	    	int loc4=(int)((vec.get(b2.pos).end-minprice)/extent2*(line-50));
	    	
		    g.setColor(Color.red);
		    g.drawLine(100+imagewidth-step1,100+imageheight+105-loc1,100+imagewidth-step2 ,100+imageheight+105-loc2);
		    g.drawLine(100+imagewidth-step1,100+line-20-loc3,100+imagewidth-step2 ,100+line-20-loc4);
		 }
	 }
  }
  public void comparemin(Graphics g)//下面的股价比较
  {
	  int imagewidth=this.getWidth()-300;//画图区域的宽度
	  int imageheight=this.getHeight()-300;//画图区的高度

    /*  float max,min;
      if(deamax>=difmax)
      {
    	  max=deamax;
      }
      else
      {
    	  max=difmax;
      }
      if(deamin<=difmin)
      {
    	  min=deamin;
      }
      else
      {
    	  min=difmin;
      }
      
      float extent=max-min;
      int count=imagewidth%showcount;*/
      
	 for(int i=0;i<vecstr2.size()-1;i++)
	 {
		 beili b3=vecstr2.get(i);
		 beili b4=vecstr2.get(i+1);
		 StockData d3=vec.get(b3.pos);
		 StockData d4=vec.get(b4.pos);
		
		 int line=(this.getHeight()-300)*3/5;//取3/5的区域画上面的图
			
		 float extent2=maxprice-minprice;
		 if(b3.min>b4.min && d3.end<d4.end || b3.min<b4.min && d3.end>d4.end )
		 {
		    int step1=(b3.pos-1)*(imagewidth/showcount);
		    int step2=(b4.pos-1)*(imagewidth/showcount);
		    
		    int loc1=(int)(Math.abs(b3.min*40));
		    int loc2=(int)(Math.abs(b4.min*40));
		    
		    int loc3=(int)((vec.get(b3.pos).begin-minprice)/extent2*(line-50));
	    	int loc4=(int)((vec.get(b4.pos).end-minprice)/extent2*(line-50));
		   
		    g.setColor(Color.white);
		 
		    g.drawLine(100+imagewidth-step1,100+imageheight+105+loc1,100+imagewidth-step2 ,100+imageheight+105+loc2);
		    g.drawLine(100+imagewidth-step1,100+line-20-loc3,100+imagewidth-step2 ,100+line-20-loc4);
		    // System.out.println("背离");
		 }
	 }
  }
   
	   //键盘事件
	
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
		
		//对下键的反应
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(showcount>20)
			{
				showcount-=10;
				this.dataminmax();
				this.repaint();
			}
		
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//System.out.println("向上");
			if(showcount+removecount+30<datacount && showcount+removecount<vec.size())
			{
				showcount+=10;
				this.dataminmax();
				this.repaint();
			}
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			//System.out.println("向左");
			
			//图形偏移
			if(removecount<datacount-showcount)
			{
				removecount+=1;
			
				this.dataminmax();
				this.repaint();
			}
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			//System.out.println("向右");
			if(removecount>1)
			{
				removecount-=1;
				this.dataminmax();
				this.repaint();
			}
		}
	
	    
		
	}
	//鼠标事件
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) 
	{ 
		   Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
		   int imagewidth=this.getWidth()-300;//画图区域的宽度
		   int imageheight=this.getHeight()-300;//画图区的高度
		// TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON1)//e.ismetadown这是右键点击
		{
			
			if(e.getX()>100 && e.getX()<100+imagewidth)
			    x=e.getX()-100;
		
				this.repaint();
			
		}
		else
		{
			x=0;
			this.repaint();
		}
		if(e.getX()>=100+imagewidth+25 && e.getX()<=100+imagewidth+25+131 && e.getY()>=635 && e.getY()<=635+14)
		{
			String str=  "rundll32 url.dll,FileProtocolHandler http://finance.sina.com.cn/" ;
			try 
			{
				Runtime.getRuntime().exec(str);
			} catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//菜单点击事件
		if(e.getSource()==this.jm1_1)
		{
			 String filename=this.choosefile();
			
			 System.out.println("1"+filename);
			 
			this.initFile(filename);
			
			//System.out.println("打开");
			this.repaint();
		}
		else if(e.getSource()==this.jm1_2)
		{
			System.exit(0);
		}
		//进行股票搜索
		else if(e.getSource()==this.jb1)
		{
		 
			 if(isfocus==false)
			  {
				  isfocus=true;
				
			  }else
			  {
				  isfocus=false;
				 this.requestFocus(true);

				  
			  }
			  
			  jt1.setFocusable(isfocus);
		
		//  jl1.setFocusable(isfocus);
		 // jb1.setFocusable(isfocus);
		 
		  String strstock=this.jt1.getText();
			//System.out.println(strstock);
		  f.readStock("D:\\data\\stockcode\\sh_stockcode.csv");
		  String str=f.compare(strstock);
		
		  if(str!="")
		  {
			  this.initFile(str);
			  this.fileName=str.substring(str.length()-16, str.length()-4);
			  f.stockName=this.fileName.substring(this.fileName.length()-7, this.fileName.length()-1);
			  this.repaint();
			  this.jt1.setText("");
		  }else 
		  {
			  isfocus=true;
			  jt1.setFocusable(isfocus);
			  
		  }
		
		
		  
		}
	}
/*	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
*/

	//鼠标移动事件
	public void mouseMoved(MouseEvent e) 
	{
		Dimension screamsize=Toolkit.getDefaultToolkit().getScreenSize();
		int line=(screamsize.height-200)*3/5;//取3/5的区域画上面的图
		int imagewidth=this.getWidth()-300;//画图区域的宽度
		int imageheight=this.getHeight()-300;//画图区的高度
		// TODO Auto-generated method stub
		if(e.getX()>100 && e.getY()<100+imagewidth)
		{
		    float extent =maxprice-minprice;
		    int y=e.getY()-130;
		    nowdata=maxprice-y*extent/(line-50);//坐标所占的比例
		   //保留两位小数
		    DecimalFormat df = new DecimalFormat("#.00");
	        nowdata=Float.parseFloat(df.format(nowdata));
		   // this.repaint();
		    
		    
		}
		
		
		
		
	}
	public void focusLost(FocusEvent e) 
	{ 
	 System.out.println("lost");
	}
	public void focusGained(FocusEvent e)
	{
		System.out.println("get");
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			
			try 
			{
				f.gettimedata();
				this.repaint();
				//System.out.print("1");
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	   
}
	
class Point 
{
    int x;
    int y;

    public Point()
    {
    		this.x = 0;
    		this.y = 0;
    }
    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
}
class iPoint extends Point
{
	 public iPoint(Point point,int x) {
		super();
		this.x = point.x;
		this.y = point.y;
		this.num = x;
	}
	int num;
}
class Line
{
    Point a;
    Point b;

    public Line() 
    {
        this.a = new Point();
        this.b = new Point();
    }
    public Line(Point a,Point b)
    {
    		this.a = a;
    		this.b = b;
    }
}
	
class StockData
{
	String date;//时间
	public float begin;//开盘价
	public float high;//最高价
	public float end;//收盘价
	public float low;//最低价
	public int volumn;//成交量
	
	public StockData()
	{
	
	}
	//将数据转换加入到其中
	void addData(String str[])
	{
		this.date=str[0];
		this.begin=Float.valueOf(str[1]);
		this.high=Float.valueOf(str[2]);
		this.end=Float.valueOf(str[3]);
		this.low=Float.valueOf(str[4]);
		this.volumn=Integer.valueOf(str[5].trim());
		
		
	}
}

class beili
{
	public float max;//最大值
	public float min;//最大值
	public int pos;//存储位置
}

