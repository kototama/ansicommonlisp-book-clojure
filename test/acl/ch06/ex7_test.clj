(ns acl.ch06.ex7-test
  (:use clojure.test
        acl.ch06.ex7))

(deftest test-greater-than-last?
  (is (= false (greater-than-last? 42)))
  (is (= true (greater-than-last? 43)))
  (is (= false (greater-than-last? 40)))
  (is (= true (greater-than-last? 41))))