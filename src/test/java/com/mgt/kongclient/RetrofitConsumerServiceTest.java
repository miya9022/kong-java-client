package com.mgt.kongclient;

import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.model.admin.consumer.Consumer;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vaibhav on 12/06/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitConsumerServiceTest extends BaseTest {

  private final String CONSUMER_ID = "12faf661-3529-40c6-98e0-5a54894ad22f";
  private final String CONSUMER_USERNAME = "";
  private final String CONSUMER_CUSTOM_ID = "1234-5678-9012";

  @Test
  public void test01_CreateConsumer() throws IOException {
    var request = new Consumer(CONSUMER_ID, CONSUMER_CUSTOM_ID);

    var response = kongClient.getConsumerService().createConsumer(request);
    printJson(response);
    Assert.assertEquals(request.customId(), response.customId());
  }

  @Test
  public void test02_GetConsumer() throws IOException {
    var response = kongClient.getConsumerService().getConsumer(CONSUMER_ID);
    printJson(response);
    Assert.assertEquals(CONSUMER_ID, response.id());
  }

  @Test(expected = KongClientException.class)
  public void test03_exceptionTest() throws IOException {
    kongClient.getConsumerService().getConsumer("some-random-id");
  }

  @Test
  public void test04_UpdateConsumer() throws IOException {
    var request = new Consumer(null, "1234-5678-9012-3456");

    Consumer response = kongClient.getConsumerService().updateConsumer(CONSUMER_ID, request);
    printJson(response);
    Assert.assertEquals(request.customId(), response.customId());
  }

  //    @Test
  public void test05_CreateOrUpdateConsumer() throws IOException {
    var request = new Consumer(CONSUMER_ID, CONSUMER_CUSTOM_ID, new Date().getTime());
    var response = kongClient.getConsumerService().upsertConsumer(CONSUMER_ID, request);
    printJson(response);
    Assert.assertEquals(request.customId(), response.customId());
  }

  @Test
  public void test09_DeleteConsumer() throws IOException {
    kongClient.getConsumerService().deleteConsumer(CONSUMER_ID);
  }

  @Test
  public void test10_ListConsumers() throws IOException {
    var consumerList = kongClient.getConsumerService().getAllConsumers();
    var consumers = new ArrayList<>(consumerList.getData());
    printJson(consumers);
    Assert.assertNotEquals(consumers.size(), 0);
  }
}
