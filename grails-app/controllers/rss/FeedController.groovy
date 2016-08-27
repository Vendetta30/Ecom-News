package rss

import CO.ScrapUtil
import geb.Browser
import grails.plugin.springsecurity.annotation.Secured

import javax.swing.text.Document

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
        println(params)
        id=params.id

        feedService.readRssFeedXml(url)
        redirect action:"showFeed",params:[id:id]
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
            setBaseUrl("http://economictimes.indiatimes.com/small-biz/startups")
            go()
           def st= $("#pageContent").find(".eachStory").find("a")
            st.eachWithIndex {a,i->
              def str = st.eq(i).attr("href")
                def value=ScrapUtil.calculateTransaction(str.toLowerCase())
               if(value) {
                   println("=====================ATTTTTTTTT===========${str}")
               }
            }


        }
    }

}
