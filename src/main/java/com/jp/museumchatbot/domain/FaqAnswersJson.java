package com.jp.museumchatbot.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // cria os getters
@AllArgsConstructor // cria o construtor
public class FaqAnswersJson {
  private List<String> keywords;
  private String answer;
}
