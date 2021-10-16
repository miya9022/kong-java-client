package com.github.vaibhavsinha.kong.impl.helper;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.Okio;
import retrofit2.Converter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
final class CustomMoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {

  private final Moshi moshi;
  private final JsonAdapter<T> jsonAdapter;

  CustomMoshiResponseBodyConverter(Moshi moshi, JsonAdapter<T> jsonAdapter) {
    this.moshi = moshi;
    this.jsonAdapter = jsonAdapter;
  }

  @Override
  public T convert(ResponseBody value) throws IOException {
    var response = value.string();
    if (response.isEmpty()) {
      //It may response empty body...
      log.debug("Response empty body...");
      return null;
    }
    return jsonAdapter.fromJson(ByteString.encodeUtf8(response).utf8());
  }
}
