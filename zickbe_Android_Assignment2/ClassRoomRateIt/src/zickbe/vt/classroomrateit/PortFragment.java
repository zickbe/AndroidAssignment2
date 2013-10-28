package zickbe.vt.classroomrateit;

import zickbe.vt.classroomrateit.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PortFragment extends Fragment {

	View rootView;
	String url;
	String port;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.section3, container, false);
		final EditText portText = (EditText) rootView.findViewById(R.id.portInfo);
		final EditText ipText = (EditText) rootView.findViewById(R.id.IPInfo);
		final TextView TV = (TextView) rootView.findViewById(R.id.newIPandPort);
		Button button = (Button) rootView.findViewById(R.id.changePorts);
		button.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	  
		    	  url = ipText.getText().toString();
		    	  port = portText.getText().toString();
		    	  String http = "http://" + url + ":" + port;
		    	  TV.setText(http);
		    	  
		    	  //Could not get this working
//		    	  GetTask task = new GetTask(http);
//		    	  task.execute("GET", http);
		      }
		    });
		
		return rootView;
	}
}
