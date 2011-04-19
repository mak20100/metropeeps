package com.metropeeps

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userList: User.list(params), userTotal: User.count()]
    }

    def create = {
        def user = new User()
        user.properties = params
        return [user: user]
    }

    def save = {
        def user = new User(params)
		
		// verify the passwords
		if(params.password != params.passwordVerify){
			flash.message = "passwords do not match"
			render(view: "create", model: [user: user])
			return
		}
		
		// save the user
        if (user.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])}"
            redirect(action: "show", id: user.id)
        }
        else {
			flash.message = "error(s) creating user"
            render(view: "create", model: [user: user])
        }
    }

    def show = {
        def user = User.get(params.id)
        if (!user) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            [user: user]
        }
    }

    def edit = {
        def user = User.get(params.id)
        if (!user) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [user: user]
        }
    }

    def update = {
        def user = User.get(params.id)
        if (user) {
            if (params.version) {
                def version = params.version.toLong()
                if (user.version > version) {
                    
                    user.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'User')] as Object[], "Another user has updated this User while you were editing")
                    render(view: "edit", model: [user: user])
                    return
                }
            }
            user.properties = params
            if (!user.hasErrors() && user.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])}"
                redirect(action: "show", id: user.id)
            }
            else {
                render(view: "edit", model: [user: user])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def user = User.get(params.id)
        if (user) {
            try {
                user.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }
}
