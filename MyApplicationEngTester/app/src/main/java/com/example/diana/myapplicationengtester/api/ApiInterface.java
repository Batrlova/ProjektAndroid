package com.example.diana.myapplicationengtester.api;

        import com.example.diana.myapplicationengtester.api.pojo.ResponseTranslator;
        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;
        import retrofit2.http.Query;
        public interface ApiInterface {
    /**
     *
     * @param title Searched string
     * @param redirect e.g. cs|en
     * @return
     */
    //@GET("car")
    @GET("page/summary/{title}")
    Call<ResponseTranslator> getDescription(
            @Path("title") String title,
            @Query("redirect") boolean redirect
    );
}