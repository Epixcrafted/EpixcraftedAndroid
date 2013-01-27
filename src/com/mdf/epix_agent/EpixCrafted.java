package com.mdf.epix_agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class EpixCrafted extends Activity
{
	private static final int PICK_SESSION_ID = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences settings = getPreferences(0);
		String session_id = settings.getString("session_id", "");
		if (session_id == "") {
			Intent intent = new Intent(Intent.ACTION_PICK);
			intent.setClass(this, LoginActivity.class);
			startActivityForResult(intent, PICK_SESSION_ID);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK && requestCode == PICK_SESSION_ID) {
			SharedPreferences prferences = getPreferences(0);
			SharedPreferences.Editor editor = prferences.edit();
			editor.putString("session_id", "xxx");
			editor.commit();
		}
	}
}
