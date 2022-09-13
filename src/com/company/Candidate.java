package com.company;

public class Candidate {
    private Integer id;
    private String name;
    private String photo;
    private Integer countVotes;
    private Integer percents;

    public Candidate(Integer id, String name, String photo, Integer countVotes) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.countVotes = countVotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCountVotes() {
        return countVotes;
    }

    public void setCountVotes(Integer countVotes) {
        this.countVotes = countVotes;
    }

    public Integer getPercents() {
        return percents;
    }

    public void setPercents(Integer percents) {
        this.percents = percents;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", countVotes=" + countVotes +
                '}';
    }
}
