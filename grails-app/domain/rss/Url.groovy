package rss

class Url {
    String urlLink

    static constraints = {
        urlLink nullable: false, unique: true, blank: true
    }

    static hasMany = [feed: Feed]
}
