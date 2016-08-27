package ecom.news

import com.rss.Feed
import com.rss.FetchUrl

import java.text.DateFormat
import java.text.SimpleDateFormat


class FeedService {
    static transactional = false

    def readRssFeedXml(FetchUrl url) {

        DateFormat dateFormatComing = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z")
        Date date

        def xmlFeed = new XmlParser().parse(url.urlLink);
        (0..<xmlFeed.channel.item.size()).each {
            def item = xmlFeed.channel.item.get(it);


            if (!(Feed.findAllByLink(item.link.text())) && (!(Feed.findAllByTitle(item.link.text())))) {
                println(item.link.text)
                date = dateFormatComing.parse(item.pubDate.text())
                Feed feed = new Feed(title: item.title.text(), link: item.link.text(), content: item.description.text(), pubDate: date, url: url)
                feed.save(flush: true, failOnError: true)
            }
        }
    }
}
