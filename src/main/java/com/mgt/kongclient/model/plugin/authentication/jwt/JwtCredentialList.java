package com.mgt.kongclient.model.plugin.authentication.jwt;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 16/06/17.
 */
@Data
public class JwtCredentialList extends AbstractEntityList {
  Long total;
  List<JwtCredential> data;
}
