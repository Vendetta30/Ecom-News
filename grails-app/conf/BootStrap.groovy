class BootStrap {
    def bootStrapService

    def init = { servletContext ->
        bootStrapService.createRoles()
        bootStrapService.createAdmin()
        bootStrapService.createSubAdmin()
    }
    def destroy = {
    }
}