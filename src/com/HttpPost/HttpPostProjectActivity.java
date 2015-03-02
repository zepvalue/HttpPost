package com.HttpPost;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HttpPostProjectActivity extends Activity {
    /** Called when the activity is first created. */
	EditText name, desc;
    Button send;
    TextView res, risp;
    //TextView test;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        res = (TextView) findViewById (R.id.tvRes);
        name = (EditText) findViewById (R.id.etNome);
        desc = (EditText) findViewById (R.id.etDesc);
        send = (Button) findViewById (R.id.bInvia);
        
        send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				res.setText("Invio dati in corso... \n");
				// TODO Auto-generated method stub
				String nameET = name.getText().toString();
				String descET = desc.getText().toString();				
				
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost post = new HttpPost("http://www.terryvenus.it/booking/public/index.php/test/android");
				
				List<NameValuePair> 
				arrayDati = new ArrayList<NameValuePair>(1);
				arrayDati.add(new BasicNameValuePair("nome", nameET));
				arrayDati.add(new BasicNameValuePair("descrizione", descET));			
				
				try {
					post.setEntity(new UrlEncodedFormEntity(arrayDati));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				
				try {
					String response = httpclient.execute(post, responseHandler);
					res.setText(response);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			 
				
				
					
				
			}
		});
       
        
        
       
        
        
        
    }
}