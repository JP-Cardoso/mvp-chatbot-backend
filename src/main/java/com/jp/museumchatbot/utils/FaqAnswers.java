package com.jp.museumchatbot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.jp.museumchatbot.domain.FaqAnswersJson;

import lombok.Getter;

@Getter
public class FaqAnswers {
  private String defaultAnswer;
  private ArrayList<FaqAnswersJson> answers;

  public FaqAnswers() {
    try {
      JSONTokener tokener = new JSONTokener(new FileInputStream("src/main/resources/static/answers.json")); // carrega o
                                                                                                            // arquivo
      JSONObject faqData = new JSONObject(tokener); // cria um novo objeto
      JSONArray faqArray = faqData.getJSONArray("faq"); // aqui eu pego o conteúdo que do meu json que virou um objeto
      this.answers = new ArrayList<>();

      for (int i = 0; i < faqArray.length(); i++) {
        JSONObject faqEntry = faqArray.getJSONObject(i);
        JSONArray keywordsArray = faqEntry.getJSONArray("keywords");
        List<String> keywords = new ArrayList<>();
        for (int j = 0; j < keywordsArray.length(); j++) {
          keywords.add(keywordsArray.getString(j));
        }
        String answer = faqEntry.getString("answer");
        this.answers.add(new FaqAnswersJson(keywords, answer));
      }

      this.defaultAnswer = faqData.getString("default");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
