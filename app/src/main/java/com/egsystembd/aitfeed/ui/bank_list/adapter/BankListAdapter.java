package com.egsystembd.aitfeed.ui.bank_list.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.model.AitBankList;

import java.util.ArrayList;
import java.util.List;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.MyViewHolder> {


    private List<AitBankList.Data> productListListFiltered;
    private String areaId2;

    private List<AitBankList.Data> dataSet = new ArrayList<>();

    Context context;

    public BankListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<AitBankList.Data> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_bank_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TextView txtSlNo = holder.txtSlNo;
        TextView tv_bank_name = holder.tv_bank_name;
        TextView tv_bank_account_holder_name = holder.tv_bank_account_holder_name;
        TextView tv_bank_account_number = holder.tv_bank_account_number;
        TextView tv_bank_branch_name = holder.tv_bank_branch_name;


        ImageView imageView = holder.imageView;

//        AitBankList.Data productList = dataSet.get(position);

//        for (int j = 0; j < dataSet.size(); j++){
//            if(dataSet.get(j).equals(0)) {
//                dataSet.remove(0);
//            }
//            else{
//
//            }
//        }


        AitBankList.Data productList = dataSet.get(position);
        Log.d("tag1", "dataSet:"+dataSet.size());
        Log.d("tag1", "dataSet2:"+dataSet.size());
        Log.d("tag1", "sl:"+position);





//        Glide.with(context)
//                .load(productList.getProduct_image())
//                .into(imageView);


//        manageInventory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                InventoryProductSizeFragment fragment =  InventoryProductSizeFragment.newInstance(productList.getId(),productList.getProductId(),productList.getImageLink(),productList.getProductName());
//
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_inventory_activity, fragment).addToBackStack(null).commit();
//
//            }
//        });


        tv_bank_name.setText(productList.getBankName());
        tv_bank_account_holder_name.setText(productList.getBankAccountHolderName());
        tv_bank_account_number.setText(productList.getBankAccountNumber());
        tv_bank_branch_name.setText(productList.getBankBranchName());


    }



    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtSlNo;
        TextView tv_bank_name;
        TextView tv_bank_account_holder_name;
        TextView tv_bank_account_number;
        TextView tv_bank_branch_name;

        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            txtSlNo = itemView.findViewById(R.id.txt_sl);
            tv_bank_name = itemView.findViewById(R.id.tv_bank_name);
            tv_bank_account_holder_name = itemView.findViewById(R.id.tv_bank_account_holder_name);
            tv_bank_account_number = itemView.findViewById(R.id.tv_bank_account_number);
            tv_bank_branch_name = itemView.findViewById(R.id.tv_bank_branch_name);

//            imageView = itemView.findViewById(R.id.iv_1);

        }
    }


    public void showProgress() {
        dialog = new ProgressDialog(context);
        dialog.setMessage("please wait.");
        dialog.show();
    }

    public void hideProgress() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    private ProgressDialog dialog;




//    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
//    public void filter(CharSequence charText) {
//
//        List<AitBankList.Data> filteredList = new ArrayList<>();
//        String charString = charText.toString();
//
//        if (charString.length() == 0) {
//////         productListListFiltered = dataSet;
////         filteredList.addAll(dataSet);
//            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
//
//
//        }
//
//        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
//            productListListFiltered = dataSet;
//        } else {
////         List<AitBankList.Data> filteredList = new ArrayList<>();
//            for (Product row : dataSet) {
//                if (
//                        row.getProductName().contains(charString.toLowerCase()) ||
//                                row.getBrandName().toLowerCase().contains(charString.toLowerCase())
////                             ||
////                             row.getMobileNumber().contains(charText) ||
////                             row.getOrderDate().toLowerCase().contains(charString.toLowerCase()) ||
////                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
////                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
//                ) {
//                    filteredList.add(row);
//                }
//            }
//
//            Log.i("tag", "2:  "+String.valueOf(charString.length())+filteredList);
//
//            productListListFiltered = filteredList;
//        }
//
////     Filter.FilterResults filterResults = new Filter.FilterResults();
////     filterResults.values = productListListFiltered;
//        this.setData(productListListFiltered);
//        this.notifyDataSetChanged();
//    }



}
