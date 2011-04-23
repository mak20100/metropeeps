package com.metropeeps

class ProfileController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [profileList: Profile.list(params), profileTotal: Profile.count()]
    }

    def create = {
        def profile = new Profile()
        profile.properties = params
        return [profile: profile]
    }

    def save = {
        def profile = new Profile(params)
        if (profile.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'profile.label', default: 'Profile'), profile.id])}"
            redirect(action: "show", id: profile.id)
        }
        else {
            render(view: "create", model: [profile: profile])
        }
    }

    def show = {
        def profile = Profile.get(params.id)
        if (!profile) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
            redirect(action: "list")
        }
        else {
            [profile: profile]
        }
    }

    def edit = {
        def profile = Profile.get(params.id)
        if (!profile) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [profile: profile]
        }
    }

    def update = {
        def profile = Profile.get(params.id)
        if (profile) {
            if (params.version) {
                def version = params.version.toLong()
                if (profile.version > version) {
                    
                    profile.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'profile.label', default: 'Profile')] as Object[], "Another user has updated this Profile while you were editing")
                    render(view: "edit", model: [profile: profile])
                    return
                }
            }
            profile.properties = params
            if (!profile.hasErrors() && profile.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'profile.label', default: 'Profile'), profile.id])}"
                redirect(action: "show", id: profile.id)
            }
            else {
                render(view: "edit", model: [profile: profile])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def profile = Profile.get(params.id)
        if (profile) {
            try {
                profile.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])}"
            redirect(action: "list")
        }
    }
}
