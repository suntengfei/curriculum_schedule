import java.util.List;

import android.test.AndroidTestCase;

import com.android.demo.model.Lesson;
import com.android.demo.dao.LessonDAO;
import android.text.format.Time;
import android.util.Log;

public class LessonDaoTest extends AndroidTestCase
{
	private final static String TAG = "LessonDAOtest";
	
	public void testAdd()
	{
		LessonDAO ld = new LessonDAO(this.getContext());
		Lesson ls = new Lesson("English","研教513","9:55","11:30",1);
		ld.add(ls);
		List<Lesson> lessons = ld.getData(1);
		Log.i(TAG,String.valueOf(lessons.size()));
	}
	public void testGetData()
	{
		LessonDAO ld = new LessonDAO(this.getContext());
		List<Lesson> lessons = ld.getData(1);
		
		Log.i(TAG,String.valueOf(lessons.get(0).getLid()));
		Log.i(TAG,lessons.get(0).toString());
	}
	
	public void testDelete()
	{
		LessonDAO ld = new LessonDAO(this.getContext());
		ld.delete(1);
		Log.i(TAG,"DELETE SUCCEED");
	}
}
