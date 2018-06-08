package systems.texture.alize;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import systems.texture.alize.databinding.ActivityMachineDetailBinding;
import systems.texture.alize.model.paperspace.Machine;

public class MachineDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Machine machine = getIntent().getParcelableExtra("machine");
        ActivityMachineDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_machine_detail);
        binding.setMachine(machine);
    }
}
