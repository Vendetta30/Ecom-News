package ecom.news

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_SUBADMIN'])
class AdminController {

    def index() {
        render(view: 'index')
    }
}