package com.android.demo;



import com.android.demo.dao.LessonDAO;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddLesns extends Activity
{
	EditText lename = null;
	EditText addr = null;
	Button okbtn = null;
	Button celbtn = null;
	Spinner sp = null;
	TimePicker stime = null;
	TimePicker etime = null;
	
	LessonDAO lesdao = new LessonDAO(this);
	
	private static final String[] days={"星期一","星期二","星期三","星期四","星期五"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertdialog);
		
		okbtn = (Button)findViewById(R.id.okbutton);
		celbtn = (Button)findViewById(R.id.celbutton);
		stime = (TimePicker)findViewById(R.id.timePicker1);
		etime = (TimePicker)findViewById(R.id.timePicker2);

		sp = (Spinner)findViewById(R.id.spinner1);
		//将可选内容与ArrayAdapter连接 
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,days);
		//设置下拉列表风格 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//将adapter添加到spinner中 
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) { 
			// TODO Auto-generated method stub 
			//设置显示当前选择的项 
			arg0.setVisibility(View.VISIBLE); 
			}
			public void onNothingSelected(AdapterView<?> arg0) { 
			// TODO Auto-generated method stub 
			} 
			});
		
		stime.setIs24HourView(true);
		etime.setIs24HourView(true);
		
		okbtn.setOnClickListener(btnlistener);
		celbtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		
	}
	private OnClickListener btnlistener = new OnClickListener(){

		public void onClick(View v)
		{
			lename = (EditText)findViewById(R.id.editText1);
			addr = (EditText)findViewById(R.id.editText2);
			Log.i("aaaaaa", "111111111111111");
			// TODO Auto-generated method stub
			String ls = lename.getText().toString().trim();
			String ad = addr.getText().toString().trim();
			
			int wk = sp.getSelectedItemPosition()+1;
			Log.i("aaaaaa", String.valueOf(ls.length()));
			Log.i("aaaaaa", String.valueOf(ad.length()));
			
			int sh = stime.getCurrentHour().intValue();
			int sm = stime.getCurrentMinute().intValue();
			int eh = etime.getCurrentHour().intValue();
			int em = etime.getCurrentMinute().intValue();
			int id = wk*10000+sh*100+sm;
			if(ls!=null&&ls.length()!=0&&ad!=null&&ad.length()!=0)
			{
				if(lesdao.search(id)==0)
				{
					lesdao.add(id, ls, ad,String.valueOf(sh)+":"+(sm>9?String.valueOf(sm):"0"+String.valueOf(sm)), String.valueOf(eh)+":"+(em>9?String.valueOf(em):"0"+String.valueOf(em)), wk);
					finish();
				}
				else
					Toast.makeText(AddLesns.this, "该时段已有课程", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(AddLesns.this, "请写入完整内容", Toast.LENGTH_SHORT).show();
		}
		
	};

}

//class okbtnClick implements OnClickListener{
//
//	public void onClick(View v)
//	{
//		// TODO Auto-generated method stub
//		String ls = lename.getText().toString().trim();
//		String ad = addr.getText().toString().trim();
//		
//		int wk = sp.getSelectedItemPosition()+1;
//		
//		int sh = stime.getCurrentHour().intValue();
//		int sm = stime.getCurrentMinute().intValue();
//		int eh = etime.getCurrentHour().intValue();
//		int em = etime.getCurrentMinute().intValue();
//		int id = wk*10000+sh*100+sm;
//		if((ls!=null||ls!="")&&(ad!=null||ad!=""))
//			if(lesdao.search(id)==0)
//			{
//				lesdao.add(id, ls, ad, stime.toString(), etime.toString(), wk);
//				finish();
//			}
//			else
//				Toast.makeText(this, " ", Toast.LENGTH_SHORT);
//	}
//	
//}
