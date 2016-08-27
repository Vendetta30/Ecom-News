package ecom.news

import com.rss.Feed
import com.rss.FetchUrl
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_SUBADMIN'])
class FeedController {

    def feedService

    def readRssFeed() {

    }
}