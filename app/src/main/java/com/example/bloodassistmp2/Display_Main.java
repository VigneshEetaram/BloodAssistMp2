package com.example.bloodassistmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bloodassistmp2.api_interfaces.JsonPlaceHolderApi;
import com.example.bloodassistmp2.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Display_Main extends AppCompatActivity {
    private TextView textViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_main);

        textViewResults = findViewById(R.id.text_view_result);

        //getPosts();
        createPost();
    }
    void createPost(){
        Post post=new Post("Jhon","07061996","B+","987654321","Jhon@Jhon.com","Montreal");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResults.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content = "";
                content += "Details: " + response.code()+"\n";
                content += "Name: " + postResponse.getFullname()+"\n";
                content += "DateOfBirth: " + postResponse.getDateofbirth()+"\n";
                content += "BloodGroup: " + postResponse.getBloodgroup()+"\n";
                content += "PhoneNumber: " + postResponse.getPhonenumber()+"\n";
                content += "Address: " + postResponse.getAddress()+"\n\n";

                textViewResults.setText(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResults.setText(t.getMessage());
            }
        });
    }

    public void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost/phpmyadmin/tbl_structure.php?db=bloodassist&table=donar")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call =jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textViewResults.setText("Code: "+ response.code());
                    return;
                }

                List<Post> posts = response.body();
                for(Post post:posts){
                    String content = "";
                    content += "Name: " + post.getFullname()+"\n";
                    content += "DateOfBirth: " + post.getDateofbirth()+"\n";
                    content += "BloodGroup: " + post.getBloodgroup()+"\n";
                    content += "PhoneNumber: " + post.getPhonenumber()+"\n";
                    content += "Address: " + post.getAddress()+"\n\n";

                    textViewResults.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResults.setText(t.getMessage());

            }
        });
    }
}