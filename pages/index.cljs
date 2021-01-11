(ns index
  (:require [kepler16.clam.head :as head]))

(defn root [page]
  [:<>
   [head/Head
    [:title "TITLE FOR ALL PAGES"]]
   page])

(defn page {:clam/page true} []
  [:div "THIS IS THE INDEX PAGE"])
