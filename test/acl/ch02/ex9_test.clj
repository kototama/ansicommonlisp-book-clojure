(ns acl.ch02.ex9-test
  (:use clojure.test
        acl.ch02.ex9))

(deftest summit-test
  (is (= 10 (summit '(1 2 3 4))))
  (is (zero? (summit nil)))
  (is (= 7 (summit '(1 2 nil 4)))))
