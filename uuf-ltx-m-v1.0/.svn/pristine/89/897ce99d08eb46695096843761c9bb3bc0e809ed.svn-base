package cn.uuf.stu.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* 日期工具
* @ClassName: DateUtils 
* @author tangpeng
* @date 2015年8月24日 下午9:49:40 
*
*/
public class DateUtils {
	
	 
	public static final String DEFAULT_DATE_FORMAT = "yyyyMMddHHmmss";
	
	/**
	* 获得格式化日期字符串
	* @param pattern
	* @return    
	* String
	*/
	public static String getFormatDateString(String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date());
	}
	
	/**
	* 获得格式化日期字符串
	* @param pattern
	* @param date
	* @return    
	* String
	 */
	public static String getFormatDateString(String pattern,Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	
	/**
	 * 获得格式化日期
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getFormatDate(String pattern,String date) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(date);
	}
	
	/**
	 * 日期比较
	 * @param data1
	 * @param data2
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String data1,String data2,String pattern) throws ParseException{
		DateFormat df = new SimpleDateFormat(pattern);
		Date dt1 = df.parse(data1);
		Date dt2 = df.parse(data2);
		if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 0;
        }
	}
	
	/**
	 * 日期比较 和现在时间比
	 * @param data1
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String data1,String pattern) throws ParseException{
		DateFormat df = new SimpleDateFormat(pattern);
		Date dt1 = df.parse(data1);
		Date dt2 = df.parse(getFormatDateString(pattern));
		if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 0;
        }
	}
	
	 /**
     * 获得当前月第一天
     * @author: pgf
     * @creation: Dec 6, 2013 5:22:18 PM
     * @return
     * @return: Date
     */
    public static Date getMonthFirstDay(){
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	    Date firstDate = calendar.getTime();
	    return firstDate;
    }
    /**
     * 获得当前月最后一天
     * @author: pgf
     * @creation: Dec 6, 2013 5:22:18 PM
     * @return
     * @return: Date
     */
    public static Date getMonthEndDay(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int curDay=calendar.get(Calendar.DAY_OF_MONTH);
    	calendar.add(Calendar.DATE, 1-curDay);
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.DATE,-1);
    	return calendar.getTime();
    }
	
	
	public static void main(String[] args) throws ParseException {
//		String string = getFormatDateString("yyyy-MM-dd hh:mm:ss");
//		System.out.println(string);
		int i = compareDate("2015-12-04", "yyyy-MM-dd");
		System.out.println(i);
	}

}
