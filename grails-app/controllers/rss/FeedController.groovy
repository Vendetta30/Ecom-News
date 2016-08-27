package rss

import geb.Browser
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class FeedController {

    def feedService

    def index() {}

    def readRssFeed() {
        // Url url=new Url(urlLink:"http://timesofindia.indiatimes.com/rssfeeds/1081479906.cms")
        //url.save(flush: true,failOnError: true)
        //String url_Link="http://timesofindia.indiatimes.com/rssfeeds/1081479906.cms"
        //Url url=Url.findByUrlLink(url_Link)
        Url url = Url.findById(params.id as Long)

        feedService.readRssFeedXml(url)
        redirect action:"showFeed"
    }

    def showFeed() {
        println(params.id)
        Url url=Url.findById(params.id as Long)
        List feedList=Feed.createCriteria().listDistinct {
            eq("url", url)
        }
        render view:"showFeed",model: [feedList:feedList]
    }
    def gotoSite()
    {
        Browser.drive() {
          println("==================HELLOOOO=========")
            setBaseUrl("https://yourstory.com/ys-stories/")
        }
    }

}
