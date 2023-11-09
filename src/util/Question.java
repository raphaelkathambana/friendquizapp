package util;

import java.util.List;

public class Question {
    private String prompt;
    private List<String> options;
    private int correctAnswerIndex;
    private List<String> multimediaElements;

    public Question(String question, List<String> options, int correctAnswerIndex, List<String> multimediaElements) {
        this.prompt = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.multimediaElements = multimediaElements;
    }

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.prompt = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public List<String> getMultimediaElements() {
        return multimediaElements;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public void removeOption(int index) {
        options.remove(index);
    }

    public void addMultimediaElement(String multimediaElement) {
        multimediaElements.add(multimediaElement);
    }

    public void removeMultimediaElement(int index) {
        multimediaElements.remove(index);
    }

    public int getNumOptions() {
        return options.size();
    }

    public String getOption(int j) {
        return options.get(j);
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex2) {
    }

    public String getQuestion() {
        return this.prompt;
    }
}

