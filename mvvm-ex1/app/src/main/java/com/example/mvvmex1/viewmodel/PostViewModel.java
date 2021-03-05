package com.example.mvvmex1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmex1.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel extends ViewModel {

    //LiveData, MutableLiveData
    private MutableLiveData<List<Post>> mtPosts = new MutableLiveData<>();

    public MutableLiveData<List<Post>> 구독(){
        return mtPosts;
    }

    //1.
    public void 포스트한건추가(Post post){
        List<Post> posts = mtPosts.getValue();
        posts.add(post);
        mtPosts.setValue(posts);
    }

    //2.
    public void 포스트변경(){
        List<Post> posts = mtPosts.getValue();
        posts.get(0).setTitle("테스트");
        mtPosts.setValue(posts);
    }

    public void 데이터초기화(){
        List<Post> posts = new ArrayList<>();
        mtPosts.setValue(posts);
    }

}
