package ecom.news

import com.Role
import com.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class HomeController {
    def springSecurityService

    def index() {}

    def decide() {
        User user = springSecurityService.currentUser
        if (user) {
            List<Role> roles = user.getAuthorities().toList()
            roles.each { print it }
            if (roles.authority.contains("ROLE_USER")) {
                redirect(controller: "user", action: "index")
            } else if (roles.authority.contains("ROLE_ADMIN") || roles.authority.contains("ROLE_SUBADMIN")) {
                redirect(controller: "admin", action: "index")
            } else {
                redirect(uri: '/')
            }
        } else {
            redirect(uri: '/')
        }
    }
}