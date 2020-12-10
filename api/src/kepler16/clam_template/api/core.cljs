(ns kepler16.clam-template.api.core
  (:require [kepler16.clam.server.core :as clam.server]
            [kepler16.clam.server.ring.node :as clam.ring]
            [reitit.ring :as reitit.ring]
            [kepler16.clam-template.site.core :as site]))

(defn api-404 [_]
  {:body "This is not the route you're looking for"})

(def api-router
  (reitit.ring/router
   {"/api/*" api-404}))

(def ssr-handler
  (-> (clam.server/ssr-handler
       [:div#app
        [site/root]])
      (clam.server/vercel-cache)))

(def handler
  (clam.ring/ring->node-handler
   (reitit.ring/ring-handler
    api-router
    (reitit.ring/routes
     ssr-handler
     (reitit.ring/create-default-handler)))))
