package systems.texture.alize.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import systems.texture.alize.BindingHolder;
import systems.texture.alize.R;
import systems.texture.alize.databinding.ItemMachineBinding;
import systems.texture.alize.model.paperspace.Machine;

public class MachineAdapter extends RecyclerView.Adapter<BindingHolder> {
    private List<Machine> machineList;

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BindingHolder(inflater.inflate(R.layout.item_machine, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {
        ItemMachineBinding binding = (ItemMachineBinding) holder.getBinding();
        binding.setMachine(machineList.get(position));
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return machineList != null ? machineList.size() : 0;
    }
}
