package systems.texture.alize.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.util.List;

import systems.texture.alize.BindingHolder;
import systems.texture.alize.MachineDetailActivity;
import systems.texture.alize.R;
import systems.texture.alize.databinding.ItemAccountBinding;
import systems.texture.alize.databinding.ItemMachineBinding;
import systems.texture.alize.model.paperspace.Machine;
import systems.texture.alize.model.paperspace.User;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class MachineAdapter extends RecyclerView.Adapter<BindingHolder> {
    @Retention(SOURCE)
    @IntDef({TYPE_MACHINE, TYPE_ACCOUNT})
    public @interface ViewTypes {}
    public static final int TYPE_MACHINE = 0;
    public static final int TYPE_ACCOUNT = 1;

    private AdapterMapper mapper;

    public MachineAdapter() {
        mapper = new AdapterMapper();
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_MACHINE:
                return new BindingHolder(inflater.inflate(R.layout.item_machine, parent, false));
            default:
                return new BindingHolder(inflater.inflate(R.layout.item_account, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_MACHINE:
                ItemMachineBinding machineBinding = (ItemMachineBinding) holder.getBinding();
                machineBinding.buttonMachineSettings.setOnClickListener(view -> {
                    Intent intent = new Intent(view.getContext(), MachineDetailActivity.class);
                    intent.putExtra("machine", (Machine) mapper.get(position));
                    view.getContext().startActivity(intent);
                });
                machineBinding.setMachine((Machine) mapper.get(position));
                break;
            case TYPE_ACCOUNT:
                ItemAccountBinding accountBinding = (ItemAccountBinding) holder.getBinding();
                accountBinding.setUser((User) mapper.get(position));
                break;
        }
    }

    public void addUserAndMachineList(User user, List<Machine> machineList) {
        mapper.clear();
        mapper.add(TYPE_ACCOUNT, user);
        mapper.addList(TYPE_MACHINE, machineList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mapper.getViewType(position);
    }

    @Override
    public int getItemCount() {
        return mapper.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }
}
