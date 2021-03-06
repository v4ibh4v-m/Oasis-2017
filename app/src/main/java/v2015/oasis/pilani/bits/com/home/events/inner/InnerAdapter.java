package v2015.oasis.pilani.bits.com.home.events.inner;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import v2015.oasis.pilani.bits.com.home.R;
import v2015.oasis.pilani.bits.com.home.databinding.InnerItemBinding;
import v2015.oasis.pilani.bits.com.home.events.onItemClickListener;


public class InnerAdapter extends com.ramotion.garlandview.inner.InnerAdapter<InnerItem> {

    private final List<InnerData> mData = new ArrayList<>();
    int color;
    int type;
     onItemClickListener mListener;

    public InnerAdapter(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public InnerItem onCreateViewHolder(ViewGroup parent, int viewType) {
        final InnerItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new InnerItem(binding, mListener);
    }

    @Override
    public void onBindViewHolder(InnerItem holder, int position) {
        holder.setContent(mData.get(position), color, type);
    }

    @Override
    public void onViewRecycled(InnerItem holder) {
        holder.clearContent();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.inner_item;
    }

    public void addData(@NonNull List<InnerData> innerDataList, int color, int type) {
        final int size = mData.size();
        mData.addAll(innerDataList);
        notifyItemRangeInserted(size, innerDataList.size());
        this.color = color;
        this.type = type;
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }

}
