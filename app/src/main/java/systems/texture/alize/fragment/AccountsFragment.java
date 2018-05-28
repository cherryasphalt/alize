package systems.texture.alize.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import systems.texture.alize.R;
import systems.texture.alize.adapter.AccountAdapter;

public class AccountsFragment extends Fragment {
    private RecyclerView accountsRecycler;
    private AccountAdapter adapter;

    public AccountsFragment() {}

    public static AccountsFragment newInstance() {
        return new AccountsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        accountsRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_accounts, container, false);
        adapter = new AccountAdapter();
        accountsRecycler.setAdapter(adapter);
        return accountsRecycler;
    }
}
