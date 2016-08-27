package ecom.news

import grails.validation.Validateable

@Validateable
class FetchUrlCO {
    String urlLink

    static constraints = {
        urlLink nullable: false, blank: false, unique: true
    }
}
