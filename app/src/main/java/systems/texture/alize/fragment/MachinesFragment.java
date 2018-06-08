package systems.texture.alize.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.commons.lang3.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import systems.texture.alize.R;
import systems.texture.alize.adapter.MachineAdapter;
import systems.texture.alize.net.API;
import systems.texture.alize.util.SharedPrefUtil;

public class MachinesFragment extends Fragment {
    private MachineAdapter adapter;
    private CompositeDisposable apiSubs = new CompositeDisposable();
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

    public void startMachineListNetworkCall() {
        boolean isAPIKeyAvailable = !StringUtils.isEmpty(SharedPrefUtil.getPaperspaceAPIKey(getContext()));
        swipeRefreshLayout.setRefreshing(isAPIKeyAvailable);
        if (isAPIKeyAvailable)
            apiSubs.add(API.PaperSpace.getAuthClient(getContext())
                    .create(API.PaperSpace.UserService.class)
                    .getUsers()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userList -> {
                        apiSubs.add(API.PaperSpace.getAuthClient(getContext())
                                .create(API.PaperSpace.MachineService.class)
                                .getMachineList()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(list -> {
                                    adapter.addUserAndMachineList(userList.get(0), list);
                                    swipeRefreshLayout.setRefreshing(false);
                                }, Throwable::printStackTrace));
                    }));
    }

    @Override
    public void onDestroy() {
        apiSubs.dispose();
        super.onDestroy();
    }
}
