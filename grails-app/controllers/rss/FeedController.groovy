package rss

import CO.ScrapUtil
import geb.Browser
import grails.plugin.springsecurity.annotation.Secured

import javax.swing.text.Document

@Secured("ROLE_ADMIN")
class FeedController {

    def feedService

    def index() {}

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
