package LC400_15_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Gary on 2019-01-27.
 */
public class LC399 {
    //******************************方法2****************************************
    public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);

        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }

    //**************************方法1：****************************************************

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> valueMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] equation = equations[i];
            double value = values[i];
            // init first
            if (!parentMap.containsKey(equation[0])) {
                parentMap.put(equation[0], equation[0]);
                valueMap.put(equation[0], new HashMap<>());
                valueMap.get(equation[0]).put(equation[0], 1.0);
            }
            // init second
            if (!parentMap.containsKey(equation[1])) {
                parentMap.put(equation[1], equation[1]);
                valueMap.put(equation[1], new HashMap<>());
                valueMap.get(equation[1]).put(equation[1], 1.0);
            }

            // find first parent and second parent
            String first = parentMap.get(equation[0]);
            String second = parentMap.get(equation[1]);
            int sizeFirst = valueMap.get(first).size();
            int sizeSecond = valueMap.get(second).size();

            // find first parent and second parent relationship
            if (!first.equals(equation[0])) {
                value = value * valueMap.get(first).get(equation[0]);
            }
            if (!second.equals(equation[1])) {
                value = value / valueMap.get(second).get(equation[1]);
            }
            if (sizeFirst >= sizeSecond) {
                union(first, second, valueMap, parentMap, value);
            } else {
                union(second, first, valueMap, parentMap, 1 / value);
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            String parent1 = parentMap.get(queries[i][0]);
            String parent2 = parentMap.get(queries[i][1]);
            if (parent1 == null || parent2 == null || !parent1.equals(parent2)) {
                result[i] = -1.0;
            } else {
                result[i] = valueMap.get(parent1).get(queries[i][1]) / valueMap.get(parent1).get(queries[i][0]);
            }
        }
        return result;
    }

    private static void union(String parent, String child,
                              Map<String, Map<String, Double>> valueMap,
                              Map<String, String> parentMap,
                              double index) {
        Map<String, Double> parentValueMap = valueMap.get(parent);
        Map<String, Double> childValueMap = valueMap.get(child);
        parentValueMap.put(child, index);
        parentMap.put(child, parent);
        for (String s : childValueMap.keySet()) {
            parentValueMap.put(s, childValueMap.get(s) * index);
            parentMap.put(s, parent);
        }
        valueMap.remove(child);
    }
}
