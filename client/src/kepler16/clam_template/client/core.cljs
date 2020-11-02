(ns kepler16.clam-template.client.core
  (:require ["react-router-dom" :as rr]
            [kepler16.clam.client :as clam.client]))

(defn document [child]
  [:html
   [:head
    [:title "Clam Template"]
    [:meta {:name "Description" :content "This is a template for a standard Kepler 16 Clam Site"}]
    [:meta {:charset "UTF-8"}]
    [:meta {:content "width=device-width, initial-scale=1", :name "viewport"}]
    [:link {:href "/static/css/normalize.css", :rel "stylesheet"}]
    [:script {:defer true :src "/static/dist/cljs/main.js", :type "text/javascript"}]]
   [:body {:lang "en"}
    [:div#app child]]])

(defn root []
  [:> rr/Switch
   [:> rr/Route {:path "/"}
    [:div "Clam Template"]]])

(defn render []
  (clam.client/render
   (js/document.getElementById "app")
   root))

(defn ^:dev/before-load before-load []
  (js/console.log "reloading..."))

(defn ^:dev/after-load after-load []
  (render)
  (js/console.log "reloaded..."))

(defn browser-init []
  (render))
