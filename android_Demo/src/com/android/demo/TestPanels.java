package com.android.demo;


//import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.demo.dao.LessonDAO;
import com.android.demo.interpolator.BackInterpolator;
import com.android.demo.interpolator.BounceInterpolator;
import com.android.demo.interpolator.EasingType;
import com.android.demo.interpolator.ElasticInterpolator;
import com.android.demo.interpolator.ExpoInterpolator;
import com.android.demo.model.Lesson;
import com.android.demo.widget.Panel;
import com.android.demo.widget.Panel.OnPanelListener;

public class TestPanels extends Activity implements OnPanelListener {

	LessonDAO lesdao = new LessonDAO(this);
	private Panel bottomPanel;
	private Panel topPanel;
	List<Lesson> ltt1;
	List<Lesson> ltt2;
	List<Lesson> ltt3;
	List<Lesson> ltt4;
	List<Lesson> ltt5;
	ListView lv1;
	ListView lv2;
	ListView lv3;
	ListView lv4;
	ListView lv5;
	
	
	@Override
	protected void onRestart()
	{
		// TODO Auto-generated method stub
		super.onRestart();
		loadData();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_main);
        
        Panel panel;
        lv1 = (ListView)findViewById(R.id.list1);
        lv2 = (ListView)findViewById(R.id.list2);
        lv3 = (ListView)findViewById(R.id.list3);
        lv4 = (ListView)findViewById(R.id.list4);
        lv5 = (ListView)findViewById(R.id.list5);
        Panel[] pl = {(Panel) findViewById(R.id.leftPanel),(Panel) findViewById(R.id.leftPanel2),(Panel) findViewById(R.id.rightPanel),(Panel) findViewById(R.id.rightPanel2),(Panel) findViewById(R.id.rightPanel3)};
        topPanel = panel = (Panel) findViewById(R.id.topPanel);
        panel.setOnPanelListener(this);
        panel.setInterpolator(new BounceInterpolator(EasingType.INOUT));
        
        panel = (Panel) findViewById(R.id.leftPanel);
        panel.setOnPanelListener(this);
        panel.setInterpolator(new ExpoInterpolator(EasingType.OUT));


        panel = (Panel) findViewById(R.id.rightPanel);
        panel.setOnPanelListener(this);
        panel.setInterpolator(new ExpoInterpolator(EasingType.OUT));

        bottomPanel = panel = (Panel) findViewById(R.id.bottomPanel);
        panel.setOnPanelListener(this);
        panel.setInterpolator(new ElasticInterpolator(EasingType.OUT, 1.0f, 0.3f));
        
