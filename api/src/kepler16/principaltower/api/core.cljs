(ns kepler16.clam-template.api.core
  (:require [uix.dom.alpha :as dom]
            [uix.core.alpha :as uix]
            ["react-dom/server" :as dom-server]
            [kepler16.clam-template.client.core :as website]
            [kepler16.clam-template.client.document :as document]
						[kepler16.clam.core :as clam]
            [kepler16.clam.ring.node :as clam.ring]
            [reitit.ring :as reitit.ring]))

(defn ssr [req]
	(let [location (:uri req)]
		{:status 200
		 :headers {"Cache-Control" "max-age=0, s-maxage=86400"}
		 :body
		 (->> (uix/as-element
					 [clam/router {:location location :context {}}
						[document/document
						 [website/app]]])
					(.renderToString dom-server))}))

(def api
	(reitit.ring/ring-handler
	 (reitit.ring/router
		{"/api/*" (constantly {:body "Welcome to the Kepler 16 API  "})})
	 (reitit.ring/routes
		ssr
		(reitit.ring/create-default-handler))))

(defn handler [^js req ^js res]
	(let [handler (clam.ring/proxy-handler api)]
		(handler req res)))
