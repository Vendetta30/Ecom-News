package ecom.news

import com.rss.Feed
import com.rss.FetchUrl
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_SUBADMIN'])
class FeedController {

    def show(Long id) {
        Feed feed = Feed.findById(id)
        render(view: 'show', model: [feed: feed])
    }
}