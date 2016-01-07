package com.example.daniel.generalchemistry101flashcards_2;

/**
 * Created by Daniel on 12/28/2015.
 */
public class Question {
    private int id;
    private String ask;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String correctChoice;

    public Question(){}

    public Question(int id, String ask, String choice1, String choice2, String choice3, String choice4, String correctChoice){
        this.id=id;
        this.ask=ask;
        this.choice1=choice1;
        this.choice2=choice2;
        this.choice3=choice3;
        this.choice4=choice4;
        this.correctChoice=correctChoice;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id=id; }

    public String getAsk() { return ask;}
    public void setAsk(String ask) { this.ask=ask; }

    public String getChoice1(){ return choice1; }
    public void setChoice1(String choice1){this.choice1=choice1;}

    public String getChoice2(){ return choice2; }
    public void setChoice2(String choice2){this.choice2=choice2;}

    public String getChoice3(){ return choice3; }
    public void setChoice3(String choice3){this.choice3=choice3;}

    public String getChoice4(){ return choice4; }
    public void setChoice4(String choice4){this.choice4=choice4;}

    public String getCorrectChoice(){ return correctChoice; }
    public void setCorrectChoice(String correctChoice){this.correctChoice=correctChoice;}

    @Override
    public String toString() {
        return "Question [id=" + id + "ask=" + ask + ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4=" + choice4 + ", correctChoice=" + correctChoice
                + "]";
    }
}
