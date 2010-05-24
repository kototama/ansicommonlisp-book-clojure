(ns acl.ch03.ex3
  (:use clojure.contrib.def))

(declare count-occurences)

(defn occurences [col]
  (sort-by (fn [[v occ]] occ) > (count-occurences col)))

(defn- count-occurences [col]
  "return a map key/nb_occurences"
  (reduce (fn [m v] (assoc m v (inc (get m v 0)))) {} col))
