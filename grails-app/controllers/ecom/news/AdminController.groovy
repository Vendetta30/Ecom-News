package ecom.news
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class AdminController {

    def index() {
        render controller:"feed",action:"readRssFeed"
    }
}
