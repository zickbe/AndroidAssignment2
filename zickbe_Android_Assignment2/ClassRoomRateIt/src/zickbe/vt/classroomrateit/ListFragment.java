package zickbe.vt.classroomrateit;


import zickbe.vt.classroomrateit.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ListFragment extends Fragment {

	View rootView;
	String ratings;
	Button pressedButton;
	
	
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
		GetTask task = new GetTask(ListFragment.this);
		task.execute("GET",URL);
		rootView = inflater.inflate(R.layout.section1, container, false);
		Button button = (Button) rootView.findViewById(R.id.retrieveRatingButton);
		button.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	updateList("");
		    	GetTask task = new GetTask(ListFragment.this);
		  		task.execute("GET",URL);
		      }
		    });
		
		return rootView;
	}
	
	public void updateList(String str)
	{
		TextView ratingsRec = (TextView)getView().findViewById(R.id.ratingsResults);
		ratingsRec.setText(str);
		
	}
	public void setURL(String url)
	{
		URL = url;
	}
	
}
