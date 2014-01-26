package com.pbi.vst;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pbi.vst.db.LiveDBHelper;

/**
 * 还是 获取不到 数据 不知道 为什么
 * 
 * @author Administrator
 * 
 */
public class MainActivity extends Activity {

	private LiveDBHelper dbHelper;

	private HomePage homepage;

	// private USBReciver usbReciver;

	private ExecutorService pool = Executors.newFixedThreadPool(4);

	private Runnable checkLiveDB = new Runnable() {

		@Override
		public void run() {
			// 查看数据库
			// 解析XML 通过dom4j Dom4jXmlUtils 这个类
			// 不为空 使用 handler 发送 message
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1); // 1 具体代表什么？
		getWindow().setFlags(1024, 1024);
//		setContentView(R.layout.wait_for_data);
		// TODO 这里 需要一个 数据 .. 不知道为什么呢.. 具体里面 没有写..
		dbHelper = LiveDBHelper.getInstance(getApplicationContext());

		initDialog();

		pool.execute(checkLiveDB); // 执行一个线程

		// 这里面还需要传入一个 handler ， handler 里很多东西 ，我先不传 ..
		homepage = new HomePage(this);
		setContentView(homepage);
		homepage.requestFocus();
//		
		registerReceiver();

	}

	protected void onDestroy() {
		Log.i("MainActivity", "onDestroy()-----------");
		super.onDestroy();
//		unregisterReceiver(this.usbReciver);
//		unregisterReceiver(this.dbReciver);
	}

	protected void onResume() {
		
		Log.i("MainActivity", "onResume()-----------");
		super.onResume();
	}

	protected void onStart() {
		Log.i("MainActivity", "onStart()-----------");
		super.onStart();
	}

	protected void onStop() {
		Log.i("MainActivity", "onStop()-----------");
		super.onStop();
	}

	/**
	 * 注册 监听器
	 */
	private void registerReceiver() {
		// this.usbReciver = new USBReciver();
		// this.dbReciver = new DBReciver();
		// IntentFilter localIntentFilter1 = new IntentFilter(
		// "android.intent.action.MEDIA_MOUNTED");
		// localIntentFilter1.addDataScheme("file");
		// registerReceiver(this.usbReciver, localIntentFilter1);
		// IntentFilter localIntentFilter2 = new IntentFilter();
		// localIntentFilter2.addAction("2222222222222222");
		// localIntentFilter2.addAction("1111111111111111");
		// registerReceiver(this.dbReciver, localIntentFilter2);
	}

	/**
	 *  
	 */
	private void initDialog() {
		/* 弹出对话框 想必是 检查网络的.. */
	}

	// class USBReciver extends BroadcastReceiver {
	// USBReciver() {
	// }
	//
	// public ArrayList<File> getCustomTxt(File paramFile) {
	// ArrayList localArrayList = new ArrayList();
	// File[] arrayOfFile = paramFile.listFiles();
	// while (true) {
	// int i = arrayOfFile.length;
	// int j = 0;
	// File localFile = arrayOfFile[j];
	// if (localFile.isFile()) {
	// if ((localFile.getName().contains("tv"))
	// && (localFile.getName().endsWith("txt"))) {
	// localArrayList.add(localFile);
	// }
	// }
	// localArrayList.addAll(getCustomTxt(localFile));
	// j++;
	// if (j >= i)
	// break;
	// }
	// return localArrayList;
	// }
	//
	// public void onReceive(Context paramContext, Intent paramIntent)
	// {
	// String str = paramIntent.getAction();
	// Log.i("MainActivity", "action==" + str);
	// if (str.equals("android.intent.action.MEDIA_MOUNTED"))
	// {
	// Uri localUri = paramIntent.getData();
	// Log.i("MainActivity", localUri.getPath());
	// new Thread(new MainActivity.USBReciver.1(this,
	// getCustomTxt(new File(localUri.getPath())), new ArrayList())).start();
	// }
	// }
	// }

}
