package com.egsystembd.aitfeed.retrofit;


import com.egsystembd.aitfeed.model.AitBankList;
import com.egsystembd.aitfeed.model.ChangePassword;
import com.egsystembd.aitfeed.model.DeviceVerifyLoginModel;
import com.egsystembd.aitfeed.model.DueOrdersModel;
import com.egsystembd.aitfeed.model.Ledger;
import com.egsystembd.aitfeed.model.LoginModel;
import com.egsystembd.aitfeed.model.Logout;
import com.egsystembd.aitfeed.model.MakeOrder;
import com.egsystembd.aitfeed.model.Notices;
import com.egsystembd.aitfeed.model.OrderDetailsModel;
import com.egsystembd.aitfeed.model.OrderListModel5;
import com.egsystembd.aitfeed.model.OrderPaymentModel;
import com.egsystembd.aitfeed.model.PaymentListModel;
import com.egsystembd.aitfeed.model.ProductCategory;
import com.egsystembd.aitfeed.model.ProductList;
import com.egsystembd.aitfeed.model.ResetPassword;
import com.egsystembd.aitfeed.model.SalesPoints;
import com.egsystembd.aitfeed.model.UserDetails;


import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST(Api.get_product_gas_customer)
//    Observable<Response<Products>> getProductGasCustomerData(@Field("area_id") String area_id);

//    @FormUrlEncoded
//    @POST(Api.verify_acccount)
//    Observable<Response<LoginModel>> verifyAccount(@Field("email") String email,
//                                                   @Field("password") String password);
//

    //    @Headers("Content-Type: application/json")
//    @Headers("Content-Type: multipart/form-data")


//    @FormUrlEncoded
//    @POST(Api.verify_acccount)
//    Observable<Response<LoginModel>> verifyAccount(@Field("email") String email,
//                                                   @Field("password") String password);


    @FormUrlEncoded
    @POST(Api.verify_acccount)
    Observable<Response<LoginModel>> verifyAccount(@Field("email") String email,
                                                   @Field("password") String password,
                                                   @Field("device_id") String device_id,
                                                   @Field("verify") String verify);

    @FormUrlEncoded
    @POST(Api.verify_device)
    Observable<Response<DeviceVerifyLoginModel>> verifyDevice(@Header("Authorization") String authorization,
                                                              @Header("Accept") String accept,
                                                              @Field("device_id") String device_id,
                                                              @Field("verification_code") String verification_code);


    @FormUrlEncoded
    @POST(Api.reset_password)
    Observable<Response<ResetPassword>> reset_password(
            @Field("user_phone") String user_phone
    );

    @FormUrlEncoded
    @POST(Api.change_password)
    Observable<Response<ChangePassword>> change_password(@Header("Authorization") String authorization,
                                                         @Header("Accept") String accept,
                                                         @Field("old_password") String user_phone1,
                                                         @Field("password") String user_phone2,
                                                         @Field("c_password") String user_phone
    );

    @GET(Api.logout)
    Observable<Response<Logout>> logout(@Header("Authorization") String authorization,
                                        @Header("Accept") String accept);


    //    @Headers({"Authorization: Bearer {token}","Content-Type: application/json"})
    @GET(Api.get_product_list)
    Observable<Response<ProductList>> getProductList(@Header("Authorization") String authorization,
                                                     @Header("Accept") String accept);


    @GET(Api.get_order_list)
    Observable<Response<OrderListModel5>> getOrderList(@Header("Authorization") String authorization,
                                                       @Header("Accept") String accept);

    @GET(Api.get_order_details)
    Observable<Response<OrderDetailsModel>> getOrderDetails(@Header("Authorization") String authorization,
                                                            @Header("Accept") String accept,
                                                            @Query("order_id") String order_id);

    @GET(Api.get_due_orders)
    Observable<Response<DueOrdersModel>> get_due_orders(@Header("Authorization") String authorization,
                                                        @Header("Accept") String accept);

