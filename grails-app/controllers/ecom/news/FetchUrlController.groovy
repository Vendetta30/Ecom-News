package ecom.news

import com.rss.FetchUrl

class FetchUrlController {

    def createCreateUrl(FetchUrlCO urlCO) {
        if (urlCO.validate()) {
            FetchUrl url = new FetchUrl(urlLink: urlCO.urlLink)
            url.save(flush: true, failOnError: true)

        } else {
            urlCO.errors.each { it }
            render view: "", model: [urlCOError: urlCO.errors]
        }
    }

    def delete() {
        println(params.id)
        FetchUrl url = FetchUrl.findById(params.id as Long)
        url.delete()
        redirect action: "showUrl"
    }

    def showUrl() {
        List urlList = FetchUrl.createCriteria().listDistinct {}
        if (urlList) {
            render view: "", model: [urlList: urlList]
        } else {
            flash.showUrlListNull = "please insert the Url"
        }
    }

    def editUrl() {
        render view: ""
    }

    def updateUrl(FetchUrlCO urlCO) {
        println(params.id)

        if (urlCO.validate()) {
            FetchUrl url = FetchUrl.findById(params.id as Long)
            url.urlLink = urlCO.urlLink
            url.save(flush: true, failOnError: true)
        }
    }
}
