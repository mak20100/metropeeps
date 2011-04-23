package com.metropeeps

class EventController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index = {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[eventList: Event.list(params), eventTotal: Event.count()]
	}

	def create = {
		def event = new Event()
		event.properties = params
		return [event: event]
	}

	def save = {
		def event = new Event(params)
		if (event.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'event.label', default: 'Event'), event.id])}"
			redirect(action: "show", id: event.id)
		}
		else {
			render(view: "create", model: [event: event])
		}
	}

	def show = {
		def event = Event.get(params.id)
		if (!event) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
			redirect(action: "list")
		}
		else {
			[event: event]
		}
	}

	def edit = {
		def event = Event.get(params.id)
		if (!event) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [event: event]
		}
	}

	def update = {
		def event = Event.get(params.id)
		if (event) {
			if (params.version) {
				def version = params.version.toLong()
				if (event.version > version) {

					event.errors.rejectValue("version", "default.optimistic.locking.failure", [
						message(code: 'event.label', default: 'Event')]
					as Object[], "Another user has updated this Event while you were editing")
					render(view: "edit", model: [event: event])
					return
				}
			}
			event.properties = params
			if (!event.hasErrors() && event.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'event.label', default: 'Event'), event.id])}"
				redirect(action: "show", id: event.id)
			}
			else {
				render(view: "edit", model: [event: event])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
			redirect(action: "list")
		}
	}

	def delete = {
		def event = Event.get(params.id)
		if (event) {
			try {
				event.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
			redirect(action: "list")
		}
	}

	def register = {
		def user = User.get(params.user.id)
		def registers = params.register.collect{Long.parseLong it}
		
		if(registers){
			def criteria = Event.createCriteria()
			def events = criteria.list{
				'in'("id", registers)
			}
			events.each {e -> e.register(user)}
			flash.message = "Registered user to event(s)"
		}
		redirect(action: "list")
	}
	
	def unregister = {
		def user = User.get(params.user.id)
		def registers = params.register.collect{Long.parseLong it}
		
		if(registers){
			def criteria = Event.createCriteria()
			def events = criteria.list{
				'in'("id", registers)
			}
			events.each {e -> e.unregister(user)}
			flash.message = "Unregistered user from event(s)"
		}
		redirect(action: "list")
	}
}
