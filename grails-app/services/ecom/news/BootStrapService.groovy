package ecom.news

import com.Role
import com.User
import com.UserRole
import com.rss.FetchUrl

class BootStrapService {

    static transactional = false

    public void createRoles() {
        Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)
        Role.findByAuthority("ROLE_SUBADMIN") ?: new Role(authority: "ROLE_SUBADMIN").save(flush: true, failOnError: true)
        Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true, failOnError: true)
    }

    public void createAdmin() {
        Role adminRole = Role.findByAuthority("ROLE_ADMIN")
        Role subAdminRole = Role.findByAuthority("ROLE_SUBADMIN")
        Role userRole = Role.findByAuthority("ROLE_USER")
        if (!User.findByUsername("admin@gmail.com")) {
            User userAdmin = new User(username: "admin@gmail.com", password: "123456", firstName: "admin_first", lastName: "admin_last")
            userAdmin.save(flush: true, failOnError: true)
            UserRole.create(userAdmin, adminRole, true)
            UserRole.create(userAdmin, subAdminRole, true)
        }

        if (!User.findByUsername("system@mailtopost.in")) {
            User userAdmin = new User(username: 'system@mailtopost.in', password: 'fgQ1crsdcx4scsdTYk&3mmmdmf', firstName: "System", lastName: 'MailToPost')
            userAdmin.save(flush: true, failOnError: true)
            UserRole.create(userAdmin, adminRole, true)
            UserRole.create(userAdmin, userRole, true)
            UserRole.create(userAdmin, subAdminRole, true)
        }
    }

    public void createSubAdmin() {
        Role subAdminRole = Role.findByAuthority("ROLE_SUBADMIN")
        if (!User.findByUsername("subadmin@gmail.com")) {
            User userSubAdmin = new User(username: "subadmin@gmail.com", password: "123456", firstName: "subadmin_first", lastName: "subadmin_last")
            userSubAdmin.save(flush: true, failOnError: true)
            UserRole.create(userSubAdmin, subAdminRole, true)
        }
    }

    public void createUrl() {
        List<String> urlList = ["http://www.efinancialnews.com/fintech", "http://www.mobilepaymentstoday.com/", "http://www.ft.com/intl/comment/blogs", "https://letstalkpayments.com/"]
        urlList.each { url ->
            FetchUrl fetchUrl = FetchUrl.findByUrlLink(url)
            if (!fetchUrl) {
                fetchUrl = new FetchUrl(urlLink: url)
                fetchUrl.save(flush: true)
            }
        }
    }
}