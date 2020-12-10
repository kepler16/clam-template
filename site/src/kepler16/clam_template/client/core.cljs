(ns kepler16.clam-template.client.core
  (:require ["react-router-dom" :as rr]
            [kepler16.clam.client.core :as clam.client]
            ["react-helmet" :as helmet]
            [kepler16.clam.util :as clam.util]))

(defn head []
  [:<>
   [:> helmet/Helmet
    [:html {:lang "en"}]
    [:meta {:charset "UTF-8"}]
    [:meta {:content "width=device-width, initial-scale=1", :name "viewport"}]

    [:title "Clam Template"]
    [:meta {:name "Description" :content "Clam Template"}]
    [:meta {:name "robots" :content "index, follow"}]]

   (when-not (clam.util/browser?)
     [:> helmet/Helmet
      [:script {:ssronly "true"
                :defer true
                :src "/static/dist/cljs/main.js"}]
      [:link {:ssronly "true" :href "/static/css/tailwind.css", :rel "stylesheet"}]])])

(defn root []
  [:<>
   [head]
   [:> rr/Switch
    [:> rr/Route {:path "/"}
     [:div "Clam Template"]]]])

(defn render! []
  (clam.client/render
   (js/document.getElementById "app")
   [root]))

(defn ^:dev/before-load before-load! []
  (js/console.log "reloading..."))

(defn ^:dev/after-load after-load! []
  (render!)
  (js/console.log "reloaded..."))

(defn browser-init! []
  (render!))
