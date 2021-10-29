package com.mgt.kongclient;

import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.plugin.authentication.jwt.JwtCredential;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by dvilela on 10/22/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitJwtServiceTest extends BaseTest {

  private static Consumer consumer;

  @Before
  public void createConsumerAndAddCredential() throws Exception {
    var c = new Consumer(null, UUID.randomUUID().toString());
    consumer = kongClient.getConsumerService().createConsumer(c);

    var credential = kongClient.getJwtService().addCredentials(consumer.id(), new JwtCredential());
    assertEquals(consumer.id(), credential.getConsumerId());
  }

  @After
  public void deleteConsumer() throws Exception {
    kongClient.getConsumerService().deleteConsumer(consumer.id());
  }

  @Test
  public void test01_listCredentialsTest() throws Exception {
    var list = kongClient.getJwtService().listCredentials(consumer.id(), null, null);
    var c = list.getData().get(0);
    assertEquals(consumer.id(), c.getConsumerId());
  }

  @Test
  public void test02_deleteCredentialTest() throws Exception {
    var list = kongClient.getJwtService().listCredentials(consumer.id(), null, null);
    var credential = list.getData().get(0);
    kongClient.getJwtService().deleteCredentials(consumer.id(), credential.getId());
    var list2 = kongClient.getJwtService().listCredentials(consumer.id(), null, null);
    assertEquals(0L, (long) list2.getTotal());
  }

}
