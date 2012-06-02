package com.android.demo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper
{

	private static final int VERSION = 1;
	private static final String DBNAME = "data.db";
	private static final String LESSON="t_lesson";
	
	public DBOpenHelper(Context context)
	{
		super(context, DBNAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("create table "+LESSON+"(lid integer primary key,name varchar(20),place varchar(20),starttime varchar(5),endtime varchar(5),weekday integer)");
		String sql = "insert into t_lesson (name,place,starttime,endtime,weekday) values('传感网络','研教701[1-8]','08:00','09:30',1)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('传感网络','研教1113[2-9]','09:55','11:35',1,10955)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('就业指导','研教601 [9-16]','13:30','15:00',1,11330)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('Android','研教1213 [2-17]','18:00','19:30',1,11800)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('嵌入软件开发','研教701 [1-16]','08:00','09:30',2,20800)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('英语写作','研教213 [1-16]','09:55','11:35',2,20955)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('接口技术','研教1213 [1-16]','13:30','15:00',2,21330)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('嵌入软件调试','研教701 [1-16]','08:00','09:30',3,30800)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('英语写作','研教213 [1-16]','09:55','11:35',3,30955)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('接口设计技术','研教1208 [3-17]','13:30','15:00',3,31330)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('英语视听说','研教513 [1-16]','09:55','11:35',4,40955)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('传感网络技术','研教1113 [2-9]','18:00','19:30',4,41800)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('软件组织管理','研教701 [1-16]','08:00','09:30',5,50800)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('嵌入软件调试','研教1213 [1-16]','09:55','11:35',5,50955)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('Anroid','研教701 [1-16]','13:30','15:00',5,51330)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('传感网络技术','研教501 [1-8]','15:25','17:00',5,51525)";
		db.execSQL(sql);
		sql = "insert into t_lesson (name,place,starttime,endtime,weekday,lid) values('嵌入软件开发案例','研教1208 [1-16]','18:00','21:00',5,51800)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.i("LESSONDAOTest", "UpGrade!");
		String tempTable = "temp_lesson";
		db.execSQL("alter table "+LESSON +" rename to "+tempTable);
		db.execSQL("create table "+LESSON+" (lid integer primary key,name varchar(20),place varchar(20),starttime varchar(5),endtime varchar(5),weekday integer)");
		String sql = "insert into "+LESSON+"(lid,name,place,starttime,endtime,weekday) select lid,name,place,starttime,endtime,weekday from "+tempTable;
		db.execSQL(sql);

	}

}
