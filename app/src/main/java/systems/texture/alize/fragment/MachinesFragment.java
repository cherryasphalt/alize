package systems.texture.alize.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import systems.texture.alize.R;
import systems.texture.alize.adapter.AccountAdapter;
import systems.texture.alize.adapter.MachineAdapter;
import systems.texture.alize.net.API;

public class MachinesFragment extends Fragment {
    private MachineAdapter adapter;
    private Disposable machineSub;
    private SwipeRefreshLayout swipeRefreshLayout;

    public MachinesFragment() {}

    public static MachinesFragment newInstance() {
        return new MachinesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        swipeRefreshLayout = (SwipeRefreshLayout) inflater.inflate(R.layout.fragment_machines, container, false);
        RecyclerView machinesRecycler = swipeRefreshLayout.findViewById(R.id.recycler);
        adapter = new MachineAdapter();
        machinesRecycler.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this::startMachineListNetworkCall);

        startMachineListNetworkCall();
        return swipeRefreshLayout;
    }

    private void startMachineListNetworkCall() {
        if (machineSub == null || machineSub.isDisposed())
            machineSub = API.PaperSpace.getClient(getContext())
                    .create(API.PaperSpace.MachineService.class)
                    .getMachineList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(list -> {
                        adapter.setMachineList(list);
                        swipeRefreshLayout.setRefreshing(false);
                    });
    }

    @Override
    public void onDestroy() {
        if (machineSub != null)
            machineSub.dispose();
        super.onDestroy();
    }
}
