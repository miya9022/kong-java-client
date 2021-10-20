package com.mgt.kongclient.model.plugin.authentication.oauth2;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by fanhua on 2017-08-07.
 */
@Data
public class TokenList extends AbstractEntityList {

  Long total;

  List<Token> data;
}
