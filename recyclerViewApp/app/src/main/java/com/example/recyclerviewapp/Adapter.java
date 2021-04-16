package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ModelClass> myList;
    public Adapter(List<ModelClass> myList){
        this.myList=myList;
    }
    @NonNull
    @Override
    //inflate our layout file
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }
    //helps in binding data from main Activity to inside our layout recyclerView

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int image=myList.get(position).getImageview();
        String name=myList.get(position).getName();
        String date=myList.get(position).getDate();
        String msg=myList.get(position).getMsg();
        String divider=myList.get(position).getSeparator();
        holder.setData(image,name,date,msg,divider);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private TextView nameview,dateview,msgview,dividerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageview1);
            nameview=itemView.findViewById(R.id.name);
            dateview=itemView.findViewById(R.id.date);
            msgview=itemView.findViewById(R.id.msg);
            dividerView=itemView.findViewById(R.id.divide);
        }

        public void setData(int image, String name, String date, String msg,String divide) {
            imageview.setImageResource(image);
            nameview.setText(name);
            dateview.setText(date);
            msgview.setText(msg);
            dividerView.setText(divide);


        }
    }
}
