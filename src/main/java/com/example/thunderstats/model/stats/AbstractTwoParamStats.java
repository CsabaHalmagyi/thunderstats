package com.example.thunderstats.model.stats;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTwoParamStats implements StatsInterface{

    private Map<String, Map<String, Integer>> stats;

    AbstractTwoParamStats() {

        this.stats = new HashMap<>();
    }

    public Map<String, Map<String, Integer>> getStats() {
        return stats;
    }



    void increaseStat(String statKey, String sentOrReceived){
        if(!stats.containsKey(statKey)) stats.put(statKey, new HashMap<>());
        if(!stats.get(statKey).containsKey(sentOrReceived)) stats.get(statKey).put(sentOrReceived, 0);
        Integer i = stats.get(statKey).get(sentOrReceived) + 1;
        stats.get(statKey).put(sentOrReceived, i);
    }
}
