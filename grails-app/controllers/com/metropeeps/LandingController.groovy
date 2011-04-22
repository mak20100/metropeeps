package com.metropeeps

class LandingController {

    def landing = {
		params.max = Math.min(params.max ? params.int('max') : 10, 20)
		[events: Event.list(params)]
	}
}
