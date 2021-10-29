package com.mgt.kongclient;

import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredential;
import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredentialList;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by dvilela on 11/08/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitKeyAuthServiceTest extends BaseTest {

  private Consumer consumer;

  @Before
  public void createConsumer() throws Exception {
    var c = new Consumer(null, UUID.randomUUID().toString());
    consumer = kongClient.getConsumerService().createConsumer(c);

    var credential = kongClient.getKeyAuthService().addCredentials(consumer.id(), null);
    assertEquals(consumer.id(), credential.getConsumerId());
    assertNotNull(consumer.id(), credential.getKey());
  }

  @After
  public void deleteConsumer() throws Exception {
    kongClient.getConsumerService().deleteConsumer(consumer.id());
  }

  @Test
  public void test01_addRepeatedCredentialTest() throws Exception {
    var credential1 = kongClient.getKeyAuthService().addCredentials(consumer.id(), null);
    assertEquals(consumer.id(), credential1.getConsumerId());
    assertNotNull(consumer.id(), credential1.getKey());

    try {
      var credential2 = kongClient.getKeyAuthService().addCredentials(consumer.id(),
        credential1.getKey());
      fail("RetrofitKeyAuthService did not throw");
    } catch (KongClientException e) {
      assertEquals(409, e.getCode());
      assertEquals("Conflict", e.getError());
    }
  }

  @Test
  public void test02_listCredentialsTest() throws Exception {
    var list = kongClient.getKeyAuthService().listCredentials(consumer.id(), null,
      null);
    var credential = list.getData().get(0);
    assertEquals(consumer.id(), credential.getConsumerId());
  }

  @Test
  public void test03_deleteCredentialTest() throws Exception {
    var list = kongClient.getKeyAuthService().listCredentials(consumer.id(), null,
      null);
    var credentials = list.getData();
    for (var credential : credentials) {
      kongClient.getKeyAuthService().deleteCredential(credential.getConsumerId(), credential.getId());
    }
    var list2 = kongClient.getKeyAuthService().listCredentials(consumer.id(), null,
      null);
    assertEquals(0L, (long) list2.getTotal());
  }

}
