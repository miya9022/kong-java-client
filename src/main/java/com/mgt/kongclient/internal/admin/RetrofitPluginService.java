package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vaibhav on 12/06/17.
 * <p>
 * Updated by fanhua on 2017-08-05.
 */
public interface RetrofitPluginService {

  @POST("plugins/")
  Call<Plugin> addPlugin(@Body Plugin request);

  @GET("plugins/{id}")
  Call<Plugin> getPlugin(@Path("id") String nameOrId);

  @PATCH("plugins/{id}")
  Call<Plugin> updatePlugin(@Path("id") String nameOrId, @Body Plugin request);

  @PUT("plugins/{id}")
  Call<Plugin> upsertPlugin(@Path("id") String nameOrId, @Body Plugin request);

  @DELETE("plugins/{id}")
  Call<Void> deletePlugin(@Path("id") String nameOrId);

  @GET("plugins/")
  Call<PluginList> listPlugins();
}
