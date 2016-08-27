package rss

import CO.UrlCO
import geb.Browser
import grails.plugin.springsecurity.annotation.Secured


@Secured("ROLE_ADMIN")
class UrlController {

    def index() {

    }
    def showCreateUrlPage(){
        //render view:
    }
    def createCreateUrl(UrlCO urlCO){
        if(urlCO.validate())
        {
            Url url=new Url(urlLink:urlCO.urlLink)
            url.save(flush:true,failOnError: true)
            //redirect to method where the list of url will be shown

        }
        else {
            urlCO.errors.each { it }
            render view: "", model: [urlCOError: urlCO.errors]
        }
    }
    def delete()
    {
        println(params.id)
        Url url=Url.findById(params.id as Long)
        url.delete()
        redirect action:"showUrl"
    }
    def showUrl()
    {
        List urlList=Url.createCriteria().listDistinct {}
        if(urlList){
            render view:"",model: [urlList:urlList]
        }
        else {
            flash.showUrlListNull="please insert the Url"
        }
    }
    def editUrl(){
        render view: ""
    }
    def updateUrl(UrlCO urlCO){
        println(params.id)

        if(urlCO.validate())
        {
            Url url=Url.findById(params.id as Long)
            url.urlLink=urlCO.urlLink
            url.save(flush:true,failOnError: true)
        }
    }
    def gotoSite()
    {
        Browser.drive() {

            setBaseUrl("https://yourstory.com/ys-stories/")}
    }

}
