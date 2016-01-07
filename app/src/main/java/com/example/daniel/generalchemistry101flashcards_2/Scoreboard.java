package com.example.daniel.generalchemistry101flashcards_2;

/**
 * Created by Daniel on 12/28/2015.
 */
public class Scoreboard {
    private int id;
    private String subject;
    private int score;

    public Scoreboard(){}

    public Scoreboard(int id, String subject, int score){
        this.id=id;
        this.subject=subject;
        this.score=score;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id=id; }

    public String getSubject() { return subject;}
    public void setSubject(String subject) { this.subject=subject; }

    public int getScore() { return score;}
    public void setScore(int score) { this.score=score; }


    @Override
    public String toString() {
        return "Scoreboard [id= " + id + ", subject= " + subject + ", score= " + score
                + "]";
    }
}