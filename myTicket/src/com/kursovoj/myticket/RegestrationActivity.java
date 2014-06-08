package com.kursovoj.myticket;

import com.clouding2u.EnginioUser;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class RegestrationActivity extends Activity implements
OnEditorActionListener,
OnClickListener {
	EnginioUser user;
	EditText editUsername;
    EditText editEMail;
    EditText editPassword;
    Button sendRegistrationBTN;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regestration);
		 editUsername=	(EditText) findViewById(R.id.editUsername);
		    editEMail=    (EditText) findViewById(R.id.editEmail);
		    editPassword= (EditText) findViewById(R.id.editPassword);
		    editPassword.setOnEditorActionListener(this);
		    sendRegistrationBTN=(Button) findViewById(R.id.buttonSendRegestration);
		    sendRegistrationBTN.setOnClickListener(this);

	}
	
public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
		
		if(arg0.getId()==R.id.editPassword){
			if(arg1==EditorInfo.IME_ACTION_DONE){
				if(arg0.getText().length()<9) Toast.makeText(this,
						R.string.warning_lessPasswordLength,Toast.LENGTH_LONG).show();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.buttonSendRegestration){
		boolean hasUsername=(editUsername.getText().length()>0) ? true:false;
		boolean hasEmail=(editEMail.getText().length()>0) ? true:false;
		boolean hasPassword=(editPassword.getText().length()>0) ? true:false;
		if(hasUsername&&hasEmail&&hasPassword)	{
			String username=editUsername.getText().toString();
			String email=editEMail.getText().toString();
			String password=editPassword.getText().toString();
			Bundle bundle=new Bundle();
			bundle.putString("username",username);
			bundle.putString("email", email);
			bundle.putString("password",password);
		//	Intent sendNewUserRegestrationIntent=new Intent(this, cls);
			try {
			user=new EnginioUser(editUsername.getText().toString(),editEMail.getText().toString(),
					            "","",editPassword.getText().toString());
			System.out.println();} catch (Exception e){
				e.printStackTrace();
			}
		} else
			Toast.makeText(this,R.string.noinput, Toast.LENGTH_LONG).show();
		}
		
	}
	
}
