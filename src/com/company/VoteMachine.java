package com.company;

import com.sun.net.httpserver.HttpExchange;
import server.BasicServer;

import java.io.IOException;
import java.util.Map;

import static server.Utils.parseUrlEncoded;

public class VoteMachine extends BasicServer {

    private boolean canVote = true;


    private Candidates candidates = new Candidates();

    protected VoteMachine(String host, int port) throws IOException {
        super(host, port);

        registerGet("/", this::mainHandler);

        registerPost("/votes", this::vote);

        //registerGet("/candidates", this::candidateHandler);

        registerGet("/error", this::errorHandler);
    }

//    private void candidateHandler(HttpExchange exchange) {
//        renderTemplate(exchange, "candidates.html", candidates);
//    }


    private void mainHandler(HttpExchange exchange) {
        renderTemplate(exchange, "candidates.html", candidates);
    }

    private void errorHandler(HttpExchange exchange) {
        renderTemplate(exchange, "/error.html", candidates);
    }

    private void vote(HttpExchange exchange) {

        if (canVote) {

            String raw = getBody(exchange);
            Map<String, String> parsed = parseUrlEncoded(raw, "&");

            Candidate candidate = null;

            for (Candidate candidate1 : candidates.getCandidates()) {
                if (candidate1.getId() == Integer.parseInt(parsed.get("id"))) {
                    candidate = candidate1;
                    int vote = candidate1.getCountVotes();
                    candidate1.setCountVotes(vote + 1);
                    break;
                }
            }

            assert candidate != null;
            int votesPercent = countVotes(candidate.getCountVotes());

            candidate.setPercents(votesPercent);

            renderTemplate(exchange, "votes.html", candidate);

            canVote = false;


        } else {
            renderTemplate(exchange, "error.html", candidates);
        }
    }


    private int countVotes(int candidateVotes) {

        int totalVotes = 0;

        for (Candidate candidate : candidates.getCandidates()) {

            totalVotes = totalVotes + candidate.getCountVotes();
        }

        return (100 * candidateVotes) / totalVotes;
    }
}


