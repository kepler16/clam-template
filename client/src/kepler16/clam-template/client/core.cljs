(ns kepler16.clam-template.client.core
  (:require [uix.core.alpha :as uix]
            [uix.dom.alpha :as uix.dom]
            ["react-router-dom" :as rr]
            [kepler16.clam.core :as clam]
            [kepler16.clam.client :as clam.client]
            [kepler16.clam-template.client.home :as home]))

(defn app []
   [:> rr/Switch
    [:> rr/Route {:path "/" :exact true}
     [home/Home]]])
    ;; [:> rr/Route {:path "/auth"}
    ;;  [auth/component]]])

(defn ^:dev/before-load stop []
  (js/console.log "stop "))

(defn ^:dev/after-load start []
  (clam.client/render (js/document.getElementById "app") app))

(defn browser-init []
  (start))
