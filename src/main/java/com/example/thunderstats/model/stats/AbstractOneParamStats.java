package com.example.thunderstats.model.stats;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractOneParamStats implements StatsInterface {

    private Map<String, Integer> stats;

    public AbstractOneParamStats() {
        stats = new HashMap<>();
    }

    public void increaseStat(String statKey){

        if(!stats.containsKey(statKey)) stats.put(statKey, 0);
        stats.put(statKey, stats.get(statKey)+1);
    }



    public Map<String, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }


}