        loadData();
        Button btn = (Button)findViewById(R.id.addlessonbtn);
	
		
/*        //设置dialog
        LayoutInflater inflater = getLayoutInflater();
		   View layout = inflater.inflate(R.layout.alertdialog,
		     (ViewGroup) findViewById(R.id.aldialog));

		   final Dialog dialog = new AlertDialog.Builder(this).setTitle("自定义布局").setView(layout)
		     .setPositiveButton("确定", null)
		     .setNegativeButton("取消", null).create();*/
		
		
        OnClickListener l = new OnClickListener(){

			public void onClick(View v)
			{
				// TODO Auto-generated method stub
/*				dialog.show();
				//填充spinner
				Spinner sp = (Spinner)findViewById(R.id.spinner1);
				//将可选内容与ArrayAdapter连接 
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(TestPanels.this,android.R.layout.simple_spinner_item,days);
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
					}); */
				
				Intent intent = new Intent();
				intent.setClass(TestPanels.this, AddLesns.class);
				startActivity(intent);
			}

		};
        btn.setOnClickListener(l);
        lv1.setOnItemLongClickListener(itemlistener);
        lv2.setOnItemLongClickListener(itemlistener);
        lv3.setOnItemLongClickListener(itemlistener);
        lv4.setOnItemLongClickListener(itemlistener);
        lv5.setOnItemLongClickListener(itemlistener);
        
//        Calendar c = Calendar.getInstance();
//        mY = c.get(Calendar.YEAR); 
//        mM = c.get(Calendar.MONTH)+1;
//        mD = c.get(Calendar.DAY_OF_MONTH);
//        wk =  (mD+2*mM+3*(mM+1)/5+mY+mY/4-mY/100+mY/400)%7;
//        if(wk>=0&&wk<5)
//        {
// 
//        	pl[wk].setOpen(!pl[wk].isOpen(), false);
//        	Log.i("aaaaaa",String.valueOf(wk));
//        	Log.i("aaaaaa",String.valueOf(mY));
//        	Log.i("aaaaaa",String.valueOf(mM));
//        	Log.i("aaaaaa",String.valueOf(mD));
//        }  
        
    }
    
    private OnItemLongClickListener itemlistener = new OnItemLongClickListener(){

		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id)
		{
			dialog(parent,view,position,id);
			// TODO Auto-generated method stub
			return false;
		}
    	
    };
    
    protected void dialog(final AdapterView<?> parent,final View view,final int position, long id) {
    	  AlertDialog.Builder builder = new Builder(TestPanels.this);
    	  builder.setMessage("确认要删除出吗？");
    	  builder.setTitle("提示");
    	  builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
    	   public void onClick(DialogInterface dialog, int which) {
    		if(parent.getId()==lv1.getId())
    		{
    			lesdao.delete(ltt1.get(position).getLid());
    			ltt1.remove(position);
    			//lv1.removeView(view);
    			lv1.setAdapter(new ArrayAdapter<Lesson>(TestPanels.this, R.layout.list_item, ltt1));
    		}
    		else if(parent.getId()==lv2.getId())
    		{
    			lesdao.delete(ltt2.get(position).getLid());
    			ltt2.remove(position);
    			lv2.setAdapter(new ArrayAdapter<Lesson>(TestPanels.this, R.layout.list_item, ltt2));
    		}
    		else if(parent.getId()==lv3.getId())
    		{
    			lesdao.delete(ltt3.get(position).getLid());
    			ltt3.remove(position);
    			lv3.setAdapter(new ArrayAdapter<Lesson>(TestPanels.this, R.layout.list_item, ltt3));
    		}
    		else if(parent.getId()==lv4.getId())
    		{
    			lesdao.delete(ltt4.get(position).getLid());
    			ltt4.remove(position);
    			lv4.setAdapter(new ArrayAdapter<Lesson>(TestPanels.this, R.layout.list_item, ltt4));
    		}
    		else if(parent.getId()==lv5.getId())
    		{
    			lesdao.delete(ltt5.get(position).getLid());
    			ltt5.remove(position);
    			lv5.setAdapter(new ArrayAdapter<Lesson>(TestPanels.this, R.layout.list_item, ltt5));
    		}
    	    dialog.dismiss();
    	   }
    	  });
    	  builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

    	   public void onClick(DialogInterface dialog, int which) {
    	    dialog.dismiss();
    	   }
    	  });
    	  builder.create().show();
    	 }
    
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//   	if (keyCode == KeyEvent.KEYCODE_T) {
//    		topPanel.setOpen(!topPanel.isOpen(), false);
//    		return false;
//    	}
//    	if (keyCode == KeyEvent.KEYCODE_B) {
//    		bottomPanel.setOpen(!bottomPanel.isOpen(), true);
//    		return false;
//    	}
//    	return super.onKeyDown(keyCode, event);
//    }

	public void onPanelClosed(Panel panel) {
		String panelName = getResources().getResourceEntryName(panel.getId());
		Log.d("TestPanels", "Panel [" + panelName + "] closed");
	}
	public void onPanelOpened(Panel panel) {
		String panelName = getResources().getResourceEntryName(panel.getId());
		Log.d("TestPanels", "Panel [" + panelName + "] opened");
	}
	
	public void loadData()
	{
		LessonDAO ld = new LessonDAO(this);
		ltt1 = ld.getData(1);
		ListView lv = (ListView)findViewById(R.id.list1);
		lv.setAdapter(new ArrayAdapter<Lesson>(this, R.layout.list_item, ltt1));
		ltt2 = ld.getData(2);
		lv = (ListView)findViewById(R.id.list2);
		lv.setAdapter(new ArrayAdapter<Lesson>(this, R.layout.list_item, ltt2));
		ltt3 = ld.getData(3);
		lv = (ListView)findViewById(R.id.list3);
		lv.setAdapter(new ArrayAdapter<Lesson>(this, R.layout.list_item, ltt3));
		ltt4 = ld.getData(4);
		lv = (ListView)findViewById(R.id.list4);
		lv.setAdapter(new ArrayAdapter<Lesson>(this, R.layout.list_item, ltt4));
		ltt5 = ld.getData(5);
		lv = (ListView)findViewById(R.id.list5);
		lv.setAdapter(new ArrayAdapter<Lesson>(this, R.layout.list_item, ltt5));
	}
}
