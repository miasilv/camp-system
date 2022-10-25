package camp;

/**
 * an object representing an FAQ
 * @author sara
 */
public class FAQ {
    private String question;
    private String answer;

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * constructor of faq
     * @param question the question
     * @param answer the answer
     */
    public FAQ(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
}
