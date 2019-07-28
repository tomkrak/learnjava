package pl.sda.learnjava.LearnJava.dto;

public class SimpleAnswer {

    private String answer;
    private String question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "SimpleAnswer{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
