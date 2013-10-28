package zickbe.vt.classroomrateit.adapter;

import zickbe.vt.classroomrateit.ListFragment;
import zickbe.vt.classroomrateit.PortFragment;
import zickbe.vt.classroomrateit.RateFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new ListFragment();
		case 1:
			// Games fragment activity
			return new RateFragment();
		case 2:
			// Movies fragment activity
			return new PortFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
