package zickbe.vt.classroomrateit;

//modified from
//http://stackoverflow.com/questions/3505930/make-an-http-request-with-android

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class PostTask extends AsyncTask<String, String, String> {

	String httpString = "try again";
	private RateFragment rateFrag;
	
	///////////////
	//SET IP HERE//
	///////////////
	String URL = "http://10.0.0.5:8080";
	///////////////
	//SET IP HERE//
	///////////////

	

	public PostTask(RateFragment rfrag)
	{
		rateFrag = rfrag;
	}
	public PostTask(RateFragment rfrag, String url)
	{
		rateFrag = rfrag;
		URL = url;
	}
	public PostTask(String url)
	{
		URL = url;
	}
	
	@Override
	protected String doInBackground(String... uri) {
		try {

			if (uri[0] == "POST") {

				HttpClient client = new DefaultHttpClient();
				HttpPost request = new HttpPost(URL);

				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("temperature", uri[1]));
				pairs.add(new BasicNameValuePair("stars", uri[2]));
				pairs.add(new BasicNameValuePair("date", uri[3]));
				pairs.add(new BasicNameValuePair("time", uri[4]));
				pairs.add(new BasicNameValuePair("light", uri[5]));
				
				
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
				request.setEntity(entity);

				//HttpResponse result = client.execute(request);
//				InputStream in = result.getEntity().getContent();
//
//				String line = "";
//
//				BufferedReader reader = new BufferedReader(
//						new InputStreamReader(in));
//				StringBuilder sb = new StringBuilder();
//
//				while ((line = reader.readLine()) != null) {
//					sb.append(line + "\n");
//				}
//
//				String response = sb.toString();
//				// always close an InputStream when you are done
//				in.close();
				HttpResponse response = client.execute(request);
				String responseString = null;
				StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					response.getEntity().writeTo(out);
					out.close();
					responseString = out.toString();
				} else {
					// Closes the connection.
					response.getEntity().getContent().close();
					throw new IOException(statusLine.getReasonPhrase());
				}
				return responseString;
		

			} 
			else
				return "error";

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		
		// Do anything with response..
	}

	public String getHttpString() {
		return httpString;
	}
}
