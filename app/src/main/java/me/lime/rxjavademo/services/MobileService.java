package me.lime.rxjavademo.services;

import io.reactivex.Observable;
import me.lime.rxjavademo.entity.Mobile;
import me.lime.rxjavademo.entity.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MobileService {
    @GET("/")
    Observable<Result<Mobile>> getInfo(@Query(value = "mobile") String mobile);
}
