(ns acl.ch04.binsearch
  (:use clojure.test
        acl.ch04.binsearch))

(deftest test-bincontains?
  (is (not (bincontains? [1 2 3 4 5 6] 9)))
  (is (bincontains? [0 1 2 3 4 5 6 7 8 9] 6)))
