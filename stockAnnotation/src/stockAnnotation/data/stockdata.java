package stockAnnotation.data;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.VoiceStatus;
import javax.swing.JFrame;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.nio.codecs.LengthDelimitedDecoder;
import org.apache.http.util.EntityUtils;

public class stockdata extends JFrame{

	boolean isWrite;//用来判断标示数据的名称是否写入
	public String stockName="";//用于获取股票名称
	public static Vector<Stock> vectorStock = new Vector<Stock>();
	public  String str[];
	
	public stockdata() {
		
	}
	
	public static void main(String args[])
	{
		stockdata fStockdata = new stockdata();
		try 
		{
//			fStockdata.getStockName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		fStockdata.tidyStockName();
		fStockdata.readStock("/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/sh_stockcode.csv");
		//更新数据
		fStockdata.update();
		
	}
	
	 public void gettimedata()
	   {
		  
		   String page=this.httpGetPage("http://hq.sinajs.cn/list=sh"+this.stockName,"gb2312");
		   System.out.println(this.stockName);
		   Pattern p=Pattern.compile(".*=(.*)");
		   Matcher m=p.matcher(page);
		   while(m.find())
		   {
			 page=m.group(1);
		   }
		   str=page.split(",");
		   
		   
	   }
	
	//获取网页源文件
	public String httpGetPage(String url,String code)
	{
		String page = "";
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				page = EntityUtils.toString(entity, code);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
		
	}
	
	//写入内容写入文件里
	public void writeContentToFile(String fileName, String content, boolean mode)
	{
		if (fileName == null) 
		{
			return;
		}
		
		FileOutputStream fileOutputStream = null;
		PrintStream printStream = null;
		File file = new File(fileName);
		try 
		{
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			fileOutputStream = new FileOutputStream(file, mode);
			printStream = new PrintStream(fileOutputStream);
			printStream.print(content);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally
		{
			try {
				printStream.close();
				fileOutputStream.close();
			} catch (IOException e2) 
			{
				e2.printStackTrace();
			}
		}
	}

	//获取股票的名称和代码
	public void getStockName() throws Exception
	{
		//获取上海交易所的股票代码
		String pageString = this.httpGetPage("http://www.sse.com.cn/js/common/ssesuggestdata.js;pvefccd83d3d44593b","utf-8");
		//System.out.println(pageString);
		//编译正则表达式
		Pattern pattern = Pattern.compile(".*val:\"(.*)\",val2:\"(.*)\",val3.*");
		//对网页内容进行匹配
		Matcher matcher = pattern.matcher(pageString);
		
		File stockFile = new File("/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode");
		if (!stockFile.exists()) 
		{
			stockFile.mkdirs();
		}
		
		while (matcher.find()) 
		{
			String str = "";
			str += "sh" + "," + matcher.group(1) + "," + matcher.group(2) + "\r\n";
			//System.out.println(str);
			//将str里的内容写到新建的文件里
			this.writeContentToFile("/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/sh_stockcode.csv", str, true);
		}
		//获取深证交易所上市公司列表
		String SZListOfListedCompany="http://www.szse.cn//szseWeb/ShowReport.szse?SHOWTYPE=EXCEL&CATALOGID=1110&tab1PAGENUM=1&ENCODE=1&TABKEY=tab1";
		//构造URL
		URL SZListOfListedCompanyURL = new URL(SZListOfListedCompany);
		//打开链接
		URLConnection connection = SZListOfListedCompanyURL.openConnection();
		//设置请求超时为5s
		connection.setConnectTimeout(5*1000);
		//输入流
		InputStream iStream = connection.getInputStream();
		//1k的数据缓存
		byte[] bs = new byte[1024];
		//输出流
		OutputStream oStream = null;
		//读取数据的长度
		int length;
		
		try 
		{
			oStream = new FileOutputStream(stockFile.getPath()+"/tempstockcode2.xls");
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		//开始读取
		while ((length = iStream.read(bs)) != -1) 
		{
			oStream.write(bs, 0, length);
		}
		oStream.close();
		iStream.close();
	}

	//整理股票代码的数据
	public void tidyStockName()
	{
		InputStream inputStream;
		try 
		{
			inputStream = new FileInputStream("/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/tempstockcode2.xls");
			byte[] bs = new byte[1024];
			int size = 0;
			String string = "";
			try 
			{
				while ((size = inputStream.read(bs))!=-1) 
				{
					String tempString = new String(bs, 0, size);
					string += tempString + "\r\n";
//					System.out.println(string);
				}
				Pattern pattern = Pattern.compile("<td.*class=\'cls-data-td\'.*>(\\d{6})</td><td.*class=\'cls-data-td\'.*>([\u4e00-\u9fa5]{3,4})</td><.*>\\d{4}-.*");
				Matcher matcher = pattern.matcher(string);
				
				while (matcher.find()) 
				{
					String content = "sz" + "," + matcher.group(1) + "," + matcher.group(2) + "\r\n";
					//System.out.println(content);
					this.writeContentToFile("/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/sz_stockcode2.csv", content, true);
				}
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("股票代码处理完成！");
	}

	//读入股票代码
	public void readStock(String filePath)
	{
		vectorStock.clear();
		try
		{
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string = "";
			String temp[];
			while((string = bufferedReader.readLine())!=null)
			{
				temp = string.split(",");
				Stock stock = new Stock();
				stock.addStock(temp);
				vectorStock.add(stock);
			}
			bufferedReader.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}  
	}

	//更新数据
	public void update()
	{
		for (int i = 10; i < vectorStock.size(); i++) 
		{
			isWrite = false;
			Stock stock = vectorStock.get(i);
			for (int j = 2015; j >2012; j--) 
			{
				String urlString = "http://vip.stock.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/"+stock.stockCode+".phtml?year="+j+"&jidu=";
//				System.out.println(urlString);
				this.getNetData(urlString);
			}
		}
	}
	//提取网页数据
	public void getdata(String url)
	{
		String page = this.httpGetPage(url, "gb2312");
		System.out.println(page);
		
		//数据时间
		Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}\t.*)</a>");
		Matcher matcher = pattern.matcher(page);
		
		//数据各种的指标数据
		Pattern pattern2 = Pattern.compile("<td.*><div align=\"center\">(\\d.*)</div></td>");
		Matcher matcher2 = pattern2.matcher(page);
		
		String  fileNameString = "/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/4.csv";
		
		while(matcher.find())
		{
			writeContentToFile(fileNameString, matcher.group(1)+"\r\n",true);
		}
		fileNameString = "/Users/mumutongxue/Documents/workspace/stockAnnotation/stockcode/5.csv";
		
		int index = 1;
		while (matcher2.find()) 
		{
			if (index%6!=0) 
			{
				writeContentToFile(fileNameString, matcher2.group(1)+"\r\n", true);
				index++;
			}
			else
			{
				index = 1;
				writeContentToFile(fileNameString, matcher2.group(1)+"\r\n", true);
			}
		}
	}
	
	//步骤和在一起
	public void getNetData(String url)
	{
		for (int i = 4; i >=1; i--) 
		{
			String tempURL = url;
			tempURL = tempURL + i;
//			System.out.println(tempURL);
			this.getdata(tempURL);
		}
	}
}

class Stock
{
	String stockCode;//股票代码
	String stockName;//股票名称
	String stockType;//股票类型
	
	//加入新股票
	public void addStock(String str[])
	{
		this.stockType = str[0];
		this.stockCode = str[1];
		this.stockName = str[2];
	}
	
}
