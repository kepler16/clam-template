(ns a
  (:require
   [kepler16.clam.head :as head]
   [kepler16.clam.util :as clam.util]))

(defn a []
  [:<>
   [head/Head
    [:title "a"]]
   [:div "a"]])

(defn c []
  #?(:cljs (js/console.log "I AM ON BROWSER")
     :node (js/console.log "I AM ON NODE"))
  [:div "c"])

(defn root [page]
  [:<>
   [head/Head
    [:title "hi"]]
   page])
