(ns acl.ch07.ex2
  (:use clojure.test clojure.contrib.duck-streams)
  (:import (java.io PushbackReader)))

(defn read-exprs [filename]
  (with-open [pbrdr (PushbackReader. (reader filename))]
    (loop [curexpr (read pbrdr false :eof)
           exprs ()]
      (if (= curexpr :eof)
        (reverse exprs)
        (recur (read pbrdr false :eof) (conj exprs curexpr))))))

(deftest read-exprs-test
  (is (= '((ns acl.ch07.ex1 (:use clojure.contrib.duck-streams)
               (:import (java.io FileReader BufferedReader)))
           (read-lines "test1.txt")
           (defn our-read-lines [filename]
             (with-open [rdr (BufferedReader. (FileReader. "test1.txt"))]
               (doall (line-seq rdr)))))
         (read-exprs "ex2_test.clj") )))
