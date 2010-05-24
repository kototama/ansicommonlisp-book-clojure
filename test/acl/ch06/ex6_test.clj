(ns acl.ch06.ex6-test
  (:use clojure.test
        acl.ch06.ex6))

(deftest test-max-so-far
  (is (= 10 (max-so-far 10)))
  (is (= 42 (max-so-far 42)))
  (is (= 42 (max-so-far 30))))
