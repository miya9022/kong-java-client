package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.admin.consumer.ConsumerList;

/**
 * Created by vaibhav on 13/06/17.
 */
public interface ConsumerService {

  Consumer createConsumer(Consumer request);

  ConsumerList getAllConsumers();

  Consumer getConsumer(String usernameOrId);

  Consumer updateConsumer(String usernameOrId, Consumer request);

  Consumer upsertConsumer(String usernameOrId, Consumer request);

  Void deleteConsumer(String usernameOrId);
}
