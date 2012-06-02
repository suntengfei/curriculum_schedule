package com.android.demo.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;
import android.util.Log;

import com.android.demo.model.Lesson;
/**
 * @author suntengfei
 *
 */
public class LessonDAO
{
	private DBOpenHelper helper;
	private SQLiteDatabase db; 
	
	public LessonDAO(Context context)
	{
		helper = new DBOpenHelper(context);
	}
	
	/**
	 * ��ӿγ�
	 * @param lesson
	 */
	public void add(Lesson lesson)
	{
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", lesson.getName());
		values.put("place", lesson.getPlace());
		values.put("starttime", lesson.getStarttime());
		values.put("endtime", lesson.getEndtime());
		values.put("weekday", lesson.getWeekday());
		db.insert("t_lesson", "name", values);
		db.close();
	}
	/**
	 * @param a name
	 * @param b place
	 * @param c starttime
	 * @param d endtime
	 * @param e week
	 */
	public void add(int id,String a,String b,String c,String d,int e)
	{
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("lid", id);
		values.put("name", a);
		values.put("place", b);
		values.put("starttime", c);
		values.put("endtime", d);
		values.put("weekday", e);
		db.insert("t_lesson", "name", values);
		db.close();
	}
	/**
	 * ���¿γ���Ϣ
	 * @param lesson
	 */
	public void update(Lesson lesson,int lid)
	{
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", lesson.getName());
		values.put("place", lesson.getPlace());
		values.put("starttime", lesson.getStarttime());
		values.put("endtime", lesson.getEndtime());
		values.put("weekday", lesson.getWeekday());
		db.update("t_lesson", values, "lid=?", new String[]{String.valueOf(lid)});
		db.close();
	}
	/**
	 * ��ȡ weekday�Ŀα�
	 * @param weekday
	 * @return
	 */
	public List<Lesson> getData(int weekday)
	{
		List<Lesson> lessons = new ArrayList<Lesson>();
		int i = 0;
		db = helper.getWritableDatabase();
		Cursor cursor = db.query("t_lesson", new String[]{"lid","name","place","starttime","endtime","weekday"}, "weekday=?", new String[]{String.valueOf(weekday)}, null, null, "lid");
		while(cursor.moveToNext())
		{
			lessons.add(new Lesson(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5)));
		}
		cursor.close();
		return lessons;
	}
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public int search(int id)
	{
		int i = 0;
		db = helper.getWritableDatabase();
		Cursor cursor = db.query("t_lesson", new String[]{"lid","name","place","starttime","endtime","weekday"}, "lid=?", new String[]{String.valueOf(id)}, null, null, null);
		if(cursor.moveToNext())
			return 1;
		else
			return 0;
	}
	/**
	 * ɾ��α�
	 * @param lid
	 */
	public int delete(int lid)
	{
		int a;
		db = helper.getWritableDatabase();
		a = db.delete("t_lesson", "lid in(?)",new String[]{String.valueOf(lid)});
		Log.i("aaaaaa", String.valueOf(a));
		db.close();
		return a;
	}
}





