package src.Preferences;

import java.util.*;

public class RelevantInfo {

    private static List<Param> top3 = new ArrayList<>();

    //compute the most important 3 parameters. based on the impact factors
    //takes as argument the current selection of sports
    public static List<Param> computeTop3(List<Sport> interestSports) {
        Map<Param, Integer> paramScores = new HashMap<>();

        for (Sport s : interestSports) {
            List<Param> influenceParam = ImpactSport.getImpactParams(s);
            for (Param p : influenceParam) {

                //add one score point for each mention of parameter p
                //in the list of parameters that influence selected sports
                if (paramScores.containsKey(p)) {
                    int newCount = paramScores.get(p) + 1;
                    paramScores.put(p, newCount);
                } else {
                    paramScores.put(p, 1);
                }
            }
        }

        //getting the three parameters with maximal score
        //through one pass through the array
        //if there is equality for the third place, pick any
        Param max1 = Param.VOID, max2 = Param.VOID, max3 = Param.VOID;

        //put 0 in the map for VOID to have an initial comparison score value
        paramScores.put(Param.VOID, 0);

        for (Param p : paramScores.keySet()) {
            if (paramScores.get(p) >= paramScores.get(max1)) {
                max3 = max2;
                max2 = max1;
                max1 = p;
            } else {
                if (paramScores.get(p) >= paramScores.get(max2)) {
                    max3 = max2;
                    max2 = p;
                } else {
                    if (paramScores.get(p) >= paramScores.get(max3)) {
                        max3 = p;
                    }
                }
            }
        }

        return new ArrayList<>(List.of(max1, max2, max3));
    }

    // From Victor Zhao: lazy implementation won't work here because reference of sportsLastComputed has changed
    //                   and it will always pass the condition
    ////pass the current selection of sports as a list, get the top 3 parameters
    //public static List<Param> getTop3 (List<Sport> interestSports) {
    //    //only recompute if the selection of sports has changed from the last call
    //    if (top3 == null || !interestSports.equals(sportsLastComputed)) {
    //        top3 = computeTop3(interestSports);
    //    }
    //
    //    return top3;
    //}
}