//    @FormUrlEncoded
//    @POST(Api.send_order_payment)
//    Observable<Response<OrderPaymentModel>> send_order_payment(@Header("Authorization") String authorization,
//                                                               @Header("Accept") String accept,
//                                                               @Field("order_id") String order_id,
//                                                               @Field("amount") String amount,
//                                                               @Field("receiver_bank_account_id") String receiver_bank_account_id,
//                                                               @Field("sender_bank_branch") String sender_bank_branch,
//                                                               @Field("payment_type") String payment_type,
//                                                               @Field("sender_money_receipt_reference") String sender_money_receipt_reference
//    );


    @FormUrlEncoded
    @POST(Api.send_order_payment)
    Observable<Response<OrderPaymentModel>> send_order_payment(@Header("Authorization") String authorization,
                                                               @Header("Accept") String accept,
                                                               @Field("amount[]") ArrayList<String> amount,
                                                               @Field("receiver_bank_account_id[]") ArrayList<String> receiver_bank_account_id,
                                                               @Field("payment_type[]") ArrayList<String> payment_type,
                                                               @Field("sender_money_receipt_reference[]") ArrayList<String> sender_money_receipt_reference,
                                                               @Field("sender_bank_branch[]") ArrayList<String> sender_bank_branch
    );


    @FormUrlEncoded
    @POST(Api.send_order_payment)
    Observable<Response<OrderPaymentModel>> send_order_payment_cash(@Header("Authorization") String authorization,
                                                                    @Header("Accept") String accept,
                                                                    @Field("amount[]") ArrayList<String> amount,
                                                                    @Field("payment_type[]") ArrayList<String> payment_type
    );


    @GET(Api.ait_bank_list)
    Observable<Response<AitBankList>> getAitBankList(@Header("Authorization") String authorization,
                                                     @Header("Accept") String accept);

    @GET(Api.user_details_info)
    Observable<Response<UserDetails>> getUserDetailsInfo(@Header("Authorization") String authorization,
                                                         @Header("Accept") String accept);

    @GET(Api.get_sales_points)
    Observable<Response<SalesPoints>> getSalesPoints(@Header("Authorization") String authorization,
                                                     @Header("Accept") String accept);

    @GET(Api.get_product_category)
    Observable<Response<ProductCategory>> productCategoryObtained(@Header("Authorization") String authorization,
                                                                  @Header("Accept") String accept);

    @GET(Api.get_notices)
    Observable<Response<Notices>> get_notices(@Header("Authorization") String authorization,
                                              @Header("Accept") String accept);


    @GET(Api.get_ledger)
    Observable<Response<Ledger>> getLedger(@Header("Authorization") String authorization,
                                           @Header("Accept") String accept,
                                           @Query("start_time") String start_time,
                                           @Query("end_time") String end_time);


    @GET(Api.get_payment_list)
    Observable<Response<PaymentListModel>> getPaymentList(@Header("Authorization") String authorization,
                                                          @Header("Accept") String accept);


    @FormUrlEncoded
    @POST(Api.make_order)
    Observable<Response<MakeOrder>> makeOrder(@Header("Authorization") String authorization,
                                              @Header("Accept") String accept,
                                              @Field("order_total") String order_total,
                                              @Field("product_id[]") ArrayList<String> product_id,
                                              @Field("product_quantity[]") ArrayList<String> product_quantity,
                                              @Field("receiver_bank_account_id") int receiver_bank_account_id,
                                              @Field("sender_bank_branch") String sender_bank_branch,
                                              @Field("sender_money_receipt_reference") String sender_money_receipt_reference,
                                              @Field("truck_driver_name") String truck_driver_name,
                                              @Field("truck_driver_mobile") String truck_driver_mobile,
                                              @Field("truck_reg_no") String truck_reg_no,
                                              @Field("sales_point") String sales_point,
                                              @Field("payment_type") String payment_type
    );


}

