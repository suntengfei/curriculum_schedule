package com.android.demo.model;

public class Lesson
{
	private String place;
	private String starttime;
	private String endtime;
	private String name;
	private int weekday;
	private int lid;
	public Lesson()
	{
		super();
	}
	/**
	 * ���캯��
	 * ������ݿ������ݵ�ʱ��ʹ��
	 * 
	 * @param place
	 * @param starttime
	 * @param endtime
	 * @param name
	 * @param weekday
	 */
	public Lesson(String name,String place,String starttime,String endtime,int weekday)
	{
		super();
		this.place = place;
		this.starttime = starttime;
		this.endtime = endtime;
		this.name = name;
		this.weekday = weekday;
		this.lid = 0;
	}
	
	/**
	 * ���캯��
	 * �ڴ���ݿ��ȡ��ݵ�ʱ��ʹ��
	 * @param place
	 * @param starttime
	 * @param endtime
	 * @param name
	 * @param weekday
	 * @param lid
	 */
	public Lesson(int lid,String name,String place,String starttime,String endtime,int weekday)
	{
		super();
		this.place = place;
		this.starttime = starttime;
		this.endtime = endtime;
		this.name = name;
		this.weekday = weekday;
		this.lid = lid;
	}
	
	public String getPlace()
	{
		return place;
	}
	public String getStarttime()
	{
		return starttime;
	}
	public String getEndtime()
	{
		return endtime;
	}
	public String getName()
	{
		return name;
	}
	public int getWeekday()
	{
		return weekday;
	}
	public int getLid()
	{
		return lid;
	}
	
	public String toString()
	{
		return "课程名："+name+"\n地点："+place+"\n时间："+starttime+"--"+endtime;
	}
}
