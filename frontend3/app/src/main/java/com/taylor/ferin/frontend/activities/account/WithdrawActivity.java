package com.taylor.ferin.frontend.activities.account;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.taylor.ferin.frontend.R;
import com.taylor.ferin.frontend.domain.account.Account;
import com.taylor.ferin.frontend.domain.login.Login;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class WithdrawActivity extends AppCompatActivity {

    Long client_id;
    Account account[] = null;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Bundle extras = getIntent().getExtras();
        client_id = extras.getLong("CLIENT_ID");

        HttpRequestTask httpRequestTask = new HttpRequestTask();
        httpRequestTask.execute();

    }

    public void peformWithdraw(View view){
        RadioGroup  group= (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rb = (RadioButton) findViewById(group.getCheckedRadioButtonId());

        if(account != null) {
            for (int i = 0; i < account.length; i++) {
                if ((account[i].getAccountNumber() + "  R" + account[i].getBalance()).equals(rb.getText())) {
                    String amt = ((EditText) findViewById(R.id.txtAmount)).getText().toString();
                    Double balance = Double.parseDouble(account[i].getBalance()) - Double.parseDouble(amt);

                    Account updated = new Account.Builder()
                            .copy(account[i])
                            .balance(balance.toString())
                            .build();

                    AccountWithdrawrTask accountWithdrawrTask = new AccountWithdrawrTask(updated);
                    accountWithdrawrTask.execute();
                }
            }
        }
        else
            Toast.makeText(getBaseContext(), "You have no accounts!", Toast.LENGTH_SHORT).show();

    }

    public class AccountWithdrawrTask extends AsyncTask<Void, Void, Account> {

        private final Account account;

        AccountWithdrawrTask(Account account) {
            this.account = account;
        }

        @Override
        protected Account doInBackground(Void... params) {

            final String uri = "http://148.100.5.6:8080/account-request/"+account.getId();

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            HttpEntity<Account> requestHttpEntity = new HttpEntity<Account>(account,requestHeaders);
            restTemplate.exchange(uri, HttpMethod.PUT, requestHttpEntity,Account.class);
            return null;
        }

        @Override
        protected void onPostExecute(final Account success) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(getBaseContext(), "Withdaw successfully complete!", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }


    private class HttpRequestTask extends AsyncTask<Void, Void, String> {
        ViewGroup hourButtonLayout = (ViewGroup) findViewById(R.id.radioGroup);


        @Override
        protected void onPostExecute(String user) {
            runOnUiThread(new Runnable() {
                public void run() {
                    if(account != null) {
                        for (int i = 0; i < account.length; i++) {
                            // if(account[i].getClient().getId().equals(client_id)) {
                            RadioButton button = new RadioButton(getBaseContext());
                            button.setId(i);
                            button.setText(account[i].getAccountNumber() + "  R" + account[i].getBalance());
                            button.setTextColor(Color.BLACK);
                            button.setTextSize(9);
                            //button.setChecked(i == currentHours);
                            hourButtonLayout.addView(button);
                            cnt++;
                            //}
                        }
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "You have no accounts!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


        @Override
        protected String doInBackground(Void... params) {
            String uri = "http://148.100.5.6:8080/account-requests/";
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            HttpEntity<Login> requestHttpEntity = new HttpEntity<>(requestHeaders);
            account = restTemplate.exchange(uri, HttpMethod.GET, requestHttpEntity, Account[].class).getBody();

            return null;
        }


    }
}
