package LC400_18_Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC359 {
    class Logger {
        private Map<String, Integer> map;
        /**
         * Initialize your data structure here.
         */
        public Logger() {
            map = new HashMap<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (timestamp < map.getOrDefault(message, 0)) return false;
            map.put(message, timestamp + 10);
            return true;
        }
    }

}
