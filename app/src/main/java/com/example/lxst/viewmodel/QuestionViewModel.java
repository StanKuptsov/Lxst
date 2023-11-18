package com.example.lxst.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lxst.Model.QuestionModel;
import com.example.lxst.Model.ResultModel;
import com.example.lxst.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionViewModel extends ViewModel implements QuestionRepository.OnQuestionLoad, QuestionRepository.OnResultAdded, QuestionRepository.OnResultLoad {

    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;
    private MutableLiveData<HashMap<String , String>> resultMutableLiveData;
    private MutableLiveData<HashMap<String , String>> userMutableLiveData;

    public MutableLiveData<HashMap<String, String>> getResultMutableLiveData() {
        return resultMutableLiveData;
    }

    public void getResults(){
        repository.getResults();
    }

    public MutableLiveData<List<QuestionModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }

    public QuestionViewModel(){
        questionMutableLiveData = new MutableLiveData<>();
        resultMutableLiveData = new MutableLiveData<>();
        repository = new QuestionRepository(this , this , this);
    }
    public void addResults(HashMap<String , Object> resultMap){
        repository.addResults(resultMap);
    }

    public void setQuizId(String quizId){
        repository.setQuizId(quizId);
    }

    public void getQuestions(){
        repository.getQuestions();
    }

    @Override
    public void onLoad(List<QuestionModel> questionModels) {
        questionMutableLiveData.setValue(questionModels);
    }

    @Override
    public boolean onSubmit() {
        return true;
    }


    @Override
    public void onResultLoad(HashMap<String, String> resultMap) {
        resultMutableLiveData.setValue(resultMap);
    }

    @Override
    public void onError(Exception e) {
        Log.d("QuizError", "onError: " + e.getMessage());
    }
}