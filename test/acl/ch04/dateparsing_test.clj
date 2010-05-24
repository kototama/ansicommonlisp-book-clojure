(ns acl.ch04.dateparsing-test
  (:use clojure.test
        acl.ch04.dateparsing))

(deftest test-parse-date
  (= [16 8 1980] (parse-date "16 Aug 1980")))


