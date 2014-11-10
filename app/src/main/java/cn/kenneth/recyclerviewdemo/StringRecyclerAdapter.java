package cn.kenneth.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kenneth on 14/11/7.
 */
public class StringRecyclerAdapter extends RecyclerView.Adapter<StringRecyclerAdapter.ViewHolder> {
    private String[] strings;

    public StringRecyclerAdapter(String[] strings) {
        this.strings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.adapter_string_recylcer, null);

       //这里发现不给item布局添加LayoutParams，会直接默认为WRAP_CONTENT，WRAP_CONTENT布局。
        view.setPadding(20, 0,0, 0);
        view.setFocusable(true);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 10;
        lp.rightMargin = 5;
        lp.topMargin = 20;
        lp.bottomMargin = 15;
        view.setLayoutParams(lp);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(StringRecyclerAdapter.class.getSimpleName() + getValueAt(i));
    }

    public String getValueAt(int i) {
        return strings[i];
    }

    @Override
    public int getItemCount() {
        return this.strings == null ? 0 : strings.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
