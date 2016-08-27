class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        name feed: "/feed/$id/$title" {
            controller = "feed"
            action = "show"
        }
    }
}