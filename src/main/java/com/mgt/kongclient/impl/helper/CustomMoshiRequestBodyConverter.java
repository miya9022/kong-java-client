package com.mgt.kongclient.impl.helper;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

import java.io.IOException;

final class CustomMoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {

  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

  private final Moshi moshi;
  private final JsonAdapter<T> jsonAdapter;

  CustomMoshiRequestBodyConverter(Moshi moshi, JsonAdapter<T> jsonAdapter) {
    this.moshi = moshi;
    this.jsonAdapter = jsonAdapter;
  }

  @Override
  public RequestBody convert(T value) throws IOException {
    var buffer = new Buffer();
    var jsonWriter = JsonWriter.of(buffer);
    jsonAdapter.toJson(jsonWriter, value);
    return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
  }
}
