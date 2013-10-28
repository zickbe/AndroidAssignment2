package zickbe.vt.classroomrateit;

import zickbe.vt.classroomrateit.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class RateFragment extends Fragment {

	View rootView;
	String numStars = "0";
	String date = "MM/DD/YYYY";
	String time = "0h0m";
	String lightIntensity = "0";
	
	///////////////
	//SET IP HERE//
	///////////////
	String URL = "http://10.0.0.5:8080";
	///////////////
	//SET IP HERE//
	///////////////

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.section2, container, false);
		//TextView tv = findViewById(R.id.TestingText);
		final EditText dateText = (EditText) rootView.findViewById(R.id.dateInput);
		final RatingBar rateBar = (RatingBar) rootView.findViewById(R.id.ratingBar1);
		final TimePicker timePick = (TimePicker) rootView.findViewById(R.id.timePicker1);
		final SensorActivity act = new SensorActivity();
		Button button = (Button) rootView.findViewById(R.id.subRatingButton);
		button.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	  date = dateText.getText().toString();
		    	  float nStars = rateBar.getRating();
		    	  numStars = String.valueOf(nStars);
		    	  int i = timePick.getCurrentHour();
		    	  int j = timePick.getCurrentMinute();
		    	  time = String.valueOf(i) + ":" + String.valueOf(j);
		    	  float light = act.getLux();
		    	  lightIntensity = String.valueOf(light);//light.toString();
		    	  
		    	  PostTask task = new PostTask(RateFragment.this,URL);
			  	  task.execute("POST","72 degrees",numStars,date,time,lightIntensity);
		      }
		    });
		
		
		return rootView;
	}
	public void setText(String set)
	{
		TextView view = (TextView) getView().findViewById(R.id.TestingText);
		view.setText(set);
	}
	public void setURL(String url)
	{
		URL = url;
	}
	
}