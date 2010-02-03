(ns acl.ch07.ex1
  (:use clojure.contrib.duck-streams) 
  (:import (java.io FileReader BufferedReader))) ;; if we don't use duck-streams

;; function already exist
(read-lines "test1.txt")
;; ("first" "second222" "third 3 33 333" "fourth" "five" "" "seven" "eight")

;; without contrib:
(defn our-read-lines [filename]
  (with-open [rdr (BufferedReader. (FileReader. "test1.txt"))]
    (doall (line-seq rdr))))
