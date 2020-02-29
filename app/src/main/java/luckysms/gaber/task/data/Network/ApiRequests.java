package luckysms.gaber.task.data.Network;

import java.util.List;

import luckysms.gaber.task.data.Model.dataModel;
import luckysms.gaber.task.data.Model.response_model;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequests {
    @GET("/api/home")
    Call<response_model> data();
}
