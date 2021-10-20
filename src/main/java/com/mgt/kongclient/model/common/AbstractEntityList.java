package com.mgt.kongclient.model.common;

import com.mgt.kongclient.utils.UrlUtil;

/**
 * Created by vaibhav on 13/06/17.
 */
public abstract class AbstractEntityList {

  public String getNext() {
    return null;
  }

  public String getOffset() {
    if (getNext() == null) {
      return null;
    } else {
      return UrlUtil.splitQueryString(getNext()).get("offset");
    }
  }
}
