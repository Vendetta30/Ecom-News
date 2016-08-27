package CO

import grails.validation.Validateable
import rss.Url


@Validateable
class UrlCO {
    String urlLink

    static constraints = {
        urlLink nullable: false, blank: false, unique:true
        }

    }


