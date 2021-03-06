package com.whatsapp.pe;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends SherlockFragmentActivity {
	
	private static final String[] CONTENT = new String[] {"Contactos", "Chats", "Favoritos", "Otros"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentPagerAdapter adapter = new WhatsappAdapter(getSupportFragmentManager());
		
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(adapter);
		
		TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}
	
	//clase FragmentPagerAdapter
	class WhatsappAdapter extends FragmentPagerAdapter{

		public WhatsappAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			//default
			//return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
			Fragment fragment;
			
			switch (position) {
			case 0:
				fragment = new FirstActivity();
				break;
			case 1:
				fragment = new SecondActivity();
				break;
			default:
				fragment = new FirstActivity();
				break;
			}
			return fragment;
		}
		
		@Override
        public CharSequence getPageTitle(int position) {
			//default
            //return CONTENT[position % CONTENT.length].toUpperCase();
			String title = "";
	        switch(position){
	        case 0:
	            title = "Contactos";
	            break;
	        case 1:
	            title = "Chats";
	            break;
	        case 2:
	            title = "Favoritos";
	            break;
	        case 3:
	            title = "Otros";
	            break;
	        }
	        return title;
        }
		@Override
		public int getCount() {
			return CONTENT.length;
		}
		
		
		
	}
	

}
