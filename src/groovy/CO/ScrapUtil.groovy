package CO

import java.util.regex.Matcher
import java.util.regex.Pattern
import CO.Enums

/**
 * Created by abhinav on 27/8/16.
 */
class ScrapUtil {

    public static Boolean calculateTransaction(String description) {
        Boolean flag = Boolean.FALSE
        Map patternMap = [:]
        patternMap.put(Enums.Keyword.paytm, "paytm")
        patternMap.put(Enums.Keyword.amazon, "amazon")
        patternMap.put(Enums.Keyword.ecommerce, "ecommerce")

        patternMap.keySet().each { word ->
            Pattern pattern = Pattern.compile(patternMap.get(word))
            Matcher matcher = pattern.matcher(description)
            if (matcher.find()) {
                flag = Boolean.TRUE
            }
        }
        return flag
    }

}
