package com.mgt.kongclient.model.plugin.authentication.key;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by dvilela on 17/10/2017.
 */
@Data
public class KeyAuthCredentialList extends AbstractEntityList {
  Long total;
  List<KeyAuthCredential> data;
}
