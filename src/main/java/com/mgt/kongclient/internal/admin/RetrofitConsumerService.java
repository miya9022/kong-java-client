package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.admin.consumer.ConsumerList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vaibhav on 12/06/17.
 */
public interface RetrofitConsumerService {

  @POST("consumers/")
  Call<Consumer> createConsumer(@Body Consumer request);

  @GET("consumers/")
  Call<ConsumerList> getAllConsumers();

  @GET("consumers/{id}")
  Call<Consumer> getConsumer(@Path("id") String usernameOrId);

  @PATCH("consumers/{id}")
  Call<Consumer> updateConsumer(@Path("id") String usernameOrId, @Body Consumer request);

  @PUT("consumers/{id}")
  Call<Consumer> upsertConsumer(@Path("id") String usernameOrId, @Body Consumer request);

  @DELETE("consumers/{id}")
  Call<Void> deleteConsumer(@Path("id") String usernameOrId);
}
