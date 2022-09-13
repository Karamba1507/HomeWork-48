package com.company;

import service.FileService;

import java.util.List;

public class Candidates {

    private List<Candidate> candidates;

    public Candidates() {
        this.candidates = FileService.readString();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}
