
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
		Lesson ls = new Lesson("PE","ground",new Time("9:00"),new Time("11:30"),1);
		ld.add(ls);
		Log.i(TAG,"ADD SUCCEED");
	}
}
