package systems.texture.alize;

import android.app.Dialog;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import systems.texture.alize.fragment.MachinesFragment;
import systems.texture.alize.model.common.PaperspaceAccount;
import systems.texture.alize.net.API;
import systems.texture.alize.util.SharedPrefUtil;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    CompositeDisposable addAccountSubs = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        AddAccountFragment.newInstance().show(getSupportFragmentManager(), TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void addApiKey(String apiKey) {
        addAccountSubs.add(API.PaperSpace.getCustomClient(this, apiKey)
                .create(API.PaperSpace.UserService.class)
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userList -> {
                    //SharedPrefUtil.addPaperspaceAccount(this, new PaperspaceAccount(apiKey, userList.get(0)));
                    SharedPrefUtil.setPaperspaceAPIKey(this, apiKey);
                    ((MachinesFragment) getSupportFragmentManager().findFragmentById(R.id.machines_fragment)).startMachineListNetworkCall();
                }, error -> {
                    error.printStackTrace();
                }));
    }

    @Override
    public void onDestroy() {
        addAccountSubs.dispose();
        super.onDestroy();
    }

    public static class AddAccountFragment extends DialogFragment {
        @BindView(R.id.edit_api_key)
        public EditText apiKeyField;

        public AddAccountFragment() {}

        public static AddAccountFragment newInstance() {
            return new AddAccountFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.fragment_add_account, null);
            ButterKnife.bind(this, view);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setView(view);
            alertDialogBuilder.setPositiveButton(R.string.button_add, (dialog, which) -> {
                String apiKey = apiKeyField.getText().toString();
                ((HomeActivity) getActivity()).addApiKey(apiKey);
            });
            alertDialogBuilder.setNegativeButton(android.R.string.cancel, (dialog, which) -> {
                if (dialog != null)
                    dialog.dismiss();
            });

            return alertDialogBuilder.create();
        }

    }
}
