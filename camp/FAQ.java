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

    public boolean setQuestion(String question) {
        if(question != null){
            this.question = question;
            return true;
        }
        return false;
    }

    public String getAnswer() {
        return this.answer;
    }

    public boolean setAnswer(String answer) {
        if(answer != null){
            this.answer = answer;
            return true;
        }
        return false;
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
