package systems.texture.alize;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;
    private View view;

    public BindingHolder(View v) {
        super(v);
        view = v;
        try {
            binding = DataBindingUtil.bind(v);
        } catch (IllegalArgumentException e) {
            binding = null;
        }
    }

    public T getBinding() {
        return binding;
    }

    public View getView() {
        return view;
    }
}