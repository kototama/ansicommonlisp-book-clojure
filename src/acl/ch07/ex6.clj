(ns acl.ch07.ex6
  (:use [clojure.contrib.duck-streams :only (read-lines
                                             write-lines
                                             reader
                                             writer)])
  (:require [clojure.string :as str]))

(defn stream-subst [old new in out]
  "old and new can be a string, a char or a pattern"
  (write-lines out (map
                    (fn [line]
                      (str/replace line old new))
                    (read-lines in))))

;; example:
;; (stream-subst ":" ";" (reader "/etc/passwd") (writer "/tmp/passwd.txt"))
;; upcase the file (regex + reference to the match) :
;; (stream-subst #"([a-z]+)" (fn [[m]]  (.toUpperCase (str m))) (reader "/etc/passwd") (writer "/tmp/passwd.txt"))
