(ns acl.ch02.ex4-test
  (:use clojure.test
        acl.ch02.ex4))

(deftest test-simple-max
  (is (= 42 (simple-max 42 2)))
  (is (= 42 (simple-max 2 42))))

