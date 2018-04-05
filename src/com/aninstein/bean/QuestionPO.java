package com.aninstein.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */
public class QuestionPO {

    private String questionno;
    private String question;
    private List<String> answers;
    private String correctAnswer;

    public static String _questionno="questionno";
    public static String _question="question";
    public static String _answers="answers";
    public static String _correctAnswer="correctAnswer";

    public String getQuestionno() {
        return questionno;
    }

    public QuestionPO setQuestionno(String questionno) {
        this.questionno = questionno;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionPO setQuestion(String question) {
        this.question = question;
        return this;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public QuestionPO setAnswers(List<String> answers) {
        this.answers = answers;
        return this;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public QuestionPO setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }
}
