(ns kepler16.clam-template.api.core
  (:require [kepler16.clam.server :as clam.server]
            [kepler16.clam.ring.node :as clam.ring]
            [reitit.ring :as reitit.ring]
            [kepler16.clam-template.client.core :as client]))

(defn api-404 [_]
  {:body "This is not the route you're looking for"})

(def api-router
  (reitit.ring/router
   {"/api/*" api-404}))

(def ssr-handler
  (-> (clam.server/ssr-handler
       [client/document
        [client/root]])
      (clam.server/vercel-cache)))

(def handler
  (clam.ring/ring->node-handler
   (reitit.ring/ring-handler
    api-router
    (reitit.ring/routes
     ssr-handler
     (reitit.ring/create-default-handler)))))
