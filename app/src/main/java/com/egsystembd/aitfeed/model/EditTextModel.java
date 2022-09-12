package com.egsystembd.aitfeed.model;

public class EditTextModel {
    private String et_product_taka;
    private String et_sender_branch_name;
    private String et_sender_reference;
    private String paymentTypesSpinner;
    private String selectedBankNameSpinner;

    public String getSelectedBankNameSpinner() {
        return selectedBankNameSpinner;
    }

    public void setSelectedBankNameSpinner(String selectedBankNameSpinner) {
        this.selectedBankNameSpinner = selectedBankNameSpinner;
    }

    public String getPaymentTypesSpinner() {
        return paymentTypesSpinner;
    }

    public void setPaymentTypesSpinner(String paymentTypesSpinner) {
        this.paymentTypesSpinner = paymentTypesSpinner;
    }

    public String getEt_product_taka() {
        return et_product_taka;
    }

    public void setEt_product_taka(String et_product_taka) {
        this.et_product_taka = et_product_taka;
    }

    public String getEt_sender_branch_name() {
        return et_sender_branch_name;
    }

    public void setEt_sender_branch_name(String et_sender_branch_name) {
        this.et_sender_branch_name = et_sender_branch_name;
    }

    public String getEt_sender_reference() {
        return et_sender_reference;
    }

    public void setEt_sender_reference(String et_sender_reference) {
        this.et_sender_reference = et_sender_reference;
    }
}
