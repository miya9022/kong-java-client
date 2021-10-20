package com.mgt.kongclient.impl.helper;

import com.squareup.moshi.Moshi;
import dev.zacsweers.moshix.records.RecordsJsonAdapterFactory;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class CustomMoshiConverterFactory extends Converter.Factory {

  private final Moshi moshi;

  private CustomMoshiConverterFactory(Moshi moshi) {
    this.moshi = moshi;
  }

  public static CustomMoshiConverterFactory create() {
    return new CustomMoshiConverterFactory(new Moshi.Builder().add(new RecordsJsonAdapterFactory()).build());
  }

  public static CustomMoshiConverterFactory create(Moshi moshi) {
    return new CustomMoshiConverterFactory(moshi);
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
    var adapter = moshi.adapter(type);
    return new CustomMoshiResponseBodyConverter<>(moshi, adapter);
  }

  @Override
  public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
    var adapter = moshi.adapter(type);
    return new CustomMoshiRequestBodyConverter<>(moshi, adapter);
  }
}
