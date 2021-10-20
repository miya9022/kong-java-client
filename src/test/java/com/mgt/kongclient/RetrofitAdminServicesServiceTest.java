package com.mgt.kongclient;

import com.mgt.kongclient.model.admin.services.Service;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitAdminServicesServiceTest extends BaseTest {

  private String API_NAME_V1 = "Test_V1_Api";
  //    private String API_ID_V1 = "f813a66b-bac6-4951-831b-f04d53ae0bf0"; // not exist
  private String API_ID_V1 = "3a9fa5b9-5f99-4ab8-a949-d676becd30b3";

  private String API_NAME_V2 = "Test_V2_Api";
  private String API_NAME_V2_NEW = "Test.V2.Api";
  private String API_ID_V2 = "f813a66b-bac6-4952-831b-f04d53ae0bf0";

  private String API_UPSTREAM_URL = "http://httpbin.org";
  private String API_HOST = "example.com";
  private String[] API_URIS = new String[]{"/v1/example", "/v2/example"};

  @Test
  public void test1_createService() {
    var request = new Service(
      API_ID_V1, API_NAME_V1, API_HOST,
      "http", 80, "/api", 5,
      60_000L, 60_000L, 60_000L,
      List.of("test", "api"), null, new Date().getTime(), new Date().getTime()
    );

    var response = kongClient.getAdminServicesService().createService(request);
    Assert.assertEquals(request.name(), response.name());
  }
}
