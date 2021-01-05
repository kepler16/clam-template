(ns site
  (:require [kepler16.clam.head :as head]))

(defn root [page]
  [:<>
   [head/Head
    [:title "TITLE FOR ALL PAGES"]]
   page])

(defn index []
  [:div "THE INDEX PAGE"])

(defn a []
  [:div "PAGE A"])

(defn d []
  [:div "PAGE D"])

(defn e []
  [:div "PAGE E"])
