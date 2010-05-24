(ns acl.ch06.ex8
  (:use clojure.contrib.def))

(defn expensive [n]
  (Thread/sleep 5000)
  (* n n))

(def frugal (memoize expensive))

(defn-memo frugal2 [n]
  (Thread/sleep 5000)
  (* n n))
