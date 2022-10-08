package com.egsystembd.aitfeed.ui.ledger.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.model.Ledger;

import java.util.ArrayList;
import java.util.List;

public class LedgerAdapter extends RecyclerView.Adapter<LedgerAdapter.MyViewHolder> {


    private List<Ledger.DealerLedgerList> ledgerListFiltered;
    //    private OrderListAdapterListener listener;
    String finalOrderStatus;

    private List<Ledger.DealerLedgerList> dataSet = new ArrayList<>();
    Context context;

    public LedgerAdapter(Context context) {
        this.context = context;

    }

    public LedgerAdapter(Context context, List<Ledger.DealerLedgerList> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }
//    public void setData(List<Ledger.DealerLedgerList> dataSet) {
//        this.dataSet = dataSet;
//    }

    public void setData(List<Ledger.DealerLedgerList> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_for_ledger_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TextView tv_date_time = holder.tv_date_time;
        TextView tv_transaction_id = holder.tv_transaction_id;
        TextView tv_transaction_type = holder.tv_transaction_type;
        TextView tv_sale_amount = holder.tv_sale_amount;
        TextView tv_paid_amount = holder.tv_paid_amount;
        TextView tv_balance = holder.tv_balance;

        Ledger.DealerLedgerList ledger = dataSet.get(position);


        Log.d("tag1", "sl:" + position);
        Log.d("tag1111", "dataSet:" + dataSet);


        tv_date_time.setText(ledger.getDate());
        tv_transaction_id.setText(ledger.getTransactionId());
        tv_transaction_type.setText(ledger.getTransactionType());
        tv_sale_amount.setText(ledger.getSaleAmount());
        tv_paid_amount.setText(ledger.getPaidAmount());
        tv_balance.setText(ledger.getBalance());



    }


    @Override
    public int getItemCount() {
        Log.d("tag1212", "dataSet.size():" + dataSet.size());
        return dataSet.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date_time;
        TextView tv_transaction_id;
        TextView tv_transaction_type;
        TextView tv_sale_amount;
        TextView tv_paid_amount;
        TextView tv_balance;



        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date_time = itemView.findViewById(R.id.tv_date_time);
            tv_transaction_id = itemView.findViewById(R.id.tv_transaction_id);
            tv_transaction_type = itemView.findViewById(R.id.tv_transaction_type);
            tv_sale_amount = itemView.findViewById(R.id.tv_sale_amount);
            tv_paid_amount = itemView.findViewById(R.id.tv_paid_amount);
            tv_balance = itemView.findViewById(R.id.tv_balance);

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
//        List<Ledger.DealerLedgerList> filteredList = new ArrayList<>();
//        String charString = charText.toString();
//
//        if (charString.length() == 0) {
//////         ledgerListFiltered = dataSet;
////         filteredList.addAll(dataSet);
//            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
//
//
//        }
//
//        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
//            ledgerListFiltered = dataSet;
//        } else {
////         List<Ledger.DealerLedgerList> filteredList = new ArrayList<>();
//            for (OrderList row : dataSet) {
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
//            ledgerListFiltered = filteredList;
//        }
//
////     Filter.FilterResults filterResults = new Filter.FilterResults();
////     filterResults.values = ledgerListFiltered;
//        this.setData(ledgerListFiltered);
//        this.notifyDataSetChanged();
//    }


}
