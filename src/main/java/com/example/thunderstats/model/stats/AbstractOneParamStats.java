package com.example.thunderstats.model.stats;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractOneParamStats implements StatsInterface {

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


    public LinkedHashMap<String,Integer> getOrderedStats(){
        LinkedHashMap<String,Integer> sorted =
                stats.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sorted;
    }

    public LinkedHashMap<String,Integer> getTop5(){
        LinkedHashMap<String,Integer> sorted =
                stats.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(5)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sorted;
    }

}
