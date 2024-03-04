package com.jp.museumchatbot.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.museumchatbot.domain.FaqAnswersJson;
import com.jp.museumchatbot.utils.FaqAnswers;

@Service
public class FaqService {
  final private FaqAnswers faqAnswers = new FaqAnswers();

  @SuppressWarnings("rawtypes")
  public String getAnswers(String message) {
    String[] words = message.toLowerCase().split("\\s+");
    List wordsList = Arrays.asList(words).stream().map(String::toLowerCase).toList(); // faz a conversão para minusculas

    for (FaqAnswersJson entry : faqAnswers.getAnswers()) {
      for (String keyword : entry.getKeywords()) {
        if (wordsList.contains(keyword.toLowerCase())) { // verifica se o keyword está na pergunda do usuário
          return entry.getAnswer();
        }
      }
    }
    return faqAnswers.getDefaultAnswer();
  }
}

/**
 * Prcessa a pergunta que o usuário passou;
 * tentar achar uma resposta para essa pergunta
 */