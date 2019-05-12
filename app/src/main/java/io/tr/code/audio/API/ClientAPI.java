package io.tr.code.audio.API;

import io.tr.code.audio.Models.ApiModel;
import io.tr.code.audio.Models.MetaDataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClientAPI {

    @GET("/metadata/{identifier}")
    Call<ApiModel> getPlayListById(@Path("identifier") String identifier);

    @GET("/metadata/{identifier}")
    Call<MetaDataModel> getMetadataById(@Path("identifier") String identifier);

}
