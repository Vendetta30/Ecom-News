package rss

import java.text.DateFormat
import java.text.SimpleDateFormat

class Feed {

    String title
    String content
    Date pubDate
    String link
    Url url
    static belongsTo = [url: Url]


    static constraints = {
        link unique: true, nullable: false, blank: false
        title nullable: false, blank: false, unique: true
        content nullable: true, blank: true
        pubDate nullable: false, blank: false

    }
    static mapping = {
        content sqlType: 'longtext'
    }
   public static dateFormat(String date)
    {
        DateFormat dateFormatNeeded=new SimpleDateFormat("DD MMM YYYY")
       dateFormatNeeded.parse(date)
    }
}
