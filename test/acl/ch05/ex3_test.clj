(ns acl.ch05.ex3-test
  (:use clojure.test
        acl.ch05.ex3))

(deftest test-square-floor5
  (is (nil? (square-floor5 5)))
  (is (= 36 (square-floor5 6))))
